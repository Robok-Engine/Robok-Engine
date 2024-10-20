package io.material.hct

import io.material.utils.ColorUtils

class Hct private constructor(argb: Int) {
    var hue = 0.0
        private set
    var chroma = 0.0
        private set
    var tone = 0.0
        private set
    var argb = 0

    init {
        setInternalState(argb)
    }


    fun toInt(): Int {
        return argb
    }

    fun setHue(newHue: Double) {
        setInternalState(HctSolver.solveToInt(newHue, chroma, tone))
    }

    fun setChroma(newChroma: Double) {
        setInternalState(HctSolver.solveToInt(hue, newChroma, tone))
    }

    fun setTone(newTone: Double) {
        setInternalState(HctSolver.solveToInt(hue, chroma, newTone))
    }

    fun inViewingConditions(vc: ViewingConditions): Hct {
        // 1. Use CAM16 to find XYZ coordinates of color in specified VC.
        val cam16: Cam16 = Cam16.fromInt(toInt())
        val viewedInVc = cam16.xyzInViewingConditions(vc, null)

        // 2. Create CAM16 of those XYZ coordinates in default VC.
        val recastInVc: Cam16 = Cam16.fromXyzInViewingConditions(
            viewedInVc[0], viewedInVc[1], viewedInVc[2], ViewingConditions.DEFAULT
        )

        // 3. Create HCT from:
        // - CAM16 using default VC with XYZ coordinates in specified VC.
        // - L* converted from Y in XYZ coordinates in specified VC.
        return from(
            recastInVc.hue, recastInVc.chroma, ColorUtils.lstarFromY(
                viewedInVc[1]
            )
        )
    }

    private fun setInternalState(argb: Int) {
        this.argb = argb
        val cam: Cam16 = Cam16.fromInt(argb)
        hue = cam.hue
        chroma = cam.chroma
        tone = ColorUtils.lstarFromArgb(argb)
    }

    companion object {

        fun from(hue: Double, chroma: Double, tone: Double): Hct {
            val argb = HctSolver.solveToInt(hue, chroma, tone)
            return Hct(argb)
        }

        fun fromInt(argb: Int): Hct {
            return Hct(argb)
        }
    }
}