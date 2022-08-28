import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {

    Connection connection;

    public EmployeeDaoImpl() {
        connection = ConnectionFactory.getConnection();
    }

    @Override
    public void addEmployee(Employee employee) throws SQLException {
        String sql = "insert into employee (name, email, acc_no, Acc_balance) values (?, ?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, employee.getName());
        preparedStatement.setString(2, employee.getEmail());
        preparedStatement.setString(3, employee.getAcc_no());
        preparedStatement.setInt(4, employee.getAcc_balance());
        int count = preparedStatement.executeUpdate();
        if (count > 0) {
            System.out.println("employee saved");
        } else {
            System.out.println("OOps!, something went wrong");
        }
    }

    @Override
    public void updateEmployee(Employee employee) throws SQLException {
        String sql = "Update employee set name = ?, email = ? where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, employee.getId());
        preparedStatement.setString(2,employee.getName());
        preparedStatement.setString(3, employee.getEmail());
        preparedStatement.setString(4, employee.getAcc_no());
        preparedStatement.setInt(5, employee.getAcc_balance());
        int count = preparedStatement.executeUpdate();
        if (count > 0) {
            System.out.println("employee updated");
        } else {
            System.out.println("OOps!, something went wrong");
        }
    }

    @Override
    public void deleteEmployee(int id) throws SQLException {
        String sql = "delete from employee where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        int count = preparedStatement.executeUpdate();
        if (count > 0) {
            System.out.println("employee updated");
        } else {
            System.out.println("OOps!, something went wrong");
        }
    }

    @Override
    public List<Employee> getEmployees() throws SQLException {
        List<Employee> employees = new ArrayList<>();
        String sql = "select * from employee";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String email = resultSet.getString(3);
            String acc_no = resultSet.getString(4);
            int acc_balance = resultSet.getInt(5);
            Employee employee = new Employee(id, name, email, acc_no, acc_balance);
            employees.add(employee);
        }
        return employees;
    }

    @Override
    public Employee getEmployeeById(int empId) throws SQLException {
        Employee employee = new Employee();
        String sql = "select * from employee where id = " + empId;
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        resultSet.next();
        if (resultSet != null) {
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String email = resultSet.getString(3);
            String acc_no = resultSet.getString(4);
            int acc_balance = resultSet.getInt(5);
            employee = new Employee(id, name, email, acc_no, acc_balance);
        }else{
            System.out.println("no record found");
        }
        return employee;
    }

    @Override
    public void addUser(User user) throws SQLException {

    }

    @Override
    public void addEUser(User user) throws SQLException {

    }

    @Override
    public void updateUser(User user) throws SQLException {

    }

    @Override
    public void deleteUser(int id) throws SQLException {

    }

    @Override
    public List<User> getUser(int id) throws SQLException {
        return null;
    }

    @Override
    public List<User> getUsers() throws SQLException {
        return null;
    }

    @Override
    public User getUserById(int id) throws SQLException {
        return null;
    }
}
