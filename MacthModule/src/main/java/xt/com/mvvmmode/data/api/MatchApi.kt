package xt.com.mvvmmode.data.api

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import xt.com.baselibrary.data.protocol.BaseResponseData
import xt.com.mvvmmode.data.protocol.MatchDetails
import xt.com.mvvmmode.data.protocol.MatchList
import xt.com.mvvmmode.data.protocol.MatchNewsList

interface MatchApi {
    /**
     *
     */
    @GET("command/execute?command=600002/{matchDate}")
    fun getNewsList(@Path("matchDate") matchDate: String): Observable<BaseResponseData<MatchNewsList>>

    @GET("command/execute?command=200061")
    fun getMatchDetails(@Query("unionMatchId") unionMatchId: String): Observable<BaseResponseData<MatchDetails>>

    @GET("command/execute?command=200052")
    fun getMatchList(@Query("category") category :String): Observable<BaseResponseData<MatchList>>
}