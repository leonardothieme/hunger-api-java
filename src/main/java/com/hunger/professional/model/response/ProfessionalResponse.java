package com.hunger.professional.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.hunger.professional.model.Professional;
import com.hunger.specialties.model.response.SpecialtiesResponse;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.bson.types.ObjectId;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Optional;

@ApiModel("Created Professional info")
@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ProfessionalResponse {
    
    private String professionalId;

    private String name;

    private String crp;

    private String description;

    private LocalDate birthDate;

    private String language;

    private Integer valueHours;

    private Collection<SpecialtiesResponse> specialties;

    public ProfessionalResponse(final Professional entity){
        professionalId = Optional.ofNullable(entity.getId()).map(ObjectId::toHexString).orElse(null);
        name = entity.getName();
        crp = entity.getCrp();
        description = entity.getDescription();
        birthDate = entity.getBirthDate();
        language = entity.getLanguage();
        valueHours = entity.getValueHours();
    }
}
