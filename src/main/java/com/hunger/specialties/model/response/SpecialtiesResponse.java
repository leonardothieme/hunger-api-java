package com.hunger.specialties.model.response;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.hunger.specialties.model.Specialties;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.bson.types.ObjectId;
import org.springframework.hateoas.ResourceSupport;

import java.util.Optional;

@ApiModel("Created Specialties info")
@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class SpecialtiesResponse extends ResourceSupport {

    public  String specialtiesId;

    private String specialties;

    private String description;

    public SpecialtiesResponse(final Specialties entity){
        specialtiesId = Optional.ofNullable(entity.getId()).map(ObjectId::toHexString).orElse(null);
        specialties = entity.getSpecialties();
        description = entity.getDescription();
    }
}


