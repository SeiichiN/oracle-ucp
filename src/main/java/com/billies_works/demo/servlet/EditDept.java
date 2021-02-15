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

import com.billies_works.demo.model.Dept;
import com.billies_works.demo.model.GetDeptLogic;

@WebServlet("/EditDept")
public class EditDept extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost( HttpServletRequest request,
                          HttpServletResponse response )
        throws ServletException, IOException {

        String deptnoStr = request.getParameter("deptno");
        int deptno = Integer.parseInt( deptnoStr );
        System.out.println("deptno:" + deptno);

        GetDeptLogic getDeptLogic =
            new GetDeptLogic();

        Dept dept = getDeptLogic.execute( deptno );

        request.setAttribute( "dept", dept );

        RequestDispatcher dispatcher =
            request.getRequestDispatcher("/WEB-INF/jsp/editDept.jsp");
        dispatcher.forward( request, response );
    }
}


// 修正時刻: Tue Feb 16 08:09:06 2021
