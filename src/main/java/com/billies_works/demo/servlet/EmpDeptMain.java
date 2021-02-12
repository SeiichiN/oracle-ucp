package com.billies_works.demo.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.billies_works.demo.model.EmpDept;
import com.billies_works.demo.model.GetEmpDeptListLogic;

@WebServlet("/EmpDeptMain")
public class EmpDeptMain extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet( HttpServletRequest request,
                          HttpServletResponse response )
        throws ServletException, IOException {

        GetEmpDeptListLogic getEmpDeptListLogic =
            new GetEmpDeptListLogic();

        List<EmpDept> empDeptList = getEmpDeptListLogic.execute();

        empDeptList.forEach( ele -> {
                System.out.println(ele);
            });

        request.setAttribute( "empDeptList", empDeptList );
        // if (empDeptList.size() > 0) {
        //     System.out.println("空ではない!");
        // }

        RequestDispatcher dispatcher =
            request.getRequestDispatcher("/WEB-INF/jsp/empDeptDisp.jsp");
        dispatcher.forward( request, response );
    }
}




// 修正時刻: Wed Feb 10 12:09:30 2021
