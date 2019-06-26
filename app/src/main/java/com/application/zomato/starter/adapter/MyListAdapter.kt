package com.application.zomato.starter.adapter

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.application.zomato.starter.R
import com.application.zomato.starter.data.Restaurant
import java.util.ArrayList

class MyListAdapter : RecyclerView.Adapter<MyListAdapter.ViewHolder>() {

    /**
     * Change the type of data in list to support your data
     */
    var items : List<Restaurant> = ArrayList()

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {

        /**
         * change R.id.layout_item_basic to your layout id
         */
        Log.v("testing",
                "onCreateViewHolder")
        val view = LayoutInflater.from(p0.context).inflate(R.layout.activity_basic,p0, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.v("testing","onBindViewHolder")
        holder.bindData(items[position])
    }

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {

        init {
            view.setOnClickListener (
                object : View.OnClickListener {
                    override fun onClick(p0: View?) {
                          Toast.makeText(p0?.context,"Restaurant name is "+restaurant?.restaurantName,Toast.LENGTH_LONG).show()
                    }

            }
            )
        }

        private val name : TextView = view.findViewById(R.id.name)

        private val addr : TextView = view.findViewById(R.id.address)
        private val desc : TextView = view.findViewById(R.id.description)
        var restaurant : Restaurant?=null
        fun bindData(s : Restaurant) {
            /**
             * use data and set on the view
             */
            restaurant = s;
            name.text = s.restaurantName;
            addr.text = s.restaurantAddress;
            desc.text = s.description;
        }

    }
}