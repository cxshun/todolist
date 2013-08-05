$(document).ready(function(){
	
	//输入todoitem内容后，回车添加条目
	$("input[name='todoItem.content']").keydown(function(e){
		if (e.keyCode == 13) {
			var content = $(this).val();
			var actionUrl = $(this).attr("data-actionUrl");
			var getLastestItemUrl = $(this).attr("data-getUrl");
			$.ajax({
				url:actionUrl,
				type:"post",
				data:{"todoItem.content":content,"todoItem.isFinished":false},
				success:function(data) {
					//清空输入框
					$("input[name='todoItem.content']").val("");
					//成功的情况下直接在下面的列表中添加一项,但在添加前需要先获取新添加的ID
					$.ajax({
						url:getLastestItemUrl,
						type:"get",
						success:function(data) {
							appendLi($("#unfinished ul li:eq(0)"),data,content);
						}
					});
				}
			});
		}
	});
	
	//添加li到列表
	function appendLi($itemToAppend,itemId,content) {
		$itemToAppend.after(
				"<li class='clearfix' data-itemid='"+itemId+"'>" + 
				"<label class='checkbox pull-left'><input type='checkbox' name='isFinished' value='true' />" + 
				content + "</label>" + 
				"<span class='pull-right'>" +
				"<button type='button' class='close' >&times;</button>" + 
				"</span></li>");
	}
	
	//在删除窗口中点取消时隐藏当前的窗口
	$(".cancel").click(function() {
		$("#myModal").modal("hide");
	});
	
	//点击确定时删除该条记录
	$(".ok").click(function() {
		$.ajax({
			url:deleteUrl + "?todoItem.id=" + id,
			type:"get",
			success:function() {
				$currentLi.remove();
			}
		});
		$("#myModal").modal("hide");
	});
	//点击关闭按钮时删除该条记录
	$("body").on("click",".close",//删除元素
		function deleteItem() {
			deleteUrl = $("input[name='todoItem.content']").attr("data-deleteUrl");
			id = $(this).parents("li").attr("data-itemid");
			$currentLi = $(this).parents("li");
			
			$("#myModal").modal("show");
		});
	
	hasLoaded = false;//记录是否已经加载过
	//当点击已完成时，再去加载已经完成的列表
	$("a[href='#finished']").click(function(){
		//不进行重复加载
		if (!hasLoaded) {
			var listUrl = $(this).attr("data-listUrl");
			$.ajax({
				url:listUrl,
				data:{"todoItem.isFinished":true},
				type:"get",
				success:function(data) {
					$("#finished ul li:gt(0)").remove();
					for (tmp in data) {
						$("#finished").find("ul").append(
								"<li class='clearfix' data-itemid='"+data[tmp]["id"]+"'>" + 
								"<label class='checkbox pull-left'><input type='checkbox' name='isFinished' value='false' />" + 
								data[tmp]["content"] + "</label>" + 
								"<span class='pull-right'>" +
								"<button type='button' class='close' >&times;</button>" + 
								"</span></li>");
						hasLoaded = true;
					}
				}
			});
		}
	});
	
	$("body").on("click",".checkbox input",function(){
		var $currentLi = $(this).parents("li");
		var updateUrl = $("input[name='todoItem.content']").attr("data-updateUrl");
		var content = $(this).parent().text();
		var divId = $(this).parents("div").attr("id");
		var isFinished = $(this).val();
		$.ajax({
			url: updateUrl,
			type: "post",
			data: {"todoItem.content":content,"todoItem.id":$currentLi.attr("data-itemid"),"todoItem.isFinished":isFinished},
			success: function(){
				if (divId == "unfinished") {
					appendLi($("#finished ul li:eq(0)"), $currentLi.attr("data-itemid"), content);
				} else {
					appendLi($("#unfinished ul li:eq(0)"),$currentLi.attr("data-itemid"),content);
				}
				$currentLi.hide("slow",function(){
					$currentLi.remove();
				});
			}
		});
	});
	
	//点击更多按钮时的处理
	$(".refresh").click(function() {
		$that = $(this);
		$(this).button("loading");
		if ($("#unfinished:visible")) {
			$current_div = $("#unfinished");
			isFinished = false;
		} else {
			$current_div = $("#finished");
			isFinished = true;
		}
		$.ajax({
			url:$that.attr("data-listUrl"),
			type:"post",
			data:{"pageBean.startIndex": 0,
				"pageBean.endIndex":$current_div.children("input").attr("data-endIndex"),
				"todoItem.isFinished":isFinished},
			success:function(data){
				//删除当前的所有条目
				$current_div.find("ul li:gt(0)").remove();
				for (tmp in data) {
					$current_div.find("ul").append(
							"<li class='clearfix' data-itemid='"+data[tmp]["id"]+"'>" + 
							"<label class='checkbox pull-left'><input type='checkbox' name='isFinished' value='false' />" + 
							data[tmp]["content"] + "</label>" + 
							"<span class='pull-right'>" +
							"<button type='button' class='close' >&times;</button>" + 
							"</span></li>");
				}
				$that.button("reset");
			}
		});
		
	});
	
	//点击重新加载按钮时的处理
	$(".more").click(function() {
		$that = $(this);
		$that.button("loading");
		//判断当前显示的是那个tab，刷新的时候只针对该tab
		current_div = $(this).parents("div:eq(0)").attr("id");
		$current_div = $("#" + current_div);
		if (current_div == "unfinished") {
			isFinished = false;
		} else {
			isFinished = true;
		}
		$.ajax({
			url:$that.attr("data-listUrl"),
			type:"post",
			data:{"pageBean.startIndex":$that.attr("data-endIndex"),
				"pageBean.endIndex":0,
				"todoItem.isFinished":isFinished},
			success:function(data){
				for (tmp in data) {
					$current_div.find("ul").append(
							"<li class='clearfix' data-itemid='"+data[tmp]["id"]+"'>" + 
							"<label class='checkbox pull-left'><input type='checkbox' name='isFinished' value='false' />" + 
							data[tmp]["content"] + "</label>" + 
							"<span class='pull-right'>" +
							"<button type='button' class='close' >&times;</button>" + 
							"</span></li>");
				}
				$that.attr("data-endIndex",parseInt($that.attr("data-endIndex")) + data.length);
				$that.button("reset");
			}
		});
	});
});