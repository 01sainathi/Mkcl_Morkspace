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
        <h3>Excel Sheet Reader</h3>
        <form action="http://localhost:8080/ExamEventApp/excel/save" method="POST" enctype="multipart/form-data" class="form-control">
            <div class="row my-2">
                <div class="col-md-4">
                    <b>Upload a excel file</b>
                </div> 
                <div class="col-md-8">
                    <input type="file" name="excel"/>
                </div>
            </div>
            <div>
                <button class="btn btn-primary">Submit</button>
            </div>
        </form>
    </div>
</body>
</html>