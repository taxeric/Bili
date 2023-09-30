package com.lanier.bili.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import com.lanier.bili.ext.index

/**
 * Created by 幻弦让叶
 * on 2023/9/30
 */
class FragmentHelper(
    var showIndex: Int = 0,
    private val fragmentManager: FragmentManager
) {

    private val _fragments = mutableListOf<SwitchFragment>()

    fun setFragments(
        fragments: List<SwitchFragment>,
    ) {
        _fragments.clear()
        _fragments.addAll(fragments)
    }

    fun addFragment(
        fragment: SwitchFragment
    ) {
        _fragments.add(fragment)
    }

    fun switchFra(index: Int) {
        if (_fragments.isEmpty()) {
            return
        }
        if (index < 0 || index > _fragments.index) {
            return
        }
        fragmentManager.commit {
            if (showIndex != index) {
                hide(getFraByIndex(showIndex))
                if (getFraByIndex(index).isAdded) {
                    show(getFraByIndex(index))
                } else {
                    add(getFraByIndex(index), getTagByIndex(index))
                }
                showIndex = index
            }
        }
    }

    private fun getFraByIndex(index: Int) = _fragments[index].fragment

    private fun getTagByIndex(index: Int) = _fragments[index].tag

    data class SwitchFragment(
        val fragment: Fragment,
        val tag: String = fragment.javaClass.simpleName
    )
}