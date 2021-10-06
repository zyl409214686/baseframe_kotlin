package com.zyl.app.activity

import android.view.View
import android.widget.TextView
import com.zyl.app.R
import com.zyl.baseframe.activity.BaseActivity


class MainActivity : BaseActivity() {

    private val titleStr = "测试"
    override val layoutId: Int
        get() = R.layout.activity_main

    override fun getHeaderType(): HeaderType {
        return HeaderType.TYPE_COMMON_HEADER
    }

    override fun getTitleStr(): String {
        return titleStr
    }

    override fun initView(view: View) {
        var textView: TextView ?= view?.findViewById<TextView>(R.id.tv_world)
        textView?.text = "您好， 大世界haha"
    }
}