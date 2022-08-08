package hcmute.edu.tgdd.dto;

public class LaptopDTO {
  private int id;
  private String name;
  private int companyId;
  private int nationId;
  private double price;
  private int quantity;
  private int discount;
  private String images;
  private String videos;
  private String description;
  private int kindId;
  private String chip;
  private String ram;
  private String memory;
  private String screen;
  private String screenCard;
  private String port;
  private String feature;
  private String os;
  private String design;
  private String sizeWeight;
  private int year;

  public LaptopDTO() {
  }

  public LaptopDTO(int id, String name, int companyId, int nationId, double price, int quantity, int discount, String images, String videos, String description, int kindId, String chip, String ram, String memory, String screen, String screenCard, String port, String feature, String os, String design, String sizeWeight, int year) {
    this.id = id;
    this.name = name;
    this.companyId = companyId;
    this.nationId = nationId;
    this.price = price;
    this.quantity = quantity;
    this.discount = discount;
    this.images = images;
    this.videos = videos;
    this.description = description;
    this.kindId = kindId;
    this.chip = chip;
    this.ram = ram;
    this.memory = memory;
    this.screen = screen;
    this.screenCard = screenCard;
    this.port = port;
    this.feature = feature;
    this.os = os;
    this.design = design;
    this.sizeWeight = sizeWeight;
    this.year = year;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
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

  public String getChip() {
    return chip;
  }

  public void setChip(String chip) {
    this.chip = chip;
  }

  public String getRam() {
    return ram;
  }

  public void setRam(String ram) {
    this.ram = ram;
  }

  public String getMemory() {
    return memory;
  }

  public void setMemory(String memory) {
    this.memory = memory;
  }

  public String getScreen() {
    return screen;
  }

  public void setScreen(String screen) {
    this.screen = screen;
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

  public String getFeature() {
    return feature;
  }

  public void setFeature(String feature) {
    this.feature = feature;
  }

  public String getOs() {
    return os;
  }

  public void setOs(String os) {
    this.os = os;
  }

  public String getDesign() {
    return design;
  }

  public void setDesign(String design) {
    this.design = design;
  }

  public String getSizeWeight() {
    return sizeWeight;
  }

  public void setSizeWeight(String sizeWeight) {
    this.sizeWeight = sizeWeight;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  @Override
  public String toString() {
    return "LaptopDTO{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", companyId=" + companyId +
            ", nationId=" + nationId +
            ", price=" + price +
            ", quantity=" + quantity +
            ", discount=" + discount +
            ", images='" + images + '\'' +
            ", videos='" + videos + '\'' +
            ", description='" + description + '\'' +
            ", kindId=" + kindId +
            ", chip='" + chip + '\'' +
            ", ram='" + ram + '\'' +
            ", memory='" + memory + '\'' +
            ", screen='" + screen + '\'' +
            ", screenCard='" + screenCard + '\'' +
            ", port='" + port + '\'' +
            ", feature='" + feature + '\'' +
            ", os='" + os + '\'' +
            ", design='" + design + '\'' +
            ", sizeWeight=" + sizeWeight +
            ", year=" + year +
            '}';
  }
}
