<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<video width="90%" height="100%-100px" controls="controls">
			<source src="/teachervideo/${src }" type="audio/mp4"></source>
			<source src="/teachervideo/${src }" type="audio/ogg"></source>
			<source src="/teachervideo/${src }" type="video/webm"></source>
		</video>
	</body>
</html>