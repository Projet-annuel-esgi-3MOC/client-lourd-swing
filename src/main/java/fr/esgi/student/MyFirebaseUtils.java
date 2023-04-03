package fr.esgi.student;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import java.io.IOException;
import java.io.InputStream;

public class MyFirebaseUtils {
    static void login() {
        InputStream serviceAccount = MyFirebaseUtils.class.getResourceAsStream(
                "/cookup-afee1-firebase-adminsdk-8z5z1-350824fdb2.json");

        if(serviceAccount == null) {
            throw new RuntimeException("Impossible de trouver le fichier de credentials");
        }

        try {
            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://<DATABASE_NAME>.firebaseio.com/")
                    .build();

            FirebaseApp.initializeApp(options);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
