<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>GMSSPL</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="${path.css}/common.css" />
<link rel="stylesheet" href="${path.css}/member.css" />
  <!--ㅡmember.js 호출  -->
  <script src="${path.js}/member.js"></script>
</head>
<div id="wrapper">
</head>
<body>
     <header>
           <div id="header">
           <tiles:insertAttribute name="header"/>
           </div>
     </header>
     <section>
           <article id="content">
                <tiles:insertAttribute name="content"/>
           </article>
     </section>
     <footer>
           <div id="footer">
                <tiles:insertAttribute name="footer"/>
           </div>
     </footer>
</body>
</html>