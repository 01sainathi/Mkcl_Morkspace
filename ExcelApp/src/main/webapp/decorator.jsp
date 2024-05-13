<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>SiteMesh example: <sitemesh:write property='title' /></title>

<sitemesh:write property='head' />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <style>
        body{
            background-color: #fbfbfc;
        }
        .card{
            background-color: #EDE8F5;
            border: 0pc;
        }
        #navbar{
            background-color: #ADBBDA;
        }
        .my-btn{
            background-color: #7091E6;
            color: black;
            border: 0px;
            border-radius: 10px;
        }
    </style>
</head>
<body>
	<nav id="navbar" class="navbar navbar-expand-sm mx-2 my-2 rounded-4">
		<div class="container-fluid">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link active" href="http://localhost:8080/ExcelApp/"><h5>Converter</h5></a>
				</li>
				<li class="nav-item"><a class="nav-link" href="http://localhost:8080/ExcelApp/">Home</a></li>
				<li class="nav-item"><a class="nav-link" href="#">About Us</a></li>
			</ul>
		</div>
	</nav>
	<div class="container">
		<div class='mainBody'>
			<sitemesh:write property='body' />
		</div>
	</div>
	<footer class="text-center bg-body-tertiary">
		<!-- Grid container -->
		<div class="container pt-4">
			<!-- Section: Social media -->
			<section class="mb-4">
				<!-- Facebook -->
				<a data-mdb-ripple-init
					class="btn btn-link btn-floating btn-lg text-body m-1" href="#!"
					role="button" data-mdb-ripple-color="dark"><i
					class="fab fa-facebook-f"></i></a>

				<!-- Twitter -->
				<a data-mdb-ripple-init
					class="btn btn-link btn-floating btn-lg text-body m-1" href="#!"
					role="button" data-mdb-ripple-color="dark"><i
					class="fab fa-twitter text-primary"></i></a>

				<!-- Google -->
				<a data-mdb-ripple-init
					class="btn btn-link btn-floating btn-lg text-body m-1" href="#!"
					role="button" data-mdb-ripple-color="dark"><i
					class="fab fa-google text-danger"></i></a>

				<!-- Instagram -->
				<a data-mdb-ripple-init
					class="btn btn-link btn-floating btn-lg text-body m-1" href="#!"
					role="button" data-mdb-ripple-color="dark"><i
					class="fab fa-instagram"></i></a>

				<!-- Linkedin -->
				<a data-mdb-ripple-init
					class="btn btn-link btn-floating btn-lg text-body m-1" href="#!"
					role="button" data-mdb-ripple-color="dark"><i
					class="fab fa-linkedin text-primary"></i></a>
				<!-- Github -->
				<a data-mdb-ripple-init
					class="btn btn-link btn-floating btn-lg text-body m-1" href="#!"
					role="button" data-mdb-ripple-color="dark"><i
					class="fab fa-github"></i></a>
			</section>
			<!-- Section: Social media -->
		</div>
		<!-- Grid container -->

		<!-- Copyright -->
		<div class="text-center p-3"
			style="background-color: rgba(0, 0, 0, 0.05);">© 2024
			Copyright: Mkcl.org</div>
		<!-- Copyright -->
	</footer>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
</body>
</html>