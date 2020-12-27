package io.kin.buildinglocationservice.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "building_location")
public class BuildingLocationDB implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private BuildingLocationId id;
	private Double lat;
	private Double lon;

	public BuildingLocationDB() {
		this.id = new BuildingLocationId();
	}

	public BuildingLocationDB(String district, String buildingName, double lat, double lon) {
		this.id = new BuildingLocationId();
		this.id.setDistrict(district);
		this.id.setBuildingName(buildingName);
		this.lat = lat;
		this.lon = lon;
	}

	public BuildingLocation toObj() {
		BuildingLocation obj = new BuildingLocation(this.id.getDistrict(), this.id.getBuildingName(), this.lat,
				this.lon);
		return obj;
	}

	public String getDistrict() {
		return this.id.getDistrict();
	}

	public void setDistrict(String district) {
		this.id.setDistrict(district);
	}

	public String getBuildingName() {
		return this.id.getBuildingName();
	}

	public void setBuildingName(String buildingName) {
		this.id.setBuildingName(buildingName);
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
