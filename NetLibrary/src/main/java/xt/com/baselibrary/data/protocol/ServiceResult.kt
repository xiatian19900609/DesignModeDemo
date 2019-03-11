package xt.com.baselibrary.data.protocol

import xt.com.baselibrary.common.LoadingStatus

class ServiceResult<T>(var status: LoadingStatus, var message: String?, var data: T?)