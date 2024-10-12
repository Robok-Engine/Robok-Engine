package org.robok.engine.ui.activities

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

import android.os.Bundle
import android.view.Window
import android.graphics.Color.BLACK
import android.graphics.Color.TRANSPARENT
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.core.content.ContextCompat
import androidx.navigation.compose.rememberNavController
import org.robok.engine.res.ResUtils
import org.robok.engine.navigation.MainNavHost
import org.robok.engine.platform.LocalMainNavController
import org.robok.engine.ui.activities.base.RobokActivity
import org.robok.engine.ui.theme.RobokTheme

class MainActivity : RobokActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RobokTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    ProvideMainCompositionLocals { MainNavHost() }
                }
            }
        }
    }

    @Composable
    private fun ProvideMainCompositionLocals(content: @Composable () -> Unit) {
        val navController = rememberNavController()

        CompositionLocalProvider(LocalMainNavController provides navController, content = content)
    }
    
    @Suppress("DEPRECATION")
    override fun onBackPressed () {
        val window: Window = window
        val res = ResUtils(this@MainActivity)
            
        val statusBarColor = window.statusBarColor
        val navigationBarColor = window.navigationBarColor
        
        val resetColor = TRANSPARENT
            
        if (statusBarColor == BLACK && navigationBarColor == BLACK) {
                window.statusBarColor = resetColor
               window.navigationBarColor = resetColor
        }
        super.onBackPressed()
    }
}