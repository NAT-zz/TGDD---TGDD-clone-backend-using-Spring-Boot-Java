package hcmute.edu.tgdd.dto;

public class PhoneDTO {
  private int id;
  private String name;
  private int companyId;
  private int nationId;
  private double price;
  private int quantity;
  private int discount;
  private String description;
  private int kindId;
  private String screen;
  private String os;
  private String frontCam;
  private String backCam;
  private String chip;
  private String ram;
  private String memory;
  private String sim;
  private String battery;

  public PhoneDTO() {
  }

  public PhoneDTO(int id, String name, int companyId, int nationId, double price, int quantity, int discount, String description, int kindId, String screen, String os, String frontCam, String backCam, String chip, String ram, String memory, String sim, String battery) {
    this.id = id;
    this.name = name;
    this.companyId = companyId;
    this.nationId = nationId;
    this.price = price;
    this.quantity = quantity;
    this.discount = discount;
    this.description = description;
    this.kindId = kindId;
    this.screen = screen;
    this.os = os;
    this.frontCam = frontCam;
    this.backCam = backCam;
    this.chip = chip;
    this.ram = ram;
    this.memory = memory;
    this.sim = sim;
    this.battery = battery;
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

  public String getScreen() {
    return screen;
  }

  public void setScreen(String screen) {
    this.screen = screen;
  }

  public String getOs() {
    return os;
  }

  public void setOs(String os) {
    this.os = os;
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

  public String getSim() {
    return sim;
  }

  public void setSim(String sim) {
    this.sim = sim;
  }

  public String getBattery() {
    return battery;
  }

  public void setBattery(String battery) {
    this.battery = battery;
  }

  @Override
  public String toString() {
    return "PhoneDTO{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", companyId=" + companyId +
            ", nationId=" + nationId +
            ", price=" + price +
            ", quantity=" + quantity +
            ", discount=" + discount +
            ", description='" + description + '\'' +
            ", kindId=" + kindId +
            ", screen='" + screen + '\'' +
            ", os='" + os + '\'' +
            ", frontCam='" + frontCam + '\'' +
            ", backCam='" + backCam + '\'' +
            ", chip='" + chip + '\'' +
            ", ram='" + ram + '\'' +
            ", memory='" + memory + '\'' +
            ", sim='" + sim + '\'' +
            ", battery='" + battery + '\'' +
            '}';
  }
}
