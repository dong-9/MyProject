$(function(){
	$('.cancle').click(function(){
		var data = $(this).attr('id');
		
		if(!confirm("예매를 취소하시겠습니까??")){
			return;
		}
		
		var token = $("meta[name='_csrf']").attr("content");
		var header = $("meta[name='_csrf_header']").attr("content");
		
		
		$.ajax({
			type: 'POST',
			url:'/userCancleTicket',
			traditional : true,
			data: {'ticketing_number' :data},
			beforeSend : function(xhr){   
					xhr.setRequestHeader(header, token);
			},
			success: function(res){
				if(res == 'success'){
					location.reload();
					return;
				}
			},
			error: function(){
				alert('Server Error');
			}
		});
	});
});