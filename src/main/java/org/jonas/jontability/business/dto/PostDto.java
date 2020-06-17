package org.jonas.jontability.business.dto;

import java.time.LocalDate;

public class PostDto {
    private Integer id;
    private Integer categoryId;
    private Integer accountId;
    private String description;
    private boolean invoice;
    private LocalDate date;
    private Double value;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isInvoice() {
        return invoice;
    }

    public void setInvoice(boolean invoice) {
        this.invoice = invoice;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
