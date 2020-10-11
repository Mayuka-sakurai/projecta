var status = true;

$(document).ready(function(){
	$("#checkID").click(function(){
		if($("#userid").val()){
			var query = {id:$("#id").val()};
		
		$.ajax({
			type:"post",
			url:"confirmID.jsp",
			data:query,
			success:function(data){
				if(data == 1) {
					alert("사용 불가능한 아이디 입니다");
					$("#id").val("");
				}else if(data == -1)
				alert("사용 가능한 아이디 입니다");
			}
		});
		}else{
			alert("아이디를 입력해주세요");
			$("#id").focus();
		}
		});
		$("#signup").click(function(){
			checkIt();
			
			if(status){
				var query = {
				id:$("#id").val(),
				password:$("#password").val(),
				password:$("#re-password").val(),
				email:$("#email").val(),
				name:$("#name").val(),
				address_main:$("#address_main").val(),
				address_detail:$("#address_detail").val(),
				tel:$("#tel").val()};
				
		$.ajax({
			type:"post",
			url:"registerPro.jsp",
			data:query,
			success:function(data){
				window.location.href("index.jsp");
			}
			
		});
			}
	
		
		
		$("#reset").click(function(){
			window.location.href("index.jsp");
		});
		
		
	function checkIt(){
		status = true;
		
		if(!$("#id").val()) {
			alert("아이디를 입력하세요");
			$("#id").focus();
			status = false;
			return false;
		}
		
		if($("#password").val()){
			alert("비밀번호를 입력해주세요");
			$("#password").focus();
			status = false;
			return false;
		}
		
		if(!$("#password").val() != $("#re-password").val()){
			alert("비밀번호가 서로 다릅니다");
			$("#re-password").focus();
			status = false;
			return false;
		}
		
		if($("#email").val()){
		alert("이메일을 입력해주세요");
		$("#email").focus();
		status = false;
		return false;
		
		}
		
		if($("#name").val()){
		alert("이름을 입력해주세요");
		$("#name").focus();
		status = false;
		return false;
		
		}
		
		if($("#address_main").val()){
		alert("기본 주소를 입력해주세요");
		$("#address_main").focus();
		status = false;
		return false;
		
		}
		
		if($("#address_detail").val()){
		alert("상세 주소를 입력해주세요");
		$("#address_detail").focus();
		status = false;
		return false;
		
		}
		
		if($("#tel").val()){
		alert("전화번호를 입력해주세요");
		$("#tel").focus();
		status = false;
		return false;
		
		}
		
		
	});				