<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 기본기능 -->
<%@  taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- 포멧 기능 (형식지정)-->
<%@  taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!-- 함수 기능 -->
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">


function Check()
{	
 	var form = document.checkform;
 	
	 if( !form.pw.value )
	 {
		 alert( "비밀번호를 입력해주세요 좀" );
		return;
	 }
	 
	 form.submit();
}
	 
	 function Close()
	 {
		 window.close();
		 
	 }
	 
	 
//   window.opener.parent.location.href = "${pageContext.servletContext.contextPath}/guestbook/list";
// 	 self.close();

	 
// 	 switch(window.name)
// 	 {
// 	 case "update":{ 
// 		 	window.opener.parent.location.href = "${pageContext.servletContext.contextPath}/guestbook/modifyform";
		 	
// 		 	form.submit(); 
// 		 	break;
// 	                }
// 	 case "delete":{	  
// 			window.opener.parent.location.href = "${pageContext.servletContext.contextPath}/guestbook/deleteform";
// 			form.submit();
// 			break;
// 					}
//      }

// 	 window.close();

</script>

</head>

<body>

<!-- 		<form name="checkform" method="post"> -->
<!-- 		비밀번호를 입력해주세요 -->
<%-- 		<input type="hidden" name="no" value="${no}"> --%>
<!-- 		<input type= "password" name="pw"> -->
<!-- 		<input type="button" value= "입력" OnClick="javascript:Check();"> -->
<!-- 		<input type="button" value="취소" OnClick="javascript:history.back(-1)"> -->
<!-- 		</form> -->


	<c:set var="ch" value="${m.check}"/>
	
	<c:choose>
	<c:when test="${ch eq '1'}">
		<form name="checkform" action="${pageContext.servletContext.contextPath}/guestbook/modifyform" method="post">
		비밀번호를 입력해주세요
		
		<input type= "password" name="pw">
		<input type="hidden" name="no" value="${m.no}">
		<input type="button" value= "입력" OnClick="Check()">
		<input type="button" value="취소" OnClick="Close()">
		
		
		</form>
		

	</c:when>	
	
	<c:when test="${ch eq '2'}">
		<form name="checkform" action="${pageContext.servletContext.contextPath}/guestbook/deleteform" method="post">
		비밀번호를 입력해주세요
		
		<input type= "password" name="pw">
		<input type="hidden" name="no" value="${m.no}">
		<input type="button" value= "입력" OnClick="Check()">
		<input type="button" value="취소" OnClick="Close()">
		</form>		
	</c:when>		
	</c:choose>	


</body>
</html>