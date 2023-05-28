package Entity;

import java.sql.*;

public class PaymentList {
    Payment[] paymentArray = new Payment[100];

    public Payment[] getPaymentArray() {return paymentArray;}

    public PaymentList(String EmployeeID) throws SQLException {
        int i = 0;
        String driver = "org.mariadb.jdbc.Driver";
        String url = "jdbc:mariadb://localhost:3306/softengi_db";
        String userName = "root";
        String password = "c3g9h4c3";
        String EmployeeNum;

        Connection connection = DriverManager.getConnection(url, userName, password);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT employeeNUM FROM employee WHERE employeeID = '" + EmployeeID +"'");
        resultSet.next();
        EmployeeNum = resultSet.getString("employeeNUM");
        resultSet = statement.executeQuery("SELECT * FROM payment WHERE employeeNUM = '" + EmployeeNum +"'");

        while(resultSet.next()){
            if (i==100) break;
            Payment payment = new Payment();
            payment.setPaymentNum(Integer.parseInt(resultSet.getString("paymentNUM")));
            payment.setSalary(Integer.parseInt(resultSet.getString("salary")));
            payment.setNetsalary(Integer.parseInt(resultSet.getString("netsalary")));
            payment.setPaymentDate(resultSet.getString("payment_Date"));
            paymentArray[i] = payment;
            i++;
        }

        resultSet.close();
        statement.close();
        connection.close();
    }
}
