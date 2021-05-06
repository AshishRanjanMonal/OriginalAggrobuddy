package com.ashish.aggrobuddy.adapter

import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.ashish.aggrobuddy.R
import com.ashish.aggrobuddy.model.Farmer


class DashboardRecyclerAdapter(val context: Context, private val itemList: ArrayList<Farmer>) :
    RecyclerView.Adapter<DashboardRecyclerAdapter.DashboardViewHolder>() {

    class DashboardViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txtfarmerName: TextView = view.findViewById(R.id.txtfarmerName)
        val txtrate: TextView = view.findViewById(R.id.txtrate)
        val txtphone: TextView = view.findViewById(R.id.txtphone)
        val txtrating: TextView = view.findViewById(R.id.txtrating)
        val imgdashboard1: ImageView = view.findViewById(R.id.imagedashboard1)

        val content: RelativeLayout = view.findViewById(R.id.content)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: DashboardViewHolder, position: Int) {

        val farmer = itemList[position]
        holder.txtfarmerName.text = farmer.farmerName
        holder.txtphone.text = farmer.phone
        holder.txtrate.text = farmer.rate
        holder.txtrating.text = farmer.rating
        holder.imgdashboard1.setImageResource(farmer.image)

        holder.content.setOnClickListener {
            Toast.makeText(
                context, "Clicked on farmer Pallet ",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_dashboard_single_row, parent, false)
        return DashboardViewHolder(view)
    }


}