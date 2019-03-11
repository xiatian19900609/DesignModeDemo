package xt.com.mvvmmode.ui.adapter

import android.os.Bundle
import androidx.recyclerview.widget.DiffUtil
import xt.com.mvvmmode.data.protocol.MatchDetails

class DiffMatchListCallback(var oldData: MutableList<MatchDetails>, var newData: MutableList<MatchDetails>) :
    DiffUtil.Callback() {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldData[oldItemPosition].unionMatchId == newData[newItemPosition].unionMatchId
    }

    override fun getOldListSize(): Int {
        return oldData.size
    }

    override fun getNewListSize(): Int {
        return newData.size
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val old = oldData[oldItemPosition]
        val new = newData[newItemPosition]
        return if (new.matchStatus == old.matchStatus)
            new.homeGoals == old.homeGoals && new.awayGoals == old.awayGoals
        else
            false
    }

//    override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
//        val old = oldData[oldItemPosition]
//        val new = newData[newItemPosition]
//        val bundle = Bundle()
//        if (new.matchStatus == old.matchStatus) {
//            bundle.putString("matchStatus", new.matchStatus)
//        }
//        return bundle
//
//    }
}