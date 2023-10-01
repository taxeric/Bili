package com.lanier.bili.modules.main.fragment

import android.os.Bundle
import android.view.View
import android.widget.Button
import com.google.android.material.imageview.ShapeableImageView
import com.lanier.bili.R
import com.lanier.bili.base.BaseFra
import com.lanier.bili.ext.start
import com.lanier.bili.modules.login.LoginAct2

/**
 * Created by 幻弦让叶
 * on 2023/9/28
 */
class MineFra private constructor(
    override val layoutId: Int = R.layout.fra_mine
) : BaseFra() {

    companion object {
        fun newInstance(): MineFra {
            val args = Bundle()

            val fragment = MineFra()
            fragment.arguments = args
            return fragment
        }
    }

    private lateinit var btnLogin: Button
    private lateinit var ivAvatar: ShapeableImageView

    override fun initView(view: View) {
        btnLogin = view.findViewById(R.id.btnLogin)
        ivAvatar = view.findViewById(R.id.ivAvatar)

        btnLogin.setOnClickListener {
            requireContext().start<LoginAct2>()
        }
    }
}