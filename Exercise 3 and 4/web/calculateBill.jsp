<%@ page import="java.io.*,java.text.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Electricity Bill Calculation (India)</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f9fa;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .container {
            text-align: center;
            background-color: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 400px;
        }

        h1 {
            color: #007bff;
        }

        p {
            font-size: 18px;
            color: #333;
        }

        button {
            padding: 10px 20px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>

<div class="container">
    <h1>Electricity Bill</h1>

    <%
        // Get the units from the form
        String unitsStr = request.getParameter("units");
        double units = Double.parseDouble(unitsStr);
        double billAmount = 0.0;

        // Tariff rates based on consumption in units
        double rate1 = 3.50; // First 100 units
        double rate2 = 4.00; // 101 to 200 units
        double rate3 = 5.50; // 201 to 400 units
        double rate4 = 7.00; // Above 400 units

        // Bill Calculation Logic
        if (units <= 100) {
            billAmount = units * rate1;
        } else if (units <= 200) {
            billAmount = (100 * rate1) + ((units - 100) * rate2);
        } else if (units <= 400) {
            billAmount = (100 * rate1) + (100 * rate2) + ((units - 200) * rate3);
        } else {
            billAmount = (100 * rate1) + (100 * rate2) + (200 * rate3) + ((units - 400) * rate4);
        }

        // Format the output to two decimal places
        DecimalFormat df = new DecimalFormat("#.##");
        String formattedBill = df.format(billAmount);
    %>

    <p>You have used <strong><%= units %></strong> kWh of electricity.</p>
    <p>Your total bill is: <strong>₹<%= formattedBill %></strong></p>

    <form action="home.html">
        <button type="submit">Go Back</button>
    </form>
</div>

</body>
</html>
