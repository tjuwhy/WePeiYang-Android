package com.example.yellowpages2.view

import android.animation.ObjectAnimator
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.support.v7.app.AlertDialog
import android.support.v7.widget.RecyclerView
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.yellowpages2.R
import com.example.yellowpages2.model.Department
import com.example.yellowpages2.model.GroupData
import com.example.yellowpages2.service.update
import com.example.yellowpages2.utils.Expandable
import com.example.yellowpages2.utils.Item
import com.example.yellowpages2.utils.ItemController
import com.twt.wepeiyang.commons.experimental.cache.RefreshState
import es.dmoral.toasty.Toasty
import org.jetbrains.anko.layoutInflater
import org.jetbrains.anko.sdk25.coroutines.onClick
import java.util.regex.Matcher
import java.util.regex.Pattern

class HeaderItem(val context: Context) : Item {

    companion object Controller : ItemController {
        override fun onBindViewHolder(holder: android.support.v7.widget.RecyclerView.ViewHolder, item: Item) {
            item as HeaderItem
            holder as HeaderViewHolder
            val viewList = arrayListOf(holder.tju1895, holder.libIv,
                    holder.hospitalIv, holder.dormitoryIv, holder.bikeIv, holder.teamIv, holder.bankIv, holder.fixIv)
            viewList.forEachIndexed { index, imageView ->
                imageView.setOnClickListener {
                    startActivity(item.context, index)
                }
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup): android.support.v7.widget.RecyclerView.ViewHolder {
            val inflater = parent.context.layoutInflater
            val view = inflater.inflate(R.layout.item_home_header, parent, false)
            val tju1895 = view.findViewById<ImageView>(R.id.food)
            val libIv = view.findViewById<ImageView>(R.id.lib)
            val hospitalIv = view.findViewById<ImageView>(R.id.hospital)
            val dormitoryIv = view.findViewById<ImageView>(R.id.dormitory)
            val bikeIv = view.findViewById<ImageView>(R.id.bike)
            val teamIv = view.findViewById<ImageView>(R.id.team)
            val bankIv = view.findViewById<ImageView>(R.id.bank)
            val fixIv = view.findViewById<ImageView>(R.id.fix)
            return HeaderViewHolder(view, tju1895, libIv, hospitalIv, dormitoryIv, bikeIv, teamIv, bankIv, fixIv)
        }

        fun startActivity(context: Context, index: Int) {
            val intent = Intent(context, DepartmentActivity::class.java)
            when (index) {
                0 -> addExtra(intent, 2, 18)
                1 -> addExtra(intent, 2, 0)
                2 -> addExtra(intent, 2, 2)
                3 -> addExtra(intent, 0, 15)
                4 -> addExtra(intent, 2, 19)
                5 -> addExtra(intent, 0, 20)
                6 -> addExtra(intent, 2, 20)
                7 -> addExtra(intent, 0, 14)
            }
            context.startActivity(intent)
        }

    }

    class HeaderViewHolder(itemView: View, val tju1895: ImageView, val libIv: ImageView, val hospitalIv: ImageView,
                           val dormitoryIv: ImageView, val bikeIv: ImageView, val teamIv: ImageView, val bankIv: ImageView,
                           val fixIv: ImageView) : RecyclerView.ViewHolder(itemView)

    override val controller: ItemController = Controller

}

class GroupItem(val groupData: GroupData, val expandable: Expandable) : Item {
    override val controller: ItemController
        get() = Controller

    companion object Controller : ItemController {
        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: Item) {
            holder as GroupViewHolder
            item as GroupItem
            holder.groupTitle.text = item.groupData.title
            holder.itemView.setOnClickListener {
                if (item.groupData.isExpanded) {
                    item.expandable.collapse(item.groupData.groupIndex)
                    item.groupData.isExpanded = false
                    ObjectAnimator.ofFloat(holder.arrowIv, "rotation", 90f, 0f).setDuration(500).start()
                } else {
                    item.expandable.expand(item.groupData.groupIndex)
                    item.groupData.isExpanded = true
                    ObjectAnimator.ofFloat(holder.arrowIv, "rotation", 0f, 90f).setDuration(500).start()
                }
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
            val layoutInflater = parent.context.layoutInflater
            val view = layoutInflater.inflate(R.layout.item_home_group, parent, false)
            val arrowIv = view.findViewById<ImageView>(R.id.state_arrow)
            val groupTitle = view.findViewById<TextView>(R.id.group_name)
            return GroupViewHolder(view, arrowIv, groupTitle)
        }

    }

    class GroupViewHolder(itemView: View, val arrowIv: ImageView, val groupTitle: TextView) : RecyclerView.ViewHolder(itemView)
}

class SubItem(val context: Context, val name: String, val groupIndex: Int, val childIndex: Int, val firstIndex: Int) : Item {
    override val controller: ItemController
        get() = Controller

    companion object Controller : ItemController {
        override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
            val layoutInflater = parent.context.layoutInflater
            val view = layoutInflater.inflate(R.layout.item_home_sub, parent, false)
            val textView = view.findViewById<TextView>(R.id.sub_text)
            return ViewHolder(view, textView)
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: Item) {
            holder as ViewHolder
            item as SubItem
            holder.textView.text = item.name
            holder.itemView.setOnClickListener {
                val intent = Intent(item.context, DepartmentActivity::class.java)
                intent.putExtra("first_index", item.firstIndex - 1)
                intent.putExtra("second_index", item.childIndex)
                item.context.startActivity(intent)
            }
        }

    }

    class ViewHolder(itemView: View, val textView: TextView) : RecyclerView.ViewHolder(itemView)
}

class ChildItem(val context: Context, val name: String, val phoneNum: String, var isStared: Boolean, val tid: Int) : Item {
    override val controller: ItemController
        get() = Controller

    companion object Controller : ItemController {
        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: Item) {
            holder as ChildViewHolder
            item as ChildItem
            holder.thirdName.text = item.name
            holder.phoneTv.text = item.phoneNum
            holder.isStared.apply {
                if (item.isStared) {
                    setImageResource(R.drawable.favorite_light)
                } else {
                    setImageResource(R.drawable.favourite_dark)
                }
                onClick {
                    update(item.tid) { refreshState, str ->
                        when (refreshState) {
                            is RefreshState.Success -> {
                                if (item.isStared) {
                                    Toast.makeText(item.context, str, Toast.LENGTH_SHORT).show()
                                    item.isStared = false
                                    holder.isStared.setImageResource(R.drawable.favourite_dark)
                                } else {
                                    Toast.makeText(item.context, str, Toast.LENGTH_SHORT).show()
                                    item.isStared = true
                                    holder.isStared.setImageResource(R.drawable.favorite_light)
                                }
                            }
                            is RefreshState.Failure -> {

                                Toasty.error(item.context, "$str，请检查网络")
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
            holder.itemView.setOnClickListener {
                val items = arrayListOf("复制号码", "新建联系人", "报错/反馈")
                val normalDialog = AlertDialog.Builder(item.context)
                normalDialog.setItems(items.toTypedArray()) { _, which ->
                    when (which) {
                        0 -> {
                            val cm = (item.context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager)
                            cm.text = item.phoneNum.trim()
                            Toast.makeText(item.context, "已复制到剪贴板", Toast.LENGTH_SHORT).show()
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
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
            val inflater = parent.context.layoutInflater
            val view = inflater.inflate(R.layout.item_home_child, parent, false)
            val thirdName = view.findViewById<TextView>(R.id.third_name)
            val phoneTv = view.findViewById<TextView>(R.id.phone_tv)
            val isStared = view.findViewById<ImageView>(R.id.is_starred)
            val phoneIv = view.findViewById<ImageView>(R.id.phone_button)
            return ChildViewHolder(view, thirdName, phoneTv, isStared, phoneIv)
        }
    }

    class ChildViewHolder(itemView: View, val thirdName: TextView, val phoneTv: TextView, val isStared: ImageView, val phoneIv: ImageView) : RecyclerView.ViewHolder(itemView)
}

class CharItem(val a: Char) : Item {

    companion object Cotroller : ItemController {
        override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
            val inflater = parent.context.layoutInflater
            val view = inflater.inflate(R.layout.item_char, parent, false)
            val char = view.findViewById<TextView>(R.id.item_text_char)
            return ViewHolder(view, char)
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: Item) {
            item as CharItem
            holder as ViewHolder
            holder.char.text = item.a.toString()
        }

    }

    class ViewHolder(itemView: View, val char: TextView) : RecyclerView.ViewHolder(itemView)

    override val controller: ItemController
        get() = Cotroller

}

private fun addExtra(intent: Intent, firstIndex: Int, secondIndex: Int) {
    intent.putExtra("first_index", firstIndex)
    intent.putExtra("second_index", secondIndex)
}

class SearchHistoryItem(val content: String) : Item {

    companion object Cotroller : ItemController {


        override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
            val inflater = parent.context.layoutInflater
            val view = inflater.inflate(R.layout.item_search_history, parent, false)
            val textView = view.findViewById<TextView>(R.id.text_search_history)
            val imageView = view.findViewById<ImageView>(R.id.item_search_delete)
            return ViewHolder(view, textView, imageView)
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: Item) {
            holder as ViewHolder
            item as SearchHistoryItem
            holder.itemView.setOnClickListener {
                //实现点击历史记录跳转到搜索
            }
            holder.textView.text = item.content
            holder.textView.setOnLongClickListener {
                holder.imageView.visibility = View.VISIBLE
                true
            }
        }
    }

    override val controller: ItemController
        get() = Cotroller

    class ViewHolder(itemView: View, val textView: TextView, val imageView: ImageView) : RecyclerView.ViewHolder(itemView)
}

class SearchResultItem(val context: Context, val department: Department, val subList: MutableList<String>, val query: String) : Item {


    companion object Cotroller : ItemController {
        override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
            val inflater = parent.context.layoutInflater
            val view = inflater.inflate(R.layout.item_search_result, parent, false)
            val textView = view.findViewById<TextView>(R.id.item_sear_result_text1)
            val textView2 = view.findViewById<TextView>(R.id.item_sear_result_text2)
            return ViewHolder(view, textView, textView2)
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: Item) {
            holder as ViewHolder
            item as SearchResultItem
            var content = ""
            if (item.subList.size > 1) {
                item.subList.forEach {
                    content += "$it、"
                }
            } else if (item.subList.size in 1..1) content += item.subList[0]
            holder.textView2!!.setSingleLine()
            holder.textView!!.text = matchText(item.department.department_name, item.query)
            holder.textView2.text = matchText(content, item.query)
            holder.itemView.setOnClickListener {
                val intent = Intent(item.context, DepartmentActivity::class.java)
                intent.putExtra("first_index", item.department.department_attach.toInt() - 1)
                intent.putExtra("second_index", when (item.department.department_attach.toInt()) {
                    1 -> item.department.id - 1
                    2 -> item.department.id - 29
                    3 -> item.department.id - 54
                    else -> 0
                })
                item.context.startActivity(intent)
            }
        }

        fun matchText(text: String, keyword: String): SpannableString {
            val ss = SpannableString(text)
            val pattern: Pattern = Pattern.compile(keyword)
            val matcher: Matcher = pattern.matcher(ss)
            while (matcher.find()) {
                val start: Int = matcher.start()
                val end: Int = matcher.end()
                ss.setSpan(ForegroundColorSpan(Color.parseColor("#45a0e3")), start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

            }
            return ss
        }
    }

    class ViewHolder(itemView: View?, val textView: TextView?, val textView2: TextView?) : RecyclerView.ViewHolder(itemView)

    override val controller: ItemController
        get() = Cotroller


}


