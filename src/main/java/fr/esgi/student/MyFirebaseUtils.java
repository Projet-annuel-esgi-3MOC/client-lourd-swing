package fr.esgi.student;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class MyFirebaseUtils {
    static void login() {
//        throw new RuntimeException("here");

        InputStream serviceAccount = MyFirebaseUtils.class.getResourceAsStream(
                "/cookup-afee1-firebase-adminsdk-8z5z1-350824fdb2.json");

        if(serviceAccount == null) {
            throw new RuntimeException("Impossible de trouver le fichier de credentials");
        }

        try {
            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setProjectId("cookup-afee1")
//                    .setDatabaseUrl("https://<DATABASE_NAME>.firebaseio.com/")
                    .build();

            if (FirebaseApp.getApps().isEmpty()) {
                FirebaseApp.initializeApp(options);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static FirebaseApp loginFirebase() {
        MyFirebaseUtils.login();
        FirebaseApp app = FirebaseApp.getInstance();

        System.out.println(app.getName());

        Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();

        System.out.println(gson.toJson(app.getOptions()));

        return app;
    }

    public static List<String> listFirebaseTodosOnIHM(FirebaseApp app) {
        Firestore db = FirestoreClient.getFirestore(app);

        ApiFuture<QuerySnapshot> query = db.collection("dev-todos").get();

        QuerySnapshot querySnapshot;

        try {
            querySnapshot = query.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

        List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();

        List<String> res = new ArrayList<>();

        for (QueryDocumentSnapshot document :
                documents) {
            System.out.println("id" + document.getId());
            System.out.println("id" + document.getString("content"));

            res.add(document.getString("content"));
        }

        return res;
    }
}
