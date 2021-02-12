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
import com.billies_works.demo.model.GetEmpListLogic;

@WebServlet("/Main")
public class Main extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet( HttpServletRequest request,
                          HttpServletResponse response )
        throws ServletException, IOException {

        GetEmpListLogic getEmpListLogic =
            new GetEmpListLogic();

        List<Emp> empList = getEmpListLogic.execute();

        empList.forEach( ele -> {
                System.out.println(ele);
            });

        request.setAttribute( "empList", empList );
        // if (empList.size() > 0) {
        //     System.out.println("空ではない!");
        // }

        RequestDispatcher dispatcher =
            request.getRequestDispatcher("/WEB-INF/jsp/mainDisp.jsp");
        dispatcher.forward( request, response );
    }
}




// 修正時刻: Sun Feb  7 21:49:15 2021
