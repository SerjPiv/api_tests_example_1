package com.spivenko.configurations;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.name.Named;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.wait.strategy.Wait;
import org.testcontainers.utility.DockerImageName;

import static org.apache.http.HttpStatus.*;

public class PetClinicContainerConfiguration extends AbstractModule {

    public static final int PORT_TO_EXPOSE_9966 = 9966;
    private static final String GET_PET_CLINIC_API_OWNERS_PATH = "/petclinic/api/owners";
    private static final String PET_CLINIC_REST_DOCKER_IMAGE = "springcommunity/spring-petclinic-rest:2.1.5";

    @Provides
    @Named("PetClinicContainer")
    static GenericContainer petClinicContainer() {
        return new GenericContainer<>(DockerImageName.parse(PET_CLINIC_REST_DOCKER_IMAGE))
                .withExposedPorts(PORT_TO_EXPOSE_9966)
                .waitingFor(Wait.forHttp(GET_PET_CLINIC_API_OWNERS_PATH).forStatusCode(SC_OK));
    }
}