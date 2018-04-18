<%@  taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %> <!-- �⺻��� -->
<%@  taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %> <!-- ���� ��� (��������)-->
<%@  taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn" %> <!-- �Լ� ��� -->
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
        var strTime = "<H2>���� �ð��� ";
        strTime += today.getHours()+"�� ";
        strTime += today.getMinutes()+"�� "
        strTime += today.getSeconds()+"��. "
        document.write(strTime);
         
        setTimeout("location.reload()",6000)



    }
</script>
</head>
<body>

			<h1>GUESTBOOKLIST</h1>
	
		<h3> PARK �� ȯ���մϴ�</h3>      
		
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

					<input type=button value="����" OnClick="windowOpen('${pageContext.servletContext.contextPath}/guestbook/checkpw?no=${vo.no}&check=1')">
					<input type=button value="����" OnClick="windowOpen('${pageContext.servletContext.contextPath}/guestbook/checkpw?no=${vo.no}&check=2')">

				</tr>
		</c:forEach>	

		     <tr>
		         <td colspan="5">
<!--                ó���������� �̵� : ���� �������� 1���� ũ��  [ó��]�����۸�ũ�� ȭ�鿡 ��� -->
                <c:if test="${map.bp.curBlock > 1}">
                    <a href="javascript:list('1')">[ó��]</a>
                </c:if>
                
<!--                 ���������� ������� �̵� : ���� ������ ���� 1���� ũ�� [����]�����۸�ũ�� ȭ�鿡 ��� -->
                <c:if test="${map.bp.curBlock > 1}">
                    <a href="javascript:list('${map.bp.prevPage}')">[����]</a>
                </c:if>
                
<!--                 �ϳ��� �� �������������� ������������ �ݺ��� ���� -->
                <c:forEach var="num" begin="${map.bp.blockBegin}" end="${map.bp.blockEnd}">
<!--                     �����������̸� �����۸�ũ ���� -->
                    <c:choose>
                        <c:when test="${num == map.bp.curPage}">
                            <span style="color: red">${num}</span>&nbsp;
                        </c:when>
                        <c:otherwise>
                            <a href="javascript:list('${num}')">${num}</a>&nbsp;
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
                
<!--                 ���������� ������� �̵� : ���� ������ ���� ��ü ������ ������ �۰ų� ������ [����]�����۸�ũ�� ȭ�鿡 ��� -->
                <c:if test="${map.bp.curBlock <= map.bp.totalBlock}">
                    <a href="javascript:list('${map.bp.nextPage}')">[����]</a>
                </c:if>
                
<!--                 ���������� �̵� : ���� �������� ��ü ���������� �۰ų� ������ [��]�����۸�ũ�� ȭ�鿡 ��� -->
                <c:if test="${map.bp.curPage <= map.bp.totalPage}">
                    <a href="javascript:list('${map.bp.totalPage}')">[��]</a>
                </c:if>
            </td>
        </tr>       
		
			</table>

</body>
</html>