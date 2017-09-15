<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<body>
<div id="wrapper">
<div id="container">
	<img src="${path.img}/login111.png" alt="" /><br />
	<mark style="color: red;">*ID는 숫자포함 8자 이내</mark><br />
<form id="login_box" name="login_box" >

         <!--do 서블릿  -->
         <fieldset class="form-edit">
            <legend>로그인</legend>
            <span class="login-span">ID</span> 
            <input type="text" id="input_id" name="id" value="son"/><br /> <label>PASSWORD</label>
            <input type="password"id="input_password" name="password" value="49"/><br />
            <br /> 
            <input type="reset" value="CANCEL" />
     		<input type="hidden" name="action" value="login">
            <input type="hidden" name="page" value="main">
            <input type="submit" id="loginBtn" value="로그인"  class="submit-pink" >
         </fieldset>
      </form>
      <div style="text-align:center";>
      <h2 style="font-size: 20px; color:blue; ">${msg}</h2>
      </div>
	
</div>

	</div>
	<script>
	app.auth.init();
	</script>
</body>
</html>