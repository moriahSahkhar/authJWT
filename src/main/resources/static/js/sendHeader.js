
$(document).ready(function() {

	const token = $("meta[name='_csrf']").attr("content");
	const jwt = $("meta[name='Bearer']").attr("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTY5MTM5MDQ5MywiZXhwIjoxNjkxMzkxOTMzfQ.Wq4tYsuiOwwsP6SXK1MycLzkL6-TVE2Vz9uRnA8oO2s");
	const header = $("meta[name='_csrf_header']").attr("content");


	$("#loginForm").submit(function(e) {
            console.log("HERE")
    		e.preventDefault();
    		const formData = new FormData($(this)[0]);
    		$.confirm({
    			content: function() {
    				var self = this;
    				return $.ajax({
    					method: "POST",
    					url: "/login",
    					data: formData,
    					contentType: false,
    					cache: false,
    					processData: false,
    					beforeSend: function(request) {
    						request.setRequestHeader(header, token, jwt);
    					},
    				})
    					.done(function(response) {
    						self.close();
    					})
    					.fail(function() {
    						self.setContent("Something went wrong.");
    					});
    			}
    		});
    	});
});