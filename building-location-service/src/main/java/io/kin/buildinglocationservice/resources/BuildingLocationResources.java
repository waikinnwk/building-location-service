package io.kin.buildinglocationservice.resources;

import java.util.ArrayList;
import java.util.List;

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
	public List<BuildingLocation> getAllBuildingLovation() {
		List<BuildingLocation> buildingLocationList = new ArrayList<BuildingLocation>();
		List<BuildingLocationDB> buildingLocationListDB = buildingLocationRepository.getAllBuildingLocation();
		for(BuildingLocationDB db :buildingLocationListDB) {
			buildingLocationList.add(db.toObj());
		}
	    return buildingLocationList;
	}
}
