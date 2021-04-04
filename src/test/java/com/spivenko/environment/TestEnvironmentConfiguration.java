package com.spivenko.environment;

import com.google.inject.Inject;
import com.spivenko.properties.PetClinicProperties;
import io.restassured.RestAssured;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import static com.spivenko.environment.Environments.DOCKERISED;

@Slf4j
@AllArgsConstructor(onConstructor = @__({ @Inject }))
public class TestEnvironmentConfiguration implements EnvironmentConfiguration {

    private final PetClinicProperties petClinicProperties;

    @Override
    public void setup() {
        log.info("Setting up default RestAssured configuration: {}/{}", DOCKERISED, petClinicProperties);
        RestAssured.baseURI = petClinicProperties.petClinicHost();
        RestAssured.basePath = petClinicProperties.petClinicBasePath();
        RestAssured.port = petClinicProperties.petClinicPort();
    }

    @Override
    public void cleanup() {
    }
}