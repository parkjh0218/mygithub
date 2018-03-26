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
<script src="https://code.jquery.com/jquery-3.2.1.min.js">
</script>
<script>
    $(document).ready(function(){
        $("#btnWrite").click(function(){
            // 페이지 주소 변경(이동)
            alert("글쓰기 이동");
            location.href = "${pageContext.servletContext.contextPath}/board/write";
        });
    });
    
    
    //  페이지 이동
    function list(page) {
        location.href="${pageContext.servletContext.contextPath}/board/list?curpage="+page+"&search-${map.search}"+"&keyword=${map.keyword}";
    }
       
    
</script>
</head>
<body>
<h2>게시글LIST</h2>

<form name="form1" method="post" action="${pageContext.servletContext.contextPath}/board/list">
        <select name="searchOption">            
            <option value="all" <c:out value="${map.search == 'all'?'selected':''}"/> >전체</option>
            <option value="id" <c:out value="${map.search == 'id'?'selected':''}"/> >작성자</option>
            <option value="content" <c:out value="${map.search == 'content'?'selected':''}"/> >내용</option>
            <option value="title" <c:out value="${map.search == 'title'?'selected':''}"/> >제목</option>
        </select>
        <input name="keyword" value="${map.keyword}">
        <input type="submit" value="조회">        
    </form>
    
    게시글 개수 : ${map.count}개의 게시물.
  현 페이지 : ${map.bp.curPage}  
<table border="1" width="600px">
    <tr>
        <th>번호</th>
        <th>제목</th>
        <th>작성자</th>
        <th>작성일</th>
        <th>조회수</th>
    </tr>
    <c:forEach var="vo" items="${map.list}">
    <tr>
        <td>${vo.no}</td>
        <td><a href="${pageContext.servletContext.contextPath}/board/view/${vo.no}">${vo.title}         
         <span style ="color: red;">(${vo.replycount})</span>         
        </a>
        </td>
        <td>${vo.id}</td>
        <td>${vo.timestamp}</td>
        <td>${vo.hit}</td>
    </tr>    
    </c:forEach>         
    
       <tr>
            <td colspan="5">
                <!-- 처음페이지로 이동 : 현재 페이지가 1보다 크면  [처음]하이퍼링크를 화면에 출력-->
                <c:if test="${map.bp.curBlock > 1}">
                    <a href="javascript:list('1')">[처응]</a>
                </c:if>
                
                <!-- 이전페이지 블록으로 이동 : 현재 페이지 블럭이 1보다 크면 [이전]하이퍼링크를 화면에 출력 -->
                <c:if test="${map.bp.curBlock > 1}">
                    <a href="javascript:list('${map.bp.prevPage}')">[이전]</a>
                </c:if>
                
                <!-- 하나의 블럭 시작페이지부터 끝페이지까지 반복문 실행 -->
                <c:forEach var="num" begin="${map.bp.blockBegin}" end="${map.bp.blockEnd}">
                    <!-- 현재페이지이면 하이퍼링크 제거 -->
                    <c:choose>
                        <c:when test="${num == map.bp.curPage}">
                            <span style="color: red">${num}</span>&nbsp;
                        </c:when>
                        <c:otherwise>
                            <a href="javascript:list('${num}')">${num}</a>&nbsp;
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
                
                <!-- 다음페이지 블록으로 이동 : 현재 페이지 블럭이 전체 페이지 블럭보다 작거나 같으면 [다음]하이퍼링크를 화면에 출력 -->
                <c:if test="${map.bp.curBlock <= map.bp.totalBlock}">
                    <a href="javascript:list('${map.bp.nextPage}')">[다음]</a>
                </c:if>
                
                <!-- 끝페이지로 이동 : 현재 페이지가 전체 페이지보다 작거나 같으면 [끝]하이퍼링크를 화면에 출력 -->
                <c:if test="${map.bp.curPage <= map.bp.totalPage}">
                    <a href="javascript:list('${map.bp.totalPage}')">[끝]</a>
                </c:if>
            </td>
        </tr>       
    
    
</table><br>
<button type="button" id="btnWrite">글쓰기</button>

</body>
</html>