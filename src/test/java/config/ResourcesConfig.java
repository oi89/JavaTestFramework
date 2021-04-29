package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config.properties")
public interface ResourcesConfig extends Config {
    @Config.Key("selenoidUrl")
    String selenoidUrl();

    @Config.Key("baseUrl")
    String baseUrl();
}
