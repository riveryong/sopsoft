
/*
 *页面重要操作结束后，提示信息 
 *例如：注册成功、充值成功等对DB操作成功的提示信息
 */
function alertOperMsg(msg){
	if(msg == '' || msg == undefined){
		return;
	}
	
	Messenger.options = {
		extraClasses: 'messenger-fixed messenger-on-bottom',
		theme: 'ice'
	};
	
	Messenger().post(msg); 	
}

/*
 * 表单验证等提示信息
 * Example:
 * 调用alertMsg("#txtMemberNo","编号错误");
 * 其中：#txtMemberNo是编号输入框的id
 */
function alertMsg(itemId,msg){
	$(itemId).grumble(
		{
			text: msg, 
			angle: 80, 
			distance: 50, 
			showAfter: 500,			
			hideAfter: false,
			hasHideButton: true,
			buttonHideText: 'Pop!'
		}
	);
}

