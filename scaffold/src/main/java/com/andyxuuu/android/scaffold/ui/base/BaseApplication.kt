package com.andyxuuu.android.scaffold.ui.base

import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner
import com.zeugmasolutions.localehelper.LocaleAwareApplication

/**
 *  author : Andy Xuuu
 *  date : 11/24/20
 *  description :
 *  LocaleAwareApplication 可以动态配置应用的语言，主题等等全局信息
 */
class BaseApplication : LocaleAwareApplication(), ViewModelStoreOwner {
    //提供一个全局的ViewModel
    val globalViewModelStore = ViewModelStore()

    override fun getViewModelStore(): ViewModelStore {
        return globalViewModelStore
    }

}