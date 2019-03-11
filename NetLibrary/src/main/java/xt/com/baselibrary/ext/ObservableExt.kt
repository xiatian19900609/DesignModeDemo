package xt.com.baselibrary.ext

import com.blankj.utilcode.util.LogUtils
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers

/**
 * 扩展Observable执行
 */
fun <T> Observable<T>.execute(observer: Observer<T>) {
    this.subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(observer)
}

/**
 * 扩展数据转换
 */
fun <F, T> Observable<F>.convert(func: ((f: F) -> T)): Observable<T> {
    return this.flatMap(object : Function<F, Observable<T>> {
        override fun apply(f: F): Observable<T> {
            LogUtils.dTag("==============", "apply :: ${Thread.currentThread().name}")
            val t = func.invoke(f)
            return Observable.just(t)
        }
    })
}