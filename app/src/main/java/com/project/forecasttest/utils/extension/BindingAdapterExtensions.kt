//package com.example.project.utils.extension
//
//import android.text.Html
//import android.view.View
//import android.widget.ImageView
//import android.widget.TextView
//import androidx.appcompat.app.AppCompatActivity
//import androidx.databinding.BindingAdapter
//import androidx.lifecycle.MutableLiveData
//import androidx.lifecycle.Observer
//import androidx.recyclerview.widget.RecyclerView
//import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
//import com.bumptech.glide.Glide
//import com.example.project.utils.extension.getParentActivity
//
///**
// * @author Leopold
// */
//
//@BindingAdapter("refreshing")
//fun SwipeRefreshLayout.refreshing(visible: Boolean) {
//    isRefreshing = visible
//}
//
//@BindingAdapter("adapter")
//fun setAdapter(view: RecyclerView, adapter: RecyclerView.Adapter<*>) {
//    view.adapter = adapter
//}
//
//@BindingAdapter("mutableVisibility")
//fun setMutableVisibility(view: View, visibility: MutableLiveData<Int>?) {
//    val parentActivity: AppCompatActivity? = view.getParentActivity()
//    if (parentActivity != null && visibility != null) {
//        visibility.observe(parentActivity, Observer { value -> view.visibility = value ?: View.VISIBLE })
//    }
//}
//
//@BindingAdapter("mutableText")
//fun setMutableText(view: TextView, text: MutableLiveData<String>?) {
//    val parentActivity: AppCompatActivity? = view.getParentActivity()
//    if (parentActivity != null && text != null) {
//        text.observe(parentActivity, Observer { value -> view.text = value ?: "" })
//    }
//}
//
//@BindingAdapter("bind:imageUrl")
//fun setImageUrl(view: ImageView, url: String) {
//    Glide.with(view.context).load(url).into(view)
////   Picasso.with(view.context).load(Html.fromHtml(url).toString()).placeholder(R.drawable.placeholder_image).into(view)
//}