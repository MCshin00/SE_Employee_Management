package UI;

import javax.swing.*;
public class PaymentListUI extends JFrame {
    public PaymentListUI() {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel Employee = new JLabel("사원명 : ");
        JLabel EmployeeNameLabel = new JLabel("윤지수");

        String header[] = {"기록번호", "급여 지급 날짜"};
        String psex[][] = {{"001", "2023.04.01"}, {"002", "2023.05.01"}};

        JTable PaymentJTable = new JTable(psex, header);
        JScrollPane jsp = new JScrollPane(PaymentJTable);

        Employee.setBounds(37, 25, 70, 25);
        EmployeeNameLabel.setBounds(100, 25, 140, 25);
        jsp.setBounds(23, 80, 420, 250);


        panel.add(Employee);
        panel.add(EmployeeNameLabel);
        panel.add(jsp);

        add(panel);

        setVisible(true);
        setTitle("급여 기록 조회");
        setBounds(50, 50, 480, 400);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}