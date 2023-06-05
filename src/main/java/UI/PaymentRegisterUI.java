package UI;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import Control.PaymentSystem;
import Entity.Payment;
import Entity.User;

public class PaymentRegisterUI extends JFrame implements ActionListener {
    String EmployeeID;
    String EmployeeName;
    PaymentSystem paymentSystem = new PaymentSystem();
    JTextField SalaryTextField;
    JTextField DateTextField;
    JLabel SalarySumLabel;
    JLabel NetSalaryLabel;
    JLabel Deduction1Label;
    JLabel Deduction2Label;
    JLabel Deduction3Label;
    JLabel Deduction4Label;
    JLabel DeductionSumLabel;

    JButton CalculateButton;
    JButton RegisterButton;

    public PaymentRegisterUI(String ID, String Name) {
        this.EmployeeID = ID;
        this.EmployeeName = Name;
        JPanel panel1 = new JPanel();
        panel1.setLayout(null);

        CalculateButton = new JButton("계산");
        RegisterButton = new JButton("등록");
        CalculateButton.addActionListener(this);
        RegisterButton.addActionListener(this);

        JLabel EmployeeName = new JLabel("사원명 : ");
        JLabel EmployeeNameLabel = new JLabel(this.EmployeeName);
        JLabel Date = new JLabel("지급일");
        DateTextField = new JTextField();

        JLabel Salary = new JLabel("기본급");
        SalaryTextField = new JTextField();
        JLabel SalarySum = new JLabel("급여계");
        SalarySumLabel = new JLabel();
        JLabel NetSalary = new JLabel("차감수령액");
        NetSalaryLabel = new JLabel();

        JLabel Header1 = new JLabel("지급 항목");
        JLabel Header2 = new JLabel("지급액");
        JLabel Header3 = new JLabel("공제 항목");
        JLabel Header4 = new JLabel("공제액");

        JLabel Deduction1 = new JLabel("고용보험");
        Deduction1Label = new JLabel();
        JLabel Deduction2 = new JLabel("국민연금");
        Deduction2Label = new JLabel();
        JLabel Deduction3 = new JLabel("장기요양");
        Deduction3Label = new JLabel();
        JLabel Deduction4 = new JLabel("건강보험");
        Deduction4Label = new JLabel();
        JLabel DeductionSum = new JLabel("공제합계");
        DeductionSumLabel = new JLabel();

        JLabel l1 = new JLabel();
        JLabel l2 = new JLabel();
        JLabel l3 = new JLabel();
        JLabel l4 = new JLabel();
        JLabel l5 = new JLabel();
        JLabel l6 = new JLabel();
        JLabel l7 = new JLabel();
        JLabel l8 = new JLabel();

        Salary.setBorder(new LineBorder(Color.BLACK));
        Salary.setHorizontalAlignment(JLabel.CENTER);
        SalaryTextField.setBorder(new LineBorder(Color.BLACK));
        Header1.setBorder(new LineBorder(Color.BLACK));
        Header1.setHorizontalAlignment(JLabel.CENTER);
        Header2.setBorder(new LineBorder(Color.BLACK));
        Header2.setHorizontalAlignment(JLabel.CENTER);
        Header3.setBorder(new LineBorder(Color.BLACK));
        Header3.setHorizontalAlignment(JLabel.CENTER);
        Header4.setBorder(new LineBorder(Color.BLACK));
        Header4.setHorizontalAlignment(JLabel.CENTER);
        Deduction1.setBorder(new LineBorder(Color.BLACK));
        Deduction1.setHorizontalAlignment(JLabel.CENTER);
        Deduction1Label.setBorder(new LineBorder(Color.BLACK));
        Deduction1Label.setHorizontalAlignment(JLabel.CENTER);
        Deduction2.setBorder(new LineBorder(Color.BLACK));
        Deduction2.setHorizontalAlignment(JLabel.CENTER);
        Deduction2Label.setBorder(new LineBorder(Color.BLACK));
        Deduction2Label.setHorizontalAlignment(JLabel.CENTER);
        Deduction3.setHorizontalAlignment(JLabel.CENTER);
        Deduction3.setBorder(new LineBorder(Color.BLACK));
        Deduction3Label.setHorizontalAlignment(JLabel.CENTER);
        Deduction3Label.setBorder(new LineBorder(Color.BLACK));
        Deduction4.setHorizontalAlignment(JLabel.CENTER);
        Deduction4.setBorder(new LineBorder(Color.BLACK));
        Deduction4Label.setHorizontalAlignment(JLabel.CENTER);
        Deduction4Label.setBorder(new LineBorder(Color.BLACK));
        DeductionSum.setBorder(new LineBorder(Color.BLACK));
        DeductionSum.setHorizontalAlignment(JLabel.CENTER);
        DeductionSumLabel.setBorder(new LineBorder(Color.BLACK));
        DeductionSumLabel.setHorizontalAlignment(JLabel.CENTER);
        SalarySum.setBorder(new LineBorder(Color.BLACK));
        SalarySum.setHorizontalAlignment(JLabel.CENTER);
        SalarySumLabel.setBorder(new LineBorder(Color.BLACK));
        SalarySumLabel.setHorizontalAlignment(JLabel.CENTER);
        NetSalary.setHorizontalAlignment(JLabel.CENTER);
        NetSalary.setBorder(new LineBorder(Color.BLACK));
        NetSalaryLabel.setHorizontalAlignment(JLabel.CENTER);
        NetSalaryLabel.setBorder(new LineBorder(Color.BLACK));
        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setBorder(new LineBorder(Color.BLACK));
        l2.setHorizontalAlignment(JLabel.CENTER);
        l2.setBorder(new LineBorder(Color.BLACK));
        l3.setHorizontalAlignment(JLabel.CENTER);
        l3.setBorder(new LineBorder(Color.BLACK));
        l4.setHorizontalAlignment(JLabel.CENTER);
        l4.setBorder(new LineBorder(Color.BLACK));
        l5.setHorizontalAlignment(JLabel.CENTER);
        l5.setBorder(new LineBorder(Color.BLACK));
        l6.setHorizontalAlignment(JLabel.CENTER);
        l6.setBorder(new LineBorder(Color.BLACK));
        l7.setHorizontalAlignment(JLabel.CENTER);
        l7.setBorder(new LineBorder(Color.BLACK));
        l8.setHorizontalAlignment(JLabel.CENTER);
        l8.setBorder(new LineBorder(Color.BLACK));

        EmployeeName.setBounds(30, 60, 70, 30);
        EmployeeNameLabel.setBounds(100, 67, 70, 20);
        Date.setBounds(500, 60, 70, 30);
        DateTextField.setBounds(580, 67, 70, 20);

        Header1.setBounds(30, 100, 150, 30);
        Header2.setBounds(180, 100, 170, 30);
        Header3.setBounds(350, 100, 150, 30);
        Header4.setBounds(500, 100, 170, 30);

        Salary.setBounds(30, 130, 150, 30);
        SalaryTextField.setBounds(180, 130, 170, 30);
        Deduction1.setBounds(350, 130, 150, 30);
        Deduction1Label.setBounds(500, 130, 170, 30);

        l1.setBounds(30, 160, 150, 30);
        l2.setBounds(180, 160, 170, 30);
        Deduction2.setBounds(350, 160, 150, 30);
        Deduction2Label.setBounds(500, 160, 170, 30);

        l3.setBounds(30, 190, 150, 30);
        l4.setBounds(180, 190, 170, 30);
        Deduction3.setBounds(350, 190, 150, 30);
        Deduction3Label.setBounds(500, 190, 170, 30);

        l5.setBounds(30, 220, 150, 30);
        l6.setBounds(180, 220, 170, 30);
        Deduction4.setBounds(350, 220, 150, 30);
        Deduction4Label.setBounds(500, 220, 170, 30);

        l7.setBounds(30, 250, 150, 30);
        l8.setBounds(180, 250, 170, 30);
        DeductionSum.setBounds(350, 250, 150, 30);
        DeductionSumLabel.setBounds(500, 250, 170, 30);

        SalarySum.setBounds(30, 280, 150, 30);
        SalarySumLabel.setBounds(180, 280, 170, 30);
        NetSalary.setBounds(350, 280, 150, 30);
        NetSalaryLabel.setBounds(500, 280, 170, 30);

        CalculateButton.setBounds(500, 350, 70, 30);
        RegisterButton.setBounds(600, 350, 70, 30);

        panel1.add(EmployeeName);
        panel1.add(EmployeeNameLabel);
        panel1.add(Date);
        panel1.add(DateTextField);
        panel1.add(Header1);
        panel1.add(Header2);
        panel1.add(Header3);
        panel1.add(Header4);
        panel1.add(Salary);
        panel1.add(SalaryTextField);
        panel1.add(Deduction1);
        panel1.add(Deduction1Label);
        panel1.add(l1);
        panel1.add(l2);
        panel1.add(Deduction2);
        panel1.add(Deduction2Label);
        panel1.add(l3);
        panel1.add(l4);
        panel1.add(Deduction3);
        panel1.add(Deduction3Label);
        panel1.add(l5);
        panel1.add(l6);
        panel1.add(Deduction4);
        panel1.add(Deduction4Label);
        panel1.add(l7);
        panel1.add(l8);
        panel1.add(DeductionSum);
        panel1.add(DeductionSumLabel);
        panel1.add(SalarySum);
        panel1.add(SalarySumLabel);
        panel1.add(NetSalary);
        panel1.add(NetSalaryLabel);
        panel1.add(CalculateButton);
        panel1.add(RegisterButton);

        add(panel1);

        setVisible(true);
        setTitle("급여 기록 등록");
        setBounds(50, 50, 700, 450);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void ShowWarning(String ErrorMessage){
        JOptionPane.showMessageDialog(this, ErrorMessage, "오류", JOptionPane.ERROR_MESSAGE);
    }

    public void ShowSuccess(){
        JOptionPane.showMessageDialog(this, "등록에 성공했습니다.", "성공", JOptionPane.INFORMATION_MESSAGE);
    }

    public boolean Checksalary(){
        try{
           Integer.parseInt(SalaryTextField.getText());
        }
        catch (Exception exception){
            return false;
        }
        return true;
    }

    public boolean CheckDate(){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            sdf.setLenient(false);
            sdf.parse(DateTextField.getText());
        } catch (ParseException ex) {
            return false;
        }
        return true;
    }

    public boolean CheckDoCalc(){
        try{
            Integer.parseInt(SalarySumLabel.getText());
        } catch (Exception ex){
            return false;
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "계산":
                int salary;
                int[] calcresult;
                if (Checksalary()){
                    try {
                        salary = Integer.parseInt(SalaryTextField.getText());
                        calcresult = paymentSystem.Payment_Calculate(salary);
                        SalarySumLabel.setText(SalaryTextField.getText());
                        Deduction1Label.setText(Integer.toString(calcresult[3]));
                        Deduction2Label.setText(Integer.toString(calcresult[0]));
                        Deduction3Label.setText(Integer.toString(calcresult[2]));
                        Deduction4Label.setText(Integer.toString(calcresult[1]));
                        DeductionSumLabel.setText(Integer.toString(calcresult[4]));
                        NetSalaryLabel.setText(Integer.toString(salary-calcresult[4]));
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                else {
                    ShowWarning("기본급 항목에 올바른 값을 입력하세요.");
                }
                break;

            case "등록" :
                boolean addResult;
                int result_salary;
                int result_netsalary;
                String result_date = DateTextField.getText();

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                sdf.setLenient(false);

                if (!CheckDoCalc()){
                    ShowWarning("계산이 실행되지 않았습니다.");
                    break;
                }

                if (!CheckDate()){
                    ShowWarning("날짜 형식이 잘못되었습니다.");
                    break;
                }

                result_salary = Integer.parseInt(SalarySumLabel.getText());
                result_netsalary  =  Integer.parseInt(NetSalaryLabel.getText());

                try {
                    addResult = paymentSystem.Payment_add(result_salary, result_netsalary, result_date,User.CurrentUserID, this.EmployeeID);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

                if (addResult) {
                    ShowSuccess();
                    dispose();
                }
                else {
                    ShowWarning("잠시 후 다시 시도하세요.");
                    break;
                }
                break;
        }
    }
}
