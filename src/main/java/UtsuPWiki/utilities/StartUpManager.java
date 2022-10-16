package UtsuPWiki.utilities;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;

@Log4j2
//@Component
public class StartUpManager implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {
    FancyWritings fancyWritings = new FancyWritings();
    DatabaseHelper databaseHelper = new DatabaseHelper();

    @Override
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
        String doPopulateDatabase   = event.getEnvironment().getProperty("database-helper.populate-database");
        String doPopulateAuthors    = event.getEnvironment().getProperty("database-helper.populate-authors");
        String doPopulateClients    = event.getEnvironment().getProperty("database-helper.populate-clients");
        String doPopulateComments   = event.getEnvironment().getProperty("database-helper.populate-comments");
        String doPopulateCountries  = event.getEnvironment().getProperty("database-helper.populate-countries");
        String doPopulateDelivery   = event.getEnvironment().getProperty("database-helper.populate-delivery");
        String doPopulateGenres     = event.getEnvironment().getProperty("database-helper.populate-genres");
        String doPopulateOrders     = event.getEnvironment().getProperty("database-helper.populate-orders");
        String doPopulateProducts   = event.getEnvironment().getProperty("database-helper.populate-products");
        String doPopulateTypes      = event.getEnvironment().getProperty("database-helper.populate-types");
        String doPopulateAll        = event.getEnvironment().getProperty("database-helper.populate-all");
        String doPrint              = event.getEnvironment().getProperty("fancy-writings.do-print");

        manageStartUp(doPrint);

        log.info("property is: " + event.getEnvironment().getProperty("database-helper.populate-database"));

        databaseHelper.populateDatabase(
                doPopulateDatabase,
                doPopulateAuthors,
                doPopulateClients,
                doPopulateComments,
                doPopulateCountries,
                doPopulateDelivery,
                doPopulateGenres,
                doPopulateOrders,
                doPopulateProducts,
                doPopulateTypes,
                doPopulateAll);

        log.info("still here");
    }

//    @EventListener(ApplicationEnvironmentPreparedEvent.class)
    public void manageStartUp(String doPrint){
        log.info("started here");
        fancyWritings.printMotivationalThingOnStartUp(doPrint);
    }
}
