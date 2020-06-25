package com.hunger.professional.api;

import com.hunger.common.model.ErrorResponse;
import com.hunger.professional.model.payload.ProfessionalPayload;
import com.hunger.professional.model.response.ProfessionalResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.validation.Valid;

@Api(tags = "Professional")
public interface ProfessionalApi {

    @ApiOperation(value = "Create new professional")
    @ApiResponses({ @ApiResponse(code = 201, message = "Professional created with success"),
            @ApiResponse(code = 400, message = "Wrong payload parameters", response = ErrorResponse.class),
            @ApiResponse(code = 500, message = "Unexpected error", response = ErrorResponse.class) })
    ProfessionalResponse createProfessional(@Valid final ProfessionalPayload payload);
}
