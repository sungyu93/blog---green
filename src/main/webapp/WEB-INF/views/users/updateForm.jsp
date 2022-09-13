<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container">
	<button class="btn btn-danger">회원탈퇴</button>
	<form>
		<div class="mb-3 mt-3">
			<input type="text" class="form-control" placeholder="Enter username" name="username" value="${users.username}" readonly="readonly">
		</div>
		<div class="mb-3">
			<input type="password" class="form-control"
				placeholder="Enter password" name="password" value="${users.password}" >
		</div>
		<div class="mb-3">
			<input type="email" class="form-control" placeholder="Enter email" name="email" value="${users.email}" >
		</div>
		<button type="submit" class="btn btn-primary">회원수정완료</button>
	</form>
</div>

<%@ include file="../layout/footer.jsp"%>

