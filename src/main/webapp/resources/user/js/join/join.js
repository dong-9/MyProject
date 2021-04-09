$(function(){
	$('#birthd').datepicker({
		changeYear: true,
		yearRange: "c-30:2021",
		changeMonth: true,
		dateFormat: 'yy-mm-dd',
		monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
	    monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
	    dayNames: ['일', '월', '화', '수', '목', '금', '토'],
	    dayNamesShort: ['일', '월', '화', '수', '목', '금', '토'],
	    dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
	    showMonthAfterYear: true,
	    yearSuffix: '년'
	});
	
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
	
	$('#check-id').click(function(){
		var token = $("meta[name='_csrf']").attr("content");
		var header = $("meta[name='_csrf_header']").attr("content");
		$.ajax({
			url:'findUser',
			type:'post',
			data: {'email' : $('#user-ID').val()},
			beforeSend : function(xhr){   
				xhr.setRequestHeader(header, token);
			},
			success:function(result){
				if(result.email == null){
					alert('사용 가능한 아이디 입니다');
					$('#check-id').remove();
					$('#user-ID').prop('readonly', true);
					return;
				}
				alert('이미 사용중인 아이디 입니다');
				$('#user-ID').focus();
			},
			error:function(){
				alert('Server Error');
			}
		});
	});
	
	var userId = false;
	var userPw = false; 
	var checkPw = false;
	var birthd = false;
	var phone = false;
	
	$('#user-ID').blur(function(){
		if($('#user-ID').val().length > 0){
			userId = true;
			return;
		}
		$('#user-ID').attr('placeholder', '이메일을 입력해주세요');
	});
	
	$('#user-PW').blur(function(){
		if($('#user-PW').val().length > 8){
			userPw = true;
			return;
		}
		$('#user-PW').val('');
		$('#user-PW').attr('placeholder','영문,숫자,특수문자 포함 8자리 이상 입력해주세요');
	});
	
	$('#check-PW').blur(function(){
		if($('#user-PW').val() == $('#check-PW').val()){
			checkPw = true;
			return;
		}
		$('#check-PW').val('');
		$('#check-PW').attr('placeholder', '비밀번호가 일치하지 않습니다');
	});
	
	$('#birthd').change(function(){
		if($('#birthd').val() != ''){
			birthd = true;
			return;
		}
	});
	
	$('#phone').focusout(function(){
		var p = $('#phone').val()
		if(p.split('-').length == 3 && p.replace(/[0-9.-]/gi, '').length == 0){
			phone = true;
			return;
		}
		$('#phone').attr('placeholder','010-1234-5678 형식을 맞춰주세요');
	});
	
	$('.join-btn').click(function(){
		console.log(birthd);
		console.log(phone);
		if(userId && userPw && checkPw && birthd && phone){
			$('#join').submit();
			return;
		}
		alert('양식을 채워주세요');
		$('#user-ID').focus();
	});
	
});
