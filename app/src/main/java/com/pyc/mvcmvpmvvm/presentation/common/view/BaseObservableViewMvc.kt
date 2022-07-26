package com.pyc.mvcmvpmvvm.presentation.common.view

abstract class BaseObservableViewMvc<ListenerType> : BaseViewMvc(),
    ObservableViewMvc<ListenerType> {

    private val _listeners: MutableSet<ListenerType> = hashSetOf()
    protected val listeners: Set<ListenerType>
        get() = _listeners.toSet()

    override fun registerListener(listener: ListenerType) {
        _listeners.add(listener)
    }

    override fun unregisterListener(listener: ListenerType) {
        _listeners.remove(listener)
    }
}