package com.lanier.bili.modules.main.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.android.material.divider.MaterialDividerItemDecoration
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.lanier.bili.R
import com.lanier.bili.base.BaseFra
import com.lanier.bili.ext.collect
import com.lanier.bili.modules.main.MainVM
import com.lanier.bili.modules.main.adapter.HomeFraAdapter

/**
 * Created by 幻弦让叶
 * on 2023/9/28
 */
class HomeFra private constructor(
    override val layoutId: Int = R.layout.fra_home
) : BaseFra() {

    private val vm by activityViewModels<MainVM>()

    private lateinit var recyclerView: RecyclerView
    private lateinit var refreshBtn: FloatingActionButton

    private lateinit var mAdapter: HomeFraAdapter

    companion object {
        fun newInstance(): HomeFra {
            val args = Bundle()

            val fragment = HomeFra()
            fragment.arguments = args
            return fragment
        }
    }

    override fun initView(view: View) {
        recyclerView = view.findViewById(R.id.recyclerView)
        refreshBtn = view.findViewById(R.id.floatActionButton)

        mAdapter = HomeFraAdapter(R.layout.rv_item_home_fra)
        mAdapter.onClick = {
        }
        recyclerView.layoutManager = StaggeredGridLayoutManager(2, RecyclerView.VERTICAL)
        recyclerView.adapter = mAdapter
        recyclerView.addItemDecoration(MaterialDividerItemDecoration(requireContext(), RecyclerView.VERTICAL))

        refreshBtn.setOnClickListener {
            vm.getRecommendVideos()
        }

        collect(vm.recommendVideos) {
            mAdapter.data = it
        }
    }

    override fun initData() {
        vm.getRecommendVideos()
    }
}