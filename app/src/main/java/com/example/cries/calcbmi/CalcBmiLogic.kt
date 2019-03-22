package com.example.cries.calcbmi

import java.lang.Math.round

/**
 * BMI計算ロジッククラス
 * Created by cries on 2019/02/12.
 */
object CalcBmiLogic {

        /**
         * BMIを計算する
         * 計算式 = 体重(kg) / 身長(m) * 身長(m)
         * @param height 身長(cm)
         * @param weight 体重(kg)
         * @return result bmi数値 小数点第2位で四捨五入
         */
        fun calcBmi(height: Double, weight: Double): Double {
            val result = weight / Math.pow(height / 100, 2.0)
            print("result:$result")
            return round(result * 10.0) / 10.0
    }
}
