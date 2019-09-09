<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>


	<c:if test="${to.curPage > 1}">
		<c:choose>
			<c:when test="${empty cri}">
				<a href="listall.do?page=${to.curPage-1}" title="이전 페이지"> &laquo;
				</a>
			</c:when>
			<c:otherwise>
				<a
					href="fSearch.do?page=${to.curPage-1}&cri=${cri}&keyword=${keyword}"
					title="이전 페이지"> &laquo; </a>
			</c:otherwise>
		</c:choose>
	</c:if>


	<c:forEach begin="${to.bpn}" end="${to.spn}" var="i">


		<c:choose>
			<c:when test="${empty cri}">
				<a href="listall.do?page=${i}"> <c:if test="${i==to.curPage}">
						<font color="red" size="5em">${i}</font>
					</c:if> <c:if test="${i!=to.curPage}">${i}</c:if>
				</a>&nbsp;
      </c:when>
			<c:otherwise>
				<a href="fSearch.do?page=${i}&cri=${cri}&keyword=${keyword}"> <c:if
						test="${i==to.curPage}">
						<font color="green" size="5em">${i}</font>
					</c:if> <c:if test="${i!=to.curPage}">${i}</c:if>
				</a>&nbsp;
      </c:otherwise>
		</c:choose>


	</c:forEach>


	<c:if test="${to.curPage<to.totalPage}">
		<c:choose>
			<c:when test="${empty cri}">
				<a href="fList.do?page=${to.curPage+1}" title="다음 페이지"> &raquo;
				</a>
			</c:when>
			<c:otherwise>
				<a
					href="fSearch.do?page=${to.curPage+1}&cri=${cri}&keyword=${keyword}"
					title="다음 페이지"> &raquo; </a>
			</c:otherwise>
		</c:choose>
	</c:if>


</body>
</html>