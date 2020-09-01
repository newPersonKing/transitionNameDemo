package com.example.transtiondemo

import android.app.Activity
import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_recyclerview.*

class RecyclerViewShareElementActivity :AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recyclerview)

        re_list.layoutManager = LinearLayoutManager(this)
        re_list.adapter = MyAdapter(this)
    }


}


class MyAdapter(val activity:Activity) : RecyclerView.Adapter<MyHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val textView = ImageView(parent.context);
        val holder = MyHolder(textView)
        return holder
    }

    override fun getItemCount(): Int  = 100;

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val view = holder.itemView as ImageView
        view.setImageResource(R.drawable.image1)
        view.setOnClickListener {
            it.transitionName = "i$position"
            val intent = Intent(activity,RvShareElementActivity::class.java)
            intent.putExtra("transName","i$position")
            activity.startActivity(intent,ActivityOptions.makeSceneTransitionAnimation(activity,it,"i$position").toBundle())

//            startActivity(
//                Intent(this@MainActivity, ShareElementTransition::class.java),
//                ActivityOptions.makeSceneTransitionAnimation(this, share_Transition, "share").toBundle()
//            )
        }
    }


}

class  MyHolder(itemView:View) : RecyclerView.ViewHolder(itemView) {


}