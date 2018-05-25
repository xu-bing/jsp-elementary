package com.boode.jdbc;

import com.domain.Dept;
import com.domain.Emp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpDao {

    public List<Dept> findAllDepts(){
        List<Dept> deptList = new ArrayList<Dept>();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String url = "jdbc:oracle:thin:@192.168.222.1:1521:orcl";
        String user = "scott";
        String pwd = "tiger";


        String sql =
                "SELECT d.deptno, d.dname, e.empno, e.ename, e.job, e.sal\n" +
                "FROM dept d LEFT JOIN emp e ON d.deptno = e.deptno\n" +
                "ORDER BY d.deptno";

        // --------------------------------
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            conn = DriverManager.getConnection(url, user, pwd);


            ps = conn.prepareCall(sql);

            rs = ps.executeQuery();


            while (rs.next()){
                int deptno = rs.getInt("deptno");

                Dept d = new Dept();
                d.setDeptno(deptno);

                if (!deptList.contains(d)){
                  d.setDeptno(deptno);
                  d.setDname(rs.getString("dname"));
//                  d.setEmpNames(new ArrayList<String>());
                    d.setEmps(new ArrayList<Emp>());

                  deptList.add(d);
                } else {
                    d = deptList.get(deptList.indexOf(d));
                }

                if (rs.getString("ename") != null){
//                    d.getEmpNames().add(rs.getString("ename"));
                    d.getEmps().add(new Emp(rs.getInt("empno"),
                            rs.getString("ename"),
                            rs.getString("job"),
                            rs.getDouble("sal")));
                }
            }  // while
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }

                if (ps != null){
                    ps.close();
                }

                if(conn != null){
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }   // finally


        // ---------------------------------
        return  deptList;
    }  // findAllDepts


    public static void main(String[] args) {
       EmpDao empDao = new EmpDao();
       List<Dept> deptList = empDao.findAllDepts();

       for (Dept dept : deptList){
           System.out.println(dept.getDeptno() + ":::" + dept.getDname());

           /*for (String ename : dept.getEmpNames()){
               System.out.println("---" + ename);
           }*/

           for (Emp emp : dept.getEmps()){
               System.out.println("---" + emp.getEmpno() + "::" + emp.getEname());
           }
       }

    }  // main
}
