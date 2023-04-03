package fr.esgi.student;

import com.google.firebase.FirebaseApp;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainFrame frame = new MainFrame("Todo ESGI", new Dimension(800, 600));

                frame.setVisible(true);

                FirebaseApp.initializeApp();
            }
        });
    }
}
