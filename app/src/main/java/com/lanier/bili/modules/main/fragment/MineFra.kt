package com.lanier.bili.modules.main.fragment

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import coil.load
import com.google.android.material.imageview.ShapeableImageView
import com.lanier.bili.R
import com.lanier.bili.base.BaseFra
import com.lanier.bili.ext.collect
import com.lanier.bili.ext.start
import com.lanier.bili.modules.login.LoginAct2
import com.lanier.bili.modules.main.MainVM

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
    private lateinit var tvUsername: TextView
    private lateinit var tvDesc: TextView
    private lateinit var tvMore: TextView
    private lateinit var tvFans: TextView
    private lateinit var tvFollowers: TextView

    private val vm by activityViewModels<MainVM>()

    override fun initView(view: View) {
        btnLogin = view.findViewById(R.id.btnLogin)
        ivAvatar = view.findViewById(R.id.ivAvatar)
        tvUsername = view.findViewById(R.id.tvUsername)
        tvDesc = view.findViewById(R.id.tvDesc)
        tvMore = view.findViewById(R.id.tvMore)
        tvFans = view.findViewById(R.id.tvFans)
        tvFollowers = view.findViewById(R.id.tvFollowers)

        btnLogin.setOnClickListener {
            requireContext().start<LoginAct2>()
        }
        tvMore.setOnClickListener {
        }

        collect(vm.userCardInfo) { user ->
            ivAvatar.load(user.card.face)
            tvUsername.text = user.card.name
            tvDesc.text = user.card.description
            tvFans.text = "粉丝数: ${user.card.fans}"
            tvFollowers.text = "关注数: ${user.card.attention}"
        }
    }

    override fun initData() {
        vm.getMineInfo()
    }
}