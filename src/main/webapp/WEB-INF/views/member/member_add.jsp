<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div id="container" class="margin-center" style="width: 500px;">
<img src="<%=request.getContextPath()%>/WEB-INF/resources/img/joinimg.jpg" alt="" />
<form id="join_form" >
<fieldset>
<legend>JOIN INFORMATION</legend>
<h3>회원가입 </h3>
<span id="join_id">ID: </span>
<input id="id" name="id" type="text" placeholder="ID" /><br />
<span id="join_pass" >PASSWORD: </span>
<input id="password" name="password" value="1" type="password" placeholder="비밀번호"/><br />
<span id="join_name">NAME: </span>
<input id="name" name="name"  type="text" placeholder="이름" value="이길동"/><br />
<span id="join_name">PHONE: </span>
<input id="phone" name="phone"  type="text" placeholder="전화번호" value="010-1234-5896"/><br />
<span id="join_birth">BIRTHDAY: </span>
<input id="ssn" name="ssn"  type="date" placeholder="생년월일" /><br />
<input type="radio" name="gender" value="male" checked="checked"/>남성
<input type="radio" name="gender" value="female" />여성<br />
<span id="join_email">EMAIL: </span>
<input type="email" id="email" name="email" value="leegildong@test.com"/>
<hr />
<h3>전 공</h3>
<select id ="major" name="major" style="height: 30px; display: inline-block;">
	<option value="computer" selected="selected">컴퓨터 공학</option>
	<option value="economics" >경제학</option>
	<option value="tourism">관광학</option>
	<option value="art">미술학</option>
</select><br />
<hr />
<h3>수강 과목</h3>
<input type="checkbox" name="subject" value="java" checked="checked"/>JAVA <br />
<input type="checkbox" name="subject" value="c" />C언어<br />
<input type="checkbox" name="subject" value="html" />HTML<br />
<input type="checkbox" name="subject" value="css" />CSS<br />
<input type="checkbox" name="subject" value="javascript" />자바스크립트<br />
<input type="checkbox" name="subject" value="sql" />SQL<br />
<input type="checkbox" name="subject" value="python" />PHTHON<br />
<input id="join_yes_button" type="submit" value="등록"/>
<input type="hidden" name="action" value="join"/>
<!-- <input type="hidden" name="page" value="main"/> -->
<input id="join_no_button" type="reset" value="취소"/>
</fieldset>
</form>
</div>
<script>
app.member.init();
</script>
