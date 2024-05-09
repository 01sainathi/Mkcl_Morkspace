<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"
        integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+"
        crossorigin="anonymous"></script>
</head>

<body>
    <div class="container my-5" id="body">
            <div class="row my-2">
                <div class="col-md-4">
                    <h5>Name: </h5>
                </div>
                <div class="col-md-8">
                    <input type="text" name="name" id="name" class="form-control">
                </div>
            </div>
            <div class="row my-2">
                <div class="col-md-4">
                    <h5>Roll no: </h5>
                </div>
                <div class="col-md-8">
                    <input type="text" name="roll" id="roll" class="form-control">
                </div>
            </div>
            <button class="btn btn-primary my-2" onclick="getData()">Get Report</button>
        
        <button class="btn btn-primary my-2" onclick="sendBody()">Send</button>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script>
        function sendBody(){
            let data = document.getElementById("body").innerHTML;
            console.log(data);
            
            $.ajax({
                method: "Post",
                url: "http://localhost:8080/ExcelApp/convert/reportCardPdf",
                contentType: "application/json",
                data: data,
                success: function(){
                    console.log("success");
                },
                error: function(){
                    console.log("error");
                }
            })
        }

        function getData(){

            let name = document.getElementById("name").value;
            let roll_no = document.getElementById("roll").value;

            console.log(name+" "+roll_no);

            let data = {
                name: name,
                roll_no: roll_no
            }

            $.ajax({
                method: "Get",
                url: "http://localhost:8080/ExcelApp/report/reportCard",
                contentType: "application/json",
                data: data,
                success: function(){
                    console.log("success");
                },
                error: function(error){
                    console.log(error);
                }
            })
        }

    </script>
</body>
</html>