package UtsuPWiki.utilities;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;

@Log4j2
public class StartUpManager implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {
    FancyWritings fancyWritings = new FancyWritings();
    DatabaseHelper databaseHelper = new DatabaseHelper();

    @Override
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {

        /* manually getting all the properties from application.properties because
         At ApplicationEnvironmentPreparedEvent annotations do not work yet */

        // database-helper properties
        String doPopulateDatabase   = event.getEnvironment().getProperty("database-helper.populate-database" );
        String doPopulateAuthors    = event.getEnvironment().getProperty("database-helper.populate-authors"  );
        String doPopulateClients    = event.getEnvironment().getProperty("database-helper.populate-clients"  );
        String doPopulateComments   = event.getEnvironment().getProperty("database-helper.populate-comments" );
        String doPopulateCountries  = event.getEnvironment().getProperty("database-helper.populate-countries");
        String doPopulateDelivery   = event.getEnvironment().getProperty("database-helper.populate-delivery" );
        String doPopulateGenres     = event.getEnvironment().getProperty("database-helper.populate-genres"   );
        String doPopulateOrders     = event.getEnvironment().getProperty("database-helper.populate-orders"   );
        String doPopulateProducts   = event.getEnvironment().getProperty("database-helper.populate-products" );
        String doPopulateTypes      = event.getEnvironment().getProperty("database-helper.populate-types"    );
        String doPopulateAll        = event.getEnvironment().getProperty("database-helper.populate-all"      );

        // fancy writings properties
        String doPrint              = event.getEnvironment().getProperty("fancy-writings.do-print"      );

        // managing startup
        manageStartUp(doPrint);

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
    }

    public void manageStartUp(String doPrint){
        fancyWritings.printMotivationalThingOnStartUp(doPrint);
    }
}
