package com.spivenko.properties;

import org.aeonbits.owner.Config;

import static org.aeonbits.owner.Config.*;

@Sources({"classpath:petclinic-${env}.properties"})
public interface PetClinicProperties extends Config {
    @Key("rest.pet.clinic.app.host")
    String petClinicHost();
    @Key("rest.pet.clinic.app.port")
    int petClinicPort();
    @Key("rest.pet.clinic.app.base.path")
    String petClinicBasePath();
}
