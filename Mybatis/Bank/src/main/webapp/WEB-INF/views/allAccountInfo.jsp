<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        body {
            margin: 0 auto;
            width: 552px;
        }

        .container {
            /* padding:10px; */
            border: 1px solid;
        }
        .header {
            height: 40px;
        }

        .row {
            height: 30px;
        }

        .title {
            font-weight: bold;
            background-color: lightgrey;
        }
        .colume {
            padding:5px;
            width: 100px;
            float: left;
        }

        .input {
            float: left;
        }
    </style>
</head>

<body>
    <center>
       <h3>전체 계좌 조회</h3>
       <table border = "1">
       <tr><th>계좌번호</th><th>이름</th><th>잔액</th><th>계좌구분</th><th>등급</th></tr>
       <c:forEach items="${accs }" var="acc">
       		<tr>
       			<td>${acc.id }</td>
       			<td>${acc.name }</td>
       			<td>${acc.balance }</td>
       			<td>${acc.type  }</td>
       			<c:choose>
       				<c:when test = "${acc.type =='special' }">
       					<td>${acc.grade }</td>
       				</c:when>
       				<c:otherwise>
       					<td></td>
       				</c:otherwise>
       			</c:choose>
       		</tr>
       </c:forEach>
       </table>
    </center>
</body>
</html>