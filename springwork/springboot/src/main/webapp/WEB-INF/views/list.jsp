<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="header.jsp" %>

<div class="container mt-4">
  <h2 class="mb-4">Employee List</h2>
  <table id="employeeTable" class="table table-striped">
    <thead class="table-dark">
    <tr>
      <th>#</th>
      <th>Name</th>
      <th>Age</th>
      <th>Employee Number</th>
      <th>Department</th>
      <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <!-- 데이터를 Ajax로 로드 -->
    </tbody>
  </table>
  <a href="/employees/add" class="btn btn-success">Add Employee</a>

  <div class="mt-5">
    <h3>Department Distribution</h3>
    <div id="departmentChart" style="width: 100%; height: 500px;"></div>
  </div>
</div>

<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script>
  google.charts.load('current', { packages: ['corechart'] });

  $(document).ready(function () {
    function loadEmployeeList() {
      $.ajax({
        url: '/api/employees',
        method: 'GET',
        success: function (data) {
          let tableBody = '';
          const departmentCount = {};

          data.forEach(function (employee) {
            tableBody += `
                            <tr data-id="\${employee.id}">
                                <td>\${employee.id}</td>
                                <td class="editable name">\${employee.name}</td>
                                <td class="editable age">\${employee.age}</td>
                                <td class="editable employeeNumber">\${employee.employeeNumber}</td>
                                <td class="editable department">\${employee.department}</td>
                                <td>
                                    <button class="btn btn-sm btn-primary edit-btn">Edit</button>
                                    <button class="btn btn-sm btn-success save-btn d-none">Save</button>
                                    <button class="btn btn-sm btn-secondary cancel-btn d-none">Cancel</button>
                                    <button class="btn btn-sm btn-danger delete-btn">Delete</button>
                                </td>
                            </tr>
                        `;

            // Count departments
            if (!departmentCount[employee.department]) {
              departmentCount[employee.department] = 0;
            }
            departmentCount[employee.department]++;
          });

          $('#employeeTable tbody').html(tableBody);
          drawDepartmentChart(departmentCount);
        }
      });
    }

    function drawDepartmentChart(departmentCount) {
      const data = new google.visualization.DataTable();
      data.addColumn('string', 'Department');
      data.addColumn('number', 'Employees');

      Object.keys(departmentCount).forEach(function (department) {
        data.addRow([department, departmentCount[department]]);
      });

      const options = {
        title: 'Department Distribution',
        pieHole: 0.4,
      };

      const chart = new google.visualization.PieChart(document.getElementById('departmentChart'));
      chart.draw(data, options);
    }

    loadEmployeeList();

    // Edit button click event
    $(document).on('click', '.edit-btn', function () {
      const row = $(this).closest('tr');
      row.find('.editable').each(function () {
        const text = $(this).text();
        $(this).html(`<input type="text" class="form-control" value="\${text}">`);
      });
      row.find('.edit-btn').addClass('d-none');
      row.find('.save-btn, .cancel-btn').removeClass('d-none');
    });

    // Save button click event
    $(document).on('click', '.save-btn', function () {
      const row = $(this).closest('tr');
      const id = row.data('id');
      const updatedData = {
        name: row.find('.name input').val(),
        age: row.find('.age input').val(),
        employeeNumber: row.find('.employeeNumber input').val(),
        department: row.find('.department input').val()
      };

      $.ajax({
        url: `/api/employees/\${id}`,
        method: 'PUT',
        contentType: 'application/json',
        data: JSON.stringify(updatedData),
        success: function () {
          alert('Employee updated successfully');
          loadEmployeeList();
        }
      });
    });

    // Cancel button click event
    $(document).on('click', '.cancel-btn', function () {
      const row = $(this).closest('tr');
      loadEmployeeList(); // Reload the list to reset the row
    });

    // Delete button click event
    $(document).on('click', '.delete-btn', function () {
      const row = $(this).closest('tr');
      const id = row.data('id');
      if (confirm('Are you sure you want to delete this employee?')) {
        $.ajax({
          url: `/api/employees/\${id}`,
          method: 'DELETE',
          success: function () {
            alert('Deleted successfully');
            loadEmployeeList();
          }
        });
      }
    });
  });
</script>

<%@ include file="footer.jsp" %>
