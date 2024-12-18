package com.authorities;

import java.math.BigDecimal;

public class HospitalStatistic {
    private int year;
    private int numPatients;
    private int numDoctors;
    private BigDecimal totalRevenue;

    // Getters and Setters
    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public int getNumPatients() { return numPatients; }
    public void setNumPatients(int numPatients) { this.numPatients = numPatients; }

    public int getNumDoctors() { return numDoctors; }
    public void setNumDoctors(int numDoctors) { this.numDoctors = numDoctors; }

    public BigDecimal getTotalRevenue() { return totalRevenue; }
    public void setTotalRevenue(BigDecimal totalRevenue) { this.totalRevenue = totalRevenue; }
}
