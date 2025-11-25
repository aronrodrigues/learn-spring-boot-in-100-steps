<html>

<head>
    <title>Login Page</title>
</head>

<body>
    <h1>Welcome to the login page, ${name}!</h1>
    <pre>${error}</pre>
    <form method="post">
        <p>Name: <input type="text" name="name"></p>
        <p>Password: <input type="password" name="password"></p>
        <p><input type="submit" value="Send"></input></p>
    </form>
</body>

</html>