package UtsuPWiki.utilities;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Log4j2
@Component
public class DatabaseHelper {

    public void populateDatabase(
            boolean doPopulateDatabase,
            boolean doPopulateAuthors,
            boolean doPopulateClients,
            boolean doPopulateComments,
            boolean doPopulateCountries,
            boolean doPopulateDelivery,
            boolean doPopulateGenres,
            boolean doPopulateOrders,
            boolean doPopulateProducts,
            boolean doPopulateTypes,
            boolean doPopulateAll) {
        if (doPopulateDatabase) {
            try {
                File data_sql = new File("src/main/resources/data.sql");
                if (data_sql.createNewFile()) {
                    log.info("data.sql created");
                } else {
                    log.info("data.sql already exists.");
                }
            } catch (IOException e) {
                log.error("An error occurred during creation of data.sql ." +
                        " If problem persists consider manually deleting data.sql file at src/main/resources/ " +
                        "Or disabling database-helper.populate-all at application.properties within the same folder.");
                e.printStackTrace();
            }

            try {
                FileWriter myWriter = new FileWriter("src/main/resources/data.sql");

                if (doPopulateAll) {
                    log.info("populate all is enabled.");
                    log.info("populating authors...");
                    myWriter.write("INSERT INTO Authors(id, author_pseudonym, date_of_birth, last_name, name, total_masterpieces, country_id_fk, additional_info, main_genre, main_type) VALUES(2, \"Utsu-P\", \"December/01/1990\", \"Unknown\", \"Unknown\", 7, 1, \"Very little is known about this guy\", 1, 1);\n");

                    log.info("populating clients...");
                    myWriter.write("INSERT INTO Clients(id, comments_quantity, content_created, default_address, email, password, registration_date, role, user_name, country_id_fk) VALUES(10, 0, 0, \"Via Dante 13\", \"example@mail.example.com\", \"$2a$11$Rb6OgJj.4j04iXwmW4fVnOTXJECjJ3gMh7eaxUJXzuEnwXU1CMBFS\", \"Tue Aug 09 18:16:09 CEST 2022\", \"Client\", \"Sample User\", 1); \n");
                    myWriter.write("INSERT INTO Clients(id, comments_quantity, content_created, default_address, email, password, registration_date, role, user_name, country_id_fk) VALUES(20, 0, 0, \"Via Giovanni Pascoli 4\", \"example@gmail.com\", \"$2y$11$EzzkxrKQaYmCBDFtHq.kHevldHqtLQAMMBkDhMmaXL5GbJrNX4gm.\", \"Wed Aug 17 17:54:48 CEST 2022\", \"Admin\", \"Sample Admin\", 1); \n");
                    myWriter.write("INSERT INTO Clients(id, comments_quantity, content_created, default_address, email, password, registration_date, role, user_name, country_id_fk) VALUES(30, 0, 0, \"Via Degli Pastori 16\", \"sample@sample.com\", \"$2y$11$3BX02Y/VJGX2.vOm9vNp8.Vf7QXuSt/uvEFzBqTJUWY.sV5SVtfxK\", \" Tue Aug 30 17:45:48 CEST 2022\", \"Client\", \"Federica\", 1); \n");

                } else {
                    if (doPopulateAuthors) {
                        log.info("Authors have been populated");
                        myWriter.write("INSERT INTO Authors(id, author_pseudonym, date_of_birth, last_name, name, total_masterpieces, country_id_fk, additional_info, main_genre, main_type) VALUES(2, \"Utsu-P\", \"December/01/1990\", \"Unknown\", \"Unknown\", 7, 1, \"Very little is known about this guy\", 1, 1);\n");
                    }
                    if (doPopulateClients) {
                        log.info("Clients have been populated");
                        myWriter.write("INSERT INTO Clients(id, comments_quantity, content_created, default_address, email, password, registration_date, role, user_name, country_id_fk) VALUES(10, 0, 0, \"Via Dante 13\", \"example@mail.example.com\", \"$2a$11$Rb6OgJj.4j04iXwmW4fVnOTXJECjJ3gMh7eaxUJXzuEnwXU1CMBFS\", \"Tue Aug 09 18:16:09 CEST 2022\", \"Client\", \"Sample User\", 1); \n");
                        myWriter.write("INSERT INTO Clients(id, comments_quantity, content_created, default_address, email, password, registration_date, role, user_name, country_id_fk) VALUES(20, 0, 0, \"Via Giovanni Pascoli 4\", \"example@gmail.com\", \"$2y$11$EzzkxrKQaYmCBDFtHq.kHevldHqtLQAMMBkDhMmaXL5GbJrNX4gm.\", \"Wed Aug 17 17:54:48 CEST 2022\", \"Admin\", \"Sample Admin\", 1); \n");
                        myWriter.write("INSERT INTO Clients(id, comments_quantity, content_created, default_address, email, password, registration_date, role, user_name, country_id_fk) VALUES(30, 0, 0, \"Via Degli Pastori 16\", \"sample@sample.com\", \"$2y$11$3BX02Y/VJGX2.vOm9vNp8.Vf7QXuSt/uvEFzBqTJUWY.sV5SVtfxK\", \" Tue Aug 30 17:45:48 CEST 2022\", \"Client\", \"Federica\", 1); \n");
                    }
                    if (doPopulateComments) {
                        log.info("Comments have been populated");
                    }
                    if (doPopulateCountries) {
                        log.info("Countries have been populated");
                    }
                    if (doPopulateDelivery) {
                        log.info("Delivery have been populated");
                    }
                    if (doPopulateGenres) {
                        log.info("Genres have been populated");
                    }
                    if (doPopulateOrders) {
                        log.info("Orders have been populated");
                    }
                    if (doPopulateProducts) {
                        log.info("Products have been populated");
                    }
                    if (doPopulateTypes) {
                        log.info("Types have been populated");
                    }
                }
                myWriter.close();
                System.out.println("Successfully wrote to the file.");
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
    }


//    public void populateDatabase(){
//        log.info("Boolean value is: " + doPopulateDatabase);
//    }
}
