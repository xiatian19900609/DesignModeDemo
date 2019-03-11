package xt.com.designmodedemo

import android.app.Application
import xt.com.baselibrary.data.net.NetLib

class DdApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        NetLib.init(this)
    }
}