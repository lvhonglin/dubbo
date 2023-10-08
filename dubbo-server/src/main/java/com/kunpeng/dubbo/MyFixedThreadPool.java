package com.kunpeng.dubbo;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.threadlocal.NamedInternalThreadFactory;
import org.apache.dubbo.common.threadpool.support.AbortPolicyWithReport;
import org.apache.dubbo.common.threadpool.support.fixed.FixedThreadPool;

import java.util.concurrent.*;

import static org.apache.dubbo.common.constants.CommonConstants.*;
import static org.apache.dubbo.common.constants.CommonConstants.DEFAULT_QUEUES;

public class MyFixedThreadPool extends FixedThreadPool {
    private ThreadPoolExecutor threadPoolExecutor;
    @Override
    public Executor getExecutor(URL url) {
        System.out.println("开始创建线程池");
        String name = url.getParameter(THREAD_NAME_KEY, DEFAULT_THREAD_NAME);
        int threads = url.getParameter(THREADS_KEY, DEFAULT_THREADS);
        int queues = url.getParameter(QUEUES_KEY, DEFAULT_QUEUES);
        ThreadPoolExecutor threadPoolExecutor1 = new ThreadPoolExecutor(threads, threads, 0, TimeUnit.MILLISECONDS,
                queues == 0 ? new SynchronousQueue<Runnable>() :
                        (queues < 0 ? new LinkedBlockingQueue<Runnable>()
                                : new LinkedBlockingQueue<Runnable>(queues)),
                new NamedInternalThreadFactory(name, true), new AbortPolicyWithReport(name, url));
        this.threadPoolExecutor=threadPoolExecutor1;
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    System.out.println("当前活跃线程数:"+threadPoolExecutor.getActiveCount()+"," +
                            "当前线程数:"+threadPoolExecutor.getPoolSize());
                    try {
                        TimeUnit.SECONDS.sleep(3);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }).start();
        System.out.println("线程池创建成功");
        return threadPoolExecutor1;
    }
}
