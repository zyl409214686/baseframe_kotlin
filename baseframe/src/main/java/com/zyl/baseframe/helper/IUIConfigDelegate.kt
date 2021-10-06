package com.zyl.baseframe.helper


/**
 * BaseUi代理类,采用代理模式，用于在上层model中设置baseui参数
 */

abstract class IUIConfigDelegate {


    /**
     * 全局配置头部的文件
     *
     * @return
     */
    abstract fun headerIdRes(): Int

    /**
     * 返回按鈕的名稱
     *
     * @return
     */
    abstract fun headerBackId(): Int

    /**
     * 標題的名稱
     *
     * @return
     */
    abstract fun headerTitleId(): Int

    /**
     * 右側的名稱
     *
     * @return
     */
    abstract fun headerRightId(): Int



}
