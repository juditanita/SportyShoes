<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">

	<tr>
		<th>Id</th>
		<th>Name</th>
		<th>Category</th>
		<th>Description</th>
		<th>Price</th>
		
	</tr>
	<core:forEach items=${requestScope.listOfProduct} var="product">
			<tr>
				<td><core:out value=${product.id} ></core:out> </td>
				<td><core:out value=${product.name} ></core:out> </td>
				<td><core:out value=${product.category} ></core:out></td>
				<td><core:out value=${product.description} ></core:out> </td>
				
				<td><core:out value=${product.price} ></core:out> </td>
			</tr>
	</core:forEach>
</table>





</body>
</html>