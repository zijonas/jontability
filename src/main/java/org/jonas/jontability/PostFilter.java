package org.jonas.jontability;

public class PostFilter {
    private int year;
    private Integer month;

    public PostFilter() {
    }

    public PostFilter(Integer year, Integer month) {
        this.year = year;
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    @Override
    public String toString() {
        return "PostFilter{" +
                "year=" + year +
                ", month=" + month +
                '}';
    }
}
