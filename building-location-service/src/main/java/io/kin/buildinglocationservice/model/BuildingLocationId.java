package io.kin.buildinglocationservice.model;

import java.io.Serializable;

public class BuildingLocationId implements Serializable {
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
