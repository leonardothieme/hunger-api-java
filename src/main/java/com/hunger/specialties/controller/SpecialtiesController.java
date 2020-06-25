package com.hunger.specialties.controller;

import com.hunger.specialties.api.SpecialtiesApi;
import com.hunger.specialties.model.payload.SpecialtiesPayload;
import com.hunger.specialties.model.response.SpecialtiesResponse;
import com.hunger.specialties.service.SpecialtiesService;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import static org.springframework.http.HttpStatus.CREATED;

@Validated
@CrossOrigin
@RestController
@RequestMapping("/specialties")
@RequiredArgsConstructor
public class SpecialtiesController implements SpecialtiesApi {

    private final SpecialtiesService service;

    @PostMapping
    @ResponseStatus(code = CREATED)
    public SpecialtiesResponse createSpecialties(@RequestBody final SpecialtiesPayload payload) {
        final var response = service.create(payload);

        response.add(selfLink(new ObjectId(response.getSpecialtiesId())));

        return response;
    }

    @GetMapping("/{specialtiesId}")
    public ResponseEntity<SpecialtiesResponse> findById(@PathVariable("specialtiesId") final ObjectId specialtiesId) {
        final var response = service.findById(specialtiesId);

        return response.isPresent() ? ResponseEntity.ok().body(response.get()): ResponseEntity.noContent().build();
    }

    private Link selfLink(final ObjectId specialtiesId) {
        return linkTo(methodOn(SpecialtiesController.class).findById(specialtiesId)).withSelfRel();
    }
}
