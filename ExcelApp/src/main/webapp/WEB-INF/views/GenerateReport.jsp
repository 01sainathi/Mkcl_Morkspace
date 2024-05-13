<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">

<head>
<title>Document</title>
</head>

<body>
	<div class="container my-5">
		<div class="row my-2">
			<div class="col-md-4">
				<h5>Name:</h5>
			</div>
			<div class="col-md-8">
				<input type="text" name="name" id="name" class="form-control">
			</div>
		</div>
		<div class="row my-2">
			<div class="col-md-4">
				<h5>Roll no:</h5>
			</div>
			<div class="col-md-8">
				<input type="text" name="roll" id="roll" class="form-control">
			</div>
		</div>
		<div>
			<b id="error"></b>
		</div>
		<button class="btn btn-primary my-2" onclick="getData()">Get
			Result</button>
			
		<div class="container" id="body">
			<link
				href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
				rel="stylesheet"
				integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
				crossorigin="anonymous">
			<script
				src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"
				integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+"
				crossorigin="anonymous"></script>
			<div class="container" id="report"></div>
		</div>
		<button class="btn btn-primary my-2" onclick="sendBody()">Download
			Result</button>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<script>
		function sendBody() {
			let data = document.getElementById("body").innerHTML;
			console.log(data);

			/* $.ajax({
			    method: "Post",
			    url: "http://localhost:8080/ExcelApp/report/reportCardPdf",
			    contentType: "application/json",
			    data: data,
			    success: function(result){
				    console.log("Success");
			        console.log(result);
			        /* var blob = new Blob([data], { type: 'application/pdf' });
                    var link = document.createElement('a');
                    link.href = window.URL.createObjectURL(blob);
                    link.download = 'result.pdf';
                    document.body.appendChild(link);
                    link.click();
                    document.body.removeChild(link); */
			        /* },
			    error: function(){
			        console.log("error");
			    }
			})  */

			$.ajax({
                url: 'http://localhost:8080/ExcelApp/report/reportCardPdf',
                type: 'POST',
                contentType: 'application/json',
                data: data, // Send any required data here
                xhrFields: {
                    responseType: 'blob' // Receive response as Blob
                },
                success: function(response) {
                    let blob = new Blob([response], { type: 'application/pdf' });
                    let link = document.createElement('a');
                    link.href = window.URL.createObjectURL(blob);
                    link.download = 'result.pdf';
                    document.body.appendChild(link);
                    link.click();
                    document.body.removeChild(link);
                },
                error: function(xhr, status, error) {
                    console.error('Failed to download PDF:', error);
                }
            });
		}

		function getData() {

			let name = document.getElementById("name").value;
			let roll_no = document.getElementById("roll").value;

			console.log(name + " " + roll_no);

			let data = {
				name : name,
				roll_no : roll_no
			}

			$.ajax({
				method : "Get",
				url : "http://localhost:8080/ExcelApp/report/reportCard",
				contentType : 'application/json',
				data : data,
				success : function(result) {
					if(result == "Not Found"){
						document.getElementById("error").innerText = "Please enter valid information";
					}
					else{
						let info = JSON.parse(result);
						console.log(info);

						document.getElementById("report").innerHTML = '';
						let html = '';

						html += '';
						html += '<div class="d-flex flex-column my-2">';
						html += '<div>';
						html += '<b>Roll No: </b>';
						html += info.student.rollNo
						html += '</div>';
						html += '<div>';
						html += '<b>Class: </b>';
						html += info.student.std
						html += '</div>';
						html += '<div>';
						html += '<b>Student Name: </b>';
						html += info.student.name;
						html += '</div>';
						html += '<div>';
						html += '<b>School Name: </b>';
						html += info.school.name;
						html += '</div>';
						html += '</div>';
						html += '<table class="table table-bordered">' + '<thead>'
								+ '<tr>' + '<th>Sr no.</th>' + '<th>Subject</th>'
								+ '<th>Total Marks</th>'
								+ '<th>Marks Obtained</th>' + '</tr>' + '</thead>'
								+ '<tbody id="data">' + '</tbody>' + '</table>';

						document.getElementById("report").innerHTML += html;

						html = '';

						html += '<tr>';
						html += '<td>' + 1 + '</td>';
						html += '<td>English</td>';
						html += '<td>100</td>';
						html += '<td>' + info.marks.english + '</td>';

						html += '<tr>';
						html += '<td>' + 2 + '</td>';
						html += '<td>Mathematics</td>';
						html += '<td>100</td>';
						html += '<td>' + info.marks.mathematics + '</td>';

						html += '<tr>';
						html += '<td>' + 3 + '</td>';
						html += '<td>Science</td>';
						html += '<td>100</td>';
						html += '<td>' + info.marks.science + '</td>';

						html += '<tr>';
						html += '<td>' + 4 + '</td>';
						html += '<td>Social Science</td>';
						html += '<td>100</td>';
						html += '<td>' + info.marks.socialScience + '</td>';

						html += '<tr>';
						html += '<td>' + 5 + '</td>';
						html += '<td>Hindi</td>';
						html += '<td>100</td>';
						html += '<td>' + info.marks.hindi + '</td>';

						html += '<tr>';
						html += '<td>' + 6 + '</td>';
						html += '<td>Physical Education</td>';
						html += '<td>100</td>';
						html += '<td>' + info.marks.physicalEducation + '</td>';

						html += '<tr>';
						html += '<td>' + 7 + '</td>';
						html += '<td>Drawing</td>';
						html += '<td>100</td>';
						html += '<td>' + info.marks.drawing + '</td>';

						html += '<tr>';
						html += '<td>' + 8 + '</td>';
						html += '<td>Sanskrit</td>';
						html += '<td>100</td>';
						html += '<td>' + info.marks.sanskrit + '</td>';

						html += '<tr>';
						html += '<td>' + 9 + '</td>';
						html += '<td>Moral Science</td>';
						html += '<td>100</td>';
						html += '<td>' + info.marks.moralScience + '</td>';

						let marksObtained = parseInt(info.marks.english)
								+ parseInt(info.marks.mathematics)
								+ parseInt(info.marks.science)
								+ parseInt(info.marks.socialScience)
								+ parseInt(info.marks.hindi)
								+ parseInt(info.marks.physicalEducation)
								+ parseInt(info.marks.drawing)
								+ parseInt(info.marks.sanskrit)
								+ parseInt(info.marks.moralScience);

						html += '<tr>';
						html += '<td colspan="2">Total</td>';
						html += '<td>900</td>'
						html += '<td>' + marksObtained + '</td>'
						document.getElementById("data").innerHTML = html;
						console.log(html);
					}	
				},
				error : function(error) {
					console.log(error);
				}
			})
		}
	</script>
</body>
</html>