package fr.esgi.student;


import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.FirebaseApp;
import com.google.firebase.cloud.FirestoreClient;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainFrame frame = new MainFrame("Todo ESGI", new Dimension(800, 600));

                frame.setVisible(true);

                FirebaseApp app = MyFirebaseUtils.login();

                System.out.println(app.getName());
                System.out.println(app.getOptions());

                Firestore db = FirestoreClient.getFirestore(app);

                ApiFuture<QuerySnapshot> query = db.collection("dev-todos").get();

                QuerySnapshot querySnapshot;
                try {
                    querySnapshot = query.get();
                } catch (InterruptedException | ExecutionException e) {
                    throw new RuntimeException(e);
                }
                List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();

                for (QueryDocumentSnapshot document :
                        documents) {
                    System.out.println("id" + document.getId());
                    System.out.println("id" + document.getString("content"));
                }
            }
        });
    }
}
