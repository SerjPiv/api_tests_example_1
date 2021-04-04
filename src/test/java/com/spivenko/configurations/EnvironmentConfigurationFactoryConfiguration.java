package com.spivenko.configurations;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.MapBinder;
import com.spivenko.environment.DockerisedEnvironmentConfiguration;
import com.spivenko.environment.EnvironmentConfiguration;
import com.spivenko.environment.LiveEnvironmentConfiguration;
import com.spivenko.environment.TestEnvironmentConfiguration;

import static com.spivenko.environment.Environments.*;

public class EnvironmentConfigurationFactoryConfiguration extends AbstractModule {
    @Override
    protected void configure() {
        MapBinder<String, EnvironmentConfiguration> factory
                = MapBinder.newMapBinder(binder(), String.class, EnvironmentConfiguration.class);
        factory.addBinding(DOCKERISED.name()).to(DockerisedEnvironmentConfiguration.class);
        factory.addBinding(LIVE.name()).to(LiveEnvironmentConfiguration.class);
        factory.addBinding(TEST.name()).to(TestEnvironmentConfiguration.class);
    }
}