package com.example.cries.calcbmi

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.support.v4.app.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_input -> {
                replaceFragment(InputFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_history -> {
                replaceFragment(HistoryFragment())
                return@OnNavigationItemSelectedListener true
            }

        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        // 初期表示
        replaceFragment(InputFragment())
    }

    /**
     * fragmentの画面遷移処理
     * @param fragment
     */
    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, fragment)
                .commit()
    }
}

