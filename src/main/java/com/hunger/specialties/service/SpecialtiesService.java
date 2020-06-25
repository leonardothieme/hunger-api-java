package com.hunger.specialties.service;

import com.hunger.specialties.model.payload.SpecialtiesPayload;
import com.hunger.specialties.model.response.SpecialtiesResponse;
import com.hunger.specialties.repository.SpecialtiesRepository;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.hunger.specialties.model.mapper.SpecialtiesMapper.toEntity;

@Service
@RequiredArgsConstructor
public class SpecialtiesService {

    private final SpecialtiesRepository repository;

    public SpecialtiesResponse create(final SpecialtiesPayload payload){
        return new SpecialtiesResponse(repository.save(toEntity(payload)));
    }

    public Optional<SpecialtiesResponse> findById(final ObjectId specialtiesId){
        return repository.findById(specialtiesId).map(SpecialtiesResponse::new);
    }
}
