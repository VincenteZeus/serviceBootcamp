package com.bootcamp.rest;

import com.bootcamp.rest.controller.ProjetRestController;
import java.util.HashSet;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Set;

@ApplicationPath("rest")
public class Appli extends Application {
    /**
     * configuration pour swagger
     * du fait de l'utilisation d'une sous classe Application
     * differente de la solution qui configure le web xml
     */

    public Set<Class<?>> getClasses() {

        Set<Class<?>> resources = new HashSet<>();
        resources.add(ProjetRestController.class);
        return resources;
    }
}