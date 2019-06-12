package com.bancopan.teste

import android.support.constraint.ConstraintLayout
import android.support.v7.widget.AppCompatTextView
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.TextView

class ListViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView)
{
    val rootInstallment: ConstraintLayout = itemView.findViewById(R.id.root)
    val imgCircle: TextView = itemView.findViewById(R.id.imgCircle)


}