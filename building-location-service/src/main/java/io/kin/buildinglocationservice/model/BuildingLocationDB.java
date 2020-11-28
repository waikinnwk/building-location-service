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
	private double lat;
	private double lon;

	@Id
	private CompositeKey id;


	static class CompositeKey implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private String district;
		private String buildingName;

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
	}

	public BuildingLocationDB() {
		this.id = new CompositeKey();
	}

	public BuildingLocationDB(String district, String buildingName, double lat, double lon) {
		this.id = new CompositeKey();
		this.id.district = district;
		this.id.buildingName = buildingName;
		this.lat = lat;
		this.lon = lon;
	}

	public BuildingLocation toObj() {
		BuildingLocation obj = new BuildingLocation(this.id.district,this.id.buildingName,this.lat,this.lon);
		return obj;
	}
	
	public String getDistrict() {
		return this.id.district;
	}

	public void setDistrict(String district) {
		this.id.district = district;
	}

	public String getBuildingName() {
		return this.id.buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.id.buildingName = buildingName;
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
