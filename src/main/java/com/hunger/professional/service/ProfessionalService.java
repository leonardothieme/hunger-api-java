package com.hunger.professional.service;

import com.hunger.professional.model.ProfessionalMapper;
import com.hunger.professional.model.payload.ProfessionalPayload;
import com.hunger.professional.model.response.ProfessionalResponse;
import com.hunger.professional.repository.ProfessionalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfessionalService {

    private final ProfessionalRepository repository;

    public ProfessionalResponse create(final ProfessionalPayload payload){
        return new ProfessionalResponse(repository.save(ProfessionalMapper.toEntity(payload)));
    }
}
