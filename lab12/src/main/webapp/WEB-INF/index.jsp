<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>The Number Quiz</h1>
<p>Your current score is
    ${score}
</p>
<p>Guss the number in the sequence</p>
<p>
    ${question}
</p>
<form action="home" method="Post">
    <lable> Your answer:
        <input type="text" name="answer" size="2"/>
    </lable>
    <br><br>
    <input type="submit">
</form>
</body>
</html>
