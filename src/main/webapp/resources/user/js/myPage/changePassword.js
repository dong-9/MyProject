var new_pw = false; 
var re_pw = false;
	
	
$('#new-pw').blur(function(){
	if($('#new-pw').val().length > 8){
		new_pw = true;
		return;
	}
	$('#user-PW').val('');
	$('#user-PW').attr('placeholder','영문,숫자,특수문자 포함 8자리 이상 입력해주세요');
});

$('#re-pw').blur(function(){
	if($('#re-pw').val() == $('#new-pw').val()){
		re_pw = true;
		return;
	}
	$('#re-pw').val('');
	$('#re-pw').attr('placeholder', '비밀번호가 일치하지 않습니다');
});


$('.change-pw-btn').click(function(){
	if(!(new_pw && re_pw)){
		alert('양식을 채워주세요');
		$('#pw').focus();
		return;
	}
	
	if(!confirm("비밀번호를 변경하시겠습니까??")){
		return;
	}
	
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");	
	
	$.ajax({
		type:'post',
		url:'changePW',
		data:{
			'email':$('#user-id').val(),
			'password':$('#pw').val(),
			'newPassword':$('#re-pw').val()
		},
		beforeSend : function(xhr){   
			xhr.setRequestHeader(header, token);
		},
		success:function(result){
			console.log(result);
			if(result == 'success'){
				$('.top-menu-btn').get(0).click();
				return;
			}
			alert('비밀번호가 일치하지 않습니다');
			location.reload();
		},
		error:function(){
			alert('Server Error');
		}
	});
});
