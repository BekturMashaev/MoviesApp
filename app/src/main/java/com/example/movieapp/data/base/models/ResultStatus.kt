package com.example.movieapp.data.base.models

import java.io.IOException

data class ResultStatus<T>(
    val status:ResponseStatus,
    val data:T?,
    val errorThrowable: Throwable?=null
){
    companion object{
        fun <T> success(data:T?=null): ResultStatus<T> {
            return ResultStatus(ResponseStatus.SUCCESS,data =data)
        }
        fun <T> error(errorThrowable: Throwable?,data:T?):ResultStatus<T>{
            return ResultStatus(ResponseStatus.ERROR,errorThrowable=errorThrowable,data= data)
        }
    }
}

data class AnotherError(
    val errorMessage:String,
    val code:Int
): IOException()
