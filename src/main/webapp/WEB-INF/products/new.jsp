<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Product</title>
</head>
<body>
	<h1>New Product</h1>
 <form:form action="/products" method="POST" modelAttribute="product">
      <p>
        <form:label path="name">Name: </form:label>
        <form:errors path="name"/>
        <form:input path="name"/>
     </p> 
     <p>
        <form:label path="price">Price: </form:label>
        <form:errors path="price"/>
        <form:input path="price"/>
     </p> 
     <p>
        <form:label path="description">Description: </form:label>
        <form:errors path="description"/>
        <form:input path="description"/>
     </p> 
    <input type="submit" value="Create"/>
</form:form> 
</body>
</html>