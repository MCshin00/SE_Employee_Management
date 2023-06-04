package Control;

import Entity.Employee;
import Entity.EmployeeList;
import Entity.User;

import java.sql.*;

public class EmployeeSystem {
    public EmployeeList Employee_List_see() throws SQLException {
        EmployeeList employeeList = new EmployeeList();
        int i = 0;
        String url = "jdbc:mariadb://localhost:3306/softengi_db";
        String userName = "root";
        String password = "c3g9h4c3";

        Connection connection = DriverManager.getConnection(url, userName, password);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from employee where userID='" + User.CurrentUserID + "'");

        while(resultSet.next()){
            if (i==100) break;
            Employee employee = new Employee();
            employee.setID(resultSet.getString("employeeID"));
            employee.setName(resultSet.getString("Name"));
            employee.setAge(resultSet.getInt("Age"));
            employee.setStartDate(resultSet.getString("startDate"));
            employeeList.getEmployeeArray()[i] = employee;
            i++;
        }

        resultSet.close();
        statement.close();
        connection.close();

        return employeeList;
    }

    public EmployeeList Employee_List_see(String EmployeeName) throws SQLException {
        EmployeeList employeeList = new EmployeeList();
        int i = 0;
        String url = "jdbc:mariadb://localhost:3306/softengi_db";
        String userName = "root";
        String password = "c3g9h4c3";

        Connection connection = DriverManager.getConnection(url, userName, password);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from employee where userID='" + User.CurrentUserID + "'" + "and Name like " + "'%" + EmployeeName + "%'");

        while(resultSet.next()){
            if (i==100) break;
            Employee employee = new Employee();
            employee.setID(resultSet.getString("employeeID"));
            employee.setName(resultSet.getString("Name"));
            employeeList.getEmployeeArray()[i] = employee;
            i++;
        }

        resultSet.close();
        statement.close();
        connection.close();

        return employeeList;
    }

}
