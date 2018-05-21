package com.github.amanganiello90.javafullstack.app;

import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile({"h2"})
@Configuration
@EntityScan(basePackages = { "${db.package}" })
public class ConfigH2 {

}
