package com.howellsdk.utils;


import android.util.Log;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by Administrator on 2017/8/7.
 */

public class RxUtil {

    public  static <T> Disposable doInUIThread(final RxSimpleTask<T> uiTask){
        return Flowable.just(uiTask)
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<RxSimpleTask<T>>() {
                    @Override
                    public void accept(@NonNull RxSimpleTask<T> uiTask) throws Exception {
                        uiTask.doTask();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
                        throwable.printStackTrace();
                        uiTask.doTaskError(throwable);
                    }
                }, new Action() {
                    @Override
                    public void run() throws Exception {
                        uiTask.doFinish();
                    }
                });
    }

    public static <T> Disposable doInIOTthread(final RxSimpleTask<T> ioTask){

        return Flowable.just(ioTask)
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<RxSimpleTask<T>>() {
                    @Override
                    public void accept(@NonNull RxSimpleTask<T> ioTask) throws Exception {
                        ioTask.doTask();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
                        ioTask.doTaskError(throwable);
                    }
                }, new Action() {
                    @Override
                    public void run() throws Exception {
                        ioTask.doFinish();
                    }
                });
    }

    public static <T> Disposable doRxTask(final CommonTask<T> t){
        return Flowable.create(new FlowableOnSubscribe<CommonTask>() {

            @Override
            public void subscribe(@NonNull FlowableEmitter<CommonTask> e) throws Exception {
                t.doInIOThread();
                e.onNext(t);
                e.onComplete();
            }
        },BackpressureStrategy.BUFFER)

                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<CommonTask>() {
                    @Override
                    public void accept(@NonNull CommonTask commonTask) throws Exception {
                        commonTask.doInUIThread();
                    }

                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
                        t.doError(throwable);
                    }
                }, new Action() {
                    @Override
                    public void run() throws Exception {
                        t.doFinish();
                    }
                });
    }



    public static abstract class RxSimpleTask<T>{
        private T t;

        public T getT() {
            return t;
        }

        public void setT(T t) {
            this.t = t;
        }

        public abstract void doTask();
        public void doTaskError(Throwable throwable){throwable.printStackTrace();}
        public void doFinish(){}
        public RxSimpleTask(T t){
            setT(t);
        }
        public RxSimpleTask() {}
    }


    public static abstract class CommonTask<T>{
        private T t;

        public CommonTask() {
        }

        public CommonTask(T t) {

            setT(t);
        }

        public T getT() {

            return t;
        }

        public void setT(T t) {
            this.t = t;
        }

        public abstract void doInIOThread();

        public abstract void doInUIThread();

        public void doError(Throwable throwable){throwable.printStackTrace();}

        public void doFinish(){}
    }

}
