<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Form</title>
</head>
<body>
    <h3>Registration</h3>
    <form name="loginForm" method="POST" action="login">
        Username: <input type="text" name="username"/> <br/>
        Password: <input type="password" name="password"/> <br/>
        <input type="submit" value="Login"/> <br/>
        <% for (int i = 0; i < 10; i++) { %>
            Hello, world <%= i %><br>
        <% } %>
    </form>
</body>
</html>
