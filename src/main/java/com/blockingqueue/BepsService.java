package com.blockingqueue;

import org.apache.commons.lang3.RandomUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

public class BepsService {

    private ArrayBlockingQueue<BepsDetails> queue = new ArrayBlockingQueue<>(2000);

    {
        init();
    }

    private void init() {
        new DetailProcess("Thread-1", queue).start();
        new DetailProcess("Thread-2", queue).start();
        new DetailProcess("Thread-3", queue).start();
        new DetailProcess("Thread-4", queue).start();
        new DetailProcess("Thread-5", queue).start();
    }

    public void bepsTransaction(BepsMessage message) {
        saveMessage();
        for (BepsDetails detail : message.getDetails()) {
            queue.add(detail);
        }
    }

    private void saveMessage() {
        System.out.println("=== 保存报文信息 ===");
    }


    /**
     * ==============================================================
     *
     * @param args
     */
    public static void main(String[] args) {
        BepsService service = new BepsService();
        System.out.println("=== process message ===");
        BepsMessage message = initDatas();
        service.bepsTransaction(message);

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("=== process message1 ===");
        BepsMessage message1 = initDatas();
        service.bepsTransaction(message1);
    }

    public static BepsMessage initDatas() {
        BepsMessage message = new BepsMessage();
        message.setMessageId("2019071800500267");
        message.setMessageType("beps.121.001.01");
        message.setInstgDrctPty("102100099996");
        message.setInstdDrctPty("313684093748");
        message.setProcessStatus("PR03");
        message.setDetailCount(100);
        List<BepsDetails> details = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            BepsDetails detail = new BepsDetails();
            detail.setTxId("201907188504" + getFourRandom());
            detail.setAmount(BigDecimal.valueOf(RandomUtils.nextInt(2000, 10000)));
            detail.setPaymentAccountNo("622208232000008" + getFourRandom());
            detail.setPaymentAccountNo("许志强" + getFourRandom());
            detail.setReceiptAccountNo("621057010000182" + getFourRandom());
            detail.setReceiptAccountName("郑玉芹" + getFourRandom());
            details.add(detail);
        }
        message.setDetails(details);
        return message;
    }

    /**
     * 产生4位随机数(0000-9999)
     *
     * @return 4位随机数
     */
    private static String getFourRandom() {
        Random random = new Random();
        String fourRandom = random.nextInt(10000) + "";
        int randLength = fourRandom.length();
        if (randLength < 4) {
            for (int i = 1; i <= 4 - randLength; i++)
                fourRandom = "0" + fourRandom;
        }
        return fourRandom;
    }
}
