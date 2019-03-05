package com.example.cries.calcbmi

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_history.*


/**
 * 履歴画面fragment
 *
 * 作成日:2019/02/12
 */
class HistoryFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_history, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        super.onViewCreated(view, savedInstanceState)
        Log.d("lifeCycle", "onViewCreated")

        val recyclerView = recycler_list
        val adapter = RecyclerViewAdapter(createDataList())

        val itemDecoration = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        recyclerView.addItemDecoration(itemDecoration)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = adapter
    }

    // TODO recyclerView動作確認用メソッド
    private fun createDataList(): List<RowModel> {

        val dataList = mutableListOf<RowModel>()
        for (i in 0..20) {
            val data: RowModel = RowModel().also {
                it.month = "1月"
                it.day = """${i + 1}日"""
                it.height = "身長:185cm"
                it.weight = "体重:50kg"
                it.bmi = "BMI:15.0"
            }
            dataList.add(data)
        }

        for (i in 1..11) {
            val data: RowModel = RowModel().also {
                it.month = """${i + 1}月"""
                it.day = """${i}日"""
                it.height = "身長:165cm"
                it.weight = "体重:100kg"
                it.bmi = "BMI:37.0"
                it.comment = "太った太った太った太った太った太った太った太った太った太った太った太った太った太った太った太った太った太った太った太った太った太った太った太った太った太った"
            }
            dataList.add(data)
        }
        return dataList
    }


}
