package klinka.com.coronavirus.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import klinka.com.coronavirus.R
import klinka.com.coronavirus.model.SummaryModel
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*
import java.util.zip.DataFormatException


class CoronaAdapter (private var dataList: List<SummaryModel>, private val context: Context):
        RecyclerView.Adapter<CoronaAdapter.SummaryViewHolder>(){

    fun refreshDataList(list: List<SummaryModel>){
        dataList = list
        this.notifyDataSetChanged()
    }

    class SummaryViewHolder(itemLayoutView: View):RecyclerView.ViewHolder(itemLayoutView) {
        val titleCard: TextView = itemLayoutView.findViewById(R.id.title_card)
        val confirmed: TextView = itemLayoutView.findViewById(R.id.total_confirmed_value_card)
        val deaths: TextView = itemLayoutView.findViewById(R.id.total_deaths_value_card)
        val recovered: TextView = itemLayoutView.findViewById(R.id.total_recovered_value_card)
        val update: TextView = itemLayoutView.findViewById(R.id.last_update_value_card)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SummaryViewHolder {
        return SummaryViewHolder(LayoutInflater.from(context).inflate(R.layout.item_home, parent, false))
    }

    override fun getItemCount(): Int {
       return dataList.size
    }

    override fun onBindViewHolder(holder: SummaryViewHolder, position: Int) {
        val summaryModel = dataList[position]
        val newFormat = "yyyy-MM-dd"
        val dateFormat = SimpleDateFormat(newFormat, Locale.US)

        holder.titleCard.text = summaryModel.country
        holder.confirmed.text = summaryModel.confirmed.toString()
        holder.deaths.text = summaryModel.deaths.toString()
        holder.recovered.text = summaryModel.recovered.toString()

        val lastUpdate = dateFormat.format(summaryModel.update)
        holder.update.text = lastUpdate
    }

}