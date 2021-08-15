package com.oladokun.mooveafricatest.utils

import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import com.oladokun.mooveafricatest.R

/**
 * Extension function to help with fragment transition animation
 */
fun Fragment.fragmentSlideInLeftAnimation(): NavOptions.Builder {
    val navBuilder: NavOptions.Builder = NavOptions.Builder()
    navBuilder.setEnterAnim(R.anim.slide_in_right).setExitAnim(R.anim.slide_out_left)
        .setPopEnterAnim(R.anim.slide_in_left).setPopExitAnim(R.anim.slide_out_right)
    return navBuilder
}


/**
 * Extension functions to help with view visibility
 */
fun View.hideVisibility() {
    this.visibility = View.GONE
}

fun View.showVisibility() {
    this.visibility = View.VISIBLE
}