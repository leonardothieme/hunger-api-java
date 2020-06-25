package com.hunger.specialties.api;

import com.hunger.common.model.ErrorResponse;
import com.hunger.specialties.model.payload.SpecialtiesPayload;
import com.hunger.specialties.model.response.SpecialtiesResponse;
import io.swagger.annotations.*;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;

import javax.validation.Valid;

@Api(tags = "Specialties")
public interface SpecialtiesApi {

    @ApiOperation(value = "Create new Specialties")
    @ApiResponses({ @ApiResponse(code = 201, message = "Specialties created with success"),
            @ApiResponse(code = 400, message = "Wrong payload parameters", response = ErrorResponse.class),
            @ApiResponse(code = 500, message = "Unexpected error", response = ErrorResponse.class) })
    SpecialtiesResponse createSpecialties(@Valid final SpecialtiesPayload payload);


    @ApiOperation(value = "Find Specialties by Id")
    @ApiResponses({ @ApiResponse(code = 200, message = "Find specialties with success"),
            @ApiResponse(code = 204, message = "No Specialties was found", response = Void.class),
            @ApiResponse(code = 400, message = "Wrong payload parameters", response = ErrorResponse.class),
            @ApiResponse(code = 500, message = "Unexpected error", response = ErrorResponse.class) })
    ResponseEntity<SpecialtiesResponse> findById(@ApiParam(value = "Specialties id to search", example = "5e70ca61307a2b0006f3bb1b", required = true)
                        final ObjectId specialtiesId);

}
