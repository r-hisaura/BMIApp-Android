package com.example.cries.calcbmi

/**
 * RecyclerViewAdapter
 * 履歴画面で使用する
 * Created by cries on 2019/03/05.
 */
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class RecyclerViewAdapter(private val list: List<RowModel>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    // セクションもしくはアイテムのviewを出し分け時に使用する定数
    private val ITEM = 0
    private val SECTION = 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        Log.d("Adapter", "onCreateViewHolder")
        val rowView: View = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return RecyclerItemViewHolder(rowView)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        Log.d("Adapter", "onBindViewHolder")
        when (holder) {
            is RecyclerItemViewHolder -> {
                holder.titleView.text = list[position].day
                holder.heightView.text = list[position].height
                holder.weightView.text = list[position].weight
                holder.bmiView.text = list[position].bmi
                holder.commentView.text = list[position].comment
                // メモが記載されていない場合、Viewを非表示
                if (holder.commentView.text.isEmpty()) {
                    holder.commentView.visibility = View.GONE
                }
            }
        }

    }

    override fun getItemViewType(position: Int): Int {
        val beforeMonth = list[position - 1].month.toIntOrNull() ?: ITEM
        val nowMonth = list[position].month.toIntOrNull() ?: ITEM
        if (beforeMonth != nowMonth) {
            return SECTION
        }
        return ITEM
    }

    override fun getItemCount(): Int {
        Log.d("Adapter", "getItemCount")
        return list.size
    }
}