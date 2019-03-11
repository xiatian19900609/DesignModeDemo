package xt.com.mvvmmode.ui.activity

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.blankj.utilcode.util.LogUtils
import com.blankj.utilcode.util.ToastUtils
import kotlinx.android.synthetic.main.activity_mvvm.*
import xt.com.baselibrary.common.LoadingStatus
import xt.com.baselibrary.data.protocol.ServiceResult
import xt.com.baselibrary.ui.activity.BaseActivity
import xt.com.mvvmmode.R
import xt.com.mvvmmode.data.protocol.MatchDetails
import xt.com.mvvmmode.ui.adapter.DiffMatchListCallback
import xt.com.mvvmmode.ui.adapter.MatchListAdapter
import xt.com.mvvmmode.ui.viewmodel.MatchListViewModel

class MatchListActivity : BaseActivity() {
    private lateinit var mViewModel: MatchListViewModel
    private lateinit var mAdapter: MatchListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvvm)
        mViewModel = ViewModelProviders.of(this).get(MatchListViewModel::class.java)
        initViews()
        initLiveDataListener()
    }

    override fun onResume() {
        super.onResume()
        mViewModel.loadData()
    }

    override fun initViews() {
        rv_match_list.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        mAdapter = MatchListAdapter(mutableListOf())
        rv_match_list.adapter = mAdapter

        sr.setOnRefreshListener {
            sr.isRefreshing = true
            mViewModel.loadData()
        }
    }

    private fun initLiveDataListener() {
        mViewModel.matchListLiveData.observe(this, Observer {
            LogUtils.dTag("==============", "callback = ${it.status}  ====== ${Thread.currentThread().name}")
            processListData(it)
        })
    }

    private fun processListData(it: ServiceResult<MutableList<MatchDetails>>) {
        when (it.status) {
            LoadingStatus.Loading -> {
                ToastUtils.showShort("加载")
            }
            LoadingStatus.Success -> {
                ToastUtils.showShort("成功")
                it.data?.let { data ->
                    val result = DiffUtil.calculateDiff(DiffMatchListCallback(mAdapter.data, data))
                    result.dispatchUpdatesTo(mAdapter)
                    sr.isRefreshing = false
                    mAdapter.setNewData(data)
                }
            }
            LoadingStatus.Error -> {
                ToastUtils.showShort("失败")
                sr.isRefreshing = false
            }
        }
    }
}

