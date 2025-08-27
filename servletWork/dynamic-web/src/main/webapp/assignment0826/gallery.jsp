<%--
  Gallery (Responsive: 3 cols → 2 cols → 1 col as width decreases)
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    // Navbar active & 페이지 타이틀(옵션)
    request.setAttribute("active", "Gallery");
    request.setAttribute("pageTitle", "Gallery · Mini Portal");
%>
<%@ include file="common/top.jsp" %>

<h2 class="h3 mb-3">Gallery</h2>
<p class="text-muted">반응형 카드 그리드 — 화면을 줄이면 3열 → 2열 → 1열로 변경</p>

<!-- 기본(모바일) 1열 → ≥576px(sm) 2열 → ≥992px(lg) 3열 -->
<div class="row row-cols-1 row-cols-sm-2 row-cols-lg-3 g-4">

    <!-- 로컬 3장 -->
    <div class="col">
        <div class="card h-100">
            <img src="assets/first.png" class="card-img-top" alt="첫 번째 로컬 이미지"
                 style="object-fit:cover; aspect-ratio:16/9;">
            <div class="card-body">
                <h5 class="card-title">Card 1</h5>
                <p class="card-text">1번째 이미지</p>
            </div>
            <div class="card-footer bg-transparent">
                <a href="#" class="btn btn-outline-primary btn-sm" aria-label="자세히 보기 1">View</a>
            </div>
        </div>
    </div>

    <div class="col">
        <div class="card h-100">
            <img src="assets/second.png" class="card-img-top" alt="두 번째 로컬 이미지"
                 style="object-fit:cover; aspect-ratio:16/9;">
            <div class="card-body">
                <h5 class="card-title">Card 2</h5>
                <p class="card-text">2번째 이미지</p>
            </div>
            <div class="card-footer bg-transparent">
                <a href="#" class="btn btn-outline-primary btn-sm" aria-label="자세히 보기 2">View</a>
            </div>
        </div>
    </div>

    <div class="col">
        <div class="card h-100">
            <img src="assets/third.png" class="card-img-top" alt="세 번째 로컬 이미지"
                 style="object-fit:cover; aspect-ratio:16/9;">
            <div class="card-body">
                <h5 class="card-title">Card 3</h5>
                <p class="card-text">3번째 이미지</p>
            </div>
            <div class="card-footer bg-transparent">
                <a href="#" class="btn btn-outline-primary btn-sm" aria-label="자세히 보기 3">View</a>
            </div>
        </div>
    </div>

    <div class="col">
        <div class="card h-100">
            <img src="assets/third.png" class="card-img-top" alt="세 번째 로컬 이미지"
                 style="object-fit:cover; aspect-ratio:16/9;">
            <div class="card-body">
                <h5 class="card-title">Card 3</h5>
                <p class="card-text">3번째 이미지</p>
            </div>
            <div class="card-footer bg-transparent">
                <a href="#" class="btn btn-outline-primary btn-sm" aria-label="자세히 보기 3">View</a>
            </div>
        </div>
    </div>

    <div class="col">
        <div class="card h-100">
            <img src="assets/third.png" class="card-img-top" alt="세 번째 로컬 이미지"
                 style="object-fit:cover; aspect-ratio:16/9;">
            <div class="card-body">
                <h5 class="card-title">Card 3</h5>
                <p class="card-text">3번째 이미지</p>
            </div>
            <div class="card-footer bg-transparent">
                <a href="#" class="btn btn-outline-primary btn-sm" aria-label="자세히 보기 3">View</a>
            </div>
        </div>
    </div>

    <div class="col">
        <div class="card h-100">
            <img src="assets/third.png" class="card-img-top" alt="세 번째 로컬 이미지"
                 style="object-fit:cover; aspect-ratio:16/9;">
            <div class="card-body">
                <h5 class="card-title">Card 3</h5>
                <p class="card-text">3번째 이미지</p>
            </div>
            <div class="card-footer bg-transparent">
                <a href="#" class="btn btn-outline-primary btn-sm" aria-label="자세히 보기 3">View</a>
            </div>
        </div>
    </div>


</div>

<jsp:include page="common/bottom.jsp"/>
