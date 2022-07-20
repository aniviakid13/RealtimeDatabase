package com.codefresher.realtimedatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codefresher.realtimedatabase.databinding.ActivityMainBinding
import com.google.firebase.database.*
import com.google.firebase.database.R

class MainActivity : AppCompatActivity() {
    lateinit var mDataBase: DatabaseReference
    private lateinit var binding: ActivityMainBinding
    private lateinit var itemList: ArrayList<ItemModel>
    private lateinit var mAdapter: AdapterItem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        itemList = ArrayList()
        mAdapter = AdapterItem(this, itemList)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.setHasFixedSize(true)
        getData()

    }

    private fun getData() {
        mDataBase = FirebaseDatabase.getInstance().getReference("Trending")
        mDataBase.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (trendingSnapShot in snapshot.children) {
                        val tren = trendingSnapShot.getValue(ItemModel::class.java)
                        itemList.add(tren!!)
                    }
                    binding.recyclerView.adapter = mAdapter
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(
                    this@MainActivity,
                    error.message, Toast.LENGTH_SHORT
                ).show()
            }

        })

    }
}


