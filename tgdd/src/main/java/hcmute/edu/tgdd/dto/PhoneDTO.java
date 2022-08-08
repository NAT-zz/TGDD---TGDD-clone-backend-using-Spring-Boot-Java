package hcmute.edu.tgdd.dto;

public class PhoneDTO {
  private int id;
  private String screen;
  private String os;
  private String frontCam;
  private String backCam;
  private String chip;
  private String ram;
  private String memory;
  private String sim;
  private String battery;

  public PhoneDTO(
      int id,
      String screen,
      String os,
      String frontCam,
      String backCam,
      String chip,
      String ram,
      String memory,
      String sim,
      String battery) {
    this.id = id;
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

  public PhoneDTO() {}

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
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
    return "PhoneDTO{"
        + "id="
        + id
        + ", screen='"
        + screen
        + '\''
        + ", os='"
        + os
        + '\''
        + ", frontCam='"
        + frontCam
        + '\''
        + ", backCam='"
        + backCam
        + '\''
        + ", chip='"
        + chip
        + '\''
        + ", ram='"
        + ram
        + '\''
        + ", memory='"
        + memory
        + '\''
        + ", sim='"
        + sim
        + '\''
        + ", battery='"
        + battery
        + '\''
        + '}';
  }
}
