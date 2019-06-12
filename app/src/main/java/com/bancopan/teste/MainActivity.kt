package com.bancopan.teste

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.util.Pair
import android.support.v7.widget.DefaultItemAnimator
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v4.content.ContextCompat


class MainActivity : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadListPayment()
    }

    private fun loadListPayment()
    {
        val list: ArrayList<String> = ArrayList()

        list.add("")
        list.add("")
        list.add("")
        list.add("")
        list.add("")
        list.add("")
        list.add("")
        list.add("")
        list.add("")

        with(rv_itens) {
            val itemDecorator = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
            itemDecorator.setDrawable(ContextCompat.getDrawable(context, R.drawable.divider_list)!!)

            addItemDecoration(itemDecorator)

            val adapter = ListAdapter(this@MainActivity, list)
            setAdapter(adapter)
            layoutManager = LinearLayoutManager(context)
            itemAnimator = DefaultItemAnimator()
            setHasFixedSize(true)

            adapter.setSelectedListener(object : ListAdapter.OnSelectedListener
            {
                override fun onSelected(view: View)
                {
                    val intent = Intent(this@MainActivity, DetailMainActivity::class.java)

                    val pair = Pair.create<View, String>(view, view.getTransitionName())

                    val options = ActivityOptionsCompat.makeSceneTransitionAnimation(this@MainActivity, pair)
                    startActivity(intent, options.toBundle())
                }
            })
        }
    }
}