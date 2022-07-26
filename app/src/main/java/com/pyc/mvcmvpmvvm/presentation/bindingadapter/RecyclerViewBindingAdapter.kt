package com.pyc.mvcmvpmvvm.presentation.bindingadapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

@Suppress("UNCHECKED_CAST")
@BindingAdapter(value = ["list", "callback"], requireAll = true)
fun <T, VH : RecyclerView.ViewHolder> RecyclerView.submitList(list: List<T>?, callback: Runnable?) {
    (adapter as? ListAdapter<T, VH>)?.submitList(list, callback)
}