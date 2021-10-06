package com.zyl.baseframe

import android.app.Application
import android.content.Context
import com.zyl.baseframe.helper.UIConfigHelper

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        appContext = this
        initUIConfig()
    }

    companion object {
        lateinit var appContext: Context
    }

    fun initUIConfig(){
        UIConfigHelper.configDelegate = UIConfigDelegateImpl()
    }
}