package com.spivenko.tests;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.spivenko.configurations.PetClinicConfiguration;
import com.spivenko.properties.PetClinicProperties;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.expect;

public class AppTest {

    private static PetClinicProperties petClinicProperties;

    @BeforeAll
    static void classSetup() {
        Injector injector = Guice.createInjector(new PetClinicConfiguration());
        petClinicProperties = injector.getInstance(PetClinicProperties.class);
    }

    @Test
    public void getOwnersShouldRespond200()
    {
        System.out.println(petClinicProperties.toString());

        expect().
                statusCode(200).
                when().
                get("/api/owners").
                then().
                log().
                body();
    }
}
