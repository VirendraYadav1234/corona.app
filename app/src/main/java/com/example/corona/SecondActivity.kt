package com.example.corona

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity(), NewsItemCliked {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        recycle.layoutManager=LinearLayoutManager(this)
        val data=fetchData()
          val adaptor=Adaptor(data,this)

        recycle.adapter=adaptor
    }

    private  fun fetchData():ArrayList<String>{

        val list=ArrayList<String>()
        for(i in 0 until 100){
            list.add("item->${i + 1}")
        }
        return  list
    }

    override fun onItemClicked(item: String) {
        Toast.makeText(this, "clicked item is $item", Toast.LENGTH_SHORT).show()
    }
}