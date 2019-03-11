package xt.com.mvvmmode.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import xt.com.baselibrary.data.protocol.BaseResponseData
import xt.com.baselibrary.data.protocol.ServiceResult
import xt.com.baselibrary.ext.convert
import xt.com.baselibrary.ext.execute
import xt.com.baselibrary.rx.BaseLiveObserver
import xt.com.mvvmmode.data.protocol.MatchDetails
import xt.com.mvvmmode.data.repository.MatchRepository

class MatchListViewModel(application: Application) : AndroidViewModel(application) {
    var matchListLiveData = MutableLiveData<ServiceResult<MutableList<MatchDetails>>>()
    fun loadData() {
        MatchRepository.getMatchList()
            .convert {
                val data = mutableListOf<MatchDetails>()
                it.data.history.matchList.let { list ->
                    data.addAll(list)
                }
                it.data.ongoing.matchList.let { list ->
                    data.addAll(list)
                }
                it.data.future.matchList.let { list ->
                    data.addAll(list)
                }
                return@convert BaseResponseData(it.code, it.message, data)
            }.execute(BaseLiveObserver(matchListLiveData))
    }
}