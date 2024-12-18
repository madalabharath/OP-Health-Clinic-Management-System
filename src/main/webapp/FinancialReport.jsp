<%@ page import="java.util.List" %>
<%@ page import="com.authorities.FinancialReport" %> <!-- Ensure this is the correct import -->

<!DOCTYPE html>
<html>
<head>
    <title>Financial Report</title>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <style>
        .chart-container {
            width: 70%;
            margin: auto;
        }
    </style>
</head>
<body>
    <h1>Financial Report</h1>
    <div class="chart-container">
        <canvas id="financialChart"></canvas>
    </div>
    <script>
        var dates = [];
        var revenues = [];
        var expenses = [];
        var profits = [];

        <% 
            List<FinancialReport> reports = (List<FinancialReport>) request.getAttribute("reports");
            if (reports != null) {
                for (FinancialReport report : reports) {
                    out.println("dates.push('" + report.getDate().toString() + "');");
                    out.println("revenues.push(" + report.getRevenue() + ");");
                    out.println("expenses.push(" + report.getExpenses() + ");");
                    out.println("profits.push(" + report.getProfit() + ");");
                }
            } else {
                out.println("console.error('Reports list is null');");
            }
        %>

        var ctx = document.getElementById('financialChart').getContext('2d');
        var chart = new Chart(ctx, {
            type: 'bar',
            data: {
                labels: dates,
                datasets: [
                    {
                        label: 'Revenue',
                        data: revenues,
                        backgroundColor: 'rgba(75, 192, 192, 0.2)',
                        borderColor: 'rgba(75, 192, 192, 1)',
                        borderWidth: 1
                    },
                    {
                        label: 'Expenses',
                        data: expenses,
                        backgroundColor: 'rgba(255, 99, 132, 0.2)',
                        borderColor: 'rgba(255, 99, 132, 1)',
                        borderWidth: 1
                    },
                    {
                        label: 'Profit',
                        data: profits,
                        backgroundColor: 'rgba(54, 162, 235, 0.2)',
                        borderColor: 'rgba(54, 162, 235, 1)',
                        borderWidth: 1
                    }
                ]
            },
            options: {
                responsive: true,
                plugins: {
                    legend: {
                        position: 'top',
                    },
                    tooltip: {
                        mode: 'index',
                        intersect: false,
                    },
                },
                interaction: {
                    mode: 'nearest',
                    intersect: true
                }
            }
        });
    </script>
</body>
</html>
