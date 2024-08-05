package org.gampiot.robok.feature.util.base

import android.os.Bundle
import android.view.View
import android.view.WindowManager

import androidx.activity.OnBackPressedDispatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import androidx.fragment.app.Fragment
import androidx.annotation.IdRes

import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.dialog.MaterialAlertDialogBuilder

import org.gampiot.robok.feature.util.R
import org.gampiot.robok.feature.util.requestStoragePerm
import org.gampiot.robok.feature.util.getStoragePermStatus
import org.gampiot.robok.feature.util.getBackPressedClickListener
import org.gampiot.robok.feature.util.PermissionListener
import org.gampiot.robok.feature.util.ResUtils
import org.gampiot.robok.feature.res.Strings
import org.gampiot.robok.feature.component.dialog.PermissionDialog

open class RobokActivity : AppCompatActivity(), PermissionListener {

    @IdRes var layoutResId: Int = 0
    
    private lateinit var permissionDialog: PermissionDialog
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (!getStoragePermStatus(this)) {
            requestStoragePermDialog()
        }
    }
    
    fun openFragment(fragment: Fragment) {
        supportFragmentManager.commit {
            replace(layoutResId, fragment)
        }
    }
    
    fun openCustomFragment(@IdRes layoutResId: Int, fragment: Fragment) {
        supportFragmentManager.commit {
            replace(layoutResId, fragment)
        }
    }
    
    private fun requestStoragePermDialog() {
        permissionDialog = PermissionDialog().apply {
            setIconResId(R.drawable.ic_folder_24)
            setText(getString(Strings.warning_storage_perm_message))
            setAllowClickListener {
                requestStoragePerm(this@RobokActivity)
            }
            setDenyClickListener {
                finish()
            }
        }
        permissionDialog.show(supportFragmentManager, "PermissionDialog")
    }
    
    fun configureWindow() {
        val resUtils = ResUtils(this)
        val colorBg = resUtils.getAttrColor(android.R.attr.colorBackground)
        /* window.statusBarColor = colorBg */
        window.navigationBarColor = colorBg
    }
    
    fun configureToolbarNavigationBack(toolbar: MaterialToolbar) {
        toolbar.setNavigationOnClickListener(getBackPressedClickListener(onBackPressedDispatcher))
    }
    
    fun setFragmentLayoutResId(@IdRes layoutResId: Int) {
        this.layoutResId = layoutResId
    }
    
    fun getFragmentLayoutResId(): Int {
        return layoutResId
    }
    
    override fun onReceive(status: Boolean) {
        if (status) {
            if (::permissionDialog.isInitialized) {
                permissionDialog.dismiss()
            }
        } else {
            MaterialAlertDialogBuilder(this)
                .setTitle(getString(Strings.error_storage_perm_title))
                .setMessage(getString(Strings.error_storage_perm_message))
                .setCancelable(false)
                .setPositiveButton(Strings.common_word_allow) { _, _ ->
                    requestStoragePermDialog()
                }
                .show()
        }
    }
}
