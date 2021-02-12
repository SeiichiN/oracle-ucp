package com.billies_works.demo.model;

import java.util.List;
import com.billies_works.demo.dao.EmpDao;

public class GetDeptListLogic {
    public List<Dept> execute () {
        EmpDao dao = new EmpDao();
        List<Dept> deptList = dao.findDeptAll();
        return deptList;
    }
}

// 修正時刻: Wed Feb 10 21:06:30 2021
