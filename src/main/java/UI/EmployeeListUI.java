package UI;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import Control.EmployeeSystem;
import Entity.EmployeeList;
import Entity.Employee;

public class EmployeeListUI extends JFrame implements ActionListener {
    EmployeeSystem employeeSystem = new EmployeeSystem();
    String calledUI;
    JTable EmployeeJTable;
    JPanel panel = new JPanel();
    JLabel EmployeenameLabel = new JLabel("사원명 : ");
    JTextField EmployeenameTextField = new JTextField(5);
    JButton SearchButton = new JButton("검색");
    String header[] = {"ID", "이름"};
    DefaultTableModel model = new DefaultTableModel(header, 0){
        public boolean isCellEditable(int row, int column) {
            if (column >= 0) {
                return false;
            } else {
                return true;
            }
        }
    };
    EmployeeList employeeList;
    public EmployeeListUI(String calledUI) throws SQLException {
        this.calledUI = calledUI;
        SearchButton.addActionListener(this);
        MyMouseListener listener = new MyMouseListener();
        panel.setLayout(null);

        //사원 객체 배열 엔티티 클래스 객체 생성 및 사원목록 배열 get
        employeeList = employeeSystem.Employee_List_see();
        Employee[] employeeArray = employeeList.getEmployeeArray();

        //사원 객체 배열에서 하나의 사원 객체마다 게터를 통해 ID, 이름을 받아와 JTable에 출력
        for(int i=0; i<employeeArray.length; i++){
            if (employeeArray[i] == null) {break;}
            model.addRow(new Object[]{employeeArray[i].getID(),employeeArray[i].getName()});
        }

        EmployeeJTable = new JTable(model);
        EmployeeJTable.addMouseListener(listener);
        EmployeeJTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        JScrollPane jsp = new JScrollPane(EmployeeJTable);

        EmployeenameLabel.setBounds(37, 25, 70, 25);
        EmployeenameTextField.setBounds(100, 25, 140, 25);
        SearchButton.setBounds(290, 25, 140, 25);
        jsp.setBounds(23, 80, 420, 250);


        panel.add(EmployeenameLabel);
        panel.add(EmployeenameTextField);
        panel.add(SearchButton);
        panel.add(jsp);

        add(panel);

        setVisible(true);
        setTitle("사원 목록");
        setBounds(50, 50, 480, 400);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "검색": //검색 버튼 이벤트
                model.setNumRows(0);
                String name = EmployeenameTextField.getText();
                try {
                    employeeList = employeeSystem.Employee_List_see(name);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                Employee[] employeeArray = employeeList.getEmployeeArray();
                for(int i=0; i<employeeArray.length; i++){
                    if (employeeArray[i] == null) {break;}
                    model.addRow(new Object[]{employeeArray[i].getID(),employeeArray[i].getName()});
                }
        }
    }
    class MyMouseListener implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getClickCount() == 2){ //JTable 행 더블클릭 이벤트
                int row = EmployeeJTable.getSelectedRow();
                String ID = EmployeeJTable.getModel().getValueAt(row, 0).toString();
                String Name = EmployeeJTable.getModel().getValueAt(row, 1).toString();
                switch (calledUI){
                    case "PaymentRegister" :
                        new PaymentRegisterUI(ID, Name);
                        break;

                    case "PaymentList" :
                        try {
                            new PaymentListUI(ID, Name);
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                        break;
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
