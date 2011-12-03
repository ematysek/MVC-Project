<%-- 
    Document   : index
    Created on : Dec 3, 2011, 4:14:38 PM
    Author     : Eric
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        <h1>Contact Information</h1>
        <form method="post" action ="../AddContact" >
            First Name: <input type="text" name="firstname" /><br/>
            Last Name: <input type="text" name="lastname" /><br/>
            <input type="submit" value="Submit"/>
        </form>
    </body>
</html>
