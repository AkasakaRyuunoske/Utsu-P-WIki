INSERT INTO Countries(id, description, name) VALUES(1,"none","Japan");    
INSERT INTO Countries(id, description, name) VALUES(2,"none","Italy");    
INSERT INTO Countries(id, description, name) VALUES(3,"none","America");  
INSERT INTO Countries(id, description, name) VALUES(4,"none","Ukraine");  
 
INSERT INTO Types(id, description, name) VALUES(1,"Mostly vocaloid ", "Music"); 
INSERT INTO Types(id, description, name) VALUES(2,"none ", "Manga"); 
INSERT INTO Types(id, description, name) VALUES(3,"none ", "Anime"); 
INSERT INTO Types(id, description, name) VALUES(4,"none ", "Games"); 
INSERT INTO Types(id, description, name) VALUES(5,"none ", "Programming"); 
 
INSERT INTO Genres(id, description, name) VALUES(1,"The shit that only Utsu does well ", "Vocaloid-Metal"); 
INSERT INTO Genres(id, description, name) VALUES(2,"none ", "Vocaloid"); 
 
INSERT INTO Authors(id, author_pseudonym, date_of_birth, last_name, name, total_masterpieces, country_id_fk, additional_info, main_genre, main_type) VALUES(1, "Utsu-P", "December/01/1990", "Unknown", "Unknown", 7, 1, "Very little is known about this guy", 1, 1);
 
INSERT INTO Clients(id, comments_quantity, content_created, default_address, email, password, registration_date, role, user_name, country_id_fk) VALUES(10, 0, 0, "Via Dante 13", "example@mail.example.com", "$2a$11$Rb6OgJj.4j04iXwmW4fVnOTXJECjJ3gMh7eaxUJXzuEnwXU1CMBFS", "Tue Aug 09 18:16:09 CEST 2022", "Client", "Sample User", 1); 
INSERT INTO Clients(id, comments_quantity, content_created, default_address, email, password, registration_date, role, user_name, country_id_fk) VALUES(20, 0, 0, "Via Giovanni Pascoli 4", "example@gmail.com", "$2y$11$EzzkxrKQaYmCBDFtHq.kHevldHqtLQAMMBkDhMmaXL5GbJrNX4gm.", "Wed Aug 17 17:54:48 CEST 2022", "Admin", "Sample Admin", 1); 
INSERT INTO Clients(id, comments_quantity, content_created, default_address, email, password, registration_date, role, user_name, country_id_fk) VALUES(30, 0, 0, "Via Degli Pastori 16", "sample@sample.com", "$2y$11$3BX02Y/VJGX2.vOm9vNp8.Vf7QXuSt/uvEFzBqTJUWY.sV5SVtfxK", " Tue Aug 30 17:45:48 CEST 2022", "Client", "Federica", 1); 
 
INSERT INTO Products(id, cost, product_name, quantity, genres_id_fk, date_out, author_id_fk, types_id_fk, product_image) VALUES(1, 9.49, "Utsu-P - Diarrhea", 0, 1, "15/11/2009", 1, 1, "https://yt3.ggpht.com/ytc/AKedOLSZDJ0kM5zXdip49BsNbamj_FTTfIZRpy_CU6ATrg=s900-c-k-c0x00ffffff-no-rj");                      
INSERT INTO Products(id, cost, product_name, quantity, genres_id_fk, date_out, author_id_fk, types_id_fk, product_image) VALUES(2, 9.49, "Utsu-P - Traumatic", 0, 1, "14/11/2010", 1, 1, "https://yt3.ggpht.com/ytc/AKedOLSZDJ0kM5zXdip49BsNbamj_FTTfIZRpy_CU6ATrg=s900-c-k-c0x00ffffff-no-rj");                     
INSERT INTO Products(id, cost, product_name, quantity, genres_id_fk, date_out, author_id_fk, types_id_fk, product_image) VALUES(3, 8.99, "Utsu-P - Moksha", 0, 1, "30/04/2012", 1, 1, "https://yt3.ggpht.com/ytc/AKedOLSZDJ0kM5zXdip49BsNbamj_FTTfIZRpy_CU6ATrg=s900-c-k-c0x00ffffff-no-rj");                        
INSERT INTO Products(id, cost, product_name, quantity, genres_id_fk, date_out, author_id_fk, types_id_fk, product_image) VALUES(4, 10.99, "Utsu-P - CD-R", 0, 1, "07/07/2013", 1, 1, "https://yt3.ggpht.com/ytc/AKedOLSZDJ0kM5zXdip49BsNbamj_FTTfIZRpy_CU6ATrg=s900-c-k-c0x00ffffff-no-rj");                         
INSERT INTO Products(id, cost, product_name, quantity, genres_id_fk, date_out, author_id_fk, types_id_fk, product_image) VALUES(5, 20.60, "Utsu-P - Warufuzake", 0, 1, "07/08/2013", 1, 1, "https://yt3.ggpht.com/ytc/AKedOLSZDJ0kM5zXdip49BsNbamj_FTTfIZRpy_CU6ATrg=s900-c-k-c0x00ffffff-no-rj");                   
INSERT INTO Products(id, cost, product_name, quantity, genres_id_fk, date_out, author_id_fk, types_id_fk, product_image) VALUES(6, 9.49, "Utsu-P - Algorithm", 0, 1, "17/08/2014", 1, 1, "https://yt3.ggpht.com/ytc/AKedOLSZDJ0kM5zXdip49BsNbamj_FTTfIZRpy_CU6ATrg=s900-c-k-c0x00ffffff-no-rj");                     
INSERT INTO Products(id, cost, product_name, quantity, genres_id_fk, date_out, author_id_fk, types_id_fk, product_image) VALUES(7, 9.49, "Utsu-P - Post-Traumatic-Stress-Disorder", 0, 1, "10/08/2016", 1, 1, "https://yt3.ggpht.com/ytc/AKedOLSZDJ0kM5zXdip49BsNbamj_FTTfIZRpy_CU6ATrg=s900-c-k-c0x00ffffff-no-rj");
INSERT INTO Products(id, cost, product_name, quantity, genres_id_fk, date_out, author_id_fk, types_id_fk, product_image) VALUES(8, 7.92, "Utsu-P - Galapagos", 0, 1, "11/08/2017", 1, 1, "https://yt3.ggpht.com/ytc/AKedOLSZDJ0kM5zXdip49BsNbamj_FTTfIZRpy_CU6ATrg=s900-c-k-c0x00ffffff-no-rj");                     
INSERT INTO Products(id, cost, product_name, quantity, genres_id_fk, date_out, author_id_fk, types_id_fk, product_image) VALUES(9, 9.49, "Utsu-P - Greatest Shits", 0, 1, "10/08/2018", 1, 1, "https://yt3.ggpht.com/ytc/AKedOLSZDJ0kM5zXdip49BsNbamj_FTTfIZRpy_CU6ATrg=s900-c-k-c0x00ffffff-no-rj");                
INSERT INTO Products(id, cost, product_name, quantity, genres_id_fk, date_out, author_id_fk, types_id_fk, product_image) VALUES(10, 7.92, "Utsu-P - Renaissance", 0, 1, "10/08/2019", 1, 1, "https://yt3.ggpht.com/ytc/AKedOLSZDJ0kM5zXdip49BsNbamj_FTTfIZRpy_CU6ATrg=s900-c-k-c0x00ffffff-no-rj");                  
INSERT INTO Products(id, cost, product_name, quantity, genres_id_fk, date_out, author_id_fk, types_id_fk, product_image) VALUES(11, 9.49, "Utsu-P - Unique", 0, 1, "23/10/2021", 1, 1, "https://yt3.ggpht.com/ytc/AKedOLSZDJ0kM5zXdip49BsNbamj_FTTfIZRpy_CU6ATrg=s900-c-k-c0x00ffffff-no-rj");                    
 
