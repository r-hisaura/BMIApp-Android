package com.example.cries.calcbmi

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AlertDialog
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_input.*


/**
 * 入力画面fragment
 *
 * 作成日:2019/02/12
 */
class InputFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_input, container, false)
    }

    override fun onResume() {
        super.onResume()
        val context = context as? MainActivity ?: return
        calcBmiButton.setOnClickListener {
            // 入力値が数値でない場合、ダイアログを表示する
            val height = editHeight.text.toString().toDoubleOrNull() ?: 0.0
            val weight = editWeight.text.toString().toDoubleOrNull() ?: 0.0

            if (height == 0.0 || weight == 0.0) {
                AlertDialog.Builder(context)
                        .setTitle("タダシイ　アタイ　\nニュウリョク　スル")
                        .setPositiveButton("ワカッタ", null)
                        .show()
                return@setOnClickListener
            }

            val data = CalcBmiLogic.calcBmi(height, weight)
            textBmi.text = String.format("%.1f", data)
        }

    }

}
