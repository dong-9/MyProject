$(".find-id-btn").on("click",function(){
	var phone = $('#phone').val();
	if(phone == null || phone.length != 13){
		alert('휴대폰 번호를 입력해주세요');
		return;
	}
	
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	
	$.ajax({
		type: 'POST',
		url:'findUser',
		data: {'phone' : phone},
		beforeSend : function(xhr){   
				xhr.setRequestHeader(header, token);
		},
		success: function(res){
			if(res.type == 'success'){
				var splitEmail = res.email.split('@');
				var first = splitEmail[0].substring(0,4)+'****';
				var mid = splitEmail[1].split('.')[0].substring(0,1)+"****";
				var last = "."+splitEmail[1].split('.')[1];
				var showEmail = first+"@"+mid+last;
				$(".result").show();
				$(".result-id").html(showEmail);
				return;
			}
			alert('아이디가 존재하지않습니다');
		},
		error: function(){
			alert('Server Error');
		}
	});
});
