package com.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadApp {

    private static List list = (new ArrayList());

    public static void main(String[] args) throws ExecutionException, InterruptedException {



//        new ThreadFactoryBuilder();

//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 10, 1000, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(10),Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
//
//        for (int i = 0; i < 10; i++) {
//
//            Future<?> submit = threadPoolExecutor.submit(new Runnable() {
//                public void run() {
//                    System.out.println(Thread.currentThread().getName());
//                }
//            });
//
//            System.out.println(submit.isDone());
//        }
//
//
//        threadPoolExecutor.shutdown();
        ExecutorService executorService = Executors.newCachedThreadPool();
        ExecutorService executorService1 = Executors.newFixedThreadPool(2);

//        Callable myCallable = new MyCallable();

        for (int j = 0; j < 10; j++) {
            Future submit = executorService.submit(new MyCallable(j));
            System.out.println(submit.get());
        }

        System.out.println(list.size());

        executorService.shutdown();

    }

    public static void doSomething(int k) {

//        System.out.println(Thread.currentThread().getName());

        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();

//        System.out.println(reentrantLock.isLocked());

        list.add("test");

        if (k % 3 == 0) {
            list.remove(0);
        }
//        reentrantLock.unlock();
    }

   static class MyCallable<String> implements Callable {

       private Integer k;

       public MyCallable(Integer k) {
           this.k = k;
       }

       /**
         * Computes a result, or throws an exception if unable to do so.
         *
         * @return computed result
         * @throws Exception if unable to compute a result
         */
        public java.lang.String call() throws Exception {

            doSomething(this.k);

            return "run success";
        }
    }

    static class MyRunable implements Runnable {

        private Integer k;

        public MyRunable(Integer k) {
            this.k = k;
        }

        /**
         * When an object implementing interface <code>Runnable</code> is used
         * to create a thread, starting the thread causes the object's
         * <code>run</code> method to be called in that separately executing
         * thread.
         * <p>
         * The general contract of the method <code>run</code> is that it may
         * take any action whatsoever.
         *
         * @see Thread#run()
         */
        public void run() {
            doSomething(this.k);
        }
    }
}
