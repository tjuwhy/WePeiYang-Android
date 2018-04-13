package com.twt.service.schedule2.view.detail

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.twt.service.schedule2.R
import com.twt.service.schedule2.extensions.getChineseCharacter
import com.twt.service.schedule2.model.Course

class CourseInfoComponent(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val courseNameTextView: TextView = itemView.findViewById(R.id.tv_course_name)
    private val courseTypeTextView: TextView = itemView.findViewById(R.id.tv_course_type)
    private val courseTeacherTextView: TextView = itemView.findViewById(R.id.tv_course_teacher)
    private val courseCreditTextView: TextView = itemView.findViewById(R.id.tv_course_credit)
    private val courseStatusTextView: TextView = itemView.findViewById(R.id.tv_course_status)

    fun bind(course: Course) {
        courseNameTextView.text = course.coursename
        courseTypeTextView.text = "${course.coursenature} - ${course.coursetype}"
        courseTeacherTextView.text = course.teacher
        courseCreditTextView.text = "${course.credit}学分"
        courseStatusTextView.text = course.statusMessage
    }

    companion object {
        fun create(inflater: LayoutInflater, parent: ViewGroup): CourseInfoComponent {
            val view = inflater.inflate(R.layout.schedule_item_course_info, parent, false)
            return CourseInfoComponent(view)
        }
    }

}

class CourseIndicatorComponent(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val indicatorTextView: TextView = itemView.findViewById(R.id.tv_course_indicator)
    fun bind(indicator: String) {
        indicatorTextView.text = indicator
    }

    companion object {
        fun create(inflater: LayoutInflater, parent: ViewGroup): CourseIndicatorComponent {
            val view = inflater.inflate(R.layout.schedule_item_indicator, parent, false)
            return CourseIndicatorComponent(view)
        }
    }
}

class CourseDetailComponent(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val iconImageView: ImageView = itemView.findViewById(R.id.iv_item_detail)
    private val detailTextView: TextView = itemView.findViewById(R.id.tv_item_detail)
    private val container: ViewGroup = itemView.findViewById(R.id.container_item_detail)

    fun bind(viewModel: CourseDetailViewModel) {
        iconImageView.setImageResource(viewModel.imgResId)
        detailTextView.text = viewModel.content
        container.setOnClickListener {
            viewModel.clickBlock.invoke(it)
        }
    }

    companion object {
        fun create(inflater: LayoutInflater, parent: ViewGroup): CourseDetailComponent {
            val view = inflater.inflate(R.layout.schedule_item_detail, parent, false)
            return CourseDetailComponent(view)
        }
    }
}

data class CourseDetailViewModel(val imgResId: Int, val content: String, val clickBlock: (View) -> Unit = {})

fun createCourseDetailList(course: Course): List<Any> {
    val list = mutableListOf<Any>()
    list.add(course)
    list.add("上课地点")
    val week = course.week
    course.arrangeBackup.forEach {
        list.add(CourseDetailViewModel(
                R.drawable.ic_schedule_location,
                "${week.start}-${week.end}周，${it.week}上课，每周${getChineseCharacter(it.day)}第${it.start}-${it.end}节\n${it.room}"
        ))
    }
    list.add("其他信息")
    list.add(CourseDetailViewModel(R.drawable.ic_schedule_other, "逻辑班号：${course.classid}\n课程编号：${course.courseid}"))
    list.add("自定义")
    list.add(CourseDetailViewModel(R.drawable.ic_schedule_search, "在蹭课功能中搜索相似课程"))
    list.add(CourseDetailViewModel(R.drawable.ic_schedule_event, "添加自定义课程/事件"))
    list.add(CourseDetailViewModel(R.drawable.ic_schedule_homework, "添加课程作业/考试"))
    list.add("帮助")
    list.add(CourseDetailViewModel(R.drawable.ic_schedule_info, "如何使用课程表的自定义功能"))
    return list
}