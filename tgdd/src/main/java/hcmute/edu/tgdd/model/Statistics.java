package hcmute.edu.tgdd.model;

import java.util.Date;

public class Statistics {
  private Date date;
  private int productsSold;
  private double totalRevenue;

  public Statistics() {
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public int getProductsSold() {
    return productsSold;
  }

  public void setProductsSold(int productsSold) {
    this.productsSold = productsSold;
  }

  public double getTotalRevenue() {
    return totalRevenue;
  }

  public void setTotalRevenue(double totalRevenue) {
    this.totalRevenue = totalRevenue;
  }

  public Statistics(Date date, int productsSold, double totalRevenue) {
    this.date = date;
    this.productsSold = productsSold;
    this.totalRevenue = totalRevenue;
  }

  @Override
  public String toString() {
    return "Statistics{" +
            "date=" + date +
            ", productsSold=" + productsSold +
            ", totalRevenue=" + totalRevenue +
            '}';
  }
}
