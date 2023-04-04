package fr.esgi.student;

import org.junit.jupiter.api.*;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class MainFrameTest {

    private static MainFrame mainFrame;

    @BeforeAll
    static void beforeClass() {
        boolean headless = false;
        try {
            mainFrame = new MainFrame("Test mainframe", new Dimension(200, 200));
        } catch (HeadlessException e) {
            headless = true;
        }
        Assumptions.assumeFalse(headless);
    }

    @BeforeEach
    void setUp() {
        boolean headless = false;
        try {
            mainFrame.getTitle();
        } catch (HeadlessException e) {
            headless = true;
        }
        Assumptions.assumeFalse(headless);
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