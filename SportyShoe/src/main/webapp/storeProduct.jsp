<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>Add Product</h2>
<form action="storeProductDetails" method="post">
<label>Id</label>
<input type="number" name="id" placeholder="***" required><br>
<label>Name</label>
<input type="text" name="name" placeholder="Add the name"><br>
<label>Description</label>
<input type="text" name="description" placeholder="Up to 400 character"><br>
<label>Category</label>
<select id="category">
<option value="Adults Men">Adults Men</option>
<option value="Teen Boys">Teen Boys </option>
<option value="Kid Boys">Kid Boys</option>

<option value="Adults Women">Adults Women</option>
<option value="Teen Girls">Teen Girls</option>
<option value="Kid Girls">Kid Girls</option>
</select>

<label>Price </label>
<input type="number" name="price"min="0.00" max="10000.00" placeholder=" Type the price"><br>
<label>Available</label>
<select id="available">
<option value="Yes">Yes</option>
<option value="No">No</option>
</select>			
<input type="submit" value="Add">
<input type="reset" value="Reset">
	
	



</form>

</body>
</html>