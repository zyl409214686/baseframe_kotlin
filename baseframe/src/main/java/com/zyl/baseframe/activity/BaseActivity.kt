package com.zyl.baseframe.activity

import android.content.pm.ActivityInfo
import android.os.Build
import android.os.Build.VERSION_CODES.O
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import com.zyl.baseframe.R
import com.zyl.baseframe.helper.UIConfigHelper
import com.zyl.baseframe.utils.status.StatusBarDarkUtils
import com.zyl.baseframe.utils.status.StatusBarUtils



abstract class BaseActivity : AppCompatActivity() {
    protected lateinit var mFakeStatusBarView : View
    protected lateinit var mRootView : ViewGroup
    protected var mHeaderType: Int = HeaderType.TYPE_COMMON_HEADER.type

    protected lateinit var mIvBack: ImageView
    protected lateinit var mTitleTv: TextView
    protected lateinit var mRightTv: TextView

    @get:LayoutRes
    abstract val layoutId: Int

    enum class HeaderType(val type: Int) {
        TYPE_COMMON_HEADER(0),
        TYPE_NOT_HEADER(1)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStatusBar()
        mRootView = layoutInflater.inflate(R.layout.activity_base, null) as ViewGroup
        initAndAddFakeStatusBar()
        initAndAddHeaderView()
        val contentView = layoutInflater.inflate(layoutId, null)
        val containerViewGroup = mRootView.findViewById<ViewGroup>(R.id.fl_container)
        containerViewGroup.addView(contentView)
        setContentView(mRootView)
        initView(mRootView)
    }

    private fun initAndAddHeaderView() {
        mHeaderType = getHeaderType().type
        if (mHeaderType == HeaderType.TYPE_COMMON_HEADER.type) {
            var headView = layoutInflater.inflate(UIConfigHelper.getConfig().headerIdRes(), null)
            mIvBack = headView.findViewById<ImageView>(UIConfigHelper.getConfig().headerBackId())
            mIvBack.setOnClickListener {
                finish()
            }
            mTitleTv = headView.findViewById<TextView>(UIConfigHelper.getConfig().headerTitleId())
            mTitleTv.setText(getTitleStr())
            mRightTv = headView.findViewById<TextView>(UIConfigHelper.getConfig().headerRightId())
            mRootView.addView(headView, 1)

            initView(mRootView)
            if(Build.VERSION.SDK_INT != O){
                requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
            }
        }
    }

    private fun initAndAddFakeStatusBar(){
        mFakeStatusBarView = LayoutInflater.from(this).inflate(R.layout.layout_fake_statusbar, mRootView, false)
        val layoutParams = mFakeStatusBarView.layoutParams
        layoutParams.height = StatusBarUtils.getStatusBarHeight(this)
        mFakeStatusBarView.layoutParams = layoutParams
        mRootView.addView(mFakeStatusBarView, 0)
    }

    fun setStatusBar(){
        StatusBarUtils.setTranslucent(this, 0)
        StatusBarDarkUtils.setStatusBarMode(this, true)
    }

    abstract fun getHeaderType(): HeaderType
    abstract fun getTitleStr(): String
    abstract fun initView( view: View)

}