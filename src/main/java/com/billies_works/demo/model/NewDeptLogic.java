package com.billies_works.demo.model;

import com.billies_works.demo.dao.EmpDao;
import com.billies_works.demo.model.Dept;

public class NewDeptLogic {
    public boolean execute (Dept dept) {
        EmpDao dao = new EmpDao();
        return dao.createDept( dept );
    }
}

// 修正時刻: Tue Feb 16 20:31:49 2021
