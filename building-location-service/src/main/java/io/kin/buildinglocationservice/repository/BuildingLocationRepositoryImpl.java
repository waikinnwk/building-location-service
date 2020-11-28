package io.kin.buildinglocationservice.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import io.kin.buildinglocationservice.model.BuildingLocationDB;

@Component
public class BuildingLocationRepositoryImpl implements BuildingLocationRepository {
	@Autowired
	MongoTemplate mongoTemplate;

	public boolean addBuildingLocation(BuildingLocationDB b) {
		mongoTemplate.insert(b);
		return true;
	}
	
	public List<BuildingLocationDB> getAllBuildingLocation() {
		Query query = new Query();
		return mongoTemplate.find(query, BuildingLocationDB.class);
	}
	
	public boolean isExists(BuildingLocationDB b) {
		Query query = new Query(
				Criteria.where("district").is(b.getDistrict()).where("buildingName").is(b.getBuildingName()));
		return mongoTemplate.find(query, BuildingLocationDB.class).size() > 0;
	}
}
