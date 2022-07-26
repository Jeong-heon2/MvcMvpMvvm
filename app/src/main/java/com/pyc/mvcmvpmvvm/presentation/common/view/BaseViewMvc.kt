package com.pyc.mvcmvpmvvm.presentation.common.view

import android.content.Context
import android.view.View
import androidx.annotation.StringRes

abstract class BaseViewMvc : ViewMvc {

    private lateinit var rootView: View

    override fun getRootView(): View {
        return rootView
    }

    protected fun setRootView(rootView: View) {
        this.rootView = rootView
    }

    protected val context: Context
        get() = rootView.context

    protected fun <T : View> findViewById(id: Int): T {
        return rootView.findViewById(id)
    }

    protected fun getString(@StringRes resId: Int): String {
        return context.getString(resId)
    }
}