package com.billies_works.demo.model;

import java.io.Serializable;

public class Emp implements Serializable {
    private Integer empno;
    private String ename;
    private String job;
    private Integer sal;
    private Integer age;
    private Integer deptno;

    public Emp() {}

    public Emp( Integer empno,
                String ename,
                String job,
                Integer sal,
                Integer age,
                Integer deptno ) {
        this.empno = empno;
        this.ename = ename;
        this.job = job;
        this.sal = sal;
        this.age = age;
        this.deptno = deptno;
    }

    public Integer getEmpno() { return empno; }
    public String getEname() { return ename; }
    public String getJob() { return job; }
    public Integer getSal() { return sal; }
    public Integer getAge() { return age; }
    public Integer getDeptno() { return deptno; }

    public void setEmpno( Integer empno ) {
        this.empno = empno;
    }
    public void setEname( String ename ) {
        this.ename = ename;
    }
    public void setJob( String job ) { this.job = job; }
    public void setSal( Integer sal ) { this.sal = sal; }
    public void setAge( Integer age ) { this.age = age; }
    public void setDeptno( Integer deptno ) {
        this.deptno = deptno;
    }

    public String toString() {
        return "Emp:{" + empno + ": " + ename +
            " : " + job + " : " + sal + " : " +
            age + " : " + deptno + " }";
    }
}

// 修正時刻: Mon Feb 15 07:22:18 2021
