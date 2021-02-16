<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="com.billies_works.demo.model.Dept" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="ja">
  <head>
    <meta charset="UTF-8"/>
    <title>所属部新規作成</title>
    <link rel="stylesheet" href="css/style.css"/>
  </head>
  <body>
    <h1>所属部新規作成</h1>
    <table>
      <form action="/useOracleUCP/NewDept" method="post">
        <tr>
          <th>所属No</th>
          <td><input type="number" min="1" name="deptno" /></td>
        </tr>
        <tr>
          <th>所属部名</th>
          <td><input type="text" name="dname" /></td>
        </tr>
        <tr>
          <th>電話番号</th>
          <td><input type="text" name="telno" /></td>
        </tr>
        <tr>
          <td></td>
          <td><input type="submit" value="OK"/></td>
        </tr>
      </form>
    </table>
    <p><a href="/useOracleUCP/Main">戻る</a></p>
    <jsp:include page="/footer.jsp" /> 
  </body>
</html>

<!-- 修正時刻: Tue Feb 16 20:51:00 2021 -->
