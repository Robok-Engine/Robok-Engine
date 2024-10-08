package org.robok.engine.core.components.parallax

/*
 *  This file is part of Robok © 2024.
 *
 *  Robok is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  Robok is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *   along with Robok.  If not, see <https://www.gnu.org/licenses/>.
 */

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.view.Surface
import android.view.WindowManager

import androidx.compose.runtime.mutableStateOf

import kotlin.math.*

/*
* A class for a parallax effect.
*/

class ParallaxEffect(
context: Context
) : SensorEventListener {

    var offsetX = mutableStateOf(0f)
    var offsetY = mutableStateOf(0f)
    var angle = mutableStateOf(0f)

    private val rollBuffer = FloatArray(3)
    private val pitchBuffer = FloatArray(3)
    private var bufferOffset = 0

    private val wm: WindowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
    private val sensorManager: SensorManager = context.getSystemService(Context.SENSOR_SERVICE) as SensorManager
    private val accelerometer: Sensor? = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)

    private var enabled = false
    
    var density: Float = context.resources.displayMetrics.density
    
    fun dp(value: Float): Int = if (value == 0f) 0 else ceil(density * value).toInt()
    
    fun dpf2(value: Float): Float = if (value == 0f) 0f else density * value

    fun setEnabled(enabled: Boolean) {
        if (this.enabled != enabled) {
            this.enabled = enabled
            if (accelerometer == null) return
            if (enabled) {
                sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_GAME)
            } else {
                sensorManager.unregisterListener(this)
            }
        }
    }

    override fun onSensorChanged(event: SensorEvent) {
        val rotation = wm.defaultDisplay.rotation

        val x = event.values[0] / SensorManager.GRAVITY_EARTH
        val y = event.values[1] / SensorManager.GRAVITY_EARTH
        val z = event.values[2] / SensorManager.GRAVITY_EARTH

        var pitch = atan2(x, sqrt(y * y + z * z)).toFloat() / Math.PI.toFloat() * 2f
        var roll = atan2(y, sqrt(x * x + z * z)).toFloat() / Math.PI.toFloat() * 2f

        when (rotation) {
            Surface.ROTATION_90 -> {
                val temp = pitch
                pitch = roll
                roll = temp
            }
            Surface.ROTATION_180 -> {
                roll = -roll
                pitch = -pitch
            }
            Surface.ROTATION_270 -> {
                val temp = -pitch
                pitch = roll
                roll = temp
            }
        }

        rollBuffer[bufferOffset] = roll
        pitchBuffer[bufferOffset] = pitch
        bufferOffset = (bufferOffset + 1) % rollBuffer.size

        roll = rollBuffer.average().toFloat()
        pitch = pitchBuffer.average().toFloat()

        if (roll > 1f) roll = 2f - roll
        else if (roll < -1f) roll = -2f - roll

        offsetX.value = pitch * dpf2(16f)
        offsetY.value = roll * dpf2(16f)

        var vx = max(-1f, min(1f, -pitch / 0.45f))
        var vy = max(-1f, min(1f, -roll / 0.45f))
        val len = sqrt(vx * vx + vy * vy)

        vx /= len
        vy /= len

        angle.value = (atan2(vx * -1f - vy * 0f, vx * 0f + vy * -1f) / (Math.PI / 180f)).toFloat().let {
            if (it < 0) it + 360 else it
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {}
}