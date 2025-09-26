<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- JSTL Core 태그 라이브러리 선언 -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <!-- 문서의 문자 인코딩 설정 -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 화면 크기와 스케일 조정 -->
    <title>게시판</title>
    <!-- 문서 제목 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <!-- Bootstrap CSS 로드 -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <!-- jQuery 라이브러리 로드 -->
</head>

<body>
<div class="container mt-4">
    <!-- Bootstrap 컨테이너 생성 -->
    <h2 class="mb-4">게시판</h2>
    <!-- 제목 표시 -->

    <!-- 게시글 목록 -->
    <div id="boardList">
        <table class="table table-striped">
            <!-- 게시글 테이블 -->
            <thead class="table-dark">
            <!-- 테이블 헤더 -->
            <tr>
                <th>#</th>
                <th>Title</th>
                <th>Writer</th>
                <th>Date</th>
                <th>Hit</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
        <button id="showWriteForm" class="btn btn-success">New Write</button>
        <!-- 새 글 작성 버튼 -->
    </div>

    <!-- 게시글 상세보기 -->
    <div id="boardView" style="display: none;">
        <!-- 상세보기 컨테이너 -->
        <h3>게시글 상세보기</h3>
        <div class="card">
            <div class="card-header bg-dark text-white">
                <!-- 제목 영역 -->
                <span id="viewTitle"></span>
            </div>
            <div class="card-body">
                <!-- 상세내용 영역 -->
                <h5 id="viewWriter" class="card-title"></h5>
                <p id="viewContent" class="card-text"></p>
                <p class="text-muted">
                    작성일: <span id="viewDate"></span> | 조회수: <span id="viewHits"></span>
                    <!-- 작성일 및 조회수 -->
                </p>
            </div>
        </div>
        <button id="backToList" class="btn btn-secondary mt-3">목록으로</button>
        <!-- 목록으로 돌아가기 버튼 -->
    </div>

    <!-- 게시글 작성 -->
    <div id="boardWrite" style="display: none;">
        <!-- 글 작성 폼 -->
        <h3>게시글 작성</h3>
        <form id="writeForm">
            <div class="mb-3">
                <label for="title" class="form-label">제목</label>
                <input type="text" class="form-control" id="title" name="title" required>
                <!-- 제목 입력 필드 -->
            </div>
            <div class="mb-3">
                <label for="writer" class="form-label">작성자</label>
                <input type="text" class="form-control" id="writer" name="writer" required>
                <!-- 작성자 입력 필드 -->
            </div>
            <div class="mb-3">
                <label for="content" class="form-label">내용</label>
                <textarea class="form-control" id="content" name="content" rows="5" required></textarea>
                <!-- 내용 입력 필드 -->
            </div>
            <button type="submit" class="btn btn-primary">저장</button>
            <!-- 저장 버튼 -->
            <button type="button" id="cancelWrite" class="btn btn-secondary">취소</button>
            <!-- 취소 버튼 -->
        </form>
    </div>
</div>

<script>
    $(document).ready(function () {
        // 페이지 로드 후 실행
        const loadBoards = () => {
            // 게시글 목록 로드 함수
            $.ajax({
                url: "/api/boards",
                method: "GET",
                success: function (boards) {
                    console.log(boards);
                    const tableBody = $("#boardList tbody");
                    tableBody.empty();
                    boards.forEach(board => {
                        tableBody.append(`
                            <tr data-id="\${board.id}">
                                <td>\${board.id}</td>
                                <td><a href="#" class="viewLink"  data-id="\${board.id}">\${board.title}</a></td>
                                <td>\${board.writer}</td>
                                <td>\${board.createdAt}</td>
                                <td>\${board.views}</td>
                                <td>
                                    <button class="btn btn-sm btn-primary editBtn">Edit</button>
                                    <button class="btn btn-sm btn-danger deleteBtn">Delete</button>
                                </td>
                            </tr>
                        `);
                    });
                }
            });
        };

        const showList = () => {
            // 게시글 목록 화면 표시
            $("#boardList").show();
            $("#boardWrite").hide();
            $("#boardView").hide();
            loadBoards();
        };

        const showBoardView = (board) => {
            // 게시글 상세보기 화면 표시
            $("#viewTitle").text(board.title);
            $("#viewWriter").text(`작성자:\${board.writer}`);
            $("#viewContent").text(board.content);
            $("#viewDate").text(board.createdAt);
            $("#viewHits").text(board.views);
            $("#boardList").hide();
            $("#boardView").show();
        };

        $("#backToList").click(() => {
            // 목록으로 돌아가기 버튼 이벤트
            $("#boardView").hide();
            $("#boardWrite").hide();
            $("#boardList").show();
            loadBoards();
        });

        $(document).on("click", ".viewLink", function (event) {
            // 상세보기 링크 클릭 이벤트
            event.preventDefault();
            const id = $(this).data("id");
            $.ajax({
                url: `/api/boards/\${id}`,
                method: "GET",
                success: function (board) {
                    showBoardView(board);
                }
            });
        });

        $(document).on("click", ".deleteBtn", function () {
            // 삭제 버튼 클릭 이벤트
            const id = $(this).closest("tr").data("id");
            if (confirm("정말 삭제하시겠습니까?")) {
                $.ajax({
                    url: `/api/boards/\${id}`,
                    method: "DELETE",
                    success: function () {
                        alert("게시글이 삭제되었습니다.");
                        loadBoards();
                    }
                });
            }
        });

        $(document).on("click", ".editBtn", function () {
            // 수정 버튼 클릭 이벤트
            const row = $(this).closest("tr");
            const id = row.data("id");
            const title = row.find(".viewLink").text();
            const writer = row.children("td:nth-child(3)").text();

            row.html(`
                <td>\${id}</td>
                <td><input type="text" class="form-control editTitle" value="\${title}"></td>
                <td><input type="text" class="form-control editWriter" value="\${writer}"></td>
                <td></td>
                <td></td>
                <td>
                    <button class="btn btn-sm btn-success saveEditBtn">Save</button>
                    <button class="btn btn-sm btn-secondary cancelEditBtn">Cancel</button>
                </td>
            `);
        });

        $(document).on("click", ".saveEditBtn", function () {
            // 수정 저장 버튼 클릭 이벤트
            const row = $(this).closest("tr");
            const id = row.data("id");
            const newTitle = row.find(".editTitle").val();
            const newWriter = row.find(".editWriter").val();

            $.ajax({
                url: `/api/boards/\${id}`,
                method: "PUT",
                contentType: "application/json",
                data: JSON.stringify({ title: newTitle, writer: newWriter }),
                success: function () {
                    alert("게시글이 수정되었습니다.");
                    loadBoards();
                },
                error: function () {
                    alert("수정 작업 중 문제가 발생했습니다.");
                }
            });
        });

        $(document).on("click", ".cancelEditBtn", function () {
            // 수정 취소 버튼 클릭 이벤트
            loadBoards();
        });

        $("#showWriteForm").click(() => {
            // 새 글 작성 버튼 클릭 이벤트
            $("#boardList").hide();
            $("#boardWrite").show();
        });

        $("#cancelWrite").click(showList);

        $("#writeForm").submit(function (event) {
            // 글 작성 폼 제출 이벤트
            event.preventDefault();
            const formData = {
                title: $("#title").val(),
                writer: $("#writer").val(),
                content: $("#content").val()
            };
            $.ajax({
                url: "/api/boards",
                method: "POST",
                contentType: "application/json",
                data: JSON.stringify(formData),
                success: function () {
                    showList();
                }
            });
        });

        showList();
    });
</script>
</body>

</html>
