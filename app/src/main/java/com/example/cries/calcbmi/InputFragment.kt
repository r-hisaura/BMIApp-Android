package com.example.cries.calcbmi

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AlertDialog
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
        return inflater.inflate(R.layout.fragment_input, container, false)
    }

    // TODO:onResumeでいい？
    override fun onResume() {
        super.onResume()
        val context = context as? MainActivity ?: return

        // 計算ボタン押下時の処理
        calc_bmi_button.setOnClickListener {
            // 入力値が0または数値でない場合、ダイアログを表示する
            val height = height_edit.text.toString().toDoubleOrNull() ?: 0.0
            val weight = weight_edit.text.toString().toDoubleOrNull() ?: 0.0

            if (height == 0.0 || weight == 0.0) {
                AlertDialog.Builder(context)
                        .setTitle("タダシイ　アタイ　\nニュウリョク　スル")
                        .setPositiveButton("ワカッタ", null)
                        .show()
                return@setOnClickListener
            }

            // BMIを計算する
            val data = CalcBmiLogic.calcBmi(height, weight)
            result_bmi_text.text = String.format("%.1f", data)
        }

        // 削除ボタン押下時の処理
        delete_button.setOnClickListener {
            // コメント内を削除する
            comment_edit.text.clear()
        }
    }
}
