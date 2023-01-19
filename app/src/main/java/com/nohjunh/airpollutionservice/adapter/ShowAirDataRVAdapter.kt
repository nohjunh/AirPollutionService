package com.nohjunh.airpollutionservice.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.nohjunh.airpollutionservice.R
import com.nohjunh.airpollutionservice.database.entity.CityAirPollutionEntity

class ShowAirDataRVAdapter(val context : Context, val dataSet : List<CityAirPollutionEntity>)
    :RecyclerView.Adapter<ShowAirDataRVAdapter.ViewHolder>() {

    inner class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {

        val sidoName : TextView = view.findViewById(R.id.sidoName)
        val stationName : TextView = view.findViewById(R.id.stationName)
        val pm10grade : ImageView = view.findViewById(R.id.pm10grade)
        val pm10value : TextView = view.findViewById(R.id.pm10value)
        val pm25grade : ImageView = view.findViewById(R.id.pm25grade)
        val pm25value : TextView = view.findViewById(R.id.pm25value)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.airpollutiondata_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.sidoName.text = dataSet[position].sidoName
        holder.stationName.text = dataSet[position].stationName
        when (dataSet[position].pm10Grade) {
            "좋음" -> holder.pm10grade.load(R.drawable.good)
            "보통" -> holder.pm10grade.load(R.drawable.avg)
            "나쁨" -> holder.pm10grade.load(R.drawable.bad)
            "매우나쁨" -> holder.pm10grade.load(R.drawable.verybad)
        }
        holder.pm10value.text = dataSet[position].pm10Value.toString()
        when (dataSet[position].pm25Grade) {
            "좋음" -> holder.pm25grade.load(R.drawable.good)
            "보통" -> holder.pm25grade.load(R.drawable.avg)
            "나쁨" -> holder.pm25grade.load(R.drawable.bad)
            "매우나쁨" -> holder.pm25grade.load(R.drawable.verybad)
        }
        holder.pm25value.text = dataSet[position].pm10Value.toString()

    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

}