package xt.com.mvvmmode.data.repository

import io.reactivex.Observable
import xt.com.baselibrary.data.net.RetrofitFactory
import xt.com.baselibrary.data.protocol.BaseResponseData
import xt.com.baselibrary.ext.convert
import xt.com.mvvmmode.data.api.MatchApi
import xt.com.mvvmmode.data.protocol.MatchDetails
import xt.com.mvvmmode.data.protocol.MatchList

class MatchRepository {
    companion object {

        fun getMatchList(): Observable<BaseResponseData<MatchList>> {
            return RetrofitFactory.instance.create(MatchApi::class.java).getMatchList("1")
        }
    }
}