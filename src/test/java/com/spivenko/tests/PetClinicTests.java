package com.spivenko.tests;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.spivenko.configurations.EnvironmentConfigurationFactoryConfiguration;
import com.spivenko.configurations.PetClinicContainerConfiguration;
import com.spivenko.configurations.PetClinicTestConfiguration;
import com.spivenko.environment.EnvironmentConfiguration;
import com.spivenko.environment.EnvironmentConfigurationFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.expect;

public class PetClinicTests {

    private static EnvironmentConfiguration environmentConfiguration;

    @BeforeAll
    static void classSetup() {
        Injector injector = Guice.createInjector(
                new PetClinicTestConfiguration(),
                new PetClinicContainerConfiguration(),
                new EnvironmentConfigurationFactoryConfiguration());

        environmentConfiguration = injector.getInstance(EnvironmentConfigurationFactory.class).get();
        environmentConfiguration.setup();
    }

    @AfterAll
    static void classCleanup() {
        environmentConfiguration.cleanup();
    }

    @Test
    public void getOwnersShouldRespond200()
    {
        expect().
                statusCode(200).
                when().
                get("/api/owners").
                then().
                log().
                body();
    }
}