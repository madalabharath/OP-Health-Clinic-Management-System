package com.authorities;

import java.math.BigDecimal;

public class FinancialReport {

	  private int id;
      private java.sql.Date date;
      private BigDecimal revenue;
      private BigDecimal expenses;
      private BigDecimal profit;

      public int getId() {
          return id;
      }

      public void setId(int id) {
          this.id = id;
      }

      public java.sql.Date getDate() {
          return date;
      }

      public void setDate(java.sql.Date date) {
          this.date = date;
      }

      public BigDecimal getRevenue() {
          return revenue;
      }

      public void setRevenue(BigDecimal revenue) {
          this.revenue = revenue;
      }

      public BigDecimal getExpenses() {
          return expenses;
      }

      public void setExpenses(BigDecimal expenses) {
          this.expenses = expenses;
      }

      public BigDecimal getProfit() {
          return profit;
      }

      public void setProfit(BigDecimal profit) {
          this.profit = profit;
      }
  }

