package io.kin.buildinglocationservice.model;


public class BuildingLocation {
	private String district;
	private String buildingName;
	private Double lat;
	private Double lon;
	
	public BuildingLocation(String district, String buildingName, double lat, double lon) {
		this.district = district;
		this.buildingName = buildingName;
		this.lat = lat;
		this.lon = lon;
	}
	
	public BuildingLocationDB toDBObj() {
		BuildingLocationDB dbObj = new BuildingLocationDB(district,buildingName,lat,lon);
		return dbObj;
	}
	
	
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getBuildingName() {
		return buildingName;
	}
	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}
	public Double getLat() {
		return lat;
	}
	public void setLat(Double lat) {
		this.lat = lat;
	}
	public Double getLon() {
		return lon;
	}
	public void setLon(Double lon) {
		this.lon = lon;
	}
}
