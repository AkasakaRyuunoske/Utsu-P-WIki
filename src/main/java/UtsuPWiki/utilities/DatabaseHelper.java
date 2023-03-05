package UtsuPWiki.utilities;

import lombok.extern.log4j.Log4j2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 *  In case of any error in this class consider disabling database-helper.populate-database at
 *  application.properties.
 *
 * */

@Log4j2
public class DatabaseHelper {
    public void populateDatabase(
            String doPopulateDatabase,
            String doPopulateAuthors,
            String doPopulateClients,
            String doPopulateComments,
            String doPopulateCountries,
            String doPopulateDelivery,
            String doPopulateGenres,
            String doPopulateOrders,
            String doPopulateProducts,
            String doPopulateTypes,
            String doPopulateAll) {

        // if true creates data.sql file that will be written in later and will automatically be executed by hibernate
        if (doPopulateDatabase.equals("true")) {

            log.info("Database populating is started.");

            try {
                // File is always created and referenced here
                File data_sql = new File("src/main/resources/data.sql");

                // Verifies if file exists
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
                // file data.sql created earlier is now picked by fileWriter
                FileWriter data_sqlWriter = new FileWriter("src/main/resources/data.sql");

                /*
                * Order here is very important, because most tables refer as FK to another tables.
                * Thus, the smaller tables also are the most referred ones, so they are populated first.
                * */

                // Countries Table
                if (doPopulateCountries.equals("true") || doPopulateAll.equals("true")) {

                    data_sqlWriter.write("INSERT INTO Countries(id, description, name) VALUES(1,\"none\",\"Japan\");    \n");
                    data_sqlWriter.write("INSERT INTO Countries(id, description, name) VALUES(2,\"none\",\"Italy\");    \n");
                    data_sqlWriter.write("INSERT INTO Countries(id, description, name) VALUES(3,\"none\",\"America\");  \n");
                    data_sqlWriter.write("INSERT INTO Countries(id, description, name) VALUES(4,\"none\",\"Ukraine\");  \n \n");

                    log.info("Countries have been populated");
                }

                // Types Table
                if (doPopulateTypes.equals("true") || doPopulateAll.equals("true")) {
                    data_sqlWriter.write("INSERT INTO Types(id, description, name) VALUES(1,\"Mostly vocaloid \", \"Music\"); \n");
                    data_sqlWriter.write("INSERT INTO Types(id, description, name) VALUES(2,\"none \", \"Manga\"); \n");
                    data_sqlWriter.write("INSERT INTO Types(id, description, name) VALUES(3,\"none \", \"Anime\"); \n");
                    data_sqlWriter.write("INSERT INTO Types(id, description, name) VALUES(4,\"none \", \"Games\"); \n");
                    data_sqlWriter.write("INSERT INTO Types(id, description, name) VALUES(5,\"none \", \"Programming\"); \n \n");

                    log.info("Types have been populated");
                }

                // Genres Table
                if (doPopulateGenres.equals("true") || doPopulateAll.equals("true")) {
                    data_sqlWriter.write("INSERT INTO Genres(id, description, name) VALUES(1,\"The shit that only Utsu does well \", \"Vocaloid-Metal\"); \n");
                    data_sqlWriter.write("INSERT INTO Genres(id, description, name) VALUES(2,\"none \", \"Vocaloid\"); \n \n");

                    log.info("Genres have been populated");
                }

                // Authors Table
                if (doPopulateAuthors.equals("true") || doPopulateAll.equals("true")) {
                    data_sqlWriter.write("INSERT INTO Authors(id, author_pseudonym, date_of_birth, last_name, name, total_masterpieces, country_id_fk, additional_info, main_genre, main_type) VALUES(1, \"Utsu-P\", \"December/01/1990\", \"Unknown\", \"Unknown\", 7, 1, \"Very little is known about this guy\", 1, 1);\n \n");
                    log.info("Authors have been populated");
                }

                // Clients Table
                if (doPopulateClients.equals("true") || doPopulateAll.equals("true")) {
                    data_sqlWriter.write("INSERT INTO Clients(id, comments_quantity, content_created, default_address, email, password, registration_date, role, user_name, country_id_fk) VALUES(10, 0, 0, \"Via Dante 13\", \"example@mail.example.com\", \"$2a$11$Rb6OgJj.4j04iXwmW4fVnOTXJECjJ3gMh7eaxUJXzuEnwXU1CMBFS\", \"Tue Aug 09 18:16:09 CEST 2022\", \"Client\", \"Sample User\", 1); \n");
                    data_sqlWriter.write("INSERT INTO Clients(id, comments_quantity, content_created, default_address, email, password, registration_date, role, user_name, country_id_fk) VALUES(20, 0, 0, \"Via Giovanni Pascoli 4\", \"example@gmail.com\", \"$2y$11$EzzkxrKQaYmCBDFtHq.kHevldHqtLQAMMBkDhMmaXL5GbJrNX4gm.\", \"Wed Aug 17 17:54:48 CEST 2022\", \"Admin\", \"Sample Admin\", 1); \n");
                    data_sqlWriter.write("INSERT INTO Clients(id, comments_quantity, content_created, default_address, email, password, registration_date, role, user_name, country_id_fk) VALUES(30, 0, 0, \"Via Degli Pastori 16\", \"sample@sample.com\", \"$2y$11$3BX02Y/VJGX2.vOm9vNp8.Vf7QXuSt/uvEFzBqTJUWY.sV5SVtfxK\", \" Tue Aug 30 17:45:48 CEST 2022\", \"Client\", \"Federica\", 1); \n \n");

                    log.info("Clients have been populated");
                }

                // Comments Table
                if (doPopulateComments.equals("true") || doPopulateAll.equals("true")) {
                    log.info("Comments have been populated");
                }

                // Delivery Table
                if (doPopulateDelivery.equals("true") || doPopulateAll.equals("true")) {
                    log.info("Delivery have been populated");
                }

                // Orders Table
                if (doPopulateOrders.equals("true") || doPopulateAll.equals("true")) {
                    log.info("Orders have been populated");
                }

                //Products Table
                if (doPopulateProducts.equals("true") || doPopulateAll.equals("true")) {
//                    data_sqlWriter.write("INSERT INTO Products(id, cost, product_name, quantity, genres_id_fk, date_out, author_id_fk, types_id_fk, product_image, additional_info) VALUES(1, 9.49, \"Utsu-P - Diarrhea\", 0, 1, \"15/11/2009\", 1, 1, \"https://i.scdn.co/image/ab67616d00001e02486835908dacc4ca95d5a7e4\", \"spotify=https://open.spotify.com/album/3WrPMnsYqOsqbYBHeEqURI?si=5uhS9JR7QkG3Hckwz_M_Bg || on-wiki-url=/albums/diarrhea || description=property1;property2;property3\");                      \n");
                    data_sqlWriter.write("INSERT INTO Products(id, cost, product_name, quantity, genres_id_fk, date_out, author_id_fk, types_id_fk, product_image) VALUES(2, 9.49, \"Utsu-P - Traumatic\", 0, 1, \"14/11/2010\", 1, 1, \"https://pbs.twimg.com/media/FIcD_F7VEAAGOoN.jpg\");                     \n");
                    data_sqlWriter.write("INSERT INTO Products(id, cost, product_name, quantity, genres_id_fk, date_out, author_id_fk, types_id_fk, product_image) VALUES(3, 8.99, \"Utsu-P - Moksha\", 0, 1, \"30/04/2012\", 1, 1, \"https://static.zerochan.net/Type-H.full.1118182.jpg\");                        \n");
                    data_sqlWriter.write("INSERT INTO Products(id, cost, product_name, quantity, genres_id_fk, date_out, author_id_fk, types_id_fk, product_image) VALUES(4, 10.99, \"Utsu-P - CD-R\", 0, 1, \"07/07/2013\", 1, 1, \"https://2.bp.blogspot.com/-NADgzcUVVUk/Vd4KDsYlY_I/AAAAAAAACfk/UTiAT4Qyrq0/s1600/Cover.jpg\");                         \n");
                    data_sqlWriter.write("INSERT INTO Products(id, cost, product_name, quantity, genres_id_fk, date_out, author_id_fk, types_id_fk, product_image) VALUES(5, 20.60, \"Utsu-P - Warufuzake\", 0, 1, \"07/08/2013\", 1, 1, \"https://1.bp.blogspot.com/-ZkrdobPmUhA/Vd4LYrm62DI/AAAAAAAACfw/7htWgnJbHCE/s1600/Cover.jpg\");                   \n");
                    data_sqlWriter.write("INSERT INTO Products(id, cost, product_name, quantity, genres_id_fk, date_out, author_id_fk, types_id_fk, product_image) VALUES(6, 9.49, \"Utsu-P - Algorithm\", 0, 1, \"17/08/2014\", 1, 1, \"https://pbs.twimg.com/media/FIcD_FuUYAYCpAb.jpg\");                     \n");
                    data_sqlWriter.write("INSERT INTO Products(id, cost, product_name, quantity, genres_id_fk, date_out, author_id_fk, types_id_fk, product_image) VALUES(7, 9.49, \"Utsu-P - Post-Traumatic-Stress-Disorder\", 0, 1, \"10/08/2016\", 1, 1, \"https://yt3.ggpht.com/ytc/AKedOLSZDJ0kM5zXdip49BsNbamj_FTTfIZRpy_CU6ATrg=s900-c-k-c0x00ffffff-no-rj \");\n");
                    data_sqlWriter.write("INSERT INTO Products(id, cost, product_name, quantity, genres_id_fk, date_out, author_id_fk, types_id_fk, product_image) VALUES(8, 7.92, \"Utsu-P - Galapagos\", 0, 1, \"11/08/2017\", 1, 1, \"http://p1.music.126.net/qVr09TyAqDjM4cjAHoT7KA==/109951164983684976.jpg  \");                     \n");
                    data_sqlWriter.write("INSERT INTO Products(id, cost, product_name, quantity, genres_id_fk, date_out, author_id_fk, types_id_fk, product_image) VALUES(9, 9.49, \"Utsu-P - Greatest Shits\", 0, 1, \"10/08/2018\", 1, 1, \"https://pbs.twimg.com/media/Dno97nqW0AIuoOM.jpg:large \");                \n");
                    data_sqlWriter.write("INSERT INTO Products(id, cost, product_name, quantity, genres_id_fk, date_out, author_id_fk, types_id_fk, product_image) VALUES(10, 7.92, \"Utsu-P - Renaissance\", 0, 1, \"10/08/2019\", 1, 1, \"http://p1.music.126.net/MLtANLgzgnIkW_xV4TZQ4Q==/109951164983692215.jpg   \");                  \n");
                    data_sqlWriter.write("INSERT INTO Products(id, cost, product_name, quantity, genres_id_fk, date_out, author_id_fk, types_id_fk, product_image) VALUES(11, 9.49, \"Utsu-P - Unique\", 0, 1, \"23/10/2021\", 1, 1, \"https://pbs.twimg.com/media/FEu7iZNXwA4Dy-U.jpg\");                    \n \n");

                    log.info("Products have been populated");
                }

                // File is no longer needed
                data_sqlWriter.close();
                log.info("Successfully wrote to the data.sql .");

            } catch (IOException ioException) {
                log.info("An error occurred.");
                ioException.printStackTrace();
            }
        }
    }
}
