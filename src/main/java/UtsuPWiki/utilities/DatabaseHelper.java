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
            String doPopulateProductsAdditionalInfo,
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
                    data_sqlWriter.write("INSERT INTO Authors(id, author_pseudonym, date_of_birth, last_name, name, total_masterpieces, country_id_fk,  additional_info, main_genre, main_type) VALUES(1, \"Utsu-P\", \"December/01/1990\", \"Unknown\", \"Unknown\", 7, 1, \"Very little is known about this guy\", 1, 1);\n \n");
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
                    data_sqlWriter.write("INSERT INTO Products(id, cost, product_name, quantity, genres_id_fk, date_out, author_id_fk, types_id_fk, product_image, contains) VALUES(1, 9.49, \"Utsu-P - Diarrhea\", 0, 1, \"15/11/2009\", 1, 1, \"https://i.scdn.co/image/ab67616d00001e02486835908dacc4ca95d5a7e4\", \"Anti Digitalizm, Melancholy of Heavy Rain, Psychokinesis, Self-Destruct\");                                        \n");
                    data_sqlWriter.write("INSERT INTO Products(id, cost, product_name, quantity, genres_id_fk, date_out, author_id_fk, types_id_fk, product_image, contains) VALUES(2, 9.49, \"Utsu-P - Traumatic\", 0, 1, \"14/11/2010\", 1, 1, \"https://pbs.twimg.com/media/FIcD_F7VEAAGOoN.jpg\", \"Constipation of Death, Monkey Doesn't know, Vermin, Black Showtime\");                                                                            \n");
                    data_sqlWriter.write("INSERT INTO Products(id, cost, product_name, quantity, genres_id_fk, date_out, author_id_fk, types_id_fk, product_image, contains) VALUES(3, 8.99, \"Utsu-P - Moksha\", 0, 1, \"30/04/2012\", 1, 1, \"https://static.zerochan.net/Type-H.full.1118182.jpg\", \"Riot, Black Hole Artist, Red light green light?, Shima Shima Melody\");                                                                           \n");
                    data_sqlWriter.write("INSERT INTO Products(id, cost, product_name, quantity, genres_id_fk, date_out, author_id_fk, types_id_fk, product_image, contains) VALUES(4, 10.99, \"Utsu-P - CD-R\", 0, 1, \"07/07/2013\", 1, 1, \"https://2.bp.blogspot.com/-NADgzcUVVUk/Vd4KDsYlY_I/AAAAAAAACfk/UTiAT4Qyrq0/s1600/Cover.jpg\", \"Corpse Attack!!, Disparate Society, Welcome to the Love Hospital, DIARRHEA\");                                     \n");
                    data_sqlWriter.write("INSERT INTO Products(id, cost, product_name, quantity, genres_id_fk, date_out, author_id_fk, types_id_fk, product_image, contains) VALUES(5, 20.60, \"Utsu-P - Warufuzake\", 0, 1, \"07/08/2013\", 1, 1, \"https://1.bp.blogspot.com/-ZkrdobPmUhA/Vd4LYrm62DI/AAAAAAAACfw/7htWgnJbHCE/s1600/Cover.jpg\", \"Fools Are Attracted to Anomaly, Ghost Under the Umbrella, Painting, B-Class Heroes\");                               \n");
                    data_sqlWriter.write("INSERT INTO Products(id, cost, product_name, quantity, genres_id_fk, date_out, author_id_fk, types_id_fk, product_image, contains) VALUES(6, 9.49, \"Utsu-P - Algorithm\", 0, 1, \"17/08/2014\", 1, 1, \"https://pbs.twimg.com/media/FIcD_FuUYAYCpAb.jpg\", \"A final fantasy, ALGORITHMIC KABUKICHO, P.O.R.N.O., Hell Pops\");                                                                            \n");
                    data_sqlWriter.write("INSERT INTO Products(id, cost, product_name, quantity, genres_id_fk, date_out, author_id_fk, types_id_fk, product_image, contains) VALUES(7, 9.49, \"Utsu-P - Post-Traumatic-Stress-Disorder\", 0, 1, \"10/08/2016\", 1, 1, \"https://yt3.ggpht.com/ytc/AKedOLSZDJ0kM5zXdip49BsNbamj_FTTfIZRpy_CU6ATrg=s900-c-k-c0x00ffffff-no-rj \", \"Constipation of Death, Children's World, Adult's Toy, THE DYING MESSAGE\");  \n");
                    data_sqlWriter.write("INSERT INTO Products(id, cost, product_name, quantity, genres_id_fk, date_out, author_id_fk, types_id_fk, product_image, contains) VALUES(8, 7.92, \"Utsu-P - Galapagos\", 0, 1, \"11/08/2017\", 1, 1, \"http://p1.music.126.net/qVr09TyAqDjM4cjAHoT7KA==/109951164983684976.jpg  \", \"Is it bad at the Galapagos Syndrome?, Sugarcoat of Love, Ramen shop 'GROTESQUE', Summer Vacation in the Future\");                                                  \n");
                    data_sqlWriter.write("INSERT INTO Products(id, cost, product_name, quantity, genres_id_fk, date_out, author_id_fk, types_id_fk, product_image, contains) VALUES(9, 9.49, \"Utsu-P - Greatest Shits\", 0, 1, \"10/08/2018\", 1, 1, \"https://pbs.twimg.com/media/Dno97nqW0AIuoOM.jpg:large \", \"Self-destruct, I Want to Become a Stuffed Animal, Shima Shima Melody, Imperfect Animals\");                                                                \n");
                    data_sqlWriter.write("INSERT INTO Products(id, cost, product_name, quantity, genres_id_fk, date_out, author_id_fk, types_id_fk, product_image, contains) VALUES(10, 7.92, \"Utsu-P - Renaissance\", 0, 1, \"10/08/2019\", 1, 1, \"http://p1.music.126.net/MLtANLgzgnIkW_xV4TZQ4Q==/109951164983692215.jpg   \", \"RENAISSANCE, The Beautiful Puke, Even If Everyone Around The World Laughed\");                                              \n");
                    data_sqlWriter.write("INSERT INTO Products(id, cost, product_name, quantity, genres_id_fk, date_out, author_id_fk, types_id_fk, product_image, contains) VALUES(11, 9.49, \"Utsu-P - Unique\", 0, 1, \"23/10/2021\", 1, 1, \"https://pbs.twimg.com/media/FEu7iZNXwA4Dy-U.jpg\", \"Harakiri, Dull, PEE PEE PRINCES, March 9, 2000\");                    \n                                                        \n");

                    log.info("Products have been populated");
                }

                // Products Additional Info Table
                if (doPopulateProductsAdditionalInfo.equals("true") || doPopulateAll.equals("true")) {
                    log.info("Products Additional Info have been populated");
                    //Order of albums and song in them is taken from : https://vocaloid.fandom.com/wiki/Utsu-P

                    // Diarrhea
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, song_name, link_spotify, link_wiki, product_id_fk) VALUES (1, \"Poison Apple\", \"none\", \"none\", 1);\n"                );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, song_name, link_spotify, link_wiki, product_id_fk) VALUES (2, \"Corpse Attack!!\", \"none\", \"none\", 1);\n"             );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, song_name, link_spotify, link_wiki, product_id_fk) VALUES (3, \"Anti Digitalizm\", \"none\", \"none\", 1);\n"             );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, song_name, link_spotify, link_wiki, product_id_fk) VALUES (4, \"Melancholy of Heavy Rain\", \"none\", \"none\", 1);\n"    );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, song_name, link_spotify, link_wiki, product_id_fk) VALUES (5, \"Shoegaze Life\", \"none\", \"none\", 1);\n"               );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, song_name, link_spotify, link_wiki, product_id_fk) VALUES (6, \"Sex Doll with Life\", \"none\", \"none\", 1);\n"          );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, song_name, link_spotify, link_wiki, product_id_fk) VALUES (7, \"Disparate Society\", \"none\", \"none\", 1);\n"           );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, song_name, link_spotify, link_wiki, product_id_fk) VALUES (8, \"Initiative\", \"none\", \"none\", 1);\n "                 );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, song_name, link_spotify, link_wiki, product_id_fk) VALUES (9, \"Welcome to the Love Hospital\", \"none\", \"none\", 1);\n");
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, song_name, link_spotify, link_wiki, product_id_fk) VALUES (10, \"SHIRONOIR\", \"none\", \"none\", 1);\n"                  );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, song_name, link_spotify, link_wiki, product_id_fk) VALUES (11, \"Psychokinesis\", \"none\", \"none\", 1);\n"              );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, song_name, link_spotify, link_wiki, product_id_fk) VALUES (12, \"DIARRHEA\", \"none\", \"none\", 1);\n"                   );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, song_name, link_spotify, link_wiki, product_id_fk) VALUES (13, \"Sky Burial\", \"none\", \"none\", 1);\n"                 );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, song_name, link_spotify, link_wiki, product_id_fk) VALUES (14, \"Self-Distruct\", \"none\", \"none\", 1);\n"              );

                    // Traumatic
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (15, \"none\", \"none\", \"Constipation of Death\", 2);\n");
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (16, \"nsone\", \"none\", \"Children's World\", 2);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (17, \"none\", \"none\", \"Adult's Toy\", 2);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (18, \"none\", \"none\", \"THE DYING MESSAGE\", 2);\n");
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (19, \"none\", \"none\", \"The Public Toilet's Murky Water\", 2);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (20, \"none\", \"none\", \"TRAUMATIC\", 2);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (21, \"none\", \"none\", \"Monkey Doesn't Know\", 2);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (22, \"none\", \"none\", \"Black Showtime\", 2);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (23, \"none\", \"none\", \"potato-head in wonderland\", 2);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (24, \"none\", \"none\", \"Wraith\", 2);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (25, \"none\", \"none\", \"Vermin\", 2);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (26, \"none\", \"none\", \"Sleepwalk\", 2);\n");
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (27, \"none\", \"none\", \"Doll\", 2);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (28, \"none\", \"none\", \"Heart Sutra Hardcore\", 2);\n");

                    // Moksha
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (29, \"none\", \"none\", \"MOKSHA (emancipation)\", 3);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (30, \"none\", \"none\", \"Riot\", 3);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (31, \"none\", \"none\", \"Fools Are Attracted to Anomaly\", 3);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (32, \"none\", \"none\", \"Rebirth\", 3);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (33, \"none\", \"none\", \"Corona\", 3);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (34, \"none\", \"none\", \"Red light, green light?\", 3);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (35, \"none\", \"none\", \"This is Love Song\", 3);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (36, \"none\", \"none\", \"The Setting Sun\", 3);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (37, \"none\", \"none\", \"Let's Ride The Happy Train\", 3);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (38, \"none\", \"none\", \"Compared to The Black of The Anonymous\", 3);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (39, \"none\", \"none\", \"MOKSHA\", 3);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (40, \"none\", \"none\", \"Blackhole Artist\", 3);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (41, \"none\", \"none\", \"Allegra\", 3);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (42, \"none\", \"none\", \"The trains are running on shedule\", 3);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (43, \"none\", \"none\", \"Pure White Poison\", 3);\n");
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (44, \"none\", \"none\", \"Striped Melody\", 3);\n");

                    // CD-R
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (45, \"none\", \"none\", \"Poison Apple\", 4);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (46, \"none\", \"none\", \"Corpse Attack!!\", 4);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (47, \"none\", \"none\", \"Anti digitalizm\", 4);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (48, \"none\", \"none\", \"Melancholy of Heavy Rain\", 4);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (49, \"none\", \"none\", \"Shoegaze Life\", 4);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (50, \"none\", \"none\", \"Sex doll with life\", 4);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (51, \"none\", \"none\", \"Disparate Society\", 4);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (52, \"none\", \"none\", \"Initiative\", 4);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (53, \"none\", \"none\", \"Welcome to The Love Hospital\", 4);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (54, \"none\", \"none\", \"SHIRONOIR\", 4);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (55, \"none\", \"none\", \"Psychokinesis\", 4);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (56, \"none\", \"none\", \"DARRHEA\", 4);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (57, \"none\", \"none\", \"Sky Burial\", 4);");

                    // Warufuzake
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (58, \"none\", \"none\", \"Impli-cat Understanding\", 5);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (59, \"none\", \"none\", \"Fools are Attracted to Anomaly\", 5);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (60, \"none\", \"none\", \"Vermin\", 5);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (61, \"none\", \"none\", \"Ghost Under the Umbrella\", 5);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (62, \"none\", \"none\", \"Painting\", 5);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (63, \"none\", \"none\", \"Corona\", 5);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (64, \"none\", \"none\", \"Adult's Toy\", 5);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (65, \"none\", \"none\", \"B-CLASS HEROES\", 5);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (66, \"none\", \"none\", \"Poster Girl's Prank\", 5);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (67, \"none\", \"none\", \"Corpse Attack!!\", 5);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (68, \"none\", \"none\", \"Flu\", 5);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (69, \"none\", \"none\", \"THE DYING MESSAGE\", 5);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (70, \"none\", \"none\", \"Life Select Button ~'M~\", 5);");


                    // Algorithm
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (71, \"none\", \"none\", \"A final fantasy\", 6);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (72, \"none\", \"none\", \"Baby Death Match\", 6);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (73, \"none\", \"none\", \"The magic of the massacre\", 6);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (74, \"none\", \"none\", \"Absolute Music Dance\", 6);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (75, \"none\", \"none\", \"Imperfect Animals\", 6);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (76, \"none\", \"none\", \"Brainwashing Technique of the Monkey Dance\", 6);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (77, \"none\", \"none\", \"Chocolate Girl\", 6);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (78, \"none\", \"none\", \"ALGORITHMIC KABUKICHO\", 6);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (79, \"none\", \"none\", \"P.O.R.N.O.\", 6);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (80, \"none\", \"none\", \"CR's Unique Worldview\", 6);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (81, \"none\", \"none\", \"Hell Pops\", 6);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (82, \"none\", \"none\", \"Alien's 'I Love You'\", 6);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (83, \"none\", \"none\", \"MiKUSABBATH\", 6);\n" );

                    // PTSD
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (84, \"none\", \"none\", \"Constipation of Death\", 7);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (85, \"none\", \"none\", \"Children's World\", 7);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (86, \"none\", \"none\", \"Adult's Toy\", 7);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (87, \"none\", \"none\", \"THE DYING MESSAGE\", 7);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (88, \"none\", \"none\", \"The Public Toilet's Murky Water\", 7);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (89, \"none\", \"none\", \"TRAUMATIC\", 7);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (90, \"none\", \"none\", \"Monkey Doesn't Know\", 7);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (91, \"none\", \"none\", \"Black Showtime\", 7);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (92, \"none\", \"none\", \"potato-head in wonderland\", 7);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (93, \"none\", \"none\", \"Wraith\", 7);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (94, \"none\", \"none\", \"Vermin\", 7);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (95, \"none\", \"none\", \"Sleepwalk\", 7);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (96, \"none\", \"none\", \"Doll\", 7);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (97, \"none\", \"none\", \"Hard Core Heart Sutra\", 7);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (98, \"none\", \"none\", \"Fear! The Speaker People\", 7);\n" );

                    // Galapagos
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (99, \"none\", \"none\", \"Is it bad at the Galapagos Syndrome?\", 8);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (100, \"none\", \"none\", \"Living ghost is alive\", 8);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (101, \"none\", \"none\", \"Sugarcoat of Love\", 8);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (102, \"none\", \"none\", \"Ramen shop 'GROTESQUE'\", 8);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (103, \"none\", \"none\", \"EAT\", 8);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (104, \"none\", \"none\", \"Drag\", 8);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (105, \"none\", \"none\", \"Summer Vacation in the Future\", 8);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (106, \"none\", \"none\", \"CANDIES\", 8);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (107, \"none\", \"none\", \"Living ghost is alive Remix\", 8);\n" );

                    // Greatest Shits
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (108, \"none\", \"none\", \"Corpse Attack!!\", 9);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (109, \"none\", \"none\", \"Anti digitalizm\", 9);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (110, \"none\", \"none\", \"Self-destruct\", 9);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (111, \"none\", \"none\", \"Vermin\", 9);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (112, \"none\", \"none\", \"Adult's Toy\", 9);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (113, \"none\", \"none\", \"THE DYING MESSAGE\", 9);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (114, \"none\", \"none\", \"Heart Sutra Hardcore\", 9);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (115, \"none\", \"none\", \"Black Hole Artist\", 9);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (116, \"none\", \"none\", \"Corona\", 9);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (117, \"none\", \"none\", \"Fools Are Attracted to Anomaly\", 9);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (118, \"none\", \"none\", \"Chocolate Girl\", 9);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (119, \"none\", \"none\", \"Ghost Under the Umbrella\", 9);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (120, \"none\", \"none\", \"Poster Girl's Prank\", 9);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (121, \"none\", \"none\", \"The magic of the massacre\", 9);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (122, \"none\", \"none\", \"Imperfect Animals\", 9);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (123, \"none\", \"none\", \"Absolute Music Dance\", 9);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (124, \"none\", \"none\", \"EAT\", 9);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (125, \"none\", \"none\", \"Living ghost is alive\", 9);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (126, \"none\", \"none\", \"I thought I was an angel\", 9);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (127, \"none\", \"none\", \"I Want to Become a Stuffed Animal\", 9);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (128, \"none\", \"none\", \"Shima Shima Melody -Bonus Track-\", 9);\n" );

                    // RENAISSANCE
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (129, \"none\", \"none\", \"RENAISSANCE\", 10);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (130, \"none\", \"none\", \"The Beautiful Puke\", 10);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (131, \"none\", \"none\", \"Hyper Reality Show\", 10);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (132, \"none\", \"none\", \"The Sun Goddess & Rat\", 10);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (133, \"none\", \"none\", \"Poisonous Spider Daughter\", 10);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (134, \"none\", \"none\", \"Gorgeous Big Conversation (2019)\", 10);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (135, \"none\", \"none\", \"ECHO\", 10);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (136, \"none\", \"none\", \"I thought I was an angel\", 10);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (137, \"none\", \"none\", \"Even If Everyone Around The World Laughed\", 10);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (138, \"none\", \"none\", \"Heart Sutra (RENAISSANCE COVER)\", 10);\n" );

                    // Unique
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (139, \"none\", \"none\", \"Harakiri\", 11);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (140, \"none\", \"none\", \"NULL\", 11);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (141, \"none\", \"none\", \"OGRE\", 11);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (142, \"none\", \"none\", \"Unique Parade\", 11);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (143, \"none\", \"none\", \"dull\", 11);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (144, \"none\", \"none\", \"PEE PEE PRINCESS\", 11);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (145, \"none\", \"none\", \"Death of the Law\", 11);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (146, \"none\", \"none\", \"March 9, 2000\", 11);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (147, \"none\", \"none\", \"ATARI FRONT PROGRAM\", 11);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (148, \"none\", \"none\", \"Not Photogenic\", 11);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (149, \"none\", \"none\", \"vivid \", 11);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (150, \"none\", \"none\", \"Root Rot\", 11);\n" );
                    data_sqlWriter.write("INSERT INTO products_additional_info(id, link_spotify, link_wiki, song_name, product_id_fk) VALUES (151, \"none\", \"none\", \"I thought I was an angel\", 11);\n" );
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
