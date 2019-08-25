package com.github.daggerok;

import ws.ament.hammock.Bootstrap;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ApplicationPath;

@ApplicationScoped
@ApplicationPath("")
public class Application extends javax.ws.rs.core.Application {
    public static void main(String... args) {
        Bootstrap.main(args);
    }
}
