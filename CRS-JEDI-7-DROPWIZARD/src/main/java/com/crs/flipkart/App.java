package com.crs.flipkart;
import com.crs.flipkart.restController.AdminRestAPI;
import com.crs.flipkart.restController.ProfessorRestAPI;
import com.crs.flipkart.restController.StudentRestAPI;
import com.crs.flipkart.restController.UserRestAPI;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Hello world!
 *
 */
public class App extends Application<Configuration> {
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);


    /* This will initialise the configuration*/
    @Override
    public void initialize(Bootstrap<Configuration> b) {
    }

    @Override
    public void run(Configuration c, Environment e) throws Exception {
        LOGGER.info("Registering REST resources");
        e.jersey().register(new AdminRestAPI());
        e.jersey().register(new UserRestAPI());
        e.jersey().register(new StudentRestAPI());
        e.jersey().register(new ProfessorRestAPI());
    }

    public static void main(String[] args) throws Exception {
        new App().run(args);
    }
}