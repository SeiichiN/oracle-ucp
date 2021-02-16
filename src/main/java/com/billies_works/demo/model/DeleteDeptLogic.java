package com.billies_works.demo.model;

import com.billies_works.demo.dao.EmpDao;

public class DeleteDeptLogic {
    public boolean execute (int deptno) {
        EmpDao dao = new EmpDao();
        return dao.deleteDept(deptno);
    }
}

// 修正時刻: Tue Feb 16 20:12:41 2021
