<%@include file="CommonHeader.jsp"%>
<br/><br/><br/><br/><br/>
<body>
<form action="<c:url value='/insertCategory'/>" method="post">
<table align="center" class="table table-condensed">
	<tr>
		<td colspan="2"><center>Manage Category</center></td>
	</tr>
	<tr>
		<td>Category ID</td>
		<td><input type="text" name="catId"></td>
	</tr>
	<tr>
		<td>Category Name</td>
		<td><input type="text" name="catName"></td>
	</tr>
	<tr>
		<td>Category Description</td>
		<td><textarea rows="5" cols="30" name="catDesc"></textarea></td>
	</tr>
	<tr>
		<td colspan="2">
		<center>
			<input type="submit" value="Insert Category" class="btn btn-success">
		</center>
		</td>
	</tr>
</table>
</form>

<table align="center" cellspacing="3" cellpadding="3" class="table table-condensed">
	<tr bgcolor="cyan">
		<td>Category Id</td>
		<td>Category Name</td>
		<td>Category Description</td>
		<td>Operation</td>
	</tr>
	<c:forEach items="${categoryList}" var="category">
		<tr bgcolor="pink">
			<td>${category.categoryId}</td>
			<td>${category.categoryName}</td>
			<td>${category.categoryDesc}</td>
			<td>
				<a href="<c:url value='/deleteCategory/${category.categoryId}'></c:url>">Delete</a>
				&nbsp;&nbsp;|&nbsp;&nbsp;
				<a href="<c:url value='/editCategory/${category.categoryId}'></c:url>">Edit</a>
	</c:forEach>
</table>
</body>
</html>