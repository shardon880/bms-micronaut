package bms.micronaut.DAO;

import bms.micronaut.config.PropertiesConfiguration;
import bms.micronaut.exceptionHandler.UserExistException;
import bms.micronaut.models.UserModel;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.util.Base64;

@Singleton
public class UserModelDAO {


    @Inject
    PropertiesConfiguration propertiesConfiguration;
    private Connection getDBConnection() throws SQLException{
        return DriverManager.getConnection(
                propertiesConfiguration.getConnectionURL(),
                propertiesConfiguration.getUsername(),
                propertiesConfiguration.getPassword()
        );
    }

    private ResultSet getUser(String email) throws SQLException{
        Connection con = getDBConnection();
        String FETCH_USER_EMAIL = "Select \"email\"," +
                "\"password\",\"first_name\"," +
                "\"last_name\",\"address\",\"phone_no\" " +
                "from \"user_model\" WHERE \"email\" ilike ?";

        PreparedStatement statement = con.prepareStatement(FETCH_USER_EMAIL);
        statement.setString(1,email.trim().toLowerCase());

        ResultSet rst = statement.executeQuery();
        boolean doesUserExist = rst.next();
        if(doesUserExist){
            rst.next();
            return rst;
        }
        return rst;
    }


    public ResultSet getUserByEmail(String email) throws SQLException{
        Connection con = getDBConnection();
        String FETCH_USER_EMAIL = "Select \"email\",\"password\" from \"user_table\" WHERE \"email\" ilike ?";
        PreparedStatement stmt = con.prepareStatement(FETCH_USER_EMAIL);

        stmt.setString(1, email.trim().toLowerCase());

        ResultSet rst = stmt.executeQuery();
        return rst;
    }

    public String getUserPassword(String email) {

        try (ResultSet user = getUserByEmail(email)) {
            if (user.next()) {

                return user.getString("password");
            }
            throw new UserExistException("user does not exist");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";

    }
    public void saveUser(UserModel user) throws SQLException {
        Connection con = getDBConnection();
        ResultSet rst = getUserByEmail(user.getEmail());
        if (rst.next()) {
            throw new UserExistException("user exist");
        }
        String hashedPass = encodePassword(user.getPassword());
        String INSERT_USER = "INSERT INTO \"user_table\" (\"email\", \"address\",\"password\") VALUES (?, ?, ?)";
        PreparedStatement stmt = con.prepareStatement(INSERT_USER);

        stmt.setString(1, user.getEmail());
        stmt.setString(2, user.getAddress());
        stmt.setString(3, hashedPass);
        int row = stmt.executeUpdate();
        stmt.close();
        con.close();
    }

    String encodePassword(String password) {
        password = Base64.getEncoder()
                .encodeToString(password.getBytes(StandardCharsets.UTF_8));
        return password;
    }
}
