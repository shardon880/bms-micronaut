package bms.micronaut.DAO;

import bms.micronaut.config.PropertiesConfiguration;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.sql.*;

@Singleton
public class UserDAO {

    @Inject
    PropertiesConfiguration propertiesConfiguration;

    private Connection getDBConnection() throws SQLException{
        return DriverManager.getConnection(
                propertiesConfiguration.getConnectionURL(),
                propertiesConfiguration.getUsername(),
                propertiesConfiguration.getPassword()
        );
    }
    public ResultSet getUser(String email) throws SQLException{

        Connection con = getDBConnection();
        String FETCH_USER = "Select \"id\", \"email\", \"password\", \"address\" from \"user_table\" WHERE \"email\" ilike ?";

        PreparedStatement stmt = con.prepareStatement(FETCH_USER);
        stmt.setString(1, email.trim().toLowerCase());

        ResultSet rst = stmt.executeQuery();

        if(rst.next())
            return rst;

        rst.close();
        return rst;
    }

        public int getUserId(String email) {

            try (ResultSet rst = getUser(email)) {
                return rst.getInt("id");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return -1;

        }

    }
