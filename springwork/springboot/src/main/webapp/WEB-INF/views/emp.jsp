<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Employee Data with Charts</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
</head>

<body>
<div class="container mt-5">
    <h1 class="text-center">Employee Data</h1>
    <!-- 버튼 -->
    <div class="text-center mb-3">
        <button id="loadEmployeesBtn" class="btn btn-primary">Load Employees</button>
    </div>
    <!-- 테이블 -->
    <table class="table table-bordered" id="employeeTable">
        <thead>
        <tr>
            <th>Emp No</th>
            <th>Name</th>
            <th>Job</th>
            <th>Manager</th>
            <th>Hire Date</th>
            <th>Salary</th>
            <th>Commission</th>
            <th>Dept No</th>
        </tr>
        </thead>
        <tbody></tbody>
    </table>

    <!-- 차트 1: 부서별 급여 분포 -->
    <h2 class="text-center mt-5">Salary Distribution by Department</h2>
    <div id="piechart-department" style="width: 900px; height: 500px; margin: auto;"></div>

    <!-- 차트 2: 직원별 연봉 비율 -->
    <h2 class="text-center mt-5">Salary Proportion by Employee</h2>
    <div id="piechart-employee" style="width: 900px; height: 500px; margin: auto;"></div>
</div>

<script>
    // Load Google Charts
    google.charts.load('current', { packages: ['corechart'] });

    $(document).ready(function () {
        // 버튼 클릭 이벤트
        $("#loadEmployeesBtn").click(function () {
            console.log("Fetching employee data...");
            $.ajax({
                url: "/api/employees",
                method: "GET",
                success: function (data) {
                    console.log("Data received:", data); // 데이터 확인
                    console.log(data);

                    let tableBody = $("#employeeTable tbody");
                    tableBody.empty(); // 기존 데이터 초기화

                    // 데이터를 테이블에 추가
                    // data.forEach(function (emp) {
                    //     let row = "<tr>" +
                    //         "<td>" + emp.empNo + "</td>" +
                    //         "<td>" + emp.eName + "</td>" +
                    //         "<td>" + emp.job + "</td>" +
                    //         "<td>" + (emp.mgr ? emp.mgr : '-') + "</td>" +
                    //         "<td>" + emp.hireDate + "</td>" +
                    //         "<td>" + emp.sal + "</td>" +
                    //         "<td>" + (emp.comm ? emp.comm : '-') + "</td>" +
                    //         "<td>" + emp.deptNo + "</td>" +
                    //         "</tr>";
                    //     tableBody.append(row);
                    // });
                    data.forEach(function (emp) {
                        let row = `
                            <tr>
                                <td>\${emp.empNo}</td>
                                <td>\${emp.ename}</td>
                                <td>\${emp.job}</td>
                                <td>\${emp.mgr !== null ? emp.mgr : '-'}</td>
                                <td>\${emp.hireDate}</td>
                                <td>\${emp.sal}</td>
                                <td>\${emp.comm !== null ? emp.comm : '-'}</td>
                                <td>\${emp.deptNo}</td>
                            </tr>
                        `;
                        tableBody.append(row);
                    });



                    // 부서별 급여 합계 계산
                    let salaryByDept = {};
                    data.forEach(function (emp) {
                        if (!salaryByDept[emp.deptNo]) {
                            salaryByDept[emp.deptNo] = 0;
                        }
                        salaryByDept[emp.deptNo] += emp.sal;
                    });

                    // Google Pie Chart 데이터 준비 (부서별 급여)
                    let chartDataDept = [['Department', 'Total Salary']];
                    for (let dept in salaryByDept) {
                        chartDataDept.push([`Dept ${dept}`, salaryByDept[dept]]);
                    }

                    // 직원별 연봉 비율 계산
                    let totalSalary = data.reduce((sum, emp) => sum + emp.sal, 0); // 총 급여
                    let chartDataEmployee = [['Employee', 'Salary Proportion']];
                    data.forEach(function (emp) {
                        chartDataEmployee.push([emp.eName, (emp.sal / totalSalary) * 100]);
                    });

                    // 차트 그리기
                    drawChart('piechart-department', chartDataDept, 'Salary Distribution by Department');
                    drawChart('piechart-employee', chartDataEmployee, 'Salary Proportion by Employee');
                },
                error: function (error) {
                    console.error("Error fetching employee data:", error);
                    alert("Failed to load employee data. Please try again later.");
                }
            });
        });
    });

    // Google Pie Chart 그리기 함수
    function drawChart(elementId, chartData, title) {
        let data = google.visualization.arrayToDataTable(chartData);

        let options = {
            title: title,
            pieHole: 0.4,
        };

        let chart = new google.visualization.PieChart(document.getElementById(elementId));
        chart.draw(data, options);
    }
</script>
</body>

</html>