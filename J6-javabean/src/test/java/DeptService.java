import com.domain.Dept;
import com.util.DBManager;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DeptService {

    @Test
    public void testCascadeQueryDept(){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<Dept> deptList = new ArrayList<Dept>();

        String sql = "SELECT d.deptno,d.dname,e.empno,e.ename,e.job " +
                "FROM dept d LEFT OUTER JOIN emp e " +
                "ON d.deptno = e.deptno ORDER BY d.deptno";


        try {
            conn = DBManager.getConnection();
            ps = conn.prepareStatement(sql);

            rs = ps.executeQuery();

            while(rs.next()){

              // 每条记录表示1个部门对象
              Dept d = new Dept();
              d.setDeptno(rs.getInt("deptno"));

              if (!deptList.contains(d)) {


                  deptList.add(d);  //   部门重复，不能直接加

              }


            }	// while

               System.out.println(deptList.size());

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            DBManager.close(rs, ps, conn);
        }




    }  // testCascadeQueryDept
}
