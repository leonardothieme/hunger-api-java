package com.hunger.professional.controller;

import com.hunger.professional.api.ProfessionalApi;
import com.hunger.professional.model.payload.ProfessionalPayload;
import com.hunger.professional.model.response.ProfessionalResponse;
import com.hunger.professional.service.ProfessionalService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;

@Validated
@CrossOrigin
@RestController
@RequestMapping("/professional")
@RequiredArgsConstructor
public class ProfessionalController implements ProfessionalApi {

    private final ProfessionalService service;
    @PostMapping
    @ResponseStatus(code = CREATED)
    public ProfessionalResponse createProfessional(@RequestBody @Valid final ProfessionalPayload payload) {
        return service.create(payload);
    }
}
