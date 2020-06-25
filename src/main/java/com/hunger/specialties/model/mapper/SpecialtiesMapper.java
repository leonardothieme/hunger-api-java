package com.hunger.specialties.model.mapper;

import com.hunger.specialties.model.Specialties;
import com.hunger.specialties.model.payload.SpecialtiesPayload;

public final class SpecialtiesMapper {

    public static Specialties toEntity(final SpecialtiesPayload payload){
        return Specialties.builder().description(payload.getDescription()).specialties(payload.getSpecialties()).build();
    }


}
