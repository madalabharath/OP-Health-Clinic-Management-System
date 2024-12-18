<%@ page import="java.util.List" %>
<%@ page import="com.authorities.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Hospital Statistics</title>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <style>
        .chart-container {
            width: 50%;
            margin: auto;
        }
    </style>
</head>
<body>
    <h1>Hospital Statistics</h1>
    <div class="chart-container">
        <canvas id="statisticsChart"></canvas>
    </div>
    <script>
        var years = [];
        var patientsData = [];
        var doctorsData = [];
        var revenueData = [];
        
        <% 
            List<HospitalStatistic> statsList = (List<HospitalStatistic>) request.getAttribute("statsList");
            for (HospitalStatistic stat : statsList) {
                out.println("years.push('" + stat.getYear() + "');");
                out.println("patientsData.push(" + stat.getNumPatients() + ");");
                out.println("doctorsData.push(" + stat.getNumDoctors() + ");");
                out.println("revenueData.push(" + stat.getTotalRevenue() + ");");
            }
        %>

        var ctx = document.getElementById('statisticsChart').getContext('2d');
        var chart = new Chart(ctx, {
            type: 'pie',
            data: {
                labels: years,
                datasets: [
                    {
                        label: 'Number of Patients',
                        data: patientsData,
                        backgroundColor: 'rgba(255, 99, 132, 0.2)',
                        borderColor: 'rgba(255, 99, 132, 1)',
                        borderWidth: 1
                    },
                    {
                        label: 'Number of Doctors',
                        data: doctorsData,
                        backgroundColor: 'rgba(54, 162, 235, 0.2)',
                        borderColor: 'rgba(54, 162, 235, 1)',
                        borderWidth: 1
                    },
                    {
                        label: 'Total Revenue',
                        data: revenueData,
                        backgroundColor: 'rgba(75, 192, 192, 0.2)',
                        borderColor: 'rgba(75, 192, 192, 1)',
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
