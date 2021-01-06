<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>파크센스의 개발보드 : 회원가입</title>
		<meta charset="UTF-8">
		<link href="/css/join.css" rel="stylesheet">
		<link href="/css/common.css" rel="stylesheet">
</head>
<body>
	<div id="back">
	<form name="all">
		<br></br>
		<a href="/Index"><img src="images/logo.jpg" style="width:100px;"></a>
		<ul class="all">
			<li>
				<h3>아이디</h3>
			</li>
			<li>
				<input type="text" name="id" class="c_id" autofocus="autofocus" placeholder="아이디">
				<input type="button" class="c_id_1" onClick="javascript:check_id()" value="중복검사">
				<input type="hidden" name="id_check_value">
			</li>
			<li>
				<h3>비밀번호</h3>
			</li>
			<li>
				<label for="pw"><input type="password" name="pw_1" class="c_password" placeholder="비밀번호"></label>
			</li>
			<li>
				<h3>비밀번호 재확인</h3>
			</li>
			<li>
				<label for="re_pw"><input type="password" name="pw_2" class="c_password" placeholder="비밀번호 재확인"></label>
			</li>
			<li>
				<h3>이름</h3>
			</li>
			<li>
				<label for="name"><input type="text" name="name" class="c_name" placeholder="이름"></label>
			</li>
			<li>
				<h3>생년월일</h3>
			</li>
			<li>
				<label for="bd"><input type="text" name="bd_1" class="c_bd" placeholder="년(4자)">
				<select name="bd_2" class="c_bd">
				    <option value="">월</option>
				    <option value="1">1</option>
				    <option value="2">2</option>
				    <option value="3">3</option>
				    <option value="4">4</option>
				    <option value="5">5</option>
				    <option value="6">6</option>
				    <option value="7">7</option>
				    <option value="8">8</option>
				    <option value="9">9</option>
				    <option value="10">10</option>
				    <option value="11">11</option>
				    <option value="12">12</option>
				</select>
				<input type="text" name="bd_3" class="c_bd" placeholder="일"></label>
			</li>
			<li>
				<h3>성별</h3>
			</li>
			<li>						
				<label for="sex">
					<select name="sex" class="c_sex">
					<option value="성별">성별</option>
				    <option value="남자">남자</option>
				    <option value="여자">여자</option>
				    </select>
				</label>
			</li>
			<li>
				<h3>연락처</h3>
			</li>
			<li>
				<label for="phone"><input type="text" name="phone_1" class="c_phone">
				<input type="text" name="phone_2" class="c_phone">
				<input type="text" name="phone_3" class="c_phone"></label>
			</li>
		</ul>
		<input type="button" class="c_id_2" value="회원가입" onClick="javascript:save()">
	</form>
	</div>
<script type="text/javascript">
	function check_id(){	
		var id = document.all.id.value;
	        if (id ==""){
	           alert("입력된 아이디가 없습니다.");
	           document.all.id.focus();
	        }else{
	        window.open("/Id_Check?id="+id,"아이디 중복검사","width=400, height=210");
	        }		
 	}
	function save(){			
		var form = document.all;
	    	if(form.id_check_value.value==""){
	        	alert("ID중복체크 하세요");
	            return;
	        }
	        
	    	if(form.id.value != form.id_check_value.value){
	            alert("ID변경 후 증복검사 하세요");
	            form.id.focus();
	            return;
	        }
	        
	        if(form.pw_1.value==""){
	        	alert("비밀번호를 입력하세요.");
	        	form.pw_1.focus();
	        	return;
	        }
	        if(form.pw_2.value==""){
	        	alert("비밀번호를 다시 확인해주세요.");
	        	form.pw_2.focus();
	        	return;
	        }
	        if(form.pw_1.value != form.pw_2.value){
	        	alert("비밀번호가 같지 않습니다.");
	            form.pw_1.focus();
	            return;
	        }
	        
	       if(form.name.value==""){
	    	   alert("이름을 입력하세요.");
	    	   form.name.focus();
	    	   return;
	       }
	       
	       if(form.bd_1.value==""){
	    	   alert("생년월일을 입력하세요.");
	    	   form.bd_1.focus();
	    	   return;
	       }
	       if(form.bd_2.value==""){
	    	   alert("생년월일을 입력하세요.");
	    	   form.bd_2.focus();
	    	   return;
	       }
	       if(form.bd_3.value==""){
	    	   alert("생년월일을 입력하세요.");
	    	   form.bd_3.focus();
	    	   return;
	       }
	       
	       if(form.sex.value=="성별"){
	    	   alert("성별을 선택해주세요.")
	    	   return;
	       }
	       
	       if(form.phone_1.value==""){
	    	   alert("연락처를 입력해주세요.");
	    	   form.phone_1.focus();
	    	   return;
	       }
	       if(form.phone_2.value==""){
	    	   alert("연락처를 입력해주세요.");
	    	   form.phone_2.focus();
	    	   return;
	       }
	       if(form.phone_3.value==""){
	    	   alert("연락처를 입력해주세요.");
	    	   form.phone_3.focus();
	    	   return;
	       }
       
        form.action="/Member_Proc";
        form.method="post";
        form.submit();
	        
     }
</script>			
</body>
</html>