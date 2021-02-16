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

import com.billies_works.demo.model.Emp;
import com.billies_works.demo.model.Dept;
import com.billies_works.demo.model.GetDeptListLogic;
import com.billies_works.demo.model.NewDeptLogic;

@WebServlet("/NewDept")
public class NewDept extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet( HttpServletRequest request,
                          HttpServletResponse response )
        throws ServletException, IOException {

        RequestDispatcher dispatcher =
            request.getRequestDispatcher("/WEB-INF/jsp/newDept.jsp");
        dispatcher.forward( request, response );
    }

    protected void doPost( HttpServletRequest request,
                          HttpServletResponse response )
        throws ServletException, IOException {

        String deptnoStr = request.getParameter("deptno");
        int deptno = Integer.parseInt( deptnoStr );
        
        String dname = request.getParameter("dname");
        
        String telno = request.getParameter("telno");
        
        Dept dept = new Dept( deptno, dname, telno );

        System.out.println(dept);

        NewDeptLogic newDeptLogic = new NewDeptLogic();
        String msg = null;
        if (newDeptLogic.execute( dept )) {
            msg = "追加しました";
        } else {
            msg = "追加に失敗しました";
        }

        response.sendRedirect("/useOracleUCP/DeptMain");
    }
}




// 修正時刻: Tue Feb 16 20:46:07 2021
