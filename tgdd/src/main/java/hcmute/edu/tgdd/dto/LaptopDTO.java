package hcmute.edu.tgdd.dto;

public class LaptopDTO {
  private int id;
  private String cpu;
  private int ram;
  private String hardDrive;
  private String screen;
  private String screenCard;
  private String port;
  private String special;
  private String os;
  private String design;
  private double sizeWeight;
  private int year;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getCpu() {
    return cpu;
  }

  public void setCpu(String cpu) {
    this.cpu = cpu;
  }

  public int getRam() {
    return ram;
  }

  public void setRam(int ram) {
    this.ram = ram;
  }

  public String getHardDrive() {
    return hardDrive;
  }

  public void setHardDrive(String hardDrive) {
    this.hardDrive = hardDrive;
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

  public String getSpecial() {
    return special;
  }

  public void setSpecial(String special) {
    this.special = special;
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

  public double getSizeWeight() {
    return sizeWeight;
  }

  public void setSizeWeight(double sizeWeight) {
    this.sizeWeight = sizeWeight;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public LaptopDTO() {}

  public LaptopDTO(
      int id,
      String cpu,
      int ram,
      String hardDrive,
      String screen,
      String screenCard,
      String port,
      String special,
      String os,
      String design,
      double sizeWeight,
      int year) {
    this.id = id;
    this.cpu = cpu;
    this.ram = ram;
    this.hardDrive = hardDrive;
    this.screen = screen;
    this.screenCard = screenCard;
    this.port = port;
    this.special = special;
    this.os = os;
    this.design = design;
    this.sizeWeight = sizeWeight;
    this.year = year;
  }

  @Override
  public String toString() {
    return "LaptopDTO{"
        + "id="
        + id
        + ", cpu='"
        + cpu
        + '\''
        + ", ram="
        + ram
        + ", hardDrive='"
        + hardDrive
        + '\''
        + ", screen='"
        + screen
        + '\''
        + ", screenCard='"
        + screenCard
        + '\''
        + ", port='"
        + port
        + '\''
        + ", special='"
        + special
        + '\''
        + ", os='"
        + os
        + '\''
        + ", design='"
        + design
        + '\''
        + ", sizeWeight="
        + sizeWeight
        + ", year="
        + year
        + '}';
  }
}
