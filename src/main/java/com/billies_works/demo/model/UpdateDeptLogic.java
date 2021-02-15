package com.billies_works.demo.model;

import com.billies_works.demo.dao.EmpDao;

public class UpdateDeptLogic {
    public boolean execute (Dept dept) {
        EmpDao dao = new EmpDao();
        if (dao.updateDept(dept)) {
            ;
        } else {
            return false;
        }
        return true;
    }
}

// 修正時刻: Tue Feb 16 08:02:51 2021
