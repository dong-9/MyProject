function check_all(){
	if($('#check_all').prop('checked')){
		$('input[type=checkbox]').prop('checked', true);
	}else{
		$('input[type=checkbox]').prop('checked', false);
	}
}

function deleteList() {
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	var select_obj = new Array();
	$('[class="select_num"]:checked').each(function(){
		select_obj.push($(this).val());
	});
	
	if(confirm("삭제하시겠습니까?")){
		if(select_obj.length == 0 || select_obj == null){
			alert('선택값이 없습니다');
			return;
		}

		$.ajax({
			type:'POST',
			url:'delete',
			traditional : true, //배열넘길떄 이옵션 넣기 
			data:{'select_obj' : select_obj},
			beforeSend : function(xhr){   
					xhr.setRequestHeader(header, token);
			},
			success:function(result){
				alert(result);
			},
			error:function(){
				console.log('Server Error');
			}
		});
	}
	location.reload();	
}

function search_btn(){
	self.location = "list?page=1&searchType="+$('#searchType').val()+"&keyword="+$('#keyword').val();
}

function resetKeyword(){
	if($('#searchType').val() == 'a') $('#keyword').val('');
}