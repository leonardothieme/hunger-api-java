package com.hunger.professional.model.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfessionalPayload {

    private String name;

    private String crp;

    private String description;

    private LocalDate birthDate;

    private String language;

    private Integer valueHours;

//    private ObjectId specialties;
}
