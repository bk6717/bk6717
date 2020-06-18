<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
  <h2>Product</h2>
  <form>
  <%--<button class="btn btn-danger" onClick ="deleteById(${detailDto.boardDto.board.id})">삭제</button> --%>
  <button type="button" class="btn btn-dark" onclick = "goFirst()">처음으로</button>
  <button type="button" class="btn btn-price" onclick = "priceDesc()">가격순</button>
  <button type="button" class="btn btn-light" onclick = "countDesc()">판매순</button>
  </form>
  <table class="table table-dark table-striped">

    <thead>
      <tr>
        <th>번호</th>
        <th>이름</th>
        <th>종류</th>
        <th>가격</th>
        <th>판매수</th>
      </tr>
    </thead>
<tbody id = "my__tbody">
<c:forEach var="product" items="${products}">
      <tr>
        <td>${product.id}</td>
        <td>${product.name} </td>
        <td>${product.type}</td>
        <td>${product.price}</td>
        <td>${product.count}</td>
        <td><i style = "cursor : pointer" onclick = "remove(${product.id})" class="glyphicon glyphicon-remove"></i></td>
      </tr>
</c:forEach>
 </tbody>
  </table>
</div>
</body>
</html>
<script src = "/product/js/sort.js"> </script>