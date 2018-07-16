package com.cn5.appstore.manager;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *
 * 管理线程池 根据不同的业务 开启的线程数 不一样
 *
 * Created by xzhang on 2017/5/15.
 */

public class ThreadManager {

    private static ThreadPoolProxy mLongPool=null;
    private static Object mLongLock=new Object();

    private static ThreadPoolProxy mShortPool=null;
    private static Object mShortLock=new Object();

    private static ThreadPoolProxy mDownLoadPool=null;
    private static Object mDownLoadLock=new Object();

    /**
     * 一般请求网络 用长的线程池  联网耗时比较长 尽量的让其它任务在别的线程中
     * @return
     */
    public static ThreadPoolProxy creatLongPool(){
        synchronized (mLongLock) {
            if(mLongPool==null){
                mLongPool=new ThreadPoolProxy(5, 5, 5L);
            }
            return mLongPool;
        }
    }
    /**本地IO*/
    public static ThreadPoolProxy creatShortPool(){
        synchronized (mShortLock) {
            if(mShortPool==null){
                mShortPool=new ThreadPoolProxy(2, 2, 5L);
            }
            return mShortPool;
        }
    }
    public static ThreadPoolProxy creatDownLoadPool(){
        synchronized (mDownLoadLock) {
            if(mDownLoadPool==null){
                mDownLoadPool=new ThreadPoolProxy(2, 2, 5L);
            }
            return mDownLoadPool;
        }
    }

    /**
     * 封装了线程池
     *
     * @author itcast
     *
     */
    public static class ThreadPoolProxy {
        private ThreadPoolExecutor mPool;// 系统提供的线程池
        private int mCorePoolSize;  // 线程数量
        private int maximumPoolSize; //额外的数量
        private long mKeepAliveTime;  //保持的时间



        public ThreadPoolProxy(int mCorePoolSize,
                               int maximumPoolSize, long mKeepAliveTime) {
            super();
            this.mCorePoolSize = mCorePoolSize;
            this.maximumPoolSize = maximumPoolSize;
            this.mKeepAliveTime = mKeepAliveTime;
        }



        public synchronized void execute(Runnable runnable) {
            if (runnable == null) {
                return;
            }
            if (mPool == null) {
				/*
				 * 1 线程池的任务数量
				 * 2 如果队列放满了 额外创建的线程
				 * 3 没有任务的还能活多久
				 * 4 存活时间的单位
				 * 5 线程池满了队列   可以指定上限
				 * 6 创建线程池的工厂
				 * 7 处理异常的Handler (固定写法 )
				 */
                mPool = new ThreadPoolExecutor(mCorePoolSize, maximumPoolSize,
                        mKeepAliveTime, TimeUnit.SECONDS,
                        new LinkedBlockingQueue<Runnable>(10),
                        Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
            }
            mPool.execute(runnable);
        }
        /**
         * 移除任务
         * @param runnable
         */
        public synchronized void cancel(Runnable runnable){
            if(runnable==null){
                return;
            }
            if(mPool!=null&& (!mPool.isShutdown()||mPool.isTerminated())){
                mPool.getQueue().remove(runnable);
            }

        }
    }
}
