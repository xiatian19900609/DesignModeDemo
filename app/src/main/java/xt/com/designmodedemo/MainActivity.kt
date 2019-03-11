package xt.com.designmodedemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import xt.com.mvvmmode.ui.activity.MatchListActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_mvvm.setOnClickListener {
            startActivity(Intent(this, MatchListActivity::class.java))
        }
    }
}
