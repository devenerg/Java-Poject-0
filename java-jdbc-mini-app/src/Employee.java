public class Employee {
    private int id;
    private String name;
    private String email;
    private String acc_no;
    private int acc_balance;

    public Employee(){}

    public Employee(int id, String name, String email, String acc_no, int acc_balance) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.acc_no = acc_no;
        this.acc_balance = acc_balance;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAcc_no() {
        return acc_no;
    }

    public void setAcc_no(String acc_no) {
        this.acc_no = acc_no;
    }
    public int getAcc_balance() {
        return acc_balance;
    }

    public void setAcc_balance(int acc_balance) {
        this.acc_balance = acc_balance;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", acc_no='" + acc_no + '\'' +
                ", acc_balance='" + acc_balance + '\'' +
                '}';
    }
}