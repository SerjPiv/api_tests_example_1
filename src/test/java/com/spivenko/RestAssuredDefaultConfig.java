package com.spivenko;

import com.spivenko.properties.PetClinicProperties;
import io.restassured.RestAssured;

public class RestAssuredDefaultConfig {
    public RestAssuredDefaultConfig(PetClinicProperties petClinicProperties) {
        RestAssured.baseURI = petClinicProperties.petClinicHost();
        RestAssured.port = petClinicProperties.petClinicPort();
        RestAssured.basePath = petClinicProperties.petClinicBasePath();
    }
}