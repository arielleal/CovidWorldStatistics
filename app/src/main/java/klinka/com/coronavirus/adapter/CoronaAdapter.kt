package klinka.com.coronavirus.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import klinka.com.coronavirus.R
import klinka.com.coronavirus.model.SummaryModel


class CoronaAdapter (private var dataList: List<SummaryModel>, private val context: Context):
        RecyclerView.Adapter<CoronaAdapter.SummaryViewHolder>(){

    fun refreshDataList(list: List<SummaryModel>){
        dataList = list
    }

    class SummaryViewHolder(itemLayoutView: View):RecyclerView.ViewHolder(itemLayoutView) {
        val titleCard: TextView = itemLayoutView.findViewById(R.id.title_card)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SummaryViewHolder {
        return SummaryViewHolder(LayoutInflater.from(context).inflate(R.layout.item_home, parent, false))
    }

    override fun getItemCount(): Int {
       return dataList.size
    }

    override fun onBindViewHolder(holder: SummaryViewHolder, position: Int) {
        val summaryModel = dataList[position]
        holder.titleCard.text = summaryModel.country
    }

}