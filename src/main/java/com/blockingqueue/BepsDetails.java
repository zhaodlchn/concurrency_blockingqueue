package com.blockingqueue;

import java.math.BigDecimal;

public class BepsDetails {
    /**
     * 交易号
     */
    private String txId;

    /**
     * 付款人账号
     */
    private String paymentAccountNo;

    /**
     * 付款人姓名
     */
    private String paymentAccountName;

    /**
     * 收款人账号
     */
    private String receiptAccountNo;

    /**
     * 收款人姓名
     */
    private String receiptAccountName;

    /**
     * 交易金额
     */
    private BigDecimal amount;

    public String getTxId() {
        return txId;
    }

    public void setTxId(String txId) {
        this.txId = txId;
    }

    public String getPaymentAccountNo() {
        return paymentAccountNo;
    }

    public void setPaymentAccountNo(String paymentAccountNo) {
        this.paymentAccountNo = paymentAccountNo;
    }

    public String getPaymentAccountName() {
        return paymentAccountName;
    }

    public void setPaymentAccountName(String paymentAccountName) {
        this.paymentAccountName = paymentAccountName;
    }

    public String getReceiptAccountNo() {
        return receiptAccountNo;
    }

    public void setReceiptAccountNo(String receiptAccountNo) {
        this.receiptAccountNo = receiptAccountNo;
    }

    public String getReceiptAccountName() {
        return receiptAccountName;
    }

    public void setReceiptAccountName(String receiptAccountName) {
        this.receiptAccountName = receiptAccountName;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
