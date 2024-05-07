<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"
	integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+"
	crossorigin="anonymous"></script>
</head>
<body>
	<div class="container my-4">
		<div class="card">
		<div class="card-header">
			<h4>Excel Sheet Reader</h4>
		</div>
		<div class="card-body">
			<form action="http://localhost:8080/ExcelApp/excel/save"
				method="POST" enctype="multipart/form-data">
				<div class="row my-2">
					<div class="col-md-4">
						<b>Upload a excel file</b>
					</div>
					<div class="col-md-8">
						<input type="file" name="excel" />
					</div>
				</div>
				<div>
					<button class="btn btn-primary">Submit</button>
				</div>
			</form>
		</div>

	</div>
	</div>
</body>
</html>