package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;
    public UserDAO() {
        try{
            String dbURL = "jdbc:mysql://localhost:3306/bbs";
            String dbID = "root";
            String dbPass= "0000";
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, dbID, dbPass);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public int login(String userID, String password) {
        System.out.println("userID: "+ userID);
         System.out.println("password: "+ password);
        String sql = "select * from user where userID=? ";
        try{
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userID);
           // pstmt.setString(2, password);
            rs = pstmt.executeQuery();
            if(rs.next()) {

                if(rs.getString(1).equals(userID) && rs.getString(2).equals(password)) {
                    return 1; //성공
                }
                else{
                    return 0; //비밀번호가 틀린거
                }
            }

            return -1;
        }catch (Exception e) {
            e.printStackTrace();
            return -2;
        }

    }
}
