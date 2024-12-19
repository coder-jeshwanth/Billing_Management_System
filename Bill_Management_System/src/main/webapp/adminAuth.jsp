<!DOCTYPE html>
<html>
<head>
    <title>Admin Authentication</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        .container {
            max-width: 600px;
            margin: 50px auto;
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 8px;
            box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);
        }
        h2 {
            text-align: center;
        }
        form {
            margin-bottom: 20px;
        }
        label {
            display: block;
            margin-bottom: 5px;
        }
        input {
            width: 100%;
            padding: 8px;
            margin-bottom: 15px;
            border: 1px solid #ddd;
            border-radius: 4px;
        }
        button {
            width: 100%;
            padding: 10px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        button:hover {
            background-color: #0056b3;
        }
        .error {
            color: red;
            font-size: 14px;
            margin-top: -10px;
            margin-bottom: 10px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Admin Authentication</h2>

        <!-- Signin Section -->
        <form action="AdminSigninServlet" method="post">
            <h3>Sign In</h3>
            <label for="signin-username">Username:</label>
            <input type="text" name="username" id="signin-username" required>
            <label for="signin-password">Password:</label>
            <input type="password" name="password" id="signin-password" required>
            <% 
                String signinErrorMessage = (String) request.getAttribute("signinErrorMessage");
                if (signinErrorMessage != null) {
            %>
                <p class="error"><%= signinErrorMessage %></p>
            <% } %>
            <button type="submit">Sign In</button>
        </form>

        <!-- Signup Section -->
        <form action="AdminSignupServlet" method="post">
            <h3>Sign Up</h3>
            <label for="signup-username">Username:</label>
            <input type="text" name="username" id="signup-username" required>
            <% 
                String signupErrorMessage = (String) request.getAttribute("signupErrorMessage");
                if (signupErrorMessage != null) {
            %>
                <p class="error"><%= signupErrorMessage %></p>
            <% } %>
            <label for="signup-password">Password:</label>
            <input type="password" name="password" id="signup-password" required>
            <button type="submit">Sign Up</button>
        </form>
    </div>
</body>
</html>
