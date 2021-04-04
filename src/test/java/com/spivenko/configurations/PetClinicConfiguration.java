package com.spivenko.configurations;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.spivenko.properties.PetClinicProperties;
import com.spivenko.RestAssuredDefaultConfig;
import org.aeonbits.owner.ConfigFactory;

public class PetClinicConfiguration extends AbstractModule {
    @Provides
    static PetClinicProperties petClinicProperties() {
        System.setProperty("env", "test");
        PetClinicProperties petClinicProperties = ConfigFactory.create(PetClinicProperties.class);
        new RestAssuredDefaultConfig(petClinicProperties);
        return petClinicProperties;
    }
}
