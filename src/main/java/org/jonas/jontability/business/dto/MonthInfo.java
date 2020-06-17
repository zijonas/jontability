package org.jonas.jontability.business.dto;

public class MonthInfo {
    private int month;
    private double sum;

    public MonthInfo(int month, double sum) {
        this.month = month;
        this.sum = sum;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "MonthInfo{" +
                "month=" + month +
                ", sum=" + sum +
                '}';
    }
}
