/*
인증번호 발송
$(".change-pn-btn").on("click",function(){
	$(".result").show();
});
*/
$('#phone').keyup(function(){
	var ph = $('#phone').val();
	if(ph.length == 3){
		ph += "-";
	}
	if(ph.length == 8){
		ph += "-";
	}
	$('#phone').val(ph);
});

$('.change-pn-btn').click(function(){
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");	
	
	$.ajax({
		type:'post',
		url:'changeNumber',
		data:{
			'email':$('#user-id').val(),
			'password':$('#pw').val(),
			'phone':$('#phone').val()
		},
		beforeSend : function(xhr){   
			xhr.setRequestHeader(header, token);
		},
		success:function(result){
			if(result == 'success'){
				location.href="myPage";
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

