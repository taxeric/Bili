package com.lanier.bili.modules.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.lanier.bili.R
import com.lanier.bili.apis.BiliApis
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(), CoroutineScope by MainScope() {

    private var qrkey = ""
    private val btnGet by lazy {
        findViewById<Button>(R.id.btnGetCode)
    }

    private val btnScan by lazy {
        findViewById<Button>(R.id.btnScanCode)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnGet.setOnClickListener { get() }
        btnScan.setOnClickListener { scan() }

//        checkCookie();
    }

    private fun get() {
        launch {
            val data = BiliApis.requestWebQRCode()
            if (data.code == 0) {
                qrkey = data.data?.qrcode_key?:""
            }
        }
    }

    private fun scan() {
        launch {
            val res = BiliApis.scanQRCodeForLogin(qrkey)
            println(res.data)
        }
    }

/*    private fun checkCookie(){
        val str = CookieUtils.getVmid()
        Log.e("bobtest:", str)
        if (str.isEmpty()){
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }*/
}