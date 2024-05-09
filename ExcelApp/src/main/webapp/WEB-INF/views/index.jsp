<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Upload file</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
</head>
<body>
   	<div class="container my-4">
        <div class="d-flex my-2">
            <div class="card w-50 m-2">
                <div class="card-body">
                  <h4 class="card-title">Read Excel</h4>
                  <p class="card-text">Upload a excel file and the data will be inserted into db.</p>
                  <div class="d-flex">
                  	<a href="http://localhost:8080/ExcelApp/readExcel" class="btn my-btn">Lets GO!!</a>
                  </div>  
                </div>
        </div>
        <div class="card w-50 m-2">
                <div class="card-body">
                  <h4 class="card-title">Create Excel</h4>
                  <p class="card-text">Write text data and a excel file will be created for you</p>
                  <div class="d-flex">
                    <a href="http://localhost:8080/ExcelApp/createExcel" class="btn my-btn">Lets GO!!</a>
                  </div>
                </div>
        </div>
        
        </div>
        <div class="d-flex">
            <div class="card w-50 m-2">
                <div class="card-body">
                    <h4 class="card-title">Create PDF</h4>
                      <p class="card-text">Fill the form and get that data in a pdf.</p>
                      <div class="d-flex">
                        <a href="http://localhost:8080/ExcelApp/convert/h_to_p" class="btn btn-primary my-btn">Lets GO!!</a>
                      </div>
                </div>
            </div>
            <div class="card w-50 m-2">
                <div class="card-body">
                    <h4 class="card-title">Convert Excel into PDF</h4>
                      <p class="card-text">Upload a Excel file and get a PDF representation of that file.</p>
                      <div class="d-flex">
                        <a href="http://localhost:8080/ExcelApp/convert/e_to_p" class="btn btn-primary my-btn">Lets GO!!</a>
                      </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>