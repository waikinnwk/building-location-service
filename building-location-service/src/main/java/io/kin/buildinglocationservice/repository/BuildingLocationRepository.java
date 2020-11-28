package io.kin.buildinglocationservice.repository;

import java.util.List;

import io.kin.buildinglocationservice.model.BuildingLocationDB;

public interface BuildingLocationRepository {
	boolean addBuildingLocation(BuildingLocationDB b);
	List<BuildingLocationDB> getAllBuildingLocation();
	boolean isExists(BuildingLocationDB b);
}
