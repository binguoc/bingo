function pageButton() {
	var strBut;
	var startNum;
	var endNum;
	startNum=page.pageNum-2<=1?1:page.pageNum-2;
	endNum=page.pageNum+2>=page.pages?page.pages:page.pageNum+2;
	if (page.hasPreviousPage) {
		strBut="<li class='paginItem'><a href='javascript:toPage("+(page.pageNum-1)+");'><span class='pagepre'></span></a></li>";
	} else {
		strBut="<li class='paginItem'><a href='#'><span class='pagepre1'></span></a></li>";
	}
	for(i=startNum;i<=endNum;i++){
		if(i!=page.pageNum){
			strBut+="<li class='paginItem'><a href='javascript:toPage("+i+");'>"+i+"</a></li>";
		}else{
			strBut+="<li class='paginItem current'><a href='javascript:toPage("+i+");'>"+i+"</a></li>";
		}
	}
	if (page.hasNextPage) {
		strBut+="<li class='paginItem'><a href='javascript:toPage("+(page.pageNum+1)+");'><span class='pagenxt'></span></a></li>";
	} else {
		strBut+="<li class='paginItem'><a href='#'><span class='pagenxt1'></span></a></li>";
	}
	var strr="共<i class='blue'>"+page.total+"</i>条记录，当前显示第&nbsp;<i class='blue'>"+page.pageNum+"</i>&nbsp;页&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;总共&nbsp;<i class='blue'>"+page.pages+"</i>页";
	$(".message").html(strr);
	$(".paginList").html(strBut);
}







function toSheng() {
	$.ajax({
		url:"index_selectBySid.action",
		dataType:"json",
		async:true,
		type:"post",
		success:function(result){
			var str="<option value=''>请选择省份</option>";
			$(result).each(function(){
				str+="<option value='"+this.pro_id+"' >"+this.pro_name+"</option>";
			});
			$("#ssid").html(str);
		}
	});
	
}
function toCity() {
	$.ajax({
		url:"index_selectBySSid.action",
		data:{"ssid":$("#ssid").val()},
		dataType:"json",
		async:false,
		type:"post",
		success:function(result){
			var str="<option value=''>请选择城市</option>";
			$(result).each(function(){
				str+="<option value='"+this.city_id+"'>"+this.city_name+"</option>";
			});
			$("#city").html(str);
		}
	});
}









function selectProvince() {
	$.ajax({
		url:"selectByProvince.action",
		dataType:"json",
		async:true,
		type:"post",
		success:function(result){
			var str="<option value=''>请选择省份</option>";
			$(result).each(function(){
				str+="<option >"+this.pro_name+"</option>";
			});
			$("#ssid").html(str);
		}
	});
	
}

function selectCity() {
	var city_name=$("#ssid").val();
	$.ajax({
		url:"selectByCity.action",
		data:{"city_name":city_name},
		dataType:"json",
		async:false,
		type:"post",
		success:function(result){
			var str="<option value=''>请选择城市</option>";
			$(result).each(function(){
				str+="<option >"+this.city_name+"</option>";//value="+this.city_id+"
			});
			$("#city").html(str);
		}
	});
}


/*
 *千位数转换
 */
function format(num) {
    return "￥" + (num+ '').replace(/(\d{1,3})(?=(\d{3})+(?:$|\.))/g,'$1,');
}