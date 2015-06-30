(function($) {
	var mouseOnDivFlag = false;
	var maopaoFade_fn = null;
	var obj;
	$.fn.notice = function(data) {
		obj = this;
		window.clearTimeout(maopaoFade_fn);
		this.dialog("destroy");
		initdialog(this);

		this.html(data);
		this.dialog("open");
		obj.bind("mouseover", function() {
			  window.clearTimeout(maopaoFade_fn);
		  });
		obj.bind("mouseout", function() {
			  maopaoFade_fn = window.setTimeout("closeDialog()", 2000);
		  });

	};
	closeDialog = function() {
		// alert(obj.attr("id"));
		if (obj.dialog("isOpen")) {
			obj.dialog("close");
			// $("#"+dialogid).dialog("destroy");
		}
	};
	initdialog = function(dialogObj) {

		obj.dialog({
			  autoOpen : false,
			  show : "clip",
			  modal : false,
			  width : 250,
			  height : 200,
			  minHeight : 200,
			  open : function() {
				  // closeDialog(dialogObj.attr('id'));
				  maopaoFade_fn = window.setTimeout("closeDialog()", 5000);
			  },
			  closeOnEscape : true,
			  buttons : {},
			  position : ['right', 'bottom'],
			  hide : "blind"
		  });
	};

})(jQuery);
