package com.spivenko.environment;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.spivenko.configurations.PetClinicContainerConfiguration;
import com.spivenko.properties.PetClinicProperties;
import io.restassured.RestAssured;
import lombok.extern.slf4j.Slf4j;
import org.testcontainers.containers.GenericContainer;

import static com.spivenko.environment.Environments.*;

@Slf4j
public class DockerisedEnvironmentConfiguration implements EnvironmentConfiguration {

    private final GenericContainer genericContainer;
    private final PetClinicProperties petClinicProperties;

    @Inject
    public DockerisedEnvironmentConfiguration(@Named("PetClinicContainer") GenericContainer genericContainer,
                                              PetClinicProperties petClinicProperties) {
        this.genericContainer = genericContainer;
        this.petClinicProperties = petClinicProperties;
    }

    @Override
    public void setup() {
        log.info("Starting up PetStore app docker container...");
        genericContainer.start();
        log.info("Setting up default RestAssured configuration: {}/{}", DOCKERISED, petClinicProperties);
        RestAssured.baseURI = petClinicProperties.petClinicHost();
        RestAssured.basePath = petClinicProperties.petClinicBasePath();
        RestAssured.port = genericContainer.getMappedPort(PetClinicContainerConfiguration.PORT_TO_EXPOSE_9966);
    }

    @Override
    public void cleanup() {
        log.info("Stopping PetStore app docker container...");
        genericContainer.stop();
    }
}