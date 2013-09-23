/**
 * SopSoft.net版权所有
 * @author yangyudong：yyd-yyd@163.com
 */
/**
 *使用vForm对象来处理：结合 jQuery.validate和jQuery.Form使用
 * <br>通过ajax方式提交form,在提交前进行验证
 * @param fidObj:Form的ID或Form的jQuery对象
 */
// 定义vForm对象
function vForm(fidOrObj,conf){
	if(!fidOrObj)
		throw new Error("无法找到表单。");
	
	if(typeof fidOrObj == "string"){
		this.vf = $("#"+fidOrObj);
	} else {
		this.vf = fidOrObj;
	}
	
	var options={
		type:post,
		dataType:json,
		resetForm:true,
		timeout:10000
	};
	if(typeof(conf.type) != "undefined" && conf.type){
		options.type = conf.type;
	}
	if(typeof(conf.url) != "undefined" && conf.url){
		options.url = conf.url;
	}
	
	this.vf.ajaxForm(options);
	
}

/**
 * 设置Form
 * @param fidObj:Form的ID或jQuery对象
 */
vForm.setForm = function(fidObj){
	if(!fidObj)
		throw new Error("无法找到表单。");
	
	if(typeof fidObj == "string"){
		fidObj = $("#"+fidObj);
	}
	
	fidObj.ajaxForm();
};
