package UtsuPWiki.utilities;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class StartUpManager {
    @Value("${database-helper.populate-database}")
    private boolean doPopulateDatabase;

    @Value("${database-helper.populate-authors}")
    private boolean doPopulateAuthors;

    @Value("${database-helper.populate-clients}")
    private boolean doPopulateClients;

    @Value("${database-helper.populate-comments}")
    private boolean doPopulateComments;

    @Value("${database-helper.populate-countries}")
    private boolean doPopulateCountries;

    @Value("${database-helper.populate-delivery}")
    private boolean doPopulateDelivery;

    @Value("${database-helper.populate-genres}")
    private boolean doPopulateGenres;

    @Value("${database-helper.populate-orders}")
    private boolean doPopulateOrders;

    @Value("${database-helper.populate-products}")
    private boolean doPopulateProducts;
    @Value("${database-helper.populate-types}")
    private boolean doPopulateTypes;

    @Value("${database-helper.populate-all}")
    private boolean doPopulateAll;

    @Value("${fancy-writings.do-print}")
    private boolean doPrint;

    @Autowired
    FancyWritings fancyWritings;

    @Autowired
    DatabaseHelper databaseHelper;

    @EventListener(ApplicationReadyEvent.class)
    public void manageStartUp(){
        fancyWritings.printMotivationalThingOnStartUp(doPrint);
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
}
