package com.document.tracker;

import com.document.tracker.resources.CustomerResource;
import io.dropwizard.Application;
import io.dropwizard.configuration.EnvironmentVariableSubstitutor;
import io.dropwizard.configuration.SubstitutingSourceProvider;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.skife.jdbi.v2.DBI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App extends Application<TrackerConfiguration> {

    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    @Override
    public void initialize(Bootstrap<TrackerConfiguration> b) { b.setConfigurationSourceProvider(
            new SubstitutingSourceProvider(b.getConfigurationSourceProvider(), new EnvironmentVariableSubstitutor(false)));}

    public void run(TrackerConfiguration c, Environment e) throws Exception {

        // Create a DBI factory and build a JDBI instance
        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory
                        .build(e, c.getDataSourceFactory(), "mysql");

        e.jersey().register(new CustomerResource(jdbi));
        LOGGER.info("Method App#run() called");
    }

    public static void main( String[] args ) throws Exception
    {
        new App().run(args);
    }
}
