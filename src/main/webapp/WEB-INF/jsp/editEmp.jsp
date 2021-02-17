<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="com.billies_works.demo.model.Emp" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="ja">
  <head>
    <meta charset="UTF-8"/>
    <title>社員編集</title>
    <jsp:include page="/style.jsp" /> 
  </head>
  <body>
    <div id="wrapper">
      <h1>社員編集</h1>
      <table>
        <form action="/useOracleUCP/UpdateEmp" method="post">
          <tr>
            <th>職員No</th>
            <td><input type="number" min="1" name="empno" value="${emp.empno}"/></td>
          </tr>
          <tr>
            <th>名前</th>
            <td><input type="text" name="ename" value="${emp.ename}"/></td>
          </tr>
          <tr>
            <th>課</th>
            <td><input type="text" name="job" value="${emp.job}"/></td>
          </tr>
          <tr>
            <th>給与</th>
            <td><input type="number" name="sal" value="${emp.sal}"/></td>
          </tr>
          <tr>
            <th>年齢</th>
            <td><input type="number" name="age" value="${emp.age}"/></td>
          </tr>
          <tr>
            <th>所属</th>
            <td><input type="number" name="deptno" value="${emp.deptno}"/></td        </tr>
          <tr>
            <td></td>
            <td><input type="submit" value="OK"/></td>
          </tr>
        </form>
      </table>
      <p><a href="/useOracleUCP">戻る</a></p>
      <jsp:include page="/footer.jsp" />
    </div>
  </body>
</html>

<!-- 修正時刻: Wed Feb 17 15:59:31 2021 -->
