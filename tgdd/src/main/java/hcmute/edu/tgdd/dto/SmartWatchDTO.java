package hcmute.edu.tgdd.dto;

public class SmartWatchDTO {
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
	private String screen;
	private String os;
	private String battery;
	private String feature;

	public SmartWatchDTO() {
	}

	public SmartWatchDTO(int id, String name, int companyId, int nationId, double price, int quantity, int discount, String images, String videos, String description, int kindId, String screen, String os, String battery, String feature) {
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
		this.screen = screen;
		this.os = os;
		this.battery = battery;
		this.feature = feature;
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

	public String getBattery() {
		return battery;
	}

	public void setBattery(String battery) {
		this.battery = battery;
	}

	public String getFeature() {
		return feature;
	}

	public void setFeature(String feature) {
		this.feature = feature;
	}

	@Override
	public String toString() {
		return "SmartWatchDTO{" +
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
				", screen='" + screen + '\'' +
				", os='" + os + '\'' +
				", battery='" + battery + '\'' +
				", feature='" + feature + '\'' +
				'}';
	}
}
