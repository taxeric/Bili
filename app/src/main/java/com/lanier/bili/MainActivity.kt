package com.lanier.bili

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import com.lanier.bili.login.LoginActivity
import com.lanier.bili.utils.CookieUtils

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        checkCookie();
    }

    private fun checkCookie(){
        val str = CookieUtils.getVmid()
        Log.e("bobtest:", str)
        if (str.isEmpty()){
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}