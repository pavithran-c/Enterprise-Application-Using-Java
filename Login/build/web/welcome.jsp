<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Invalid Login</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f8d7da; /* Light red background */
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh; /* Full viewport height */
                margin: 0;
                text-align: center; /* Center text */
            }

            .message-container {
                background-color: #ffffff; /* White background for the container */
                padding: 40px;
                border-radius: 8px;
                box-shadow: 0 0 15px rgba(0, 0, 0, 0.2);
                width: 300px; /* Fixed width for the container */
            }

            h1 {
                color: #721c24; /* Dark red text color */
                margin-bottom: 20px;
            }

            p {
                color: #856404; /* Dark yellow for additional information */
                margin-top: 0; /* Remove top margin */
            }

            .login-button {
                display: inline-block; /* Make it behave like a button */
                margin-top: 20px;
                padding: 10px 20px;
                background-color: #007bff; /* Bootstrap primary color */
                color: white;
                border: none;
                border-radius: 4px;
                text-decoration: none; /* Remove underline */
                font-size: 16px;
                cursor: pointer; /* Show pointer on hover */
                transition: background-color 0.3s ease; /* Smooth transition */
            }

            .login-button:hover {
                background-color: #0056b3; /* Darker blue on hover */
            }
        </style>
    </head>
    <body>
        <div class="message-container">
            <h1>Invalid Login</h1>
            <p>Please check your username and password.</p>
            <a href="index.jsp" class="login-button">Try Again</a> <!-- Link to retry login -->
        </div>
    </body>
</html>
