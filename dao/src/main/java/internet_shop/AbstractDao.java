package internet_shop;

//import org.apache.log4j.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class AbstractDao {
//    Logger lg=Logger.getLogger("loger");

    protected PreparedStatement prepareStatement(String query) throws SQLException {
//        lg.info(ConnectionManager.getConnection().toString());
        return ConnectionManager.getConnection().prepareStatement(query);

    }

    protected PreparedStatement prepareStatement(String query, int flag) throws SQLException {
        return ConnectionManager.getConnection().prepareStatement(query, flag);
    }

    protected void close(ResultSet rs) {
        try {
            if (rs != null)
                rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
