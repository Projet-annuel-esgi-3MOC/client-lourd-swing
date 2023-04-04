package fr.esgi.student;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MainFrame extends JFrame {
    JList<String> jList;
    DefaultListModel<String> todosModel;
    public MainFrame(String title, Dimension dimension) throws HeadlessException {
        super(title);

        this.setSize(dimension);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initIHM();

//        this.pack();
        this.setVisible(true);

    }

    private void initIHM() {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;

        gbc.gridx = 0;
        gbc.gridy = 0;

        jPanel.add(new JLabel("Liste de todos a faire"), gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;

        jList = new JList<>();
        todosModel = new DefaultListModel<>();
        jList.setModel(todosModel);

        jPanel.add(jList, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        jPanel.add(new JTextField("Nom du todo"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.VERTICAL;

        jPanel.add(new JTextArea("Description du todo"), gbc);

        this.setContentPane(jPanel);
    }

    public void setTodos(List<String> todos) {
        for (String todo :
                todos) {
            todosModel.addElement(todo);
        }
    }
}
