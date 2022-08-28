import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    Connection connection;

    public UserDaoImpl() {
        connection = ConnectionFactory.getConnection();
    }

    @Override
    public void addUser(User user) throws SQLException {

    }

    @Override
    public void addEUser(User user) throws SQLException {
        String sql = "insert into employee (Acc_balance) values (?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getEmail());

        int count = preparedStatement.executeUpdate();
        if (count > 0) {
            System.out.println("user saved");
        } else {
            System.out.println("something went wrong");
        }
    }

    @Override
    public void updateUser(User user) throws SQLException {
        String sql = "Update user set name = ?, email = ? where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getEmail());
        preparedStatement.setInt(3, user.getId());
        int count = preparedStatement.executeUpdate();
        if (count > 0) {
            System.out.println("User updated");
        } else {
            System.out.println("OOps!, something went wrong");
        }
    }

    @Override
    public void deleteUser(int id) throws SQLException {
        String sql = "delete from user where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        int count = preparedStatement.executeUpdate();
        if (count > 0) {
            System.out.println("user updated");
        } else {
            System.out.println("OOps!, something went wrong");
        }
    }

    @Override
    public List<User> getUser(int id) throws SQLException {
        return null;
    }

    @Override
    public List<User> getUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        String sql = "select * from user";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String email = resultSet.getString(3);
            User user = new User(id, name, email);
            users.add(user);
        }
        return users;
    }

    @Override
    public User getUserById(int userId) throws SQLException {
        User user = new User();
        String sql = "select * from user where id = " + userId;
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        resultSet.next();
        if (resultSet != null) {
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String email = resultSet.getString(3);
            user = new User(id, name, email);
        }else{
            System.out.println("no record found");
        }
        return user;
    }
}
