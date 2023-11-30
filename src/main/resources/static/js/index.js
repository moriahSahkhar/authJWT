$(document).ready(function() {

	/*get Captcha from form and modal*/
	const captcha = document.getElementById("captcha")
	const hiddenCaptcha = document.getElementById("hiddenCaptcha")
	const realCaptcha = document.getElementById("realCaptcha")
	const captchaModal = document.getElementById("captchaModal")
	const hiddenCaptchaModal = document.getElementById("hiddenCaptchaModal")
	const realCaptchaModal = document.getElementById("realCaptchaModal")
	/*end*/

	/*set in Modal*/
	hiddenCaptchaModal.value = hiddenCaptcha.value
	realCaptchaModal.src = "data:realCaptcha/jpg;base64," + realCaptcha.value;
	/*end*/

	checkCaptcha = () => {

		if (captchaModal.value != hiddenCaptchaModal.value) {
			captchaModal.value = "";

			Swal.fire({
				icon: "error",
				title: "Error!",
				text: "Captcha Does Not Match!",
				confirmButtonText: "Okay",
			});
		} else {
			captcha.value = captchaModal.value
		}
	};


	reloadCaptcha = () => {
		console.log("Here")
		$.ajax({
			url: "/refresh-captcha",
			method: "GET",
		})
			.done(function(response) {
				hiddenCaptcha.value = response.hiddenCaptcha;
				realCaptcha.value = response.realCaptcha;
				hiddenCaptchaModal.value = hiddenCaptcha.value
				realCaptchaModal.src = "data:realCaptcha/jpg;base64," + realCaptcha.value;
			})
			.fail(function() {
				self.setContent("Something went wrong.");
			});
	};

	doLogin = () => {
		const captchaCheck = document.getElementById("captchaModal")
		console.log(captchaCheck.value)

		if (captchaCheck.value === null || captchaCheck.value === "") {
			$.alert("Please Enter Captcha", "Verification Required")
		} else {
			document.getElementById("loginForm").submit();
		}

	}

	openSecurityModal = () => {
		const username = document.getElementById("username")
		const password = document.getElementById("password")

		if (username.value == null || username.value == "" || password.value == null || password.value == "") {
			$.alert("Please Enter Username/Password", "Missing Credentials");
		} else {
			$("#securityCheckModal").modal("show")
		}

	}
});