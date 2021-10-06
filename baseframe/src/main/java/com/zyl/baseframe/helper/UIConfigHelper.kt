package com.zyl.baseframe.helper

import java.lang.NullPointerException

class UIConfigHelper {
    companion object {
        var configDelegate: IUIConfigDelegate? = null

        fun setConfig(delegate: IUIConfigDelegate){
            configDelegate = delegate
        }

        fun getConfig(): IUIConfigDelegate {
            if(configDelegate == null)
                throw NullPointerException("configDelegate is null, please call set(delegate:IUIConfigDelegate) method ")
            return configDelegate as IUIConfigDelegate
        }

    }
}