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
  </head>
  <body>
    <h1>社員編集</h1>
    <p>${msg}</p>
    <table>
      <tr>
        <th>職員No</th>
        <th>名前</th>
        <th>課</th>
        <th>給与</th>
        <th>年齢</th>
        <th>所属</th>
        <th></th>
        <th></th>
      </tr>
    <c:forEach var="emp" items="${empList}">
      <tr>
        <td>${emp.empno}</td>
        <td>${emp.ename}</td>
        <td>${emp.job}</td>
        <td>${emp.sal}</td>
        <td>${emp.age}</td>
        <td>${emp.deptno}</td>
        <td>
          <form action="/useOracleUCP/EditEmp" method="post">
            <input type="hidden" name="empno" value="${emp.empno}"/>
            <input type="submit" value="編集"/>
          </form>
        </td>
        <td><a href="useOracleUCP/DeleteEmp/${emp.empno}">削除</a></td>
      </tr>
    </c:forEach>
    </table>
    <p><a href="/useOracleUCP">戻る</a></p>
    <jsp:include page="/footer.jsp" /> 
  </body>
</html>

<!-- 修正時刻: Tue Feb 16 06:53:49 2021 -->
