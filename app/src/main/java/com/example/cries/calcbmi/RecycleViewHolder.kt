package com.example.cries.calcbmi

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.list_item.view.*

/**
 * 履歴画面のリストのViewを保持するクラス
 * Created by cries on 2019/03/05.
 */
class RecyclerItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    val titleView = itemView.row_title_text
    val heightView = itemView.row_height_text
    val weightView = itemView.row_weight_text
    val bmiView = itemView.row_bmi_text
    val commentView = itemView.row_comment_text
}