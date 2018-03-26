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
        $("#btnSave").click(function(){            
            var title = $("#title").val();
            var content = $("#content").val();
            var id = $("#id").val();
            if(title == ""){
                alert("제목 입력해");
                document.form1.title.focus();
                return;
            }
            if(content == ""){
                alert("내용입력해");
                document.form1.content.focus();
                return;
            }
            if(id == ""){
                alert("이름입력해");
                document.form1.writer.focus();
                return;
            }            
            document.form1.submit();
        });
    });
</script>
</head>
<body>
<h2>게시글 작성</h2>
<form name="form1" method="post" action="${pageContext.servletContext.contextPath}/board/insert">
    <div>
        제목
        <input name="title" id="title" size="80" placeholder="제목을 입력해">
    </div>
    <div>
        내용
        <textarea name="content" id="content" rows="13" cols="80" placeholder="내용을 입력해주세요"></textarea>
    </div>
    <div>
     작성자 
        <input name="id" id="id" placeholder="작성자 아이디 ">
    </div>
    <div style="width:650px; text-align: center;">
        <button type="button" id="btnSave">확인</button>
        <button type="reset">취소</button>
    </div>
</form>
</body>
</html>