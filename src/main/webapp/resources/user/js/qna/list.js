/**
 * 
 */
$(".itme").on("click",function(){
	$(this).addClass("active").siblings().removeClass("active");
});

$('.search-btn').click(function(){
	console.log('asd');
	self.location = "qnaList?page=1&searchType=c&keyword="+$('.search-input').val();
});
