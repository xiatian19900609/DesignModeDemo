package xt.com.baselibrary.rx

import androidx.lifecycle.MutableLiveData
import com.blankj.utilcode.util.LogUtils
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import xt.com.baselibrary.common.LoadingStatus
import xt.com.baselibrary.data.protocol.BaseResponseData
import xt.com.baselibrary.data.protocol.ServiceResult

/**
 * 默认观察者实现
 * @param liveData 绑定LiveData ,通过liveData数据的变化通知UI刷新
 */
class BaseLiveObserver<T>(var liveData: MutableLiveData<ServiceResult<T>>) : Observer<BaseResponseData<T>> {
    override fun onComplete() {
    }

    override fun onSubscribe(d: Disposable) {
        LogUtils.dTag("==============", "onSubscribe :: ${Thread.currentThread().name}")
        liveData.value = ServiceResult(LoadingStatus.Loading, null, null)
    }

    override fun onNext(t: BaseResponseData<T>) {
        LogUtils.dTag("==============", "onNext :: ${Thread.currentThread().name}")
        liveData.value = ServiceResult(LoadingStatus.Success, null, t.data)
    }

    override fun onError(e: Throwable) {
        liveData.value = ServiceResult(LoadingStatus.Error, null, null)
    }
}