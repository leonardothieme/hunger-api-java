package com.hunger.specialties.repository;

import com.hunger.specialties.model.Specialties;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialtiesRepository  extends MongoRepository<Specialties, ObjectId> {

}
