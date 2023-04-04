package fr.esgi.student;

import com.google.firebase.FirebaseApp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MyFirebaseUtilsTest {
    @BeforeEach
    void setUp() {
        MyFirebaseUtils.login();
    }

    @Test
    void login() {
        MyFirebaseUtils.login();

        assertNotNull(FirebaseApp.getInstance());

        assertEquals("cookup-afee1", FirebaseApp.getInstance().getOptions().getProjectId());
    }

    @Test
    void listFirebaseTodosOnIHM() {
        List<String> todos = MyFirebaseUtils.listFirebaseTodosOnIHM(FirebaseApp.getInstance());

        assertTrue(todos.size() >= 1);
    }
}