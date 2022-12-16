package com.example.demo.config;
import com.example.demo.entities.User;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoClients;
import dev.morphia.Datastore;
import dev.morphia.Morphia;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Slf4j
@Configuration
public class DataSourceConfig {
        @Bean
        public Datastore datastore() {
            // create the Datastore connecting to the default port on the local host
            final Datastore datastore = Morphia.createDatastore(MongoClients.create("mongodb://localhost:27017"), "studio_tesi");
            log.info(datastore.toString());
            datastore.getMapper().mapPackage("com.example.demo.entities");
            datastore.ensureIndexes();
            return datastore;
        }
    }