package com.lanier.bili.utils

import android.graphics.Bitmap
import android.graphics.Color
import com.google.zxing.BarcodeFormat
import com.google.zxing.EncodeHintType
import com.google.zxing.MultiFormatWriter
import com.google.zxing.pdf417.decoder.ec.ErrorCorrection
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel

/**
 * Created by 幻弦让叶
 * on 2023/10/1
 */
object QRCodeHelper {

    fun generateQRCode(
        content: String,
        width: Int = 300,
        height: Int = 300
    ): Bitmap {
        val map = mutableMapOf<EncodeHintType, Any>()
        map[EncodeHintType.CHARACTER_SET] = "utf-8"
        map[EncodeHintType.ERROR_CORRECTION] = ErrorCorrectionLevel.M
        map[EncodeHintType.MARGIN] = 1

        val writer = MultiFormatWriter()
        val bitMatrix = writer.encode(content, BarcodeFormat.QR_CODE, width, height, map)
        val mw = bitMatrix.width
        val mh = bitMatrix.height
        val bitmap = Bitmap.createBitmap(mw, mh, Bitmap.Config.RGB_565)
        for (i in 0 until mw) {
            for (j in 0 until mh) {
                bitmap.setPixel(i, j, if (bitMatrix.get(i, j)) Color.BLACK else Color.WHITE)
            }
        }
        return bitmap
    }
}