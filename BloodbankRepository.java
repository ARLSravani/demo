package com.techm.bloodbank.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.techm.bloodbank.entity.BloodBank;

/* using MongoRepository */
public interface BloodbankRepository extends MongoRepository<BloodBank, Integer> {




	/* Query for OR operator */

	@Query("{$or:[{name:?0},{bloodgroup: ?1},{number: ?2},{id: ?3}]}")
	List<BloodBank> getByNameOrBloodgroupOrNumberOrId(String name, String bloodgroup, Integer number, Integer id);

	/* Query for AND operator with four parameters */

	@Query("{id: ?0, name: ?1, bloodgroup: ?2, number: ?3}")
	BloodBank getByNameAndBloodgroupAndNumberAndId(Integer id, String name, String bloodgroup, Integer number);

	/* AND operator using query with two parameter */
	@Query("{id: ?0, name: ?1, number: ?2}")
	BloodBank getByIdAndNameAndNumber(Integer id, String name, Integer number);

	/* AND operator using query with two parameter */
	@Query("{id: ?0, bloodgroup: ?1}")
	BloodBank getByIdAndBloodgroup(Integer id, String bloodgroup);

	/* AND operator using query with one parameter */
	@Query("{bloodgroup:?0}")
	BloodBank getByBloodgroup(String bloodgroup);
}
