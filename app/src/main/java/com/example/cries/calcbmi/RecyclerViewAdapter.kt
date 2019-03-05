package com.example.cries.calcbmi

/**
 * RecyclerViewAdapter
 * 履歴画面で使用する
 * Created by cries on 2019/03/05.
 */
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class RecyclerViewAdapter(private val list: List<RowModel>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        // セクションもしくはアイテムのviewを出し分け時に使用する定数
        const val ITEM_TYPE = 0
        private const val SECTION_TYPE = 1
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        Log.d("Adapter", "onCreateViewHolder")
        return when (viewType) {
            SECTION_TYPE -> RecyclerSectionViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_section_item, parent, false))
            ITEM_TYPE -> RecyclerItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false))
            else -> RecyclerItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false))
        }
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
                } else {
                    holder.commentView.visibility = View.VISIBLE
                }

            }
            is RecyclerSectionViewHolder -> {
                // 月はセクション表示判定のため、ここで月をつける
                holder.sectionview.text = list[position].month
                holder.titleView.text = list[position].day
                holder.heightView.text = list[position].height
                holder.weightView.text = list[position].weight
                holder.bmiView.text = list[position].bmi
                holder.commentView.text = list[position].comment
                // メモが記載されていない場合、Viewを非表示
                if (holder.commentView.text.isEmpty()) {
                    holder.commentView.visibility = View.GONE
                } else {
                    holder.commentView.visibility = View.VISIBLE
                }
            }
        }

    }

    override fun getItemViewType(position: Int): Int {
        // 一番最初はセクションを表示する
        if (position == 0) {
            return SECTION_TYPE
        }
        val lastMonth = list[position - 1].month
        val nowMonth = list[position].month

        // 月の値が違う場合、セクションを出す
        if (lastMonth != nowMonth) {
            return SECTION_TYPE
        }
        return ITEM_TYPE
    }

    override fun getItemCount(): Int {
        Log.d("Adapter", "getItemCount")
        return list.size
    }
}