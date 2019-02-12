package com.example.cries.calcbmi

/**
 * Created by cries on 2019/02/12.
 */
 class CalcBmiLogic {

    /**
     * BMIを計算する
     * 計算式 = 体重(kg) / 身長(m) * 身長(m)
     * @param height 身長(cm)
     * @param weight 体重(kg)
     * @return result bmi数値
     */
    fun calcBmi(height:Double, weight:Double): Double {
        val transferHeight = height / 100

        val result = weight / (transferHeight * transferHeight)
        print("result:" + result)

        return result

    }
}
