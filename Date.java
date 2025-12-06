package Datestore;

import java.time.LocalDateTime;

public class Date {
    private int day;
    private String month;
    private long year;

    // Constructor to initialize Date with current date
    public Date() {
        LocalDateTime now = LocalDateTime.now();
        this.day = now.getDayOfMonth();
        this.month = now.getMonth().name(); // Gets month in uppercase
        this.year = now.getYear();
    }

    // Getters
    public int getDay() {
        return day;
    }

    public String getMonth() {
        return month;
    }

    public long getYear() {
        return year;
    }
}