package com.spivenko.environment;

import com.google.inject.Inject;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
@AllArgsConstructor(onConstructor = @__({ @Inject }))
public class EnvironmentConfigurationFactory {

    private static final String ENV = "env";
    private final Map<String, EnvironmentConfiguration> environmentConfigurationMap;

    public EnvironmentConfiguration get() {
        String envProperty = System.getProperty(ENV);
        log.info("Retrieving env configuration for the environment: {}", envProperty);
        return environmentConfigurationMap.get(System.getProperty(ENV));
    }
}