<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*, pack1.Employee" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
    <%
        // Creating a list of Employee objects
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("AAA", "IT", 70000, "12-04-2024"));
        employees.add(new Employee("BBB", "IT", 70000, "12-04-2024"));
        employees.add(new Employee("CCC", "IT", 70000, "12-04-2024"));
        employees.add(new Employee("DDD", "IT", 70000, "12-04-2024"));

        // Sorting employees by name using Comparator
        Collections.sort(employees, new Comparator<Employee>() {
            public int compare(Employee e1, Employee e2) {
                return e1.getName().compareTo(e2.getName());
            }
        });

        // Setting the sorted list as a request attribute
        request.setAttribute("empList", employees);
    %>

    <h1>Employee List</h1>
    <table border="1">
        <tr>
            <th>Name</th>
            <th>Department</th>
            <th>Salary</th>
            <th>Hire Date</th>
        </tr>

        <c:forEach var="emp" items="${empList}">
            <tr>
                <td><c:out value="${emp.name}" /></td>
                <td><c:out value="${emp.department}" /></td>
                <td><c:out value="${emp.salary}" /></td>
                <td><c:out value="${emp.hireDate}" /></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
