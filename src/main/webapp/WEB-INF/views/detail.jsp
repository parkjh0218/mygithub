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
    	
        listReply(); // 댓글 목록 호출        
        
        // 댓글작성버튼
        $("#btnReply").click(function(){        	
            var content=$("#content").val();
            var b_no="${vo.no}"
            var param="content="+content+"&b_no="+b_no;            
            $.ajax({
                type: "post",
                url: "${pageContext.servletContext.contextPath}/reply/insert",
                data: param,
                success: function(result){
                    alert("댓글이 등록되었어.");
                    listReply();
                },
              error : function(request, status, error) {            	  
                    //alert("insert에러발생");
                    alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
              }
            });
        });
            
        
        $("#btnDelete").click(function(){
            if(confirm("삭제할래 ?")){
                document.form1.action = "${pageContext.servletContext.contextPath}/board/delete";
                document.form1.submit();
            }
        });
        
        $("#btnUpdete").click(function(){            
            var id = $("#id").val();
            var content = $("#content").val();
            var writer = $("#id").val();
            if(title == ""){
                alert("제목을 입력해");
                document.form1.title.focus();
                return;
            }
            if(content == ""){
                alert("내용 입력해");
                document.form1.content.focus();
                return;
            }
            if(id == ""){
                alert("id 입력해");
                document.form1.writer.focus();
                return;
            }
            if(confirm("수정할거니?")){
            document.form1.action="${pageContext.servletContext.contextPath}/board/update"
            // 폼에 입력한 데이터를 서버로 전송
            document.form1.submit();
            }
        });
        
        $("#btnlist").click(function(){       
        	if(confirm("목록갈래?")){
                document.form1.action = "${pageContext.servletContext.contextPath}/board/list";
                document.form1.submit();
        	}
        });

    });
           
    
    // 댓글 목록
    function listReply(){
        $.ajax({
            type: "get",
            url: "${pageContext.servletContext.contextPath}/reply/list/${vo.no}",
            success: function(result){
            // responseText가 result에 저장됨.
            alert("listReply에 출력 ");
                $("#listReply").html(result); //댓글출력
            },
            error : function(xhr, status, error) {
                alert("에러발생");
            }
        });
    }
    
    
    
</script>
</head>
<body>
<h2>게시글 보기</h2>
<form name="form1" method="post">
        작성일 : ${vo.timestamp}                   
    <div>
        조회수 : ${vo.hit}
    </div>
    <div>
        제목
        <input name="title" id="title" size="80" value="${vo.title}" placeholder="제목을 입력해주세요">
    </div>
    <div>
        내용
        <textarea name="content" id="content" rows="4" cols="80" placeholder="내용을 입력해주세요">${vo.content}</textarea>
    </div>
    <div>
        아이디
        <input name="id" id="id" value="${vo.id}" placeholder="id 입력해주세요">
    </div>
    <div style="width:650px; text-align: center;">
        <!-- 게시물번호를 hidden-->
        <input type="hidden" name="no" value="${vo.no}">
        
        <button type="button" id="btnUpdete">수정</button>
        <button type="button" id="btnDelete">삭제</button>
        <button type="button" id="btnlist">목록</button>
    </div>
</form>

  <div style="width:650px; text-align: center;">
        <br>
        <!-- 로그인 한 회원에게만 댓글 작성폼 보일수 있도록  
        <c:if test="${sessionScope.userId != null}">
        !-->    
        <textarea rows="5" cols="80" id="replytext" name= "replytext" placeholder="댓글을 작성해주세요"></textarea>
        <br>
        <button type="button" id="btnReply">댓글 작성</button>
        <!-- </c:if>  -->
    </div>
    <!-- **댓글 목록 출력할 위치 -->
    <div id="listReply"></div>

</body>
</html>