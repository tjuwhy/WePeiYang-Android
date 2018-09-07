package com.example.yellowpages2

import android.animation.ObjectAnimator
import android.app.Activity
import android.content.*
import android.content.pm.PackageManager
import android.net.Uri
import android.provider.ContactsContract
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.app.AlertDialog
import android.support.v7.widget.AlertDialogLayout
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.twt.wepeiyang.commons.experimental.cache.RefreshState
import es.dmoral.toasty.Toasty
import org.jetbrains.anko.layoutInflater
import org.jetbrains.anko.sdk25.coroutines.onClick
import java.util.jar.Manifest

class HeaderItem(val context: Context) : Item {

    companion object Controller : ItemController {
        override fun onBindViewHolder(holder: android.support.v7.widget.RecyclerView.ViewHolder, item: Item) {
            item as HeaderItem
            holder as HeaderViewHolder
            val viewList = arrayListOf<ImageView>(holder.tju1895, holder.libIv,
                    holder.hospitalIv, holder.dormitoryIv, holder.bikeIv, holder.teamIv, holder.bankIv, holder.fixIv)
            viewList.forEachIndexed { index, imageView ->
                imageView.setOnClickListener {
                    startActivity(item.context,index)
                }
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup): android.support.v7.widget.RecyclerView.ViewHolder {
            val inflater = parent.context.layoutInflater
            val view = inflater.inflate(R.layout.item_home_header,parent,false)
            val tju1895 = view.findViewById<ImageView>(R.id.food)
            val libIv = view.findViewById<ImageView>(R.id.lib)
            val hospitalIv = view.findViewById<ImageView>(R.id.hospital)
            val dormitoryIv = view.findViewById<ImageView>(R.id.dormitory)
            val bikeIv = view.findViewById<ImageView>(R.id.bike)
            val teamIv = view.findViewById<ImageView>(R.id.team)
            val bankIv = view.findViewById<ImageView>(R.id.bank)
            val fixIv = view.findViewById<ImageView>(R.id.fix)
            return HeaderViewHolder(view,tju1895, libIv, hospitalIv, dormitoryIv, bikeIv, teamIv, bankIv, fixIv)
        }

        fun startActivity(context: Context,index : Int){
            val intent = Intent(context,DepartmentActivity::class.java)
            when(index){
                0 -> addExtra(intent,2,18)
                1 -> addExtra(intent,2,0)
                2 -> addExtra(intent,2,2)
                3 -> addExtra(intent,0,15)
                4 -> addExtra(intent,2,19)
                5 -> addExtra(intent,0,20)
                6 -> addExtra(intent,2,20)
                7 -> addExtra(intent,0,14)
            }
            context.startActivity(intent)
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

class SubItem(val context:Context, val name:String ,val groupIndex: Int,val childIndex: Int,val firstIndex:Int) : Item {
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
            holder.itemView.setOnClickListener {
                val intent = Intent(item.context,DepartmentActivity::class.java)
                intent.putExtra("first_index",item.firstIndex-1)
                intent.putExtra("second_index",item.childIndex)
                item.context.startActivity(intent)
            }
        }

    }

    class ViewHolder(itemView: View, val textView: TextView):RecyclerView.ViewHolder(itemView)
}

class ChildItem(val context: Context,val name: String ,val phoneNum : String,var isStared:Boolean,val tid:Int) : Item{
    override val controller: ItemController
        get() = Controller

    companion object Controller : ItemController{
        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: Item) {
            holder as ChildViewHolder
            item as ChildItem
            holder.thirdName.text = item.name
            holder.phoneTv.text = item.phoneNum
            holder.isStared.apply {
                if (item.isStared){
                    setImageResource(R.drawable.favorite_light)
                } else {
                    setImageResource(R.drawable.favourite_dark)
                }
                onClick {
                    update(item.tid){ refreshState,str ->
                        when(refreshState){
                            is RefreshState.Success -> {
                                if (item.isStared){
                                    Toast.makeText(item.context, str,Toast.LENGTH_SHORT).show()
                                    item.isStared = false
                                    holder.isStared.setImageResource(R.drawable.favourite_dark)
                                } else {
                                    Toast.makeText(item.context,str,Toast.LENGTH_SHORT).show()
                                    item.isStared = true
                                    holder.isStared.setImageResource(R.drawable.favorite_light)
                                }
                            }
                            is RefreshState.Failure -> {

                                Toasty.error(item.context,"$str，请检查网络")
                            }
                        }
                    }
                }
            }

            holder.phoneIv.setOnClickListener {
                val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:${item.phoneNum}"))
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                item.context.startActivity(intent)
            }
            holder.itemView.setOnLongClickListener {
                val items = arrayListOf("复制号码","新建联系人","报错/反馈")
                val normalDialog = AlertDialog.Builder(item.context)
                normalDialog.setItems(items.toTypedArray()){ _, which ->
                    when(which){
                        0 -> {
                            val cm = ( item.context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager)
                            cm.text = item.phoneNum.trim()
                            Toast.makeText(item.context, "已复制到剪贴板",Toast.LENGTH_SHORT).show()
                        }
                        1 -> {

                            //申请读写联系人权限
//                            val permission = ContextCompat.checkSelfPermission(item.context,android.Manifest.permission.WRITE_CONTACTS)
//                            if (permission == PackageManager.PERMISSION_DENIED){
//                                ActivityCompat.requestPermissions(item.context as Activity, arrayOf(android.Manifest.permission.WRITE_CONTACTS,android.Manifest.permission.READ_CONTACTS),321)
//                            }
//                            val values = ContentValues()
//                            val rawContractUri = item.context.contentResolver.insert(ContactsContract.RawContacts.CONTENT_URI,values)
//                            val rawContactId = ContentUris.parseId(rawContractUri)
//                            values.clear()
//                            values.put(ContactsContract.Contacts.Data.RAW_CONTACT_ID, rawContactId)
//                            values.put(ContactsContract.Contacts.Data.MIMETYPE, ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE)
//                            values.put(ContactsContract.CommonDataKinds.StructuredName.GIVEN_NAME, item.name)
//                            item.context.contentResolver.insert(android.provider.ContactsContract.Contacts.CONTENT_URI,values)
//
//                            values.clear()
//                            values.put(ContactsContract.Contacts.Data.RAW_CONTACT_ID,rawContactId)
//                            values.put(ContactsContract.Contacts.Data.MIMETYPE, ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE)//待修改分类
//                            values.put(ContactsContract.CommonDataKinds.Phone.NUMBER,item.phoneNum)
//                            values.put(ContactsContract.CommonDataKinds.Phone.TYPE, if (item.phoneNum.length == 11) ContactsContract.CommonDataKinds.Phone.TYPE_MOBILE else ContactsContract.CommonDataKinds.Phone.TYPE_OTHER)
//                            item.context.contentResolver.insert(android.provider.ContactsContract.Contacts.CONTENT_URI,values)

                        }
                        2 -> {
                            val normalDialog1 = AlertDialog.Builder(item.context)
                            normalDialog1.setMessage("号码/名称有误？大佬要加群反馈下吗？")
                                    .setPositiveButton("加吧") { _, _ ->
                                        val qq = "738068756"
                                        val url = "mqqwpa://im/chat?chat_type=group&uin=$qq&version=1"
                                        item.context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
                                    }
                                    .setNegativeButton("算了") { _, _ -> }
                            normalDialog1.show()
                        }
                    }
                }
                normalDialog.show()
                true
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
            val inflater = parent.context.layoutInflater
            val view = inflater.inflate(R.layout.item_home_child, parent,false)
            val thirdName = view.findViewById<TextView>(R.id.third_name)
            val phoneTv = view.findViewById<TextView>(R.id.phone_tv)
            val isStared = view.findViewById<ImageView>(R.id.is_starred)
            val phoneIv = view.findViewById<ImageView>(R.id.phone_button)
            return ChildViewHolder(view, thirdName, phoneTv, isStared, phoneIv)
        }
    }

    class ChildViewHolder(itemView: View, val thirdName: TextView ,val phoneTv:TextView, val isStared: ImageView, val phoneIv:ImageView):RecyclerView.ViewHolder(itemView)
}

private fun addExtra(intent: Intent, firstIndex: Int, secondIndex: Int) {
    intent.putExtra("first_index", firstIndex)
    intent.putExtra("second_index", secondIndex)
}

