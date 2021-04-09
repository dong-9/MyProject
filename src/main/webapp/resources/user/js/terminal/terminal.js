$('#search-terminal').change(function(){
	
	$('.terminal-body').empty();
	
	$.ajax({
		type: 'get',
		url: 'terminalList',
		data: {'area' : $('#search-terminal').val()},
		success: function(result){
			var tag = '';
			if(result.lengt == 0){
				alert('죄송합니다 다시선택해주세요');
				return;
			}
			for(var i = 0; i < result.length; i++){
				tag += "<div class='line'>" +
					"<span>" + result[i].terminal_name + "</span>" +
					"<span>" + result[i].terminal_address + "</span>" + 
					"<span>" + result[i].terminal_phone + "</span>" +
				"</div>";
			}
			$('.terminal-body').append(tag);
		},
		error: function(){
			alert('Server Error');
		}
				
	});
});