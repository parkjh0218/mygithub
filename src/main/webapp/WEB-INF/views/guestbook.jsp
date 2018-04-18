<%@  taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %> <!-- 기본기능 -->
<%@  taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %> <!-- 포멧 기능 (형식지정)-->
<%@  taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn" %> <!-- 함수 기능 -->
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript" >
	function windowOpen(url) {
		window.open(url,"", "width=600, height=400");
	}

    function list(page) {
        location.href="${pageContext.servletContext.contextPath}/guestbook/list?curpage="+page;
        
        var today = new Date();
        var strTime = "<H2>현재 시간은 ";
        strTime += today.getHours()+"시 ";
        strTime += today.getMinutes()+"분 "
        strTime += today.getSeconds()+"초. "
        document.write(strTime);
         
        setTimeout("location.reload()",6000)



    }
</script>
</head>
<body>

			<h1>GUESTBOOKLIST</h1>
	
		<h3> PARK 님 환영합니다</h3>      
		
		<form action ="${pageContext.servletContext.contextPath}/guestbook/insert" method="post">
		id : <input type= "text" name="id"> <br>
		pw : <input type= "password" name="pw" > <br>
		content : <textarea rows="20" cols="60" name = "content"></textarea> <br> 
		<input type="submit" value="write">			
		</form>
		
		<c:forEach items="${map.list}" var="vo" >
			<table width=510 border=1 >
				<tr>
				
					<td>${vo.no}</td>
					<td>${vo.id}</td>
					<td>${vo.content}</td>

					<input type=button value="수정" OnClick="windowOpen('${pageContext.servletContext.contextPath}/guestbook/checkpw?no=${vo.no}&check=1')">
					<input type=button value="삭제" OnClick="windowOpen('${pageContext.servletContext.contextPath}/guestbook/checkpw?no=${vo.no}&check=2')">

				</tr>
		</c:forEach>	

		     <tr>
		         <td colspan="5">
<!--                처음페이지로 이동 : 현재 페이지가 1보다 크면  [처음]하이퍼링크를 화면에 출력 -->
                <c:if test="${map.bp.curBlock > 1}">
                    <a href="javascript:list('1')">[처음]</a>
                </c:if>
                
<!--                 이전페이지 블록으로 이동 : 현재 페이지 블럭이 1보다 크면 [이전]하이퍼링크를 화면에 출력 -->
                <c:if test="${map.bp.curBlock > 1}">
                    <a href="javascript:list('${map.bp.prevPage}')">[이전]</a>
                </c:if>
                
<!--                 하나의 블럭 시작페이지부터 끝페이지까지 반복문 실행 -->
                <c:forEach var="num" begin="${map.bp.blockBegin}" end="${map.bp.blockEnd}">
<!--                     현재페이지이면 하이퍼링크 제거 -->
                    <c:choose>
                        <c:when test="${num == map.bp.curPage}">
                            <span style="color: red">${num}</span>&nbsp;
                        </c:when>
                        <c:otherwise>
                            <a href="javascript:list('${num}')">${num}</a>&nbsp;
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
                
<!--                 다음페이지 블록으로 이동 : 현재 페이지 블럭이 전체 페이지 블럭보다 작거나 같으면 [다음]하이퍼링크를 화면에 출력 -->
                <c:if test="${map.bp.curBlock <= map.bp.totalBlock}">
                    <a href="javascript:list('${map.bp.nextPage}')">[다음]</a>
                </c:if>
                
<!--                 끝페이지로 이동 : 현재 페이지가 전체 페이지보다 작거나 같으면 [끝]하이퍼링크를 화면에 출력 -->
                <c:if test="${map.bp.curPage <= map.bp.totalPage}">
                    <a href="javascript:list('${map.bp.totalPage}')">[끝]</a>
                </c:if>
            </td>
        </tr>       
		
			</table>

</body>
</html>