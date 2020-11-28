package io.kin.buildinglocationservice.model;


public class BuildingLocation {
	private String district;
	private String buildingName;
	private double lat;
	private double lon;
	
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
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLon() {
		return lon;
	}
	public void setLon(double lon) {
		this.lon = lon;
	}
}
