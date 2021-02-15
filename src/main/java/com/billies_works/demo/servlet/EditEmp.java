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
import com.billies_works.demo.model.GetEmpLogic;

@WebServlet("/EditEmp")
public class EditEmp extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost( HttpServletRequest request,
                          HttpServletResponse response )
        throws ServletException, IOException {

        String empnoStr = request.getParameter("empno");
        int empno = Integer.parseInt( empnoStr );
        System.out.println("empno:" + empno);

        GetEmpLogic getEmpLogic =
            new GetEmpLogic();

        Emp emp = getEmpLogic.execute( empno );

        request.setAttribute( "emp", emp );

        RequestDispatcher dispatcher =
            request.getRequestDispatcher("/WEB-INF/jsp/editEmp.jsp");
        dispatcher.forward( request, response );
    }
}


// 修正時刻: Mon Feb 15 13:34:46 2021
