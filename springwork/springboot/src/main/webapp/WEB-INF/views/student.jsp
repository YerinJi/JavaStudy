<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Student Data</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
</head>

<body>
<div class="container mt-5">
  <h1 class="text-center">Student Data</h1>
  <!-- 버튼 -->
  <div class="text-center mb-3">
    <button id="loadStudentsBtn" class="btn btn-primary">Load Students</button>
  </div>
  <!-- 테이블 -->
  <table class="table table-bordered" id="studentTable">
    <thead>
    <tr>
      <th>Student No</th>
      <th>Name</th>
      <th>Serial ID</th>
      <th>Grade</th>
      <th>ID Number</th>
      <th>Birth Date</th>
      <th>Phone</th>
      <th>Height</th>
      <th>Weight</th>
      <th>Department No</th>
      <th>Professor No</th>
    </tr>
    </thead>
    <tbody></tbody>
  </table>

  <!-- 차트: BMI 분포 -->
  <h2 class="text-center mt-5">BMI Distribution</h2>
  <div id="bmi-chart" style="width: 900px; height: 500px; margin: auto;"></div>
</div>

<script>
  // Load Google Charts
  google.charts.load('current', { packages: ['corechart'] });

  $(document).ready(function () {
    // 버튼 클릭 이벤트
    $("#loadStudentsBtn").click(function () {
      console.log("Fetching student data...");
      $.ajax({
        url: "/api/students",
        method: "GET",
        success: function (data) {
          console.log("Data received:", data); // 데이터 확인

          let tableBody = $("#studentTable tbody");
          tableBody.empty(); // 기존 데이터 초기화

          // 데이터를 테이블에 추가
          // data.forEach(function (student) {
          //     let row = "<tr>" +
          //         "<td>" + student.studNo + "</td>" +
          //         "<td>" + student.name + "</td>" +
          //         "<td>" + student.serId + "</td>" +
          //         "<td>" + student.grade + "</td>" +
          //         "<td>" + student.idNum + "</td>" +
          //         "<td>" + student.birthDate + "</td>" +
          //         "<td>" + student.tel + "</td>" +
          //         "<td>" + student.height + "</td>" +
          //         "<td>" + student.weight + "</td>" +
          //         "<td>" + student.deptNo + "</td>" +
          //         "<td>" + student.profNo + "</td>" +
          //         "</tr>";
          //     tableBody.append(row);
          // });

          data.forEach(function (student) {
            let row = `
                        <tr>
                            <td>\${student.studNo}</td>
                            <td>\${student.name}</td>
                            <td>\${student.serId}</td>
                            <td>\${student.grade}</td>
                            <td>\${student.idNum}</td>
                            <td>\${student.birthDate}</td>
                            <td>\${student.tel}</td>
                            <td>\${student.height}</td>
                            <td>\${student.weight}</td>
                            <td>\${student.deptNo}</td>
                            <td>\${student.profNo}</td>
                        </tr>
                    `;
            tableBody.append(row);
          });

          // BMI 계산 및 차트 데이터 준비
          let bmiData = [['Name', 'BMI']];
          data.forEach(function (student) {
            let bmi = student.weight / ((student.height / 100) ** 2);
            bmiData.push([student.name, bmi]);
          });

          // BMI 차트 그리기
          drawChart(bmiData);
        },
        error: function (error) {
          console.error("Error fetching student data:", error);
          alert("Failed to load student data. Please try again later.");
        }
      });
    });
  });

  // Google Chart 그리기 함수
  function drawChart(chartData) {
    let data = google.visualization.arrayToDataTable(chartData);

    let options = {
      title: 'BMI Distribution',
      pieHole: 0.4,
    };

    let chart = new google.visualization.PieChart(document.getElementById('bmi-chart'));
    chart.draw(data, options);
  }
</script>
</body>

</html>