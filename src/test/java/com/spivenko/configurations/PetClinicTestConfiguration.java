package com.spivenko.configurations;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.spivenko.properties.PetClinicProperties;
import org.aeonbits.owner.ConfigFactory;

public class PetClinicTestConfiguration extends AbstractModule {
    @Provides
    static PetClinicProperties petClinicProperties() {
        return ConfigFactory.create(PetClinicProperties.class);
    }
}
