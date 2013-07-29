$(document).ready(function(){
	
	//点击保存按钮的时候，进行保存
	$("#save").click(function(){
		$("#save-form").attr("action",$(this).attr("data-action"));
		$("#save-form").submit();
	});
	
	$("#close").click(function(){
		$("#edit-div").modal("hide");
	});
	
});