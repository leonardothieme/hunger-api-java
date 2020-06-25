package com.hunger.professional.model;

import com.hunger.professional.model.payload.ProfessionalPayload;

public final class ProfessionalMapper {

    public static Professional toEntity(final ProfessionalPayload payload){
        return Professional.builder().birthDate(payload.getBirthDate()).crp(payload.getCrp()).description(payload.getDescription())
                .language(payload.getLanguage()).valueHours(payload.getValueHours()).build();


    }
}
