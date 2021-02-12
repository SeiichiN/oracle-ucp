<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="com.billies_works.demo.model.Emp" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="ja">
  <head>
    <meta charset="UTF-8"/>
    <title>Dept</title>
  </head>
  <body>
    <h1>Dept List</h1>
    <table>
      <tr>
        <th>所属No</th>
        <th>所属部名</th>
        <th>電話番号</th>
      </tr>
    <c:forEach var="dept" items="${deptList}">
      <tr>
        <td>${dept.deptno}</td>
        <td>${dept.dname}</td>
        <td>${dept.telno}</td>
      </tr>
    </c:forEach>
    </table>
    <p><a href="/useOracleUCP">戻る</a></p>
  </body>
</html>

<!-- 修正時刻: Fri Feb 12 07:21:40 2021 -->
