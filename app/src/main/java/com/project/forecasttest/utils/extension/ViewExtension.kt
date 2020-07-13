package com.project.forecasttest.utils.extension

import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.annotation.AnimRes
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

fun View.getParentActivity(): AppCompatActivity? {
    var context = this.context
    while (context is ContextWrapper) {
        if (context is AppCompatActivity) {
            return context
        }
        context = context.baseContext
    }
    return null
}

fun <T> Context.openActivity(it: Class<T>, extras: Bundle.() -> Unit = {}) {
    val intent = Intent(this, it)
//    intent.addExtras(Bundle().apply(extras))
    startActivity(intent)
}

fun Fragment.slideNextFragment(
    fragment: Fragment,
    @IdRes fragmentContentId: Int,
    @AnimRes enter: Int? = null,
    @AnimRes exit: Int? = null,
    @AnimRes popEnter: Int? = null,
    @AnimRes popExit: Int? = null,
    vararg sharedElements: Pair<View, String>
) {
    if (isAdded) {
        val fragmentTransaction = fragmentManager?.beginTransaction()
        enter?.let {
            exit?.let { it1 ->
                popEnter?.let { it2 ->
                    popExit?.let { it3 ->
                        fragmentTransaction?.setCustomAnimations(
                            it,
                            it1,
                            it2,
                            it3
                        )
                    }
                }
            }
        }
        fragmentTransaction?.addToBackStack(fragment.javaClass.name)
        for (i in sharedElements.indices) {
            val sharedElement = sharedElements[i]
            fragmentTransaction?.addSharedElement(sharedElement.first, sharedElement.second)
        }
        fragmentTransaction?.replace(fragmentContentId, fragment)?.commitAllowingStateLoss()
    }
}

inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> Unit) {
    val fragmentTransaction = beginTransaction()
    fragmentTransaction.func()
    fragmentTransaction.commit()
}

fun Context.getLayoutInflater() = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
fun View.getLayoutInflater() = context.getLayoutInflater()
//fun <T : ViewDataBinding> ViewGroup.bind(layoutId: Int): T {
//    return DataBindingUtil.inflate(getLayoutInflater(), layoutId, this, true)
//}

fun Fragment.slidePreviousFragment() {
    fragmentManager?.popBackStackImmediate()
}

fun View.showKeyboard(context: Context) {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.showSoftInput(this, InputMethodManager.SHOW_FORCED)
}

fun View.hideKeyboard(context: Context) {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(this.windowToken, 0)
}