<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
<!--
		*{
            margin:0;
            padding:0;
            box-sizing: border-box;
        }
        #container{
            width: 100%;
            height: 100vh;
            display: flex;
            flex-direction:column;
            align-items: center;
        }
        #header{
            width: 100%;
            border-bottom: 1px solid #DADADA;
            display: flex;
            justify-content: center;
        }
        h1{
        	position: relative;
        	top:5%;
        	margin-bottom:20px;
        }
       #section{
            width: 43%;
            display: flex;
            flex-direction: column;
            align-items: center;
            position:relative;
            top: 5%;
        	border: 1px solid #DADADA;
        }
        
        th,td{
            padding: 15px 30px;
            border-bottom:1px solid #DADADA;
        }
</style>
<body>
	<!-- 유저 삭제, 유저 삭제시 로그인 했을 때 알림, 유저 정지, 유저 자동 정지 해제 -->
	<div id="wrap">
		<div id="container">
			<div id="header">
				<div><a href="/main"><img src="${path}/resources/image/siteLogo.png" alt=""></a></div>
			</div>
			<h1>회원관리 페이지</h1>
			<div id="section">
				<table style="border-collapse: collapse;">
					<thead>
						<tr>
							<th class="table_title">아이디</th>
							<th class="table_writer">이름</th>
							<th class="table_regdate">회원 상태</th>
							<th class="table_regdate">등급</th>
							<th class="table_regdate">정지 해제일</th>
						</tr>
					</thead>

					<tbody>
						<c:forEach var="row" items="${userList}">
							<tr>
								<td class="table_cate"><a
									href="/admin/userDetail?user_id=${row.user_id}">${row.user_id}</a></td>
								<td class="table_title">${row.user_name}</td>
								<td>
								<c:choose>
										<c:when test="${row.del_YN == 'N'}">
											 <td><span style="color:crimson;">탈퇴</span></td>
										</c:when>
										<c:when test="${row.authority == 'ROLE_PAUSE'}">
											<td><span style="color:blue">정지</span></td>
										</c:when>
										<c:otherwise>
									 		<td><span style="color:green">정상</span></td>
									 	</c:otherwise>	
									</c:choose>
									</td>
								<td class="table_writer">${row.authority == 'ROLE_USER' ? "일반 회원" : "**관리자**"}</td>

								<td class="table_writer">${row.pause_date}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>

</html>