package org.selenium.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:selenium-grid.properties",
        "classpath:test.properties"})

public interface Configuration extends Config {

    @Key("target")
    String target();

    @Key("browser")
    String browser();

    @Key("headless")
    boolean headless();

    @Key("url.base")
    String url();

    @Key("grid.url")
    String gridUrl();

    @Key("grid.port")
    String gridPort();

    @Key("login.email")
    String email();

    @Key("login.password")
    String password();
}