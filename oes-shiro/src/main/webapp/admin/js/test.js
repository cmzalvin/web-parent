$(document).ready(function() {

	$("button#getJson").click(function() {
		var username = $("input#username").val();
		$.ajax({
			type : "POST",
			data : "username=" + username,
			url : "kickoutUser.do",
			success : function(data) {
				if (data == "success") {
					alert("Success  kick out : " + username);
				} else {
					alert("no called : " + username);
				}
			},
			error : function() {
				alert("Failure");
			}

		});
	});

	$("#modify").bind("click", function() {
		var width = 500;
		var height = 300;
		openwindow("window.jsp", "aaa", 600, 300);
	}),

	$("button#hide").bind("click", function() {
		$("#showUsers").toggle(500);
	}),

	$("#testListPrincipal").bind("click", function() {
		$.ajax({
			type : "POST",
			url : "testListPrincipal.do",
			async : false,
			cache : true,
			beforeSend : function() {
				$("#showUsers").hide(500);
				$("#showUsers").html("");
			},
			success : function(data) {
				$("#showUsers").html("").append(data);
			},
			error : function() {
				alert("Fail");
			},
			complete : function() {
				$("#showUsers").show(500);
			}
		});
	});

	$("#testCheckbox").click(function() {
		var arr = $("input[name='aaa']:checked").map(function() {
			return this.value;
		}).get();
		$.ajax({
			type : "POST",
			url : "testCheckbox.do",
			async : false,
			data : "datas=" + arr,
			success : function(data) {
				alert("your data is : " + data);
			},
			error : function() {
				alert("Fail");
			}
		});
	});

	$("#testSelect").click(function() {
		var uuu = $("#sel").find("option:selected").val();
		$.ajax({
			type : "POST",
			url : "testSelect.do",
			data : "u=" + uuu,
			success : function(data) {
				alert("your select is : " + data);
			},
			error : function() {
				alert("Fail");
			}
		});
	});

	$("#testRadio").click(function() {
		var ppp = $("input[name='items']:checked").val();
		$.ajax({
			type : "POST",
			url : "testRadio.do",
			data : "o=" + ppp,
			success : function(data) {
				alert("your select is : " + data);
			},
			error : function() {
				alert("Fail");
			}
		});
	});

});

function findAllUsers() {
	$.ajax({
		type : "POST",
		url : "findAllUsers.do",
		success : function() {
			alert("success");
		},
		error : function() {
			alert("Fail");
		}
	});
}

function dynamicDataSource() {
	$.ajax({
		type : "POST",
		url : "dynamicDataSource.do",
		success : function(data, status) {
			if (status == "success") {
				alert(data);
			}
		},
		error : function() {
			alert("Fail");
		}
	});
}

function openwindow(url, name, iWidth, iHeight) {
	var iTop = window.screen.availHeight / 2 - iHeight / 2;
	var iLeft = window.screen.availWidth / 2 - iWidth / 2;
	window
			.open(
					url,
					name,
					"height="
							+ iHeight
							+ ",,innerHeight="
							+ iHeight
							+ ",width="
							+ iWidth
							+ ",innerWidth="
							+ iWidth
							+ ",top="
							+ iTop
							+ ",left="
							+ iLeft
							+ ",toolbar=no,menubar=no,scrollbars=auto,resizeable=no,location=no,status=no");
};

function kickout(username) {
	username = username.trim();
	if (username == "" || username == null) {
		alert("Please input username ...");
		noMethod();
	}
	if (username != "" || username != null) {
		$.ajax({
			type : "POST",
			data : "username=" + username,
			url : "kickoutUser.do",
			success : function(data) {
				if (data == "success") {
					alert("Success  kick out : " + username);
				} else {
					alert("no called : " + username);
				}
			},
			error : function() {
				alert("Failure");
			}

		});
	}
};

function initData(pageindx, url) {
	var datas = "offset=" + (pageindx);
	$.ajax({
		type : "POST",
		url : url,
		async : false,
		data : datas,
		success : function(data, status) {
			$("#pageDataList").html("").append(data);
		},
		error : function() {
			alert("Ajax load data fail !");
		}
	});

	if ($("#totalRecords").val() != 0) {
		$("#pagination").pagination($("#totalRecords").val(), {
			callback : pageselectCallback,
			prev_text : '<< 上一页',
			next_text : '下一页 >>',
			items_per_page : 2,
			num_display_entries : 6,
			current_page : pageindx,
			num_edge_entries : 2,
			jump_text : 'Jump'
		});
		function pageselectCallback(index) {
			initData(index, url);
		}
	} else {
		alert("No data !");
	}
}

// checkbox全选/反选
function checkBoxClick() {
	var clicked = $("#allBox").attr('checked');
	if (clicked)
		$('.subBox').attr('checked', true);
	else
		$('.subBox').attr('checked', false);

}

function add(url) {
	openwindow(url, "add", 800, 400);
}

function infoLoad(url, id) {
	openwindow(url + "?id=" + id, "update", 800, 400);
}

function update(url, id) {
	alert(url + "---" + id);
	openwindow(url + "!id=" + id, "update", 800, 400);
}

function deleteAll(url) {
	var arr = $("input[name='select']:checked").map(function() {
		return this.value;
	}).get();
	if (arr == null || arr == "") {
		alert("请至少选择一项 ......");
		return;
	}
	var c = confirm("确定删除选中项？");
	if (c) {
		$.ajax({
			type : "POST",
			url : url,
			data : "ids=" + arr,
			async : true,
			success : function(data) {
				if (data == "success") {
					alert("Delete allsuccess");
				} else {
					alert("Delete all fail");
				}
			},
			error : function() {
				alert("Ajax delete fail");
			}
		});

	}
}

function authorize(url, userId) {
	openwindow(url + "?userId=" + userId, "update", 800, 400);
}

function security(url, roleId) {
	openwindow(url + "?roleId=" + roleId, "update", 800, 400);
}

function save(url) {
	$(".uuu").each(function() {
		if ($(this).val() == "") {
			alert("not allow null");
			MethodNotExists();
		}
	});
	var form = jQuery("#form").serialize();
	$.ajax({
		type : "POST",
		url : url,
		async : false,
		data : form,
		success : function(data) {
			if (data == "success") {
				window.close();
			} else {
				alert("save fail");
			}
		},
		error : function() {
			alert("Ajax save fail");
		}
	});
}

function modify(url) {
	$(".uuu").each(function() {
		if ($(this).val() == "") {
			alert("not allow null");
			MethodNotExists();
		}
	});
	var form = jQuery("#form").serialize();
	$.ajax({
		type : "POST",
		url : url,
		async : false,
		data : form,
		success : function(data) {
			if (data == "success") {
				window.close();
			} else {
				alert("save fail");
			}
		},
		error : function() {
			alert("Ajax save fail");
		}
	});
}

function deleteById(url, id) {
	var c = confirm("确定删除？");
	if (c) {

		$.ajax({
			type : "POST",
			url : url,
			data : "id=" + id,
			async : true,
			success : function(data) {
				if (data == "success") {
					alert("Delete success");
				} else {
					alert("Delete fail");
				}
			},
			error : function() {
				alert("Ajax delete fail");
			}
		});
	}
}

function closeWindows() {
	window.close();
}

function userAllotRole(roleId, userId) {
	var current = $("#check" + roleId).attr("checked");
	if (current) {
		$.ajax({
			type : "POST",
			url : "admin/allot/userAllotRole.do",
			data : "roleId=" + roleId + "&userId=" + userId,
			async : false,
			success : function(data) {
				if (data == "success") {
					alert("success");
				} else {
					alert("allot fail");
				}
			},
			error : function() {
				alert("Ajax send fail ");
			}
		});
	} else {
		$.ajax({
			type : "POST",
			url : "admin/allot/userDisallotRole.do",
			data : "roleId=" + roleId + "&userId=" + userId,
			async : false,
			success : function(data) {
				if (data == "success") {
					alert("success");
				} else {
					alert("allot fail");
				}
			},
			error : function() {
				alert("Ajax send fail ");
			}
		});
	}
}
function resourceAllotRole(resourceId, roleId) {
	var current = $("#check" + resourceId).attr("checked");
	if (current) {
		$.ajax({
			type : "POST",
			url : "admin/allot/resourceAllotRole.do",
			data : "roleId=" + roleId + "&resourceId=" + resourceId,
			async : false,
			success : function(data) {
				if (data == "success") {
					alert("success");
				} else {
					alert("allot fail");
				}
			},
			error : function() {
				alert("Ajax send fail ");
			}
		});
	} else {
		$.ajax({
			type : "POST",
			url : "admin/allot/resourceDisallotRole.do",
			data : "roleId=" + roleId + "&resourceId=" + resourceId,
			async : false,
			success : function(data) {
				if (data == "success") {
					alert("success");
				} else {
					alert("allot fail");
				}
			},
			error : function() {
				alert("Ajax send fail ");
			}
		});
	}
}