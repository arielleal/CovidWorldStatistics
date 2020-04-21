package klinka.com.coronavirus.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import klinka.com.coronavirus.R
import klinka.com.coronavirus.model.SummaryModel


class CoronaAdapter (private var dataList: List<SummaryModel>, private val context: Context):
        RecyclerView.Adapter<CoronaAdapter.CustomViewHolder>(){


    class CustomViewHolder(itemLayoutView: View):RecyclerView.ViewHolder(itemLayoutView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        return CustomViewHolder(LayoutInflater.from(context).inflate(R.layout.item_home, parent, false))
    }

    override fun getItemCount(): Int {
       return dataList.size
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val dataModel = dataList.get(position)
     //   holder.
    }

}