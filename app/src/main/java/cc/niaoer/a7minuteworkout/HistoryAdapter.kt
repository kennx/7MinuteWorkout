package cc.niaoer.a7minuteworkout

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import cc.niaoer.a7minuteworkout.databinding.ItemHistoryRowBinding

class HistoryAdapter(val context: Context, val items: ArrayList<String>): RecyclerView.Adapter<HistoryAdapter.ViewHolder>() {

    class ViewHolder(binding: ItemHistoryRowBinding): RecyclerView.ViewHolder(binding.root) {
        val llHistoryMainItem = binding.llHistoryItemMain
        val tvItem = binding.tvItem
        val tvPosition = binding.tvPosition
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemHistoryRowBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val date: String = items.get(position)

        holder.tvPosition.text = (position + 1).toString()
        holder.tvItem.text = date

        if (position % 2 == 0) {
            holder.llHistoryMainItem.setBackgroundColor(
                Color.parseColor("#EBEBEB")
            )
        } else {
            holder.llHistoryMainItem.setBackgroundColor(
                Color.parseColor("#FFFFFF")
            )
        }
    }

}