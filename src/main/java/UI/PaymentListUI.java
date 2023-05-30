package UI;

import Control.PaymentSystem;
import Entity.Payment;
import Entity.PaymentList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

public class PaymentListUI extends JFrame {

    PaymentSystem paymentSystem = new PaymentSystem();
    JTable EmployeeJTable;
    String ID;
    String Name;
    JPanel panel = new JPanel();
    String[] header = {"기록번호", "급여 지급 날짜"};

    PaymentList paymentList;
    DefaultTableModel model = new DefaultTableModel(header, 0){
        public boolean isCellEditable(int row, int column) {
            if (column >= 0) {
                return false;
            } else {
                return true;
            }
        }
    };

    public PaymentListUI(String ID, String Name) throws SQLException {
        this.ID = ID;
        this.Name = Name;
        panel.setLayout(null);
        PaymentListUI.MyMouseListener listener = new PaymentListUI.MyMouseListener();

        paymentList = paymentSystem.Payment_list_see(this.ID);
        Payment[] paymentArray = paymentList.getPaymentArray();

        JLabel Employee = new JLabel("사원명 : ");
        JLabel EmployeeNameLabel = new JLabel(Name);

        for (Payment payment : paymentArray) {
            if (payment == null) {
                break;
            }
            model.addRow(new Object[]{payment.getPaymentNum(), payment.getPaymentDate()});
        }

        EmployeeJTable = new JTable(model);
        EmployeeJTable.addMouseListener(listener);
        EmployeeJTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        JScrollPane jsp = new JScrollPane(EmployeeJTable);

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
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    class MyMouseListener implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getClickCount() == 2){
                int row = EmployeeJTable.getSelectedRow();
                String PaymentNum = EmployeeJTable.getModel().getValueAt(row, 0).toString();
                String PaymentDate = EmployeeJTable.getModel().getValueAt(row, 1).toString();
                try {
                    new PaymentSeeUI(PaymentNum, PaymentDate, ID, Name);
                    dispose();
                } catch (SQLException | InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {}
        @Override
        public void mouseReleased(MouseEvent e) {}

        @Override
        public void mouseEntered(MouseEvent e) {}
        @Override
        public void mouseExited(MouseEvent e) {}
    }
}