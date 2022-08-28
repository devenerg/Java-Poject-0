import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {


        // employee dao
        EmployeeDao dao = EmployeeDaoFactory.getEmployeeDao();
        Scanner scanner = new Scanner(System.in);

        //Login menu
        System.out.println("Please Login");
        String myLogin = scanner.next();
        System.out.println("Please, Enter Password");
        String myPassword = scanner.next();
        if (myLogin.equals("admin")&& myPassword.equals("admin"));
        boolean flag2 = true;
        boolean flag = true;
        while (flag) {
            System.out.println("*******************************");
            System.out.println("Select from the options below");
            System.out.println("******************************");
            System.out.println("PRESS 1: Add Account");
            System.out.println("PRESS 2: Update User");
            System.out.println("PRESS 3: Delete User Account");
            System.out.println("PRESS 4: Get All Member Acc");
            System.out.println("PRESS 5: Get Account By Id");
            System.out.println("PRESS 6: Exit");

                int input = scanner.nextInt();
                switch (input) {
                    case 1: {   // add
                        System.out.print("Enter Name: ");
                        String name = scanner.next();

                        System.out.print("Enter Email: ");
                        String email = scanner.next();

                        System.out.print("Enter acc_no: ");
                        String acc_no = scanner.next();

                        System.out.print("Enter Balance: ");
                        int acc_balance = scanner.nextInt();

                        Employee employee = new Employee();
                        employee.setName(name);
                        employee.setEmail(email);
                        employee.setAcc_no(acc_no);
                        employee.setAcc_balance(acc_balance);
                        dao.addEmployee(employee);
                        break;
                    }
                    case 2: { // update
                        List<Employee> employees = dao.getEmployees();
                        for (Employee employee: employees){
                            System.out.println(employee);
                        }
                        System.out.println();
                        System.out.println("Updating Account.....");
                        System.out.print("Enter Id: ");
                        int id = scanner.nextInt();
                        System.out.print("Enter Name: ");
                        String name = scanner.next();
                        System.out.print("Enter Email: ");
                        String email = scanner.next();
                        System.out.print("Enter acc_no: ");
                        String acc_no = scanner.next();

                        //while(true){ adjust account balance

                        System.out.print("Enter Balance: ");
                        int acc_balance = scanner.nextInt();

                        Employee employee = new Employee(id, name, email, acc_no, acc_balance);
                        dao.updateEmployee(employee);
                        break;
                    }
                    case 3: {  // delete
                        List<Employee> employees = dao.getEmployees();
                        for (Employee employee: employees){
                            System.out.println(employee);
                        }
                        System.out.print("Enter Id: ");
                        int id = scanner.nextInt();
                        dao.deleteEmployee(id);
                        break;
                    }
                    case 4: { // get all
                        List<Employee> employees = dao.getEmployees();
                        List<User> users = dao.getUsers();
                       //get other user table
                        for(Employee employee: employees){
                            System.out.println(employee);
                        }
                        break;
                    }
                    case 5: { // get by id
                        List<Employee> employees = dao.getEmployees();
                        for (Employee employee: employees){
                            System.out.println(employee);
                        }
                        System.out.println();
                        System.out.print("Enter Id: ");
                        int id = scanner.nextInt();
                        Employee employee = dao.getEmployeeById(id);
                        System.out.println(employee);
                        break;
                    }
                    case 6: {  //exit
                        System.out.println("Thank you");
                        System.out.println("Exiting...");
                        flag = false;
                        break;
                    }
                    default:
                        System.out.println("Choose between 1 - 6");
                }
            }//employee code

            //begining of user menu
        if (myLogin.equals("user")&& myPassword.equals("user"))

            while (flag2) {
                System.out.println("*******************");
                System.out.println("Press 1: Add User Acc");
                System.out.println("Press 2: Update Account Info");
                System.out.println("Press 3: Deposit");
                System.out.println("Press 4: Withdraw");
                System.out.println("Press 5: Transfer");
                System.out.println("Press 6: End session");

                int userInput = scanner.nextInt();
                switch (userInput) {
                    case 1: // add user account
                    {
                        List<User> users = dao.getUsers();
                        for (User user : users) {
                            System.out.println(user);
                        }
                        System.out.println();

                        System.out.println("enter account Balance");
                        int acc_balance = scanner.nextInt();

                        break;
                    }
                    case 2: //Update
                    {
                        List<User> users = dao.getUsers();
                        for (User user : users) {
                            System.out.println(user);
                        }
                        System.out.println();

                        System.out.println("Updating Account.....");
                        System.out.print("Enter Id: ");
                        int id = scanner.nextInt();
                        System.out.print("Enter Name: ");
                        String name = scanner.next();
                        System.out.print("Enter Email: ");
                        String email = scanner.next();
                        System.out.print("Enter acc_no: ");
                        String acc_no = scanner.next();
                        break;
                    }
                    case 3:{//deposit

                        List<User> users = dao.getUsers();
                        for (User user : users) {
                            System.out.println(user);
                            System.out.println("Enter the amount to be deposit");
                            int depositInput = scanner.nextInt();
                        }
                        System.out.println();
                        break;

                    }
                    case 4:{//withdraw
                        List<User> users = dao.getUsers();
                        for (User user : users) {
                            System.out.println(user);
                            System.out.println("Enter amount to be withdrawn");
                            int withdrawnInput = scanner.nextInt();
                        }
                        System.out.println();
                        break;

                    }
                    case 5:{//Transfer
                        List<User> users = dao.getUsers();
                        for (User user : users) {
                            System.out.println(user);
                            System.out.println("Enter amount to be transfer");
                            int transferInput = scanner.nextInt();
                        }
                        System.out.println();
                        break;
                        }

                    case 6:{
                        // end session
                        System.out.println("Thank you");
                        System.out.println("Exiting...");
                        flag2 = false;
                        break;
                    }
                    default:
                        System.out.println("Choose between 1-6");
                    }
                }//end switch case
            }

}