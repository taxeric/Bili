package com.lanier.bili.modules.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.viewModels
import com.lanier.bili.R
import com.lanier.bili.ext.collect
import com.lanier.bili.utils.QRCodeHelper

class LoginAct2 : AppCompatActivity() {

    private val vm by viewModels<LoginVM>()

    private val btnLogin by lazy {
        findViewById<Button>(R.id.btnLogin)
    }
    private val ivQRCode by lazy {
        findViewById<ImageView>(R.id.ivQRCode)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_login)

        btnLogin.setOnClickListener {
            vm.requestQRCode()
        }

        collect(vm.qrUrl) {
            if (it.isNotEmpty()) {
                val bitmap = QRCodeHelper.generateQRCode(it)
                ivQRCode.setImageBitmap(bitmap)
//                bitmap.recycle()
            }
        }
    }
}