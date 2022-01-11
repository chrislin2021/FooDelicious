<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://apis.google.com/js/platform.js" async defer></script>
<meta name="google-signin-client_id" content="xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.apps.googleusercontent.com">
</head>
<body>
<div class="g-signin2" data-onsuccess="onSignIn"></div>
<form method="post" action="login/success.jsp">
<input type="hidden" id="name" name="name">
<input type="hidden" id="img" name="img">
<input type="hidden" id="email" name="email">

</form>
<script>
function onSignIn(googleUser) {
	let profile = googleUser.getBasicProfile();
	document.getElementById("name").value=profile.getName();
	document.getElementById("img").value=profile.getImageUrl();
	document.getElementById("email").value=profile.getEmail();
	document.forms[0].submit();
	//console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
	//console.log('Name: ' + profile.getName());
	//console.log('Image URL: ' + profile.getImageUrl());
	//console.log('Email: ' + profile.getEmail()); // This is null if the 'email' scope is not present.
}
</script>
</body>
</html>