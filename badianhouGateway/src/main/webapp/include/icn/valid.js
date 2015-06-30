var ek = ek || $.noop;

ek.loginName = function(s) {// 验证用户名：3-20个以字母开头、可带数字、“_”的字串
	var patrn = /^[a-zA-Z0-9]{1}([a-zA-Z0-9]|[_]){2,19}$/;
	if (!patrn.exec(s)) {
		return false;
	} else {
		return true;
	}
};
ek.passWord = function(s) {// 验证密码：大小写字符、数字、下划线，长度6-18
	return (/^[a-zA-Z0-9]{6,18}$/).test(s) && (/[0-9]+/).test(s) && (/[a-zA-Z]+/).test(s);// //6-18位字母和数字组合，不能全为数字或全为字母
};
ek.isUrlOK = function(s) { // /验证URL
	var patrn = /(http:\/\/)?([\w-]+\.)+[\w-]+(\/[\w-.\/?%&=]*)?$/;
	if (!patrn.exec(s)) {
		return false;
	} else {
		return true;
	}
};
ek.isDateOk = function(s) {// 验证日期
	s = s.replace(/\//gi, '-');
	var patrn = /(^\d{4}-\d{1,2}-\d{1,2}[\ ](\d{1}|[0-1][0-9]|2[0-3]):(\d{1}|[0-5][0-9]):(\d{1}|[0-5][0-9])$)|(^\d{4}-\d{1,2}-\d{1,2}$)/;
	if (!patrn.exec(s)) {
		return false;
	} else {
		return true;
	}
};
ek.isTelOk = function(s) {// 验证电话
	var patrn = /^((\+)?86-)?\d{3,4}-\d{7,8}$/;
	if (!patrn.exec(s)) {
		return false;
	} else {
		return true;
	}
};
ek.isFaxOK = function(s) {// 验证执传真
	var patrn = /^[+]{0,1}(\d){1,3}[ ]?([-]?((\d)|[ ]){1,12})+$/;
	if (!patrn.exec(s)) {
		return false;
	} else {
		return true;
	}
};
ek.isPostalCode = function(s) {// 验证邮政编码
	var patrn = /^\d{6}$/;
	if (!patrn.exec(s)) {
		return false;
	} else {
		return true;
	}
};
ek.isMobile = function(s) {// 必须以数字开头，除数字外，可含有“-”
	var patrn= /^(?:13\d|15\d|18\d)\d{5}(\d{3}|\*{3})$/;
	if (!patrn.exec(s)) {
		return false;
	} else {
		return true;
	}
};
ek.isEMail = function(s) {// 验证EMAIL
	var patrn = /^[\w-]+(\.[\w-]+)*@[\w-]+(\.[\w-]+)+$/;
	if (!patrn.exec(s)) {
		return false;
	} else {
		return true;
	}
};
ek.isChina = function(s) {// 验证中文
	var patrn = /^[\u4e00-\u9fa5]+$/;
	if (!patrn.exec(s)) {
		return false;
	} else {
		return true;
	}
};
ek.isOrMath = function(s) {// 验证正数或者小数
	var patrn = /^[0-9]+$|^[0-9]+\.[0-9]+$/;
	if (!patrn.exec(s)) {
		return false;
	} else {
		return true;
	}
};
ek.isZMath = function(s) {// 验证正整数
	var patrn = /^[0-9]+$/;
	if (!patrn.exec(s)) {
		return false;
	} else {
		return true;
	}
};
ek.isNumEn = function(s) {// 验证由数字和26个英文组成的字符串
	var patrn = /^[A-Za-z0-9]+$/;
	if (!patrn.exec(s)) {
		return false;
	} else {
		return true;
	}
};
ek.isEnStr = function(s) {// 由26个英文字母组成的字符串
	var patrn = /^[A-Za-z]+$/;
	if (!patrn.exec(s)) {
		return false;
	} else {
		return true;
	}
};
ek.isMinusNum = function(s) {// 负正数
	var patrn = /^-[0-9]+$/;
	if (!patrn.exec(s)) {
		return false;
	} else {
		return true;
	}
};
ek.isMinusXnum = function(s) {// 负小数
	var patrn = /^-(\d)+\.(\d)+$/;
	if (!patrn.exec(s)) {
		return false;
	} else {
		return true;
	}
};
ek.isPrice = function(s) {// 小数、正整数 modify by dxx 20100720 前面加多个0也正确
	var patrn = /(^0*[1-9]+\d*\.\d*[1-9]$)|(^0*0\.\d*[1-9]$)|^0*[1-9]\d*|0$/;
	if (!patrn.exec(s)) {
		return false;
	} else {
		return true;
	}
};
ek.isTelNum = function(s) {// 7-8位非负整数
	var patrn = /^\d{7,8}(\/\d{7,8})?$/;
	if (!patrn.exec(s)) {
		return false;
	} else {
		return true;
	}
};
ek.isQQ = function(s) {// 是否QQ号码
	var patrn = /^\d{5,12}$/;
	if (!patrn.exec(s)) {
		return false;
	} else {
		return true;
	}
};
ek.isEmpty = function(s) {// 空值
	var patrn = /^\s*$/;
	if (!patrn.exec(s)) {
		return false;
	} else {
		return true;
	}
};
ek.isCard = function(s) {// 验证身份证号码
	var patrn = /^(\d{15}$|^\d{18}$|^\d{17}(\d|X|x))$/;
	if (!patrn.exec(s)) {
		return false;
	} else {
		return true;
	}
};