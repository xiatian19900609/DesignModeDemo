package xt.com.mvvmmode.data.protocol

data class MatchList(var ongoing: MatchListInfo, var history: MatchListInfo, var future: MatchListInfo) {

    data class MatchListInfo(var matchList: MutableList<MatchDetails>)
}