package fr.esgi.student;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class MainFrameTest {

    private final MainFrame mainFrame = new MainFrame("Test mainframe", new Dimension(200, 200));
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void mainFrameTitleValid() {
        assertEquals("Test mainframe", mainFrame.getTitle());
    }

    @Test
    void mainFrameSizeValid() {
        Dimension window = mainFrame.getSize();
        assertEquals(200, window.getHeight());
        assertEquals(200, window.getWidth());
    }
}