<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 4/11/2021
  Time: 10:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

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
    <style>
        .header{
            width: 66%;
            font-size: 1.3em;
            font-weight: 900;
            color: #1115a2;
            }
            .postTitle,.commentTitle{
                display: block;
                border: 2px solid #2727e2;
                width: 66%;
                padding: 0px 25px;
                font-size: 1.1em;
                font-weight: 700;
                border-radius: 1px 27px;
                color: white;
                background: #000635;

            }
            .postBody,.commentBody{
                border: 1px solid #bebebf;
                display: inline-block;
                margin: 1px 15px 24px;
                padding: 12px 18px 27px;
                border-radius: 9px;
                background: #f4f4f4;
            }
            #container{
                display: flex;
            }
            #content1{
                min-width: 372px;
            }
            #content1,#content2,#content3{}
</style>
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
