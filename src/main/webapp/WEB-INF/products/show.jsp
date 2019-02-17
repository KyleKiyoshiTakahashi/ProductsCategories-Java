<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Products</title>
</head>
<body>
<h1> <c:out value="${product.name }" /> </h1>

<h3>Categories</h3>
<c:forEach items="${product.categories}">
 <p> <c:out value="${category.name}"/>   </p>
</c:forEach>
<hr>

<form:form action="/products/${product.id}" method="POST" modelAttribute="product">
   
	<form:select path="categories">
		<c:forEach items="${allCategories}" var="c">
     		<form:option value="${c.id}" label="${c.name}"/> 
		</c:forEach>
	</form:select>
    
     
    <input type="submit" value="Add!"/>
</form:form> 

</body>
</html>