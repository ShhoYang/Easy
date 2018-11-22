package com.hao.easy.paging

import android.arch.lifecycle.MutableLiveData
import android.arch.paging.DataSource
import android.arch.paging.PageKeyedDataSource
import android.util.Log
import com.hao.easy.paging.db.Student
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * @author Yang Shihao
 * @date 2018/11/17
 */
class StudentDataSource : PageKeyedDataSource<Int, Student>() {

    companion object {
        val TAG = "StudentDataSource"
    }

    var j: Int = 0

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, Student>) {
        Log.d(TAG, "loadInitial " + params.requestedLoadSize)
        Observable.create<List<Student>> { e ->
            var list = ArrayList<Student>()
            for (i in 1..10) {
                list.add(Student(0, j++.toString()))
            }
            e.onNext(list)
        }.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    callback.onResult(it, -1, 1)
                }

    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Student>) {
        Log.d(TAG, "loadAfter " + params.key)
        Observable.create<List<Student>> {
            var list = ArrayList<Student>()
            for (i in 1..10) {
                list.add(Student(0, j++.toString()))
            }
            it.onNext(list)
        }.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {

                    if(params.key == 10){
                        callback.onResult(it, null)
                    }else {
                        callback.onResult(it, params.key + 1)
                    }

                }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Student>) {
        Log.d(TAG, "loadBefore " + params.key)
    }
}


class DataSourceFactory : DataSource.Factory<Int, Student>() {
    override fun create(): DataSource<Int, Student> {
        val mutableLiveData = MutableLiveData<StudentDataSource>()
        val studentDataSource = StudentDataSource()
        return studentDataSource
    }
}