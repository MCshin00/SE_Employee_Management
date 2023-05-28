package Entity;

import java.sql.*;

public class EmployeeList {
    Employee[] EmployeeArray = new Employee[100];

    public Employee[] getEmployeeArray() {
        return EmployeeArray;
    }

    public EmployeeList() throws SQLException {
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
            EmployeeArray[i] = employee;
            i++;
        }

        resultSet.close();
        statement.close();
        connection.close();
    }

    public EmployeeList(String EmployeeName) throws SQLException {
        int i = 0;
        String driver = "org.mariadb.jdbc.Driver";
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
            employee.setAge(resultSet.getInt("Age"));
            employee.setStartDate(resultSet.getString("startDate"));
            EmployeeArray[i] = employee;
            i++;
        }

        resultSet.close();
        statement.close();
        connection.close();
    }
}
