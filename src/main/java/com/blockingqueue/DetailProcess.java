package com.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;

public class DetailProcess extends Thread {

    private String threadName;

    private ArrayBlockingQueue<BepsDetails> detailQueue;

    private ThreadLocal<Integer> count = ThreadLocal.withInitial(() -> 0);

    public DetailProcess(String threadName, ArrayBlockingQueue<BepsDetails> detailQueue) {
        this.threadName = threadName;
        this.detailQueue = detailQueue;
    }

    public void processDetail(BepsDetails detail) {
//        System.out.println("=== Thread.currentThread().getName() ===" + threadName);
        saveDetail();
        accounting();
        System.out.println();
    }

    private void saveDetail() {
//        System.out.println("=== 保存明细信息 ===");
    }

    private void accounting() {
//        System.out.println("=== 客户账记账 ===");
    }

    @Override
    public void run() {
        while (true) {
            try {
                BepsDetails detail = detailQueue.take();
                processDetail(detail);
                System.out.println("=== detail.getTxId() === : " + detail.getTxId());
                int a = Integer.valueOf(count.get());
                count.set(++a);
                System.out.println("=== threadName : " + this.threadName + ", count.get() === : " + count.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
