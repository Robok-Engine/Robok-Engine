package org.gampiot.robok.feature.util.activities

import android.annotation.SuppressLint
import android.app.Activity
import android.content.ClipboardManager
import android.content.ClipData
import android.content.Context
import android.content.Intent
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.text.format.Formatter
import android.widget.TextView
import android.widget.Toast

import com.google.android.material.dialog.MaterialAlertDialogBuilder

import org.gampiot.robok.feature.util.R
import org.gampiot.robok.feature.res.Strings
import org.gampiot.robok.feature.util.base.RobokActivity

class DebugActivity : RobokActivity() {

    private lateinit var error: TextView
    private var madeErrMsg: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_debug)
        error = findViewById(R.id.error)

        val intent = intent
        var errMsg = ""
        madeErrMsg = ""
        if (intent != null) {
            errMsg = intent.getStringExtra("error") ?: ""
            val split = errMsg.split("\n")
            try {
                madeErrMsg = errMsg
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        error.text = madeErrMsg

        val deviceInfo = getDeviceInfo()
        val appInfo = getAppInfo()
        val fullInfo = "$madeErrMsg\n\n$deviceInfo\n$appInfo"

        val dialog = MaterialAlertDialogBuilder(this)
            .setTitle(Strings.title_debug_title)
            .setMessage("Error details and device information are provided below.")
            .setPositiveButton(Strings.common_word_end) { _, _ -> finish() }
            .setNeutralButton("Show error") { dialog, _ ->
                val messageView = dialog.findViewById<TextView>(android.R.id.message)
                messageView?.let {
                    it.setTextIsSelectable(true)
                    it.text = fullInfo
                }
            }
            .setNegativeButton("Copy") { _, _ ->
                copyToClipboard(fullInfo)
            }
            .show()
    }

    private fun getDeviceInfo(): String {
        return "Device Info:\n" +
                "Brand: ${Build.BRAND}\n" +
                "Model: ${Build.MODEL}\n" +
                "Manufacturer: ${Build.MANUFACTURER}\n" +
                "Android Version: ${Build.VERSION.RELEASE}\n" +
                "SDK Version: ${Build.VERSION.SDK_INT}"
    }

    private fun getAppInfo(): String {
        val packageManager = packageManager
        val packageName = packageName
        val packageInfo: PackageInfo
        return try {
            packageInfo = packageManager.getPackageInfo(packageName, 0)
            "App Info:\n" +
                    "Package Name: $packageName\n" +
                    "Version: ${packageInfo.versionName}\n" +
                    "Version Code: ${packageInfo.versionCode}\n" +
                    "APK Size: ${Formatter.formatFileSize(this, File(packageInfo.applicationInfo.sourceDir).length())}"
        } catch (e: PackageManager.NameNotFoundException) {
            "App Info:\nCould not retrieve app info.\nStack trace:\n${e.stackTraceToString()}"
        }
    }

    private fun copyToClipboard(text: String) {
        val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clip = ClipData.newPlainText("Debug Info", text)
        clipboard.setPrimaryClip(clip)
        Toast.makeText(this, "Copied to clipboard", Toast.LENGTH_LONG).show()
    }
}
