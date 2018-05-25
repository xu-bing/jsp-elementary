package com.boode.jdbc;

import java.sql.*;

public class TestStatement {
    public void queryAllEmps(){
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        String sql = "select * from emp";

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("111111111111");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.222.1:1521:orcl", "scott", "tiger");
            System.out.println("222222222222");
            st = conn.createStatement();

            rs = st.executeQuery(sql);

            while (rs.next()){
                int empno = rs.getInt("empno");
                String ename = rs.getString("ename");
                System.out.println(empno + ":::" + ename);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {

        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }

                if (st != null){
                    st.close();
                }

                if (conn != null){
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            ;
        }

    }

    /**
     *
     */
    public void createEmp(){

    }

    public static void main(String[] args) {
        System.out.println("---------------");
TestStatement testStatement = new TestStatement();
        testStatement.queryAllEmps();
        System.out.println("+++++++++++++");
    }   //main
}
