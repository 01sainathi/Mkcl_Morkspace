<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Document</title>
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
	<div class="container my-2">
		<h3>Reading Application properties</h3>
		<b>lglobal.recordsPerPage=</b> <span>${globalRecordsPerPage}</span>
		<br> 
		<b>QuestionPaperPath=</b> <span>${questionPaperPath}</span>
		<br> 
		<b>CandidateStatisticsReportPath=</b> <span>${candidateStatisticsReportPath}</span>
		<br> 
		<b>ImagesPath=</b> <span>${imagesPath}</span>
		<br> 
		<b>zipImagesPath=</b> <span>${zipImagesPath}</span>
		<br> 
		<b>UserDefaultImagePath=</b> <span>${userDefaultImagePath}</span>
		<br> 
		<b>global.dateFormat=</b> <span>${globalDateFormat}</span> 
		<br>
		<b>global.dateFormatWithoutTime=</b> <span>${globalDateFormatWithoutTime}</span> 
		<br>
		<b>examClientVersion=</b> <span>${examClientVersion}</span> 
		<br> 
		<b>wkhtmltopdfPath=</b> <span>${wkhtmltopdfPath}</span>
	    <br>
		<b>isCopyRightEnabled=</b> <span>${isCopyRightEnabled}</span> 
		<br> 
		<b>MaxCandidatesPerProctor=</b><span>${maxCandidatesPerProctor}</span> 
		<br> 
		<b>isLoggingEnabled=</b> <span>${isLoggingEnabled}</span>
		<br> 
		<b>isReportItemEnabled=</b> <span>${isReportItemEnabled}</span> 
		<br>
	</div>
</body>
</html>