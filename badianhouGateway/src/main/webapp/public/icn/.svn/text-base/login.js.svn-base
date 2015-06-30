$(function() {

});
function verifiy() {
	$("#verifiyForm").ajaxSubmit({
		beforeSubmit : function(arr, $form, options) {
			if ($doValidForm($form)) {
				return true;
			}
			return false;
		},
		success : function(data) {
			if (data.code == successStatus) {
				alert("验证码为："+data.payload);
			} else {
				alert(data.msg);
			}
		},
		error : function() {
		}
	});

}