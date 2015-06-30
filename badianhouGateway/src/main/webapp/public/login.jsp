<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="/include/base.jsp"%>
<script type="text/javascript" src="<%=path%>/public/icn/login.js"></script>
</head>
<body>
	<div>
		<div>
			<div style="margin-left: auto">
				<h1>
					欢迎使用8dianhouAPP
				</h1>
			<%-- 	<div>
					<form id="verifiyForm" action="<%=path%>/web/api/user/getMobileVerificationCode" method="post">
						<div>
							<input type="text" id="mobile" name="mobile" value="" title="用户名" require maxlength=40 />
						</div>
						<div>
							<input type="text" id="verificationCode" name="verificationCode" value="" title="密码" maxlength=40 />
						</div>
						<div>
							<input input type="button" value="登录" onclick="verifiy()" />
						</div>
					</form>
				</div> --%>
			</div>
		</div>
	</div>
</body>
</html>
