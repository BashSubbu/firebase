package com.yal.pushnotifications.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.*;
import com.google.firebase.messaging.FirebaseMessaging;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class FireBaseConfiguration {
    Logger logger = LoggerFactory.getLogger(FireBaseConfiguration.class);
    @PostConstruct
    public void initialize() {
        try {
            FileInputStream serviceAccount =
                    new FileInputStream("/home/sivasubrahmanyam/Downloads/push-notifications/src/main/resources/push-notifications-1fbc9-firebase-adminsdk-98gdl-5d25f14397.json");


            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://push-notifications-1fbc9-default-rtdb.firebaseio.com")
                    .build();
            FirebaseApp.initializeApp(options);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Bean
    FirebaseMessaging firebaseMessaging() throws IOException {
        FileInputStream serviceAccount =
                new FileInputStream("/home/sivasubrahmanyam/Downloads/push-notifications/src/main/resources/push-notifications-1fbc9-firebase-adminsdk-98gdl-5d25f14397.json");

        FirebaseOptions firebaseOptions = FirebaseOptions
                .builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();
        FirebaseApp app = FirebaseApp.initializeApp(firebaseOptions, "Push Notifications");
        return FirebaseMessaging.getInstance(app);
    }
}
