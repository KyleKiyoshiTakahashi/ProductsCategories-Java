<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Categories</title>
</head>
<body>
<h1> <c:out value="${category.name }" /> </h1>

<h1>Products</h1>

<c:forEach items="${category.products}">
 <p> <c:out value="${product.name}"/>   </p>
</c:forEach>

<hr>

<form:form action="/categories/${category.id}" method="POST" modelAttribute="category">
   
	<form:select path="products">
		<c:forEach items="${allProducts}" var="p">
     		<form:option value="${p.id}" label="${p.name}"/> 
		</c:forEach>
	</form:select>
    
     
    <input type="submit" value="Add!"/>
</form:form> 

</body>
</html>