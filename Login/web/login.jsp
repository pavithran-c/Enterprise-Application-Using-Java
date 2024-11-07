<%@ page language="java" contentType="text/html; charset=UTF-8"
     pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Welcome</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #e9ecef; /* Light gray background */
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh; /* Full viewport height */
            margin: 0;
            text-align: center; /* Center text */
        }

        .welcome-container {
            background-color: #ffffff; /* White background for the container */
            padding: 40px;
            border-radius: 8px;
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.2);
            width: 300px; /* Fixed width for the container */
        }

        h2 {
            color: #333; /* Dark text color */
            margin-bottom: 20px;
        }

        p {
            color: #555; /* Slightly lighter text color */
            margin-top: 0; /* Remove top margin */
        }

        .logout-button {
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

        .logout-button:hover {
            background-color: #0056b3; /* Darker blue on hover */
        }
    </style>
</head>
<body>
    <div class="welcome-container">
        <h2>Welcome to the site!</h2>
        <p>We're glad to have you here.</p>
        <a href="logout.jsp" class="logout-button">Logout</a> <!-- Example Logout button -->
    </div>
</body>
</html>
