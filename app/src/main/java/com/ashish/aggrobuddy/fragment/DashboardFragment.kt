package com.ashish.aggrobuddy.fragment

import android.app.DownloadManager
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.ashish.aggrobuddy.R
import com.ashish.aggrobuddy.adapter.DashboardRecyclerAdapter
import com.ashish.aggrobuddy.model.Farmer


class DashboardFragment : Fragment() {




    lateinit var recycleDashboard: RecyclerView
    lateinit var layoutMamager:RecyclerView.LayoutManager

    


    lateinit var recyclerAdapter:DashboardRecyclerAdapter

    val  farmerInfoList = arrayListOf<Farmer>(

        Farmer("Umesh Kumar","500/50kg","6206416452","4.3/5",R.drawable.onion),
        Farmer("Arun Kumar","400/50kg","6287099155","4.9/5",R.drawable.potato),
        Farmer("Anil Kuamr","350/50kg","9123199924","3.9/5",R.drawable.wheat),
        Farmer("Ramesh Kumar","250/50kg","7050725092","4.5/5",R.drawable.rice),
        Farmer("Ramesh Kumar","1000/50kg","821056179","3.8/5",R.drawable.orange)

    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this com.ashish.aggrobuddy.fragment
        val view= inflater.inflate(R.layout.fragment_dashboard,container,false)

        recycleDashboard=view.findViewById(R.id.recyclerDashboard)

        layoutMamager=LinearLayoutManager(activity)


        recyclerAdapter= DashboardRecyclerAdapter(activity as Context,farmerInfoList)

        recycleDashboard.adapter=recyclerAdapter
        recycleDashboard.layoutManager=layoutMamager

        recycleDashboard.addItemDecoration(
            DividerItemDecoration
            (recycleDashboard.context,
            (layoutMamager as LinearLayoutManager).orientation))


        val queue =Volley.newRequestQueue(activity as Context)

        val url = "http://13.235.250.119/v1/book/fetch_book/"


        return view
    }


}