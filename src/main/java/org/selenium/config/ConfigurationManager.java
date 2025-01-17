package org.selenium.config;

import org.aeonbits.owner.ConfigCache;

public class ConfigurationManager {

    public static Configuration configuration() {
        return ConfigCache.getOrCreate(Configuration.class);
    }
}
