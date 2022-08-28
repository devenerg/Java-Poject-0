public class User {
    private int id;
    private String name;
    private String email;
    private int acc_no;
    private int setAcc_balance;

    public User() {
    }

    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
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

    public void setAcc_no(int acc_no) {
        this.acc_no = acc_no;
    }

    public void setAcc_balance(int Acc_balance) {
        this.setAcc_balance = Acc_balance;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", acc_no='" + acc_no + '\'' +
                ", Acc_balance='" + setAcc_balance + '\'' +
                '}';
    }
}

