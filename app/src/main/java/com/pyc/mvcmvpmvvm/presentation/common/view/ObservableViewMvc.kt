package com.pyc.mvcmvpmvvm.presentation.common.view

interface ObservableViewMvc<ListenerType> :
    ViewMvc {

    fun registerListener(listener: ListenerType)

    fun unregisterListener(listener: ListenerType)
}