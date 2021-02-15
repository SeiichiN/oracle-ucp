package com.billies_works.demo.model;

import com.billies_works.demo.dao.EmpDao;

public class GetDeptLogic {
    public Dept execute (int deptno) {
        EmpDao dao = new EmpDao();
        Dept dept = dao.findDept(deptno);
        return dept;
    }
}

// 修正時刻: Tue Feb 16 07:48:45 2021
