<%@include file="CommonHeader.jsp"%>
<br/><br/><br/><br/><br/>

<div class="table-responsive">
<form action="<c:url value='/updateCategory'/>" method="post">
<table align="center" class="table table-condensed">
	<tr>
		<td colspan="2"><center>Update Category</center></td>
	</tr>
	<tr>
		<td>Category ID</td>
		<td><input type="text" name="catId" value="${category.categoryId }"></td>
	</tr>
	<tr>
		<td>Category Name</td>
		<td><input type="text" name="catName" value="${category.categoryName }"></td>
	</tr>
	<tr>
		<td>Category Description</td>
		<td><textarea rows="5" cols="30" name="catDesc" >${category.categoryDesc}</textarea></td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="reset" value="RESET">
			<input type="submit" value="Update Category">
		</td>
	</tr>
</table>
</form>
</div>
</body>
</html>