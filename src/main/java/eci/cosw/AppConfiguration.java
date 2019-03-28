package eci.cosw;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

@Configuration
public class AppConfiguration {

    @Bean
    public MongoDbFactory mongoDbFactory() throws Exception {
        System.out.println("YEEEI1");

        // Set credentials
        MongoCredential credential = MongoCredential.createCredential("nicolas-gomez", "TasPlannerDB", "203898jngm".toCharArray());
        System.out.println("YEEEI2");

        ServerAddress serverAddress = new ServerAddress("TaskPlannerCluster-3ee8z.mongodb.net",27017);
        System.out.println("YEEEI3");


        // Mongo Client
        MongoClient mongoClient = new MongoClient(serverAddress, credential, new MongoClientOptions.Builder().build());
        System.out.println("YEEEI4");



        return new SimpleMongoDbFactory(mongoClient, "test");


    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {

        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());

        return mongoTemplate;

    }

}
