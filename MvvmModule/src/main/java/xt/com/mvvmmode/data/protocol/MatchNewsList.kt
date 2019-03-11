package xt.com.mvvmmode.data.protocol

data class MatchNewsList(val data: MutableList<MatchDetails>) {

    data class MatchDetails(
        val matchId: String,
        val unionMatchId: String,
        val homeId: String,
        val homeName: String,
        val awayId: String,
        val awayName: String,
        val homeLogo: String,
        val awayLogo: String,
        val leagueName: String,
        val leagueColor: String,
        val stage: String,
        val turn: String,
        val matchNo: String,
        val matchBeginTime: String,
        val tips: MutableList<NewsInfo>

    )

    data class NewsInfo(
        val id: String,
        val subTitle: String,
        val title: String,
        val content: String,
        val publishTime: String,
        val authorId: String,
        val authorName: String,
        val picUrl: String,
        val teamTypeId: String,
        val teamTypeName: String,
        val withPic: String
    )
}