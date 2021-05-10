<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.List" %>
<%--<%@ taglib prefix="F" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@ taglib prefix="myforeach" uri="https://java.sun.com/jsp/myTag" %>
<html>
<body>
<h1 align="center">Beer Recommendations JSP</h1>
<p>
    <%
        List<String> style= Arrays.asList("one","kajg","asdgdsdf","asdf","asdf");

        %>

<%--    <F:forEach var="style" items="${styles}">--%>
<%--        <div>--%>
<%--            <br>try: ${style}--%>
<%--        </div>--%>
<%--    </F:forEach>--%>

Time is : <myforeach:DateTime color="red" size="12"/>


</body>
</html>
