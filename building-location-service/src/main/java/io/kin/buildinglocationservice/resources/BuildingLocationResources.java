package io.kin.buildinglocationservice.resources;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.kin.buildinglocationservice.model.BuildingLocation;
import io.kin.buildinglocationservice.model.BuildingLocationDB;
import io.kin.buildinglocationservice.model.InsertResult;
import io.kin.buildinglocationservice.repository.BuildingLocationRepository;

@RestController
@RequestMapping("/buildinglocation")
public class BuildingLocationResources {
	
	@Autowired
	private BuildingLocationRepository buildingLocationRepository;

	@RequestMapping(value = "/add", method = RequestMethod.POST, headers = "Accept=application/json")
	public InsertResult addBuildingLocation(
			@RequestBody BuildingLocation b) {
		InsertResult result = new InsertResult();
		System.out.println("Add - " + b.getDistrict().trim() +"," +b.getBuildingName().trim());
		try {
			b.setDistrict(b.getDistrict().trim());
			b.setBuildingName(b.getBuildingName().trim());
			BuildingLocationDB dbObj = b.toDBObj();
			if(!buildingLocationRepository.isExists(dbObj)) {
				buildingLocationRepository.addBuildingLocation(dbObj);
				result.successResult();
			}
			else
				result.duplicateResult();
		}
		catch(Exception e) {
			e.printStackTrace();
			result.errorResult(e.getMessage());
		}

		return result;
	}
	
	
	@RequestMapping("/getAll")
	public List<BuildingLocation> getAllBuildingLocation() {
		List<BuildingLocation> buildingLocationList = new ArrayList<BuildingLocation>();
		List<BuildingLocationDB> buildingLocationListDB = buildingLocationRepository.getAllBuildingLocation();
		for(BuildingLocationDB db :buildingLocationListDB) {
			buildingLocationList.add(db.toObj());
		}
	    return buildingLocationList;
	}
	
	@RequestMapping(value = "/getCoordinate", method = RequestMethod.POST, headers = "Accept=application/json")
	public List<BuildingLocation> getBuildingCoordinate(@RequestBody List<BuildingLocation> bList) {
		List<BuildingLocation> buildingLocationList = new ArrayList<BuildingLocation>();
		List<BuildingLocationDB> buildingLocationListDB = buildingLocationRepository.getBuildingLocation(bList);
		for(BuildingLocationDB db :buildingLocationListDB) {
			buildingLocationList.add(db.toObj());
		}
	    return buildingLocationList;
	}
	
	@RequestMapping(value = "/hasCoordinate", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map hasCoordinate(
			@RequestBody BuildingLocation b) {
		Map<String,String> result = new HashMap();

		try {
			b.setDistrict(b.getDistrict().trim());
			b.setBuildingName(b.getBuildingName().trim());
			BuildingLocationDB dbObj = b.toDBObj();
			if(buildingLocationRepository.hasCoordinate(dbObj)) {
				result.put("result","Y");
			}
			else
				result.put("result","N");
		}
		catch(Exception e) {
			e.printStackTrace();
		}

		return result;
	}
}
