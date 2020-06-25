package com.hunger.professional.repository;

import com.hunger.professional.model.Professional;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessionalRepository extends MongoRepository<Professional, ObjectId> {
}
