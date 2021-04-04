package com.spivenko.configurations;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.spivenko.properties.PetClinicProperties;
import org.aeonbits.owner.ConfigFactory;

import static com.spivenko.environment.Environments.DOCKERISED;

public class PetClinicTestConfiguration extends AbstractModule {
    @Provides
    static PetClinicProperties petClinicProperties() {
        System.setProperty("env", DOCKERISED.name());
        return ConfigFactory.create(PetClinicProperties.class);
    }
}
