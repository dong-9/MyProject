
$(".seat-btn").on("click",function(){
	if($('[class="select_seat"]:checked').length == 0){
		alert("좌석을 선택해주세요");
		return;
	}
	$(".payment-data-box").show();
	ticket_count = select_seat_obj.length;
	$('#ticket-num').html(ticket_count);
});

$('.select_seat').click(function(){
	select_seat_obj = [];
	$('[class="select_seat"]:checked').each(function(){
		select_seat_obj.push($(this).val());
	});
	
	input_price = 1000 * select_seat_obj.length;
	output_price = (1000*select_seat_obj.length).toLocaleString()+"원";
	$('.price').html(output_price);
	$('.seat-number').html(select_seat_obj.join(", "));
});



$('.payment-btn').click(function(){
	if(!confirm("결제하시겠습니까??")){
		return;
	}
	
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	
	var data = {
		'departure_date': $('.payment-head-box').html(),
		'email': $('#user-id').val(),
		'departure_area': $('#departure_area').html(),
		'destination' : $('#destination').html(),
		'number_of_tickets' : ticket_count,
		'total_price' : input_price,
		'seatNumbers' : select_seat_obj,
		'bus_name' : $('#busName').val(),
		'area_name' : $('#area').val()
	}
	console.log(data);
	
	$.ajax({
		type:'POST',
		url:'insertTicket',
		data : data,
		traditional : true,
		beforeSend : function(xhr){   
				xhr.setRequestHeader(header, token);
		},
		success:function(res){
			if(res == "success"){
				location.href="myPage";
				return;
			}else if(res == "noMoney"){
				alert('결제금액이 부족합니다 관리자에게 문의해주세요');
			}else{
				alert("이미 예약된 자리이거나 예매에 실패했습니다 다시시도해 주세요");
			}
			location.reload();
				
		},
		error:function(){
			alert('Server Error');
		}
	});
	
});