package com.example.yellowpages2

import android.animation.ObjectAnimator
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import org.jetbrains.anko.layoutInflater
import org.jetbrains.anko.sdk25.coroutines.onClick

class HeaderItem() : Item {

    companion object Controller : ItemController {
        override fun onBindViewHolder(holder: android.support.v7.widget.RecyclerView.ViewHolder, item: Item) {
            item as HeaderItem
            holder as HeaderViewHolder
        }

        override fun onCreateViewHolder(parent: ViewGroup): android.support.v7.widget.RecyclerView.ViewHolder {
            val inflater = parent.context.layoutInflater
            val view = inflater.inflate(R.layout.item_home_header,parent,false)
            val tju1895 = view.findViewById<ImageView>(R.id.tju1895)
            val libIv = view.findViewById<ImageView>(R.id.lib)
            val hospitalIv = view.findViewById<ImageView>(R.id.hospital)
            val dormitoryIv = view.findViewById<ImageView>(R.id.dormitory)
            val bikeIv = view.findViewById<ImageView>(R.id.bike)
            val teamIv = view.findViewById<ImageView>(R.id.team)
            val bankIv = view.findViewById<ImageView>(R.id.bank)
            val fixIv = view.findViewById<ImageView>(R.id.fix)
            return HeaderViewHolder(view,tju1895, libIv, hospitalIv, dormitoryIv, bikeIv, teamIv, bankIv, fixIv)
        }

    }

    class HeaderViewHolder(itemView : View, val tju1895:ImageView, val libIv:ImageView, val hospitalIv : ImageView,
                            val dormitoryIv :ImageView, val bikeIv:ImageView,val teamIv :ImageView,val bankIv :ImageView,
                            val fixIv:ImageView) : RecyclerView.ViewHolder(itemView)

    override val controller: ItemController = Controller

}

class GroupItem(val groupData: GroupData,val expandable: Expandable) : Item {
    override val controller: ItemController
        get() = Controller

    companion object Controller : ItemController{
        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: Item) {
            holder as GroupViewHolder
            item as GroupItem
            holder.groupTitle.text = item.groupData.title
            holder.itemView.setOnClickListener {
                if(item.groupData.isExpanded){
                    item.expandable.collapse(item.groupData.groupIndex)
                    item.groupData.isExpanded = false
                    ObjectAnimator.ofFloat(holder.arrowIv,"rotation",90f, 0f).setDuration(500).start()
                } else {
                    item.expandable.expand(item.groupData.groupIndex)
                    item.groupData.isExpanded = true
                    ObjectAnimator.ofFloat(holder.arrowIv,"rotation",0f, 90f).setDuration(500).start()
                }
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
            val layoutInflater = parent.context.layoutInflater
            val view = layoutInflater.inflate(R.layout.item_home_group,parent,false)
            val arrowIv = view.findViewById<ImageView>(R.id.state_arrow)
            val groupTitle = view.findViewById<TextView>(R.id.group_name)
            return GroupViewHolder(view, arrowIv,groupTitle)
        }

    }

    class GroupViewHolder(itemView: View, val arrowIv:ImageView,val groupTitle:TextView) : RecyclerView.ViewHolder(itemView)
}

class SubItem(val name:String ,val groupIndex: Int,val childIndex: Int) : Item {
    override val controller: ItemController
        get() = Controller

    companion object Controller : ItemController{
        override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
            val layoutInflater = parent.context.layoutInflater
            val view = layoutInflater.inflate(R.layout.item_home_sub,parent,false)
            val textView = view.findViewById<TextView>(R.id.sub_text)
            return ViewHolder(view , textView)
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: Item) {
            holder as ViewHolder
            item as SubItem
            holder.textView.text = item.name
        }

    }

    class ViewHolder(itemView: View, val textView: TextView):RecyclerView.ViewHolder(itemView)
}

class ChildItem(val phoneNum : String,val isStared:Boolean,val groupIndex: Int,val childIndex:Int) : Item{
    override val controller: ItemController
        get() = Controller

    companion object Controller : ItemController{
        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: Item) {
            holder as ChildViewHolder
            item as ChildItem
            holder.phoneTv.text = item.phoneNum
            holder.isStared.apply {
                if (item.isStared){
                    setImageResource(R.drawable.favorite_light)
                } else {
                    setImageResource(R.drawable.favourite_dark)
                }
                onClick {
                    //updatestarstate
                }
            }
            holder.phoneIv.setOnClickListener {

            }
        }

        override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
            val inflater = parent.context.layoutInflater
            val view = inflater.inflate(R.layout.item_home_child, parent,false)
            val phoneTv = view.findViewById<TextView>(R.id.phone_tv)
            val isStared = view.findViewById<ImageView>(R.id.is_starred)
            val phoneIv = view.findViewById<ImageView>(R.id.phone_button)
            return ChildViewHolder(view, phoneTv, isStared, phoneIv)
        }
    }

    class ChildViewHolder(itemView: View ,val phoneTv:TextView, val isStared: ImageView, val phoneIv:ImageView):RecyclerView.ViewHolder(itemView)
}

