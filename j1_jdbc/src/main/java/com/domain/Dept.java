package com.domain;

import java.util.List;

public class Dept {
    private Integer deptno;
    private String dname;


    private List<String> empNames;

    private List<Emp> emps;

    public Dept() {
    }

    public Dept(Integer deptno, String dname) {
        this.deptno = deptno;
        this.dname = dname;
    }

    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }


    public List<String> getEmpNames() {
        return empNames;
    }

    public void setEmpNames(List<String> empNames) {
        this.empNames = empNames;
    }

    public List<Emp> getEmps() {
        return emps;
    }

    public void setEmps(List<Emp> emps) {
        this.emps = emps;
    }

    /**
     * 判断2个对象是否相等
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {

        Dept d = (Dept) obj;

        if(d.getDeptno() == deptno){
            return true;

        } else {
            return false;
        }

    } // equals

    @Override
    public int hashCode() {
        return 17 + deptno;
    }
}
