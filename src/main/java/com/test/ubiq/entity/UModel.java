package com.test.ubiq.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "ubiq")
public class UModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("ID")
    private int id;

    @CreatedDate
    private String transactionId;

    @Column(name = "accountId", nullable = false)
    @JsonProperty("accountId")
    private String accountID;

    @Column(name = "amount", nullable = false)
    @JsonProperty("amount")
    private BigDecimal amount;

    @Column(name = "currency", nullable = false)
    @JsonProperty("currency")
    private String currency;

    @Column(name = "externalTransactionId", nullable = false)
    @JsonProperty("externalTransactionId")
    private String externalTransactionId;

    @JsonProperty("status")
    private String transactionStatus = "INITIATED";

    @JsonProperty("confirmPaymentUrl")
    private String confirmPaymentUrl;

    public UModel() { }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getExternalTransactionId() {
        return externalTransactionId;
    }

    public void setExternalTransactionId(String externalTransactionId) {
        this.externalTransactionId = externalTransactionId;
    }

    public String getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(String transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public String getConfirmPaymentUrl() {
        return confirmPaymentUrl;
    }

    public void setConfirmPaymentUrl(String confirmPaymentUrl) {
        this.confirmPaymentUrl = confirmPaymentUrl;
    }
}
