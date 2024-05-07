<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>

</head>
<body>
    <div class="container">
        <h3>Exam Event</h3>
        <form action="/ExcelApp/convert/htmlToPdf" method="get" class="form-control">
            <table class="table table--hover">
                <tbody>
                    <tr>
                        <td>Id</td>
                        <td>
                            <input type="number" name="examEventID" id="id" class="form-control">
                        </td>
                    </tr>
                    <tr>
                        <td>Name</td>
                        <td>
                            <input type="text" name="name" id="name" class="form-control">
                        </td>
                    </tr>
                    <tr>
                        <td>Code</td>
                        <td>
                            <input type="text" name="examEventCode" id="code" class="form-control">
                        </td>
                    </tr>
                    <tr>
                        <td>DefaultLanguage</td>
                        <td>
                            <input type="text" name="defaultLanguageID" id="lang" class="form-control">
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2"><input type="submit" value="Save" class="btn btn-primary"></td>
                    </tr>
                </tbody>
            </table>
        </form>
    </div>
</body>
</html>