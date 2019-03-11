package xt.com.baselibrary.data.net

import android.app.Application

class NetLib {
    companion object {
        lateinit var application: Application

        fun init(application: Application) {
            this.application = application
        }
    }
}