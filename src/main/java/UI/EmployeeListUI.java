package UI;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class EmployeeListUI extends JFrame {
    public EmployeeListUI() {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel EmployeenameLabel = new JLabel("사원명 : ");
        JTextField EmployeenameTextField = new JTextField(5);
        JButton SerchButton = new JButton("검색");

        String header[] = {"ID", "이름"};
        String emex[][] = {{"apple", "윤지수"}, {"banana", "신민철"}};

        JTable EmployeeJTable = new JTable(emex, header);
        JScrollPane jsp = new JScrollPane(EmployeeJTable);

        EmployeenameLabel.setBounds(37, 25, 70, 25);
        EmployeenameTextField.setBounds(100, 25, 140, 25);
        SerchButton.setBounds(290, 25, 140, 25);
        jsp.setBounds(23, 80, 420, 250);


        panel.add(EmployeenameLabel);
        panel.add(EmployeenameTextField);
        panel.add(SerchButton);
        panel.add(jsp);

        add(panel);

        setVisible(true);
        setTitle("사원 목록");
        setBounds(50, 50, 480, 400);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}