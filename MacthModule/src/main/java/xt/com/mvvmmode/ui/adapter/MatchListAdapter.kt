package xt.com.mvvmmode.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import xt.com.mvvmmode.R
import xt.com.mvvmmode.data.protocol.MatchDetails

class MatchListAdapter(var data: MutableList<MatchDetails>) : RecyclerView.Adapter<MatchListAdapter.ViewHolder>() {

    fun setNewData(newData: MutableList<MatchDetails>) {
        this.data = newData
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflate = LayoutInflater.from(parent.context).inflate(R.layout.item_match_list, parent, false)
        return ViewHolder(inflate)
    }

    override fun getItemCount(): Int {
        return data.size
    }

//    override fun onBindViewHolder(holder: ViewHolder, position: Int, payloads: MutableList<Any>) {
//        super.onBindViewHolder(holder, position, payloads)
//        if (payloads.isEmpty()) {
//            onBindViewHolder(holder, position)
//            return
//        }
//        val info = data[position]
//        val get = payloads[0] as Bundle
//        val status = get.getString("matchStatus")
//        if (status == "1") {
//            holder.tvScore.text = "VS"
//        } else {
//            holder.tvScore.text = "${info.homeGoals} - ${info.awayGoals}"
//        }
//    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val info = data[position]
        holder.tvHomeName.text = info.homeName
        holder.tvAwayName.text = info.awayName
        Glide.with(holder.ivHomeIcon).load(info.homeLogo).into(holder.ivHomeIcon)
        Glide.with(holder.ivAwayIcon).load(info.awayLogo).into(holder.ivAwayIcon)
        if (info.matchStatus == "1") {
            holder.tvScore.text = "VS"
        } else {
            holder.tvScore.text = "${info.homeGoals} - ${info.awayGoals}"
        }
        holder.tvLeagueName.text = "${info.leagueName} ${info.matchBeginTime.substring(0, 16)}"
        holder.tvMatchStatus.text = info.matchStatusName
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var tvHomeName = view.findViewById<TextView>(R.id.tv_home_name)!!
        var tvAwayName = view.findViewById<TextView>(R.id.tv_away_name)!!
        var tvLeagueName = view.findViewById<TextView>(R.id.tv_league_name)!!
        var tvMatchStatus = view.findViewById<TextView>(R.id.tv_status)!!
        var ivHomeIcon = view.findViewById<ImageView>(R.id.iv_home_icon)!!
        var ivAwayIcon = view.findViewById<ImageView>(R.id.iv_away_icon)!!
        var tvScore = view.findViewById<TextView>(R.id.tv_score)!!
    }
}