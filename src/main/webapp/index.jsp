<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@ include file="/common.jsp" %>
<%
Date date = new Date();
SimpleDateFormat sdf = new SimpleDateFormat("YYYY年MM月dd日");
String today = sdf.format(date);
%>
<!doctype html>
<html lang="ja">
  <head>
    <meta charset="utf-8"/>
    <title>どこつぶ</title>
  </head>
  <body>
    <h1>どこつぶへようこそ</h1>
    <time><%= today %></time>
    <p>管理人:<%= name %></p>
    <nav>
      <li><a href="/useOracleUCP/Main">Empを見る</a></li>
      <li><a href="/useOracleUCP/DeptMain">所属部一覧を見る</a></li>
      <li><a href="/useOracleUCP/EmpDeptMain">EmpDept</a></li>
    </nav>
    <jsp:include page="/footer.jsp" /> 
  </body>
</html>

<!-- 修正時刻: Fri Feb 12 07:59:40 2021 -->
