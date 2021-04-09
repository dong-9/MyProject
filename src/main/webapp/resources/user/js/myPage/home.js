$('#cancle').click(function(){
	$('.close').click();
});

$('#delete-user').click(function(){
	if(!confirm('탈퇴를 진행하시겠습니까??')){
		return;
	}
	
	$.ajax({
		url:'delUser',
		type:'GET',
		data:{
			'email':$('#user-id').val(),
			'password': $('#user-pw').val()
		},
		success:function(result){
			if(result == "success"){
				$('.top-menu-btn').get(0).click();
				return;
			}
			alert('비밀번호가 일치하지 않습니다');
		},
		error:function(){
			alert('Server Error');
		}
	});
});