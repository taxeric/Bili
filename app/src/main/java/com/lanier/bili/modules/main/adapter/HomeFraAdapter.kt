package com.lanier.bili.modules.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.google.android.material.imageview.ShapeableImageView
import com.lanier.bili.R
import com.lanier.bili.models.BiliRecommendVideoItem

/**
 * Created by 幻弦让叶
 * on 2023/9/30
 */
class HomeFraAdapter(private val layoutId: Int): RecyclerView.Adapter<HomeFraViewHolder>() {

    private val _list = mutableListOf<BiliRecommendVideoItem>()
    var data: List<BiliRecommendVideoItem>
        set(value) {
            _list.clear()
            _list.addAll(value)
            notifyDataSetChanged()
        }
        get() = _list

    var onClick: ((BiliRecommendVideoItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeFraViewHolder {
        return HomeFraViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(layoutId, parent, false),
        )
    }

    override fun getItemCount() = _list.size

    override fun onBindViewHolder(holder: HomeFraViewHolder, position: Int) {
        holder.bind(_list[position])
        holder.itemView
            .setOnClickListener {
                onClick?.invoke(_list[position])
            }
    }
}

class HomeFraViewHolder(
    itemView: View,
): RecyclerView.ViewHolder(itemView) {

    val modelPosition get() = layoutPosition

    val ivPic = itemView.findViewById<ShapeableImageView>(R.id.ivPic)
    val tvTitle = itemView.findViewById<TextView>(R.id.tvTitle)
    val tvUsername = itemView.findViewById<TextView>(R.id.tvUsername)

    internal fun bind(model: BiliRecommendVideoItem) {
        ivPic.load(model.pic)
        tvTitle.text = model.title
        tvUsername.text = model.owner.name
    }
}