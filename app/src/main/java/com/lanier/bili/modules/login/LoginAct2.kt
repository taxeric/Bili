package com.lanier.bili.modules.login

import android.content.DialogInterface
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import com.lanier.bili.R
import com.lanier.bili.ext.collect
import com.lanier.bili.uri.obtainPictureMediaUri
import com.lanier.bili.utils.QRCodeHelper

class LoginAct2 : AppCompatActivity() {

    private val vm by viewModels<LoginVM>()
    private var qrCodeBitmap: Bitmap? = null

    private val btnLogin by lazy {
        findViewById<Button>(R.id.btnLogin)
    }
    private val btnScanCompleted by lazy {
        findViewById<Button>(R.id.btnScanCompleted)
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
        btnScanCompleted.setOnClickListener {
            vm.scanCompleted(
                success = {
                    vm.saveCookies {
                        setResult(RESULT_OK)
                        finish()
                    }
                },
                err = {
                    Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
                }
            )
        }

        ivQRCode.setOnLongClickListener {
            downloadInquire()
            true
        }

        collect(vm.qrUrl) {
            if (it.isNotEmpty()) {
                qrCodeBitmap = QRCodeHelper.generateQRCode(it)
                ivQRCode.setImageBitmap(qrCodeBitmap)
            }
        }
    }

    private fun downloadInquire() {
        val listener = object : DialogInterface.OnClickListener {
            override fun onClick(dialog: DialogInterface?, which: Int) {
                if (which == DialogInterface.BUTTON_POSITIVE) {
                    val uriCase = obtainPictureMediaUri(this@LoginAct2, "qrcode_login")
                    contentResolver.openOutputStream(uriCase.uri)
                        .use { opsm ->
                            opsm?.let {
                                qrCodeBitmap?.compress(Bitmap.CompressFormat.JPEG, 100, it)
                                Toast.makeText(this@LoginAct2, "saved", Toast.LENGTH_SHORT).show()
                            }
                        }
                }
                dialog?.dismiss()
            }
        }
        AlertDialog.Builder(this)
            .setMessage("下载并跳转")
            .setPositiveButton("确定", listener)
            .show()
    }

    override fun onDestroy() {
        super.onDestroy()
        qrCodeBitmap = null
    }
}