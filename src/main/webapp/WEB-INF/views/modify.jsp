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

<script type="text/javascript">
function CheckModify()
{
  var form = document.modifyform;
 
 	 if( !form.id.value )
 	 {
	  alert( "���̵� �Է����ּ���" );
 	  form.id.focus();
 	  return;
 	 }
 	 if( !form.pw.value )
 	 {
 	  alert( "��й�ȣ�� �Է����ּ���" );
 	  form.pw.focus();
 	  return;
 	 }
 	 if( !form.content.value )
 	 {
 	     alert( "������ �Է����ּ���" );
 	     form.content.focus();
 	     return; 	
 	  }

		form.submit();
	//	window.opener.parent.location.href = "${pageContext.servletContext.contextPath}/guestbook/list";
		
		window.opener.parent.location.href = "${pageContext.servletContext.contextPath}/guestbook/list";
	    
// 		window.close();


// 		$.ajax({
// 		       type: "POST",
// 		       url: "${pageContext.servletContext.contextPath}/guestbook/modify",
// 		       dataType: "form",      		       
// 		       success: function (data)
// 		       {
// 		    	   alert( "���۽� ����" );
// 		              window.close();
// 		       }
// 		})
}			
</script>


</head>
<body>

			<h1>MODIFY</h1>
	
		<h3> PARK �� ȯ���մϴ�</h3>      
		
		<form name="modifyform"  action ="${pageContext.servletContext.contextPath}/guestbook/modify" method="post">
		id : <input type= "text" name="id" value="${gvo.id}" > <br>
		pw : <input type= "password" name="pw" > <br>
			 <input type= "hidden" name="no" value="${gvo.no}"> <br>
		content : <textarea rows="20" cols="60" name = "content">${gvo.content}</textarea> <br> 
		<input type="button" value="modify" OnClick="javascript:CheckModify()">
		<input type="button" value="cancel" OnClick="javascript:history.back(-1)">

		</form>


</body>
</html>