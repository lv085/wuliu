package com.wuliu.utils;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;


public class ODDGenerator {
    private static final AtomicInteger atomicInteger = new AtomicInteger(1);
    private static ThreadLocal<StringBuilder> threadLocal = new ThreadLocal<StringBuilder>();

    /**
     * 短码生成策略
     * 1307891882965
     * @return
     */
    public static String getOrderNo() {
        if (Objects.isNull(threadLocal.get())) {
            String lock = UUID.randomUUID().toString();
            StringBuilder builder = new StringBuilder(ThreadLocalRandom.current().nextInt(0, 999)); // 随机数
            builder.append(Math.abs(lock.hashCode()));// HASH-CODE
            builder.append(atomicInteger.getAndIncrement());// 自增顺序
            threadLocal.set(builder);
        }
        return threadLocal.get().toString();
    }

    public static void main(String[] args) {
        System.out.println(getOrderNo());
    }

}
