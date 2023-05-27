package UI;

import javax.swing.*;
import java.awt.*;
public class MainUI extends JFrame {
    public MainUI() {
        JPanel panel = new JPanel();
        panel.setBounds(0,0,480,30);
        JMenuBar mb = new JMenuBar();

        JMenu UserMenu = new JMenu("회원정보");
        JMenuItem UserRegisterMenu = new JMenuItem("회원정보 등록");
        JMenuItem UserSeeMenu= new JMenuItem("회원정보 조회");

        JMenu EmployeeMenu = new JMenu("사원정보");
        JMenuItem EmployeeRegisterMenu = new JMenuItem("사원정보 등록");
        JMenuItem EmployeeSeeMenu = new JMenuItem("사원정보 조회");

        JMenu CommuteMenu = new JMenu("출퇴근기록");
        JMenuItem CommuteRegisterMenu = new JMenuItem("출퇴근 입력");
        JMenuItem CommuteSeeMenu = new JMenuItem("월간 출퇴근 기록 조회");

        JMenu PaymentMenu = new JMenu("급여기록");
        JMenuItem PaymentRegisterMenu = new JMenuItem("급여기록 등록");
        JMenuItem PaymentSeeMenu = new JMenuItem("급여기록 조회");

        JMenu ScheduleMenu = new JMenu("스케줄");

        JMenu MemoMenu= new JMenu("메모장");


        UserMenu.add(UserRegisterMenu);
        UserMenu.add(UserSeeMenu);
        EmployeeMenu.add(EmployeeRegisterMenu);
        EmployeeMenu.add(EmployeeSeeMenu);
        CommuteMenu.add(CommuteRegisterMenu);
        CommuteMenu.add(CommuteSeeMenu);
        PaymentMenu.add(PaymentRegisterMenu);
        PaymentMenu.add(PaymentSeeMenu);

        mb.add(UserMenu);
        mb.add(EmployeeMenu);
        mb.add(CommuteMenu);
        mb.add(PaymentMenu);
        mb.add(ScheduleMenu);
        mb.add(MemoMenu);

        panel.add(mb);
        add(panel);

        setVisible(true);
        setTitle("Employee Management");
        setBounds(50, 50, 480, 400);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}