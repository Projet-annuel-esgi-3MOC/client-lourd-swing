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
    }

    private void initIHM() {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;

        jPanel.add(new JLabel("Liste de todos a faire"), gridBagConstraints);

        gridBagConstraints.gridy = 1;

        jList = new JList<>();
        todosModel = new DefaultListModel<>();
        jList.setModel(todosModel);

        jPanel.add(jList, gridBagConstraints);


        this.setContentPane(jPanel);
    }

    public void setTodos(List<String> todos) {
        for (String todo :
                todos) {
            todosModel.addElement(todo);
        }
    }
}
