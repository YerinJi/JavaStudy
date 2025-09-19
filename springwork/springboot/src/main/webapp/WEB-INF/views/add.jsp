
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="header.jsp" %>

<div class="container mt-4">
  <h2 class="mb-4">Add Employee</h2>
  <form id="addEmployeeForm">
    <div class="mb-3">
      <label for="name" class="form-label">Name</label>
      <input type="text" class="form-control" id="name" name="name" required>
    </div>
    <div class="mb-3">
      <label for="age" class="form-label">Age</label>
      <input type="number" class="form-control" id="age" name="age" required>
    </div>
    <div class="mb-3">
      <label for="employeeNumber" class="form-label">Employee Number</label>
      <input type="text" class="form-control" id="employeeNumber" name="employeeNumber" required>
    </div>
    <div class="mb-3">
      <label for="department" class="form-label">Department</label>
      <input type="text" class="form-control" id="department" name="department" required>
    </div>
    <button type="submit" class="btn btn-primary">Add Employee</button>
    <a href="/employees/list" class="btn btn-secondary">Cancel</a>
  </form>
</div>

<script>
  $(document).ready(function () {
    $('#addEmployeeForm').on('submit', function (e) {
      e.preventDefault(); // 기본 폼 동작 차단
      const employeeData = {
        name: $('#name').val(),
        age: parseInt($('#age').val(), 10), // 숫자 변환
        employeeNumber: $('#employeeNumber').val(),
        department: $('#department').val()
      };

      $.ajax({
        url: '/api/employees', // REST 컨트롤러 URL
        method: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(employeeData),
        success: function () {
          alert('Employee added successfully!');
          // 목록 화면으로 이동
          window.location.href = '/employees/list';
        },
        error: function (xhr) {
          alert('Error: ' + xhr.responseText);
        }
      });
    });
  });
</script>

<%@ include file="footer.jsp" %>
