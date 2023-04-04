package fr.esgi.student;

import com.google.firebase.FirebaseApp;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Main {
    static MainFrame frame;
    public static void main(String[] args) {
        System.out.println("Hello world!");

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                frame = new MainFrame("Cookup Todo Manager", new Dimension(800, 600));

                FirebaseApp app = MyFirebaseUtils.loginFirebase();

                List<String> todos = MyFirebaseUtils.listFirebaseTodosOnIHM(app);

                frame.setTodos(todos);
            }
        });
    }

}
