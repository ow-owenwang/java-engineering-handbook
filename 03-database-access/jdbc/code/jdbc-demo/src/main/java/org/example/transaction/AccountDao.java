package org.example.transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AccountDao {
    /**
     * 修改指定用户的余额
     *
     * @param con
     * @param name
     * @param balance
     */
    public void updateBalance(Connection con, String name, double balance) {
        try {

            String sql = "update account set balance=balance+? where name=?";
            PreparedStatement pstmt = con.prepareStatement(sql);

            pstmt.setDouble(1, balance);
            pstmt.setString(2, name);

            pstmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
