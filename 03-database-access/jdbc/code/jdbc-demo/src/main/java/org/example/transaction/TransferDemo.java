package org.example.transaction;

import org.example.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.SQLException;

public class TransferDemo {
    public static void transfer(String from, String to, double money) {

        Connection con = null;

        try {
            con = JDBCUtils.getConnection();

            con.setAutoCommit(false);
            AccountDao dao = new AccountDao();
            dao.updateBalance(con, from, -money);

            if(true){
                throw new RuntimeException("出现异常。");
            }

            dao.updateBalance(con, to, money);

            con.commit();
        } catch (Exception e) {
            System.out.println("出现了异常。");
            try {
                con.rollback();
                con.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        transfer("A", "B", 500);
    }
}
