var sendEmail;

$(".find-pw-btn").on("click",function(){
	
	var email = $('#userID').val();
	if(email == null){
		alert('아이디를 입력해주세요');
		return;
	}
	
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	
	$.ajax({
		type: 'post',
		url: 'findUser',
		data: {'email' : email},
		beforeSend : function(xhr){   
				xhr.setRequestHeader(header, token);
		},
		success: function(res){
			if(res.type == 'success'){
				$('#send-email').attr('href','sendEmail?email='+res.email);
				$(".result").show();
				return;
			}
			alert('아이디가 존재하지않습니다');
		},
		error: function(){
			alert('Server Error');
		}
	});
});

