package com.example.threadpool;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;

/**
 * @Description:线程池
 * @Date:2020/6/1
 * @Author: Cheng
 */
@Slf4j
public class MyThreadPool {
        static final Logger LOGGER = LoggerFactory.getLogger(MyThreadPool.class);

        private static final int DEFAULT_MAX_CONCURRENT = Runtime.getRuntime().availableProcessors() * 2;

        private static final String THREAD_POOL_NAME = "MyThreadPool-%d";

//        private static final ThreadFactory FACTORY = new BasicThreadFactory.Builder().namingPattern(THREAD_POOL_NAME).daemon(true).build();
        private static final RejectedExecutionHandler defaultHandler = new ThreadPoolExecutor.AbortPolicy();

        private static final int DEFAULT_SIZE = 500;

        private static final long DEFAULT_KEEP_ALIVE = 60L;

        private static ExecutorService executor;

        private static BlockingQueue<Runnable> executeQueue = new ArrayBlockingQueue<>(DEFAULT_SIZE);

        static {
            try {
                /**
                 * corePoolSize:线程池核心线程数量
                 * maximumPoolSize:线程池最大线程数量
                 * keepAliveTime:存活时间
                 * unit:时间单位
                 * workQueue:线程池中阻塞队列，一般指定队列大小
                 * threadFactory:线程池核心线程数量
                 * handler:拒绝策略
                 */
                executor = new ThreadPoolExecutor(DEFAULT_MAX_CONCURRENT, DEFAULT_MAX_CONCURRENT + 2, DEFAULT_KEEP_ALIVE,
                        TimeUnit.SECONDS,executeQueue, Executors.defaultThreadFactory() ,defaultHandler);

                Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
                    @Override
                    public void run() {
                        LOGGER.info("MyThreadPool shutting down.");
                        executor.shutdown();

                        try {
                            if (!executor.awaitTermination(1, TimeUnit.SECONDS)) {
                                LOGGER.error("MyThreadPool shutdown immediately due to wait timeout.");
                                executor.shutdownNow();
                            }
                        } catch (InterruptedException e) {
                            LOGGER.error("MyThreadPool shutdown interrupted.");
                            executor.shutdownNow();
                        }

                        LOGGER.info("MyThreadPool shutdown complete.");
                    }
                }));
            } catch (Exception e) {
                LOGGER.error("MyThreadPool init error.", e);
                throw new ExceptionInInitializerError(e);
            }
        }

        private MyThreadPool() {
        }

        public static boolean execute(Runnable task) {

            try {
                executor.execute(task);
            } catch (RejectedExecutionException e) {
                LOGGER.error("Task executing was rejected.", e);
                return false;
            }

            return true;
        }

        public static <T> Future<T> submitTask(Callable<T> task) {

            try {
                return executor.submit(task);
            } catch (RejectedExecutionException e) {
                LOGGER.error("Task executing was rejected.", e);
                throw new UnsupportedOperationException("Unable to submit the task, rejected.", e);
            }
        }

}
