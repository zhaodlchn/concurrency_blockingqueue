package com.blockingqueue;

import java.math.BigDecimal;
import java.util.List;

public class BepsMessage {

    /**
     * 报文标识号
     */
    private String messageId;

    /**
     * 报文类型
     */
    private String messageType;

    /**
     * 报文发起人
     */
    private String InstgDrctPty;

    /**
     * 报文接收人
     */
    private String InstdDrctPty;

    /**
     * 处理状态
     */
    private String processStatus;

    /**
     * 明细数量
     */
    private int detailCount;

    /**
     * 总金额
     */
    private BigDecimal totalAmount;

    /**
     * 明细列表
     */
    private List<BepsDetails> details;

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getInstgDrctPty() {
        return InstgDrctPty;
    }

    public void setInstgDrctPty(String instgDrctPty) {
        InstgDrctPty = instgDrctPty;
    }

    public String getInstdDrctPty() {
        return InstdDrctPty;
    }

    public void setInstdDrctPty(String instdDrctPty) {
        InstdDrctPty = instdDrctPty;
    }

    public String getProcessStatus() {
        return processStatus;
    }

    public void setProcessStatus(String processStatus) {
        this.processStatus = processStatus;
    }

    public int getDetailCount() {
        return detailCount;
    }

    public void setDetailCount(int detailCount) {
        this.detailCount = detailCount;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<BepsDetails> getDetails() {
        return details;
    }

    public void setDetails(List<BepsDetails> details) {
        this.details = details;
    }
}
