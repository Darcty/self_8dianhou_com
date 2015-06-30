var menu_data = {};
var checkin_object;
var dfd = $.Deferred();
var login_interval = setInterval(function() {
	$.ajax({
		url : ctxRoot + "/check-session",
		cache : false,
		success : function(data) {
			if (data.indexOf("true") > -1) {
				// location.replace(ctxRoot + "/login/logout");
			}
		}
	});
}, 120000);

jQuery(document).ready(function() {
	$(document).tooltip({
		track : true
	});

});
// 设置ajax调用全局参数
jQuery.ajaxSetup({
	type : "POST",
	contentType : "application/x-www-form-urlencoded; charset=UTF-8"
});

function converHtml(e) {
	if (!e) {
		e = $(document);
	}
	e.find("div[tabs]").tabs();
	e.find("select[ek-select-80]").attr('ek-select-80', 'ui-haier-select-80');
	e.find("select[ek-select-100]").attr('ek-select-100', 'ui-haier-select-100');
	e.find("select[ek-select-160]").attr('ek-select-160', 'ui-haier-select-160');
	e.find("select[ek-select-210]").attr('ek-select-210', 'ui-haier-select-210');
	e.find("select[ek-select-226]").attr('ek-select-226', 'ui-haier-select-226');
	e.find("input[readonly]").addClass('ui-haier-disabled');
	e.find("textarea[readonly]").addClass('ui-haier-disabled');

	e.find("button[ek]").each(function() {
		var btn = $(this);
		var type = btn.attr("ek");
		if (type && type != "") {
			if ("add" == type) {
				type = "plus";
			} else if ("save" == type) {
				type = "disk";
			} else if ("delete" == type) {
				type = "circle-close";
			} else if ("reset" == type) {
				type = "gear";
			} else if ("active" == type) {
				type = "play";
			} else if ("disable" == type) {
				type = "pause";
			} else if ("search" == type) {
				type = "search";
			} else if ("export" == type) {
				type = "folder-open";
			} else if ("key" == type) {
				type = "key";
			} else if ("back" == type) {
				type = "arrowthick-1-w";
			} else if ("resubmit" == type) {
				type = "shuffle";
			} else if ("reject" == type) {
				type = "arrowreturnthick-1-s";
			} else if ("print" == type) {
				type = "print";
			} else if ("minus" == type) {
				type = "minus";
			}
			btn.button({
				icons : {
					primary : "ui-icon-" + type
				}
			});
		} else {
			btn.button();
		}
	});

	var calcInputs = $("input[calc]");
	calcInputs.each(function() {
		$(this).keyup(function() {
			var _calc = $(this).attr("calc").split(",");
			var _parentForm = $(this).parents("form").eq(0);
			var _name1 = _calc[0];
			var _name2 = _calc[1];
			var _v2 = $(_parentForm).find(_name1).val();
			if (_name1 && _name2 && _v2) {
				var _v = $(this).val();
				var _totalMoney = _v * _v2;
				$(_parentForm).find(_name2).val(_totalMoney.toFixed(2));
			}
		});
	});

	//
	var dictCodes = [];
	var select = e.find("select[dict]:visible");
	if (select.length == 0 && e.attr("dict")) {
		select = e;
	}
	select.each(function() {
		dictCodes.push($(this).attr("dict"));
	});
	var tpl_dict = $("#tmpl-select");
	if (dictCodes.length > 0) {
		$.ajax({
			url : ctxRoot + "/dict/fill/list.compress",
			data : {
				dictCodes : dictCodes.join(",")
			},
			success : function(data) {
				select.each(function() {
					var $this = $(this);
					var d = data[$this.attr("dict")];
					if (d) {
						var v = $this.attr("v");
						if ($this.attr("d")) {
							$this.html(tpl_dict.render(d));
							if (v) {
								$this.attr("value", v);
							}
						} else {
							$this.html("<option value=''>-请选择-</option>");
							$this.append(tpl_dict.render(d));
							$this.attr("value", v);
						}
						$this.combobox();
					}
				});
			}
		});
	}
	$("input[sys-tip]").each(function() {
		var obj = $(this);
		var tip = obj.attr("sys-tip");
		var v = obj.val();
		if (!v) {
			obj.val(tip);
		}

		$(this).on('focusin', function() {
			var obj = $(this);
			var tip = obj.attr("sys-tip");
			var v = obj.val();
			if (v == tip) {
				obj.val('');
			}
		});
		$(this).on('focusout', function() {
			var obj = $(this);
			var tip = obj.attr("sys-tip");
			var v = obj.val();
			if (!v) {
				obj.val(tip);
			}
		});

	});
}
// 表单验证
function $doValidForm(ob) {
	var errorImg = "<img  align='absmiddle' src='" + ctxRoot + "/res/images/error.png' />";
	$(ob).find(".warning").remove();
	var flag = true;
	$(ob).find("input[require]:visible").each(function() {
		var tip = $(this).attr("sys-tip");
		var v = $(this).val();
		if (tip == v) {
			v = "";
		}
		if (v == "") {
			$(this).effect('pulsate', "slow").focus();
			flag = false;
			$(this).after("<span class='warning' title='必填.'>" + errorImg + "</span>");
		}
	});
	$(ob).find("select[require]:visible").each(function() {
		if ($(this).val() == "") {
			$(this).effect('pulsate', "slow").focus();
			flag = false;
			$(this).after("<span class='warning' title='必填.'>" + errorImg + "</span>");
		}
	});
	$(ob).find("input[number]:visible").each(function() {
		if (isNaN($(this).val())) {
			$(this).effect('pulsate', "slow").focus();
			flag = false;
			$(this).after("<span class='warning' title='必须为数字.'>" + errorImg + "</span>");
		}
	});
	$(ob).find("input[plusNumber]:visible").each(function() {
		if (isNaN($(this).val())) {
			$(this).effect('pulsate', "slow").focus();
			flag = false;
			$(this).after("<span class='warning' title='必须为数字.'>" + errorImg + "</span>");
		} else if ($(this).val() < 0) {
			$(this).effect('pulsate', "slow").focus();
			flag = false;
			$(this).after("<span class='warning' title='必须为正数.'>" + errorImg + "</span>");
		}
	});
	$(ob).find("input[regex]:visible").each(function() {
		if ($(this).val() != "") {
			var reg = new RegExp($(this).attr("regex"));
			if (!reg.test($(this).val())) {
				$(this).effect('pulsate', "slow").focus();
				flag = false;
				$(this).after("<span class='warning' title='" + $(this).attr("msg") + "'>" + errorImg + "</span>");
			}
		}
	});

	$(ob).find("textarea[require]:visible").each(function() {
		if ($(this).val() == "") {
			$(this).effect('pulsate', "slow").focus();
			flag = false;
			$(this).after("<span class='warning' title='必填.'>" + errorImg + "</span>");
		}
	});

	$(ob).tooltip({
		items : ".warning",
		position : {
			my : "right bottom",
			at : "right top"
		}
	});

	return flag;
}

function $showValidWarning(el, msg) {
	var errorImg = "<img  align='absmiddle' src='" + ctxRoot + "/res/images/error.png' />";
	$(el).find(".warning").remove();
	el.effect('pulsate', "slow").focus();
	el.after("<span class='warning' title='" + msg + "'>" + errorImg + "</span>");
	return false;
}

function generateFormData(obj) {
	var conditions = obj.find("input[name],select[name]");
	var formdata = {};
	conditions.each(function() {
		var name = $(this).attr("name");
		var val = $(this).val();
		if (val) {
			if ($(this).attr("type") == "radio") {
				if ($(this).attr("checked")) {
					formdata[name] = val;
				}
			} else {
				formdata[name] = val;
			}
		}
	});
	return formdata;
}

function showCenter(url) {
	if (url != "") {
		window.location.href = ctxRoot + url;
	}
}

function initLoadSelectByName(name, value) {
	$("select[name='" + name + "']").combobox("destroy");
	$("select[name='" + name + "']").attr('v', value);
	$("select[name='" + name + "']").val(value);
	$("select[name='" + name + "']").combobox();
}

// 获取多选值
function getChkIdEntity(entityName) {
	var ids = "";
	var chkeds = $("input:checkbox[name='" + entityName + "'][checked]");
	idsArr = new Array();
	chkeds.each(function(i) {
		idsArr.push($(this).val());
	});
	ids = idsArr.join(",");
	return ids;
}

function StringBuffer() {
	this.b = [];
};
StringBuffer.prototype.append = function(a) {
	this.b.push(a);
};
StringBuffer.prototype.toString = function() {
	return this.b.join("");
};
StringBuffer.prototype.clear = function() {
	var count = this.b.length;
	for (var i = count; i > 0; i--) {
		this.b.pop();
	}
};
