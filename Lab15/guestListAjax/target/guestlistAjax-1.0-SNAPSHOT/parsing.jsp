<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 5/11/2021
  Time: 10:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css" href="main.css"></style>
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script>
        $(document).ready(function () {
            $("#retrieve").click(function () {
                $("#userTable").html("");
                $.get("http://jsonplaceholder.typicode.com/users")
                    .done(function (data) {
                        $.each(data, (index, user) => $("#userTable").append("<tr data-id='" + user.id + "'><td>" + user.name + "'<td>" + user.email));
                    })
                    .fail(function (error) {
                        console.log(error)
                    })
                });

            $("#userTable").on('click','tr',function () {
                $("#postDiv").html("");
                let id=$(this).attr("data-id");
                $.get("http://jsonplaceholder.typicode.com/posts",{"userId":id})
                    .done(function (data) {
                        $.each(data, (index, post) => $("#postDiv").append("<span class='post' data-id='" + post.id + "'><span class='postTitle'>" + post.title + "</span><span class='postBody'>" + post.body + "</span></span>"));
                    })
                    .fail(function (error) {
                        console.log(error)
                    })
            });

            $("#postDiv").on('click','span.post',function () {
                $("#commentDiv").html("");
                let id=$(this).attr("data-id");
                alert(this+" "+id)
                $.get("http://jsonplaceholder.typicode.com/comments",{"postId":id})
                    .done(function (data) {
                        $.each(data, (index, comment) => $("#commentDiv").append("<span class='comment' data-id='" + comment.id + "'><span class='commentTitle'>" + comment.title + "</span><span class='commentBody'>" + comment.body + "</span></span>"));
                    })
                    .fail(function (error) {
                        console.log(error)
                    })
            });

        });
    </script>
</head>
<body>
<button id="retrieve">Click to see user</button>
<div id="container">
    <div id="content1">
        <div class="header">
            Users
        </div>
        <table id="userTable">
            <th>ID</th>
            <th>UserName</th>
            <th>Email</th>
        </table>
    </div>

    <div id="content2">
        <div class="header">
            Posts
        </div>
            <div id="postDiv">

            </div>


    </div>
    <div id="content3">
        <div class="header">
            Comments
        </div>
            <div id="commentDiv">

            </div>


    </div>
</div>

</body>
</html>
