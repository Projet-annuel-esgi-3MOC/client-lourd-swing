package fr.esgi.student;


import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.FirebaseApp;
import com.google.firebase.cloud.FirestoreClient;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class Main {
    static MainFrame frame;
    public static void main(String[] args) {
        System.out.println("Hello world!");

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                frame = new MainFrame("Todo ESGI", new Dimension(800, 600));

                frame.setVisible(true);

                FirebaseApp app = loginFirebase();

                List<String> todos = listFirebaseTodosonIHM(app);

                frame.setTodos(todos);
            }
        });
    }

    private static FirebaseApp loginFirebase() {
        FirebaseApp app = MyFirebaseUtils.login();

        System.out.println(app.getName());
        System.out.println(app.getOptions());

        return app;
    }

    private static List<String> listFirebaseTodosonIHM(FirebaseApp app) {
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
