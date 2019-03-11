package xt.com.mvvmmode.data.protocol

data class MatchDetails(
    var unionMatchId: String,
    var arenaName: String,
    var matchBeginTime: String,
    var leagueName: String,
    var matchStatusName: String,
    var matchStatus: String,


    var awayGoals: String,
    var awayLogo: String,
    var awayName: String,

    var currentScore: String,

    var homeGoals: String,
    var homeLogo: String,
    var homeName: String
)