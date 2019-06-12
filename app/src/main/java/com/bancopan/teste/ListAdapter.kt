package com.bancopan.teste

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import java.util.*
import android.support.v7.widget.RecyclerView

class ListAdapter (val context: Context, val items: ArrayList<String>) : RecyclerView.Adapter<ListViewHolder>()
{
    private var onSelectedListener: OnSelectedListener? = null

    override fun onCreateViewHolder(p0: ViewGroup, viewType: Int): ListViewHolder
    {
        val view = LayoutInflater.from(p0?.context).inflate(R.layout.item_list, p0, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int
    {
        return items.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int)
    {
        holder.rootInstallment.setOnClickListener { onClick(holder.rootInstallment) }
    }

    fun onClick(view:View)
    {
        if (onSelectedListener != null)
        {
            onSelectedListener!!.onSelected(view)
        }

        notifyDataSetChanged()
    }

    interface OnSelectedListener
    {
        fun onSelected(view:View)
    }

    fun setSelectedListener(onSelectedListener: OnSelectedListener)
    {
        this.onSelectedListener = onSelectedListener
    }
}