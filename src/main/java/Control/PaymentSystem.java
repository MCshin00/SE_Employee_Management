package Control;

import Entity.Employee;
import Entity.Payment;
import Entity.PaymentList;
import Entity.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.sql.*;

public class PaymentSystem {

    public int[] Payment_Calculate(int salary) throws InterruptedException {
        int[] result = new int[5];
        String[] web_result_label = {"lab111", "lab211", "lab241", "lab311", "lab411"};
        final String WEB_DRIVER_ID = "webdriver.chrome.driver"; //웹드라이버 ID = 크롬드라이버
        final String WEB_DRIVER_PATH = "chromedriver_win32/chromedriver.exe"; //웹드라이버 PATH = 크롬드라이버 경로, 프로젝트 폴더 내에 크롬드라이버 폴더가 존재한다고 가정
        final String Base_URL = "https://www.4insure.or.kr/ins4/ptl/data/calc/forwardInsuFeeMockCalcRenewal.do"; //4대보험 모의계산기 웹페이지 주소

        // 크롬드라이버 설정
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
        // 크롬드라이버 객체 생성
        // 크롬드라이버 옵션 - 크롬 창을 표시하지 않음
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("disable-gpu");
        chromeOptions.addArguments("disable-infobars");
        chromeOptions.addArguments("--disable-extensions");
        WebDriver driver = new ChromeDriver(chromeOptions);

        // 웹사이트 접속
        driver.get(Base_URL);
        // 0.5초 대기
        Thread.sleep(500);

        // 월 급여 입력 필드(ID = lab0001)
        WebElement inputField = driver.findElement(By.id("lab0001"));
        // 월 급여 값 입력
        String salary_string = Integer.toString(salary);
        inputField.sendKeys(salary_string);

        // 계산 버튼 클릭(xpath를 통한 이미지 접근)
        WebElement calculateButton = driver.findElement(By.xpath("//ul[@class='ul_btn ml10']/li[1]/a/img"));
        calculateButton.click();

        for (int i=0; i<5; i++){
            // 보험료 총액 - 합계 필드(ID = lab411)를 가져옴
            WebElement specificValueElement = driver.findElement(By.id(web_result_label[i]));
            // 합계 필드의 텍스트 값을 가져오고 콤마(,)를 제거
            String specificValue = specificValueElement.getAttribute("value").replaceAll(",","");
            result[i] = Integer.parseInt(specificValue);
        }
        return result;
    }

    public PaymentList Payment_list_see(String EmployeeID) throws SQLException {
        PaymentList paymentList = new PaymentList();
        int i = 0;
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
            paymentList.getPaymentArray()[i] = payment;
            i++;
        }

        resultSet.close();
        statement.close();
        connection.close();

        return paymentList;
    }

    public boolean Payment_add(Payment payment, String UserID, String EmployeeID) throws SQLException {
        String url = "jdbc:mariadb://localhost:3306/softengi_db";
        String userName = "root";
        String password = "c3g9h4c3";
        String EmployeeNum;
        Payment payment_todb = new Payment();
        payment_todb.setSalary(payment.getSalary());
        payment_todb.setNetsalary(payment.getNetsalary());
        payment_todb.setPaymentDate(payment.getPaymentDate());

        Connection connection = DriverManager.getConnection(url, userName, password);
        Statement statement = connection.createStatement();
        ResultSet resultSet;

        try{
            resultSet = statement.executeQuery("SELECT employeeNUM FROM employee WHERE employeeID = '" + EmployeeID +"'");
            resultSet.next();
            EmployeeNum = resultSet.getString("employeeNUM");
            resultSet = statement.executeQuery("INSERT INTO payment(employeeNUM, salary, netsalary, payment_Date, userID)" + " VALUES(" + EmployeeNum + "," +
                                                payment_todb.getSalary() + "," + payment_todb.getNetsalary() + ",'" + payment_todb.getPaymentDate() + "','" + UserID + "')");
        }
        catch (Exception e){
            System.out.println(e);
            statement.close();
            connection.close();
            return false;
        }
        resultSet.close();
        statement.close();
        connection.close();
        return true;
    }

    public Payment Payment_see(int PaymentNum, String UserID) throws SQLException {
        String url = "jdbc:mariadb://localhost:3306/softengi_db";
        String userName = "root";
        String password = "c3g9h4c3";
        Payment payment;

        Connection connection = DriverManager.getConnection(url, userName, password);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM payment WHERE paymentNUM = " + PaymentNum +" AND UserID = '" + UserID + "'");;

        resultSet.next();
        payment = new Payment();
        payment.setPaymentNum(Integer.parseInt(resultSet.getString("paymentNUM")));
        payment.setSalary(Integer.parseInt(resultSet.getString("salary")));
        payment.setNetsalary(Integer.parseInt(resultSet.getString("netsalary")));
        payment.setPaymentDate(resultSet.getString("payment_Date"));

        resultSet.close();
        statement.close();
        connection.close();

        return payment;
    }

    public boolean Payment_fix(Payment payment, String UserID, String EmployeeID) throws SQLException {
        String url = "jdbc:mariadb://localhost:3306/softengi_db";
        String userName = "root";
        String password = "c3g9h4c3";
        String EmployeeNum;
        Payment payment_todb = new Payment();
        payment_todb.setSalary(payment.getSalary());
        payment_todb.setNetsalary(payment.getNetsalary());
        payment_todb.setPaymentDate(payment.getPaymentDate());

        Connection connection = DriverManager.getConnection(url, userName, password);
        Statement statement = connection.createStatement();
        ResultSet resultSet;

        try{
            resultSet = statement.executeQuery("SELECT employeeNUM FROM employee WHERE employeeID = '" + EmployeeID +"'");
            resultSet.next();
            EmployeeNum = resultSet.getString("employeeNUM");
            resultSet = statement.executeQuery("UPDATE payment SET salary = " + payment.getSalary() + ", netsalary = " + payment.getNetsalary()
                    + ", payment_Date = '" + payment_todb.getPaymentDate() + "' WHERE paymentNUM = " + payment_todb.getPaymentNum() + " AND employeeNUM = " + EmployeeNum + " AND userID = '" + UserID + "'");
        }
        catch (Exception e){
            statement.close();
            connection.close();
            return false;
        }
        resultSet.close();
        statement.close();
        connection.close();
        return true;
    }

    public void Payment_delete(int PaymentNum, String UserID) throws SQLException {
        String url = "jdbc:mariadb://localhost:3306/softengi_db";
        String userName = "root";
        String password = "c3g9h4c3";
        Payment payment;

        Connection connection = DriverManager.getConnection(url, userName, password);
        Statement statement = connection.createStatement();

        statement.executeQuery("DELETE FROM payment WHERE paymentNUM = " + PaymentNum +" AND UserID = '" + UserID + "'");

        statement.close();
        connection.close();
    }

}
