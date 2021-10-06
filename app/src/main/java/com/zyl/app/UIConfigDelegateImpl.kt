package com.zyl.baseframe

import com.zyl.baseframe.helper.IUIConfigDelegate
import com.zyl.app.R

/**
 * Created by user on 2019/7/29.
 */

class UIConfigDelegateImpl : IUIConfigDelegate() {
    override fun headerIdRes(): Int {
        return R.layout.layout_header
    }

    override fun headerBackId(): Int {
        return R.id.iv_back
    }

    override fun headerTitleId(): Int {
        return R.id.tv_title
    }

    override fun headerRightId(): Int {
        return R.id.tv_right
    }


}
