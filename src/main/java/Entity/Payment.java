package Entity;

public class Payment {
    int salary;
    String paymentDate;
    int Netsalary;
    int paymentNum;

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public int getNetsalary() {
        return Netsalary;
    }

    public void setNetsalary(int netsalary) {
        Netsalary = netsalary;
    }

    public int getPaymentNum() {
        return paymentNum;
    }

    public void setPaymentNum(int paymentNum) {
        this.paymentNum = paymentNum;
    }
}
