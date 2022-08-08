package hcmute.edu.tgdd.model;

import javax.persistence.*;

@Entity
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private int companyId;
  private int nationId;
  private double price;
  private int quantity;
  private int discount;
  private String images;
  private String videos;
  private String description;
  private int kindId;
  private String os;
  private String ram;
  private String screen;
  private String memory;
  private String battery;
  private String chip;
  private String frontCam;
  private String backCam;
  private String sim;
  private String sizeWeight;
  private String feature;
  private String screenCard;
  private String port;
  private String design;
  private String year;

  public Product() {
  }

  public Product( String name, int companyId, int nationId, double price, int quantity, int discount, String images, String videos, String description, int kindId, String os, String ram, String screen, String memory, String battery, String chip, String frontCam, String backCam, String sim, String sizeWeight, String feature, String screenCard, String port, String design, String year) {
    this.companyId = companyId;
    this.nationId = nationId;
    this.price = price;
    this.quantity = quantity;
    this.discount = discount;
    this.images = images;
    this.videos = videos;
    this.description = description;
    this.kindId = kindId;
    this.os = os;
    this.ram = ram;
    this.screen = screen;
    this.memory = memory;
    this.battery = battery;
    this.chip = chip;
    this.frontCam = frontCam;
    this.backCam = backCam;
    this.sim = sim;
    this.sizeWeight = sizeWeight;
    this.feature = feature;
    this.screenCard = screenCard;
    this.port = port;
    this.design = design;
    this.year = year;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getCompanyId() {
    return companyId;
  }

  public void setCompanyId(int companyId) {
    this.companyId = companyId;
  }

  public int getNationId() {
    return nationId;
  }

  public void setNationId(int nationId) {
    this.nationId = nationId;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public int getDiscount() {
    return discount;
  }

  public void setDiscount(int discount) {
    this.discount = discount;
  }

  public String getImages() {
    return images;
  }

  public void setImages(String images) {
    this.images = images;
  }

  public String getVideos() {
    return videos;
  }

  public void setVideos(String videos) {
    this.videos = videos;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public int getKindId() {
    return kindId;
  }

  public void setKindId(int kindId) {
    this.kindId = kindId;
  }

  public String getOs() {
    return os;
  }

  public void setOs(String os) {
    this.os = os;
  }

  public String getRam() {
    return ram;
  }

  public void setRam(String ram) {
    this.ram = ram;
  }

  public String getScreen() {
    return screen;
  }

  public void setScreen(String screen) {
    this.screen = screen;
  }

  public String getMemory() {
    return memory;
  }

  public void setMemory(String memory) {
    this.memory = memory;
  }

  public String getBattery() {
    return battery;
  }

  public void setBattery(String battery) {
    this.battery = battery;
  }

  public String getChip() {
    return chip;
  }

  public void setChip(String chip) {
    this.chip = chip;
  }

  public String getFrontCam() {
    return frontCam;
  }

  public void setFrontCam(String frontCam) {
    this.frontCam = frontCam;
  }

  public String getBackCam() {
    return backCam;
  }

  public void setBackCam(String backCam) {
    this.backCam = backCam;
  }

  public String getSim() {
    return sim;
  }

  public void setSim(String sim) {
    this.sim = sim;
  }

  public String getSizeWeight() {
    return sizeWeight;
  }

  public void setSizeWeight(String sizeWeight) {
    this.sizeWeight = sizeWeight;
  }

  public String getFeature() {
    return feature;
  }

  public void setFeature(String feature) {
    this.feature = feature;
  }

  public String getScreenCard() {
    return screenCard;
  }

  public void setScreenCard(String screenCard) {
    this.screenCard = screenCard;
  }

  public String getPort() {
    return port;
  }

  public void setPort(String port) {
    this.port = port;
  }

  public String getDesign() {
    return design;
  }

  public void setDesign(String design) {
    this.design = design;
  }

  public String getYear() {
    return year;
  }

  public void setYear(String year) {
    this.year = year;
  }

  @Override
  public String toString() {
    return "Product{" +
            "id=" + id +
            ", companyId=" + companyId +
            ", nationId=" + nationId +
            ", price=" + price +
            ", quantity=" + quantity +
            ", discount=" + discount +
            ", images='" + images + '\'' +
            ", videos='" + videos + '\'' +
            ", description='" + description + '\'' +
            ", kindId=" + kindId +
            ", os='" + os + '\'' +
            ", ram='" + ram + '\'' +
            ", screen='" + screen + '\'' +
            ", memory='" + memory + '\'' +
            ", battery='" + battery + '\'' +
            ", chip='" + chip + '\'' +
            ", frontCam='" + frontCam + '\'' +
            ", backCam='" + backCam + '\'' +
            ", sim='" + sim + '\'' +
            ", sizeWeight='" + sizeWeight + '\'' +
            ", feature='" + feature + '\'' +
            ", screenCard='" + screenCard + '\'' +
            ", port='" + port + '\'' +
            ", design='" + design + '\'' +
            ", year='" + year + '\'' +
            '}';
  }
}