package com.hunger.professional.model;

import com.hunger.specialties.model.Specialties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Collection;

@Data
@Builder
@Document
@NoArgsConstructor
@AllArgsConstructor
public class Professional {

    @Id
    private ObjectId id;

    private String name;

    private String crp;

    private String description;

    private LocalDate birthDate;

    private String language;

    private Integer valueHours;

    private Collection<Specialties> specialties;
}
