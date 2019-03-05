package com.example.cries.calcbmi

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.list_item.view.*
import kotlinx.android.synthetic.main.list_section_item.view.*

/**
 * 履歴画面のセクションのViewを保持するクラス
 * Created by cries on 2019/03/05.
 */
class RecyclerSectionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val sectionview = itemView.section_text
    val titleView = itemView.section_title_text
    val heightView = itemView.section_height_text
    val weightView = itemView.section_weight_text
    val bmiView = itemView.section_bmi_text
    val commentView = itemView.section_comment_text
}

