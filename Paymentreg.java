import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.*;
import java.awt.*;
public class Paymentreg extends JFrame{
	
 JTable table;
 JScrollPane scroll; 
 String[] [] data; 
 String[] title = {"지급항목","지급액","공제항목","공제액"}; 
 public Paymentreg(){
	 Container c =getContentPane();
	 c.setLayout(null);
	 JLabel name =new JLabel("성명:");
	 JLabel tit =new JLabel("급여계산기");
	 JLabel date =new JLabel("지급일:");
	 JButton calc=new JButton("계산");
	 JButton reg=new JButton("등록");
	 JTextField name1=new JTextField(10);
	 JTextField date1=new JTextField(10);
	 
	 setTitle("급여기록 등록");
  data = new String[6][4];
  data[0][0]="기본급";
  data[0][1]="";
  data[0][2]="고용보험";
  data[0][3]="";
  
  data[1][0]="";
  data[1][1]="";
  data[1][2]="국민연금";
  data[1][3]="";
  
  data[2][0]="";
  data[2][1]="";
  data[2][2]="장기요양";
  data[2][3]="";
  data[3][0]="";
  data[3][1]="";
  data[3][2]="건강보험";
  data[3][3]="";
  data[4][0]="";
  data[4][1]="";
  data[4][2]="공제합계";
  data[4][3]="";
  data[5][0]="급여계";
  data[5][1]="";
  data[5][2]="차감수령액";
  data[5][3]="";
  
  
  table=new JTable(data,title); 
  table.setRowHeight(26);
  scroll = new JScrollPane(table);
  tit.setBounds(30,5,100,35);
 tit.setFont(new Font("돋움", Font.PLAIN, 20));
  name.setBounds(35,40,40,25);
  name1.setBounds(70,43,50,20);
 date.setBounds(468,40,40,25);
 date1.setBounds(510,43,63,20);
scroll.setBounds(30,70,540,179);
calc.setBounds(420,280,60,35);
reg.setBounds(500,280,60,35);

  
  c.add(tit);
  c.add(name);
  c.add(name1);
  c.add(date);
  c.add(date1);
  c.add(scroll);
  c.add(reg);
  c.add(calc);
  
  this.setDefaultCloseOperation(EXIT_ON_CLOSE);
  pack();
  setSize(600,410);
  setVisible(true);
 }

 public static void main(String[] args) {
  new Paymentreg();

 }

}