$.widget("custom.combobox", {
	_create : function() {
		this.wrapper = $("<span>").addClass("custom-combobox").insertAfter(this.element);

		this.element.hide();
		this._createAutocomplete();
		this._createShowAllButton();
	},

	_createAutocomplete : function() {
		var selected = this.element.children(":selected"), value = selected.val() ? selected.text() : "";
		var _selectName = this.element.attr("name");
		var _custom_combobox_name = "custom_combobox_input_" + _selectName;
		this.input = $("<input>").attr("id", _custom_combobox_name).appendTo(this.wrapper).val(value).attr("title", "")
				.addClass("custom-combobox-input").autocomplete({
					delay : 0,
					minLength : 0,
					source : $.proxy(this, "_source")
				}).tooltip({
					tooltipClass : "ui-state-highlight"
				});

		if (this.element.attr("require") != undefined) {
			this.input.attr("require", "");
		}
		var ek_select_80 = this.element.attr("ek-select-80");
		var ek_select_100 = this.element.attr("ek-select-100");
		var ek_select_160 = this.element.attr("ek-select-160");
		var ek_select_210 = this.element.attr("ek-select-210");
		var ek_select_226 = this.element.attr("ek-select-226");

		var ui_haier_select = "";
		if (ek_select_80 != undefined) {
			ui_haier_select = ek_select_80;
		}
		if (ek_select_100 != undefined) {
			ui_haier_select = ek_select_100;
		}
		if (ek_select_160 != undefined) {
			ui_haier_select = ek_select_160;
		}
		if (ek_select_210 != undefined) {
			ui_haier_select = ek_select_210;
		}
		if (ek_select_226 != undefined) {
			ui_haier_select = ek_select_226;
		}
		if (ui_haier_select != "") {
			// this.input.removeClass('custom-combobox-input');
			this.input.addClass(ui_haier_select);
		}

		if (this.element.attr("readonly") != undefined) {
			this.input.attr("readonly", true);
		}
		if (this.element.attr("readonly") != undefined) {
			this.input.attr("disabled", true);
			var _selectName_desc = _selectName + "_jq_auto_desc";
			this.element.before("<input readonly=\"true\" class=\"" + ui_haier_select
					+ " ui-haier-disabled\" type=\"text\" name=\"" + _selectName_desc + "\" id=\"" + _selectName_desc
					+ "\" value=\"" + selected.text() + "\">");
			this.element.before("<input class=\"" + ui_haier_select
					+ "ui-corner-all ui-haier-disabled\" type=\"hidden\" name=\"" + _selectName + "\" id=\""
					+ _selectName + "\" value=\"" + selected.val() + "\">");
			this.element.remove();
		}
		this._on(this.input, {
			autocompleteselect : function(event, ui) {
				ui.item.option.selected = true;
				this._trigger("select", event, {
					item : ui.item.option
				});
			},

			autocompletechange : "_removeIfInvalid"
		});
	},

	_createShowAllButton : function() {
		var input = this.input, wasOpen = false;

		$("<a>").attr("tabIndex", -1).attr("title", "Show All Items").tooltip().appendTo(this.wrapper).button({
			icons : {
				primary : "ui-icon-triangle-1-s"
			},
			text : false
		}).removeClass("ui-corner-all").addClass("custom-combobox-toggle ui-corner-right").mousedown(function() {
			wasOpen = input.autocomplete("widget").is(":visible");
		}).click(function() {
			if (input.attr("disabled") == undefined) {
				input.focus();
				// Close if already visible
				if (wasOpen) {
					return;
				}
				// Pass empty string as value to search for, displaying all
				// results
				input.autocomplete("search", "");
			}
		});
	},

	_source : function(request, response) {
		var matcher = new RegExp($.ui.autocomplete.escapeRegex(request.term), "i");
		response(this.element.children("option").map(function() {
			var text = $(this).text();
			if (this.value && (!request.term || matcher.test(text)))
				return {
					label : text,
					value : text,
					option : this
				};
		}));
	},

	_removeIfInvalid : function(event, ui) {

		// Selected an item, nothing to do
		if (ui.item) {
			return;
		}

		// Search for a match (case-insensitive)
		var value = this.input.val(), valueLowerCase = value.toLowerCase(), valid = false;
		this.element.children("option").each(function() {
			if ($(this).text().toLowerCase() === valueLowerCase) {
				this.selected = valid = true;
				return false;
			}
		});
		// Found a match, nothing to do
		if (valid) {
			return;
		}
		// Remove invalid value
		this.input.val("").attr("title", value + " didn't match any item").tooltip("open");
		this.element.attr('value',"");
		this.element.val("");
		this._delay(function() {
			this.input.tooltip("close").attr("title", "");
		}, 2500);
		this.input.data("ui-autocomplete").term = "";
	},

	_destroy : function() {
		this.wrapper.remove();
		this.element.show();
	}
});