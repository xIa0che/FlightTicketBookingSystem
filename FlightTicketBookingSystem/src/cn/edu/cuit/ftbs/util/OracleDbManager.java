package cn.edu.cuit.ftbs.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 数据库连接工具类
 * @author xIa0che
 *
 */
public class OracleDbManager {
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:ORCL";
    private static final String USER = "ftbs";
    private static final String PASSWORD = "ftbs";


    static {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("加载Oracle数据库驱动失败！");
        }
    }

    /**
     * 获取Connection
     *
     * @return 返回connection对象引用
     */
    public static Connection getConnection(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("获取数据库连接失败！");
        }
        return conn;
    }

    /**
     * 关闭ResultSet
     * @param rs
     */
    public static void closeResultSet(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * 关闭Statement
     * @param stmt
     */
    public static void closeStatement(Statement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * 关闭ResultSet、Statement
     * @param rs 查询结果集
     * @param stmt statement对象
     */
    public static void closeStatement(ResultSet rs, Statement stmt) {
        closeResultSet(rs);
        closeStatement(stmt);
    }

    /**
     * 关闭PreparedStatement
     * @param pstmt
     * @throws SQLException
     */
    public static void fastcloseStmt(PreparedStatement pstmt) throws SQLException
    {
        pstmt.close();
    }

    /**
     * 关闭ResultSet、PreparedStatement
     * @param rs
     * @param pstmt
     * @throws SQLException
     */
    public static void fastcloseStmt(ResultSet rs, PreparedStatement pstmt) throws SQLException
    {
        rs.close();
        pstmt.close();
    }

    /**
     * 关闭ResultSet、Statement、Connection
     * @param rs 查询结果集
     * @param stmt statement对象
     * @param con connection对象
     */
    public static void closeConnection(ResultSet rs, Statement stmt, Connection con) {
        closeResultSet(rs);
        closeStatement(stmt);
        closeConnection(con);
    }

    /**
     * 关闭Statement、Connection
     * @param stmt statement对象
     * @param con connection对象
     */
    public static void closeConnection(Statement stmt, Connection con) {
        closeStatement(stmt);
        closeConnection(con);
    }

    /**
     * 关闭Connection
     * @param con connection对象
     */
    public static void closeConnection(Connection con) {
        if (con != null) {
            try {
               con.close();
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}