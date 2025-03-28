<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Student</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            background-color: #f4f4f4;
        }
        form {
            background: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0px 0px 10px gray;
            width: 300px;
            margin: auto;
        }
        table {
            width: 100%;
        }
        td {
            padding: 8px;
        }
        input[type="text"], input[type="number"] {
            width: 100%;
            padding: 5px;
        }
        input[type="submit"] {
            background: blue;
            color: white;
            border: none;
            padding: 10px;
            cursor: pointer;
            width: 100%;
        }
    </style>
</head>
<body>

    <h2 style="text-align:center;">Edit Student Details</h2>

    <form action="edit" method="get">
        <table>
            <tr>
                <td>Student ID:</td>
                <td><input type="text" name="sid" value="${student.sid}" readonly></td>
            </tr>
            <tr>
                <td>Name:</td>
                <td><input type="text" name="sname" value="${student.sname}"></td>
            </tr>
            <tr>
                <td>Marks:</td>
                <td><input type="number" name="smark" value="${student.smark}"></td>
            </tr>
            <tr>
                <td>Address:</td>
                <td><input type="text" name="saddr" value="${student.saddr}"></td>
            </tr>
            <tr>
                <td colspan="2" style="text-align:center;">
                    <input type="submit" value="Update Student">
                </td>
            </tr>
        </table>
    </form>

</body>
</html>
