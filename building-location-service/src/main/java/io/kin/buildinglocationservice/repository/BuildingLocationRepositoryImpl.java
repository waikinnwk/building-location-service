package io.kin.buildinglocationservice.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import io.kin.buildinglocationservice.model.BuildingLocation;
import io.kin.buildinglocationservice.model.BuildingLocationDB;

@Component
public class BuildingLocationRepositoryImpl implements BuildingLocationRepository {
	@Autowired
	MongoTemplate mongoTemplate;

	public boolean addBuildingLocation(BuildingLocationDB b) {
		mongoTemplate.insert(b);
		return true;
	}
	
	public BuildingLocation getBuildingLocation(BuildingLocation b) {
		Query query = new Query(
				Criteria.where("id.district").is(b.getDistrict()).where("id.buildingName").is(b.getBuildingName()));
		return mongoTemplate.findOne(query, BuildingLocationDB.class).toObj();
	}
	
	public List<BuildingLocationDB> getBuildingLocation(List<BuildingLocation> bList){
		List<Criteria> docCriterias = new ArrayList<Criteria>();
		bList.forEach(b->{
			docCriterias.add(Criteria.where("id.district").is(b.getDistrict()).where("id.buildingName").is(b.getBuildingName()));
		});
		
		Query query = new Query(new Criteria().orOperator(docCriterias.toArray(new Criteria[docCriterias.size()])));
		return mongoTemplate.find(query, BuildingLocationDB.class);
	}

	public List<BuildingLocationDB> getAllBuildingLocation() {
		Query query = new Query();
		return mongoTemplate.find(query, BuildingLocationDB.class);
	}

	public boolean isExists(BuildingLocationDB b) {
		Query query = new Query(
				Criteria.where("id.district").is(b.getDistrict()).where("id.buildingName").is(b.getBuildingName()));
		return mongoTemplate.find(query, BuildingLocationDB.class).size() > 0;
	}

	public boolean hasCoordinate(BuildingLocationDB b) {
		Query query = new Query(
				Criteria.where("id.district").is(b.getDistrict()).where("id.buildingName").is(b.getBuildingName()));
		try {
			BuildingLocationDB result = mongoTemplate.findOne(query, BuildingLocationDB.class);
			if (result != null && result.getLat() != null && result.getLon() != null)
				return true;
			else
				return false;
		} catch (Exception e) {
			e.printStackTrace();
			return true;
		}
	}
}
