package io.kin.buildinglocationservice.repository;

import java.util.List;

import io.kin.buildinglocationservice.model.BuildingLocation;
import io.kin.buildinglocationservice.model.BuildingLocationDB;

public interface BuildingLocationRepository {
	boolean addBuildingLocation(BuildingLocationDB b);
	BuildingLocation getBuildingLocation(BuildingLocation b);
	List<BuildingLocationDB> getBuildingLocation(List<BuildingLocation> bList);
	List<BuildingLocationDB> getAllBuildingLocation();
	boolean isExists(BuildingLocationDB b);
	boolean hasCoordinate(BuildingLocationDB b);
}
