/**
 * 
 */

var page;
function selectAllModule(){
	var data = $("#updateForm").serialize();
	$.ajax({
		url:"queryAllModule.action",
		data:data,
		dataType:"json",
		async:false,
		type:"post",
		success:function(result){
			$(result.list).each(function(){
				if(this.f_authId=="营销管理"){
					var str="";
					str += "<li>";
					str += "<input name='f_authId' value='"+this.f_id+"' type='checkbox'/>";
					str += "<a href='../modules/moduleView.html?name="+this.f_name+"'>"+this.f_name+"</a>";
                    str += "</li>";
					$("#yx").append(str);
				}
				if(this.f_authId=="仓库管理"){
					var str="";
					str += "<li>";
					str += "<input name='f_authId' value='"+this.f_id+"' type='checkbox'/>";
					str += "<a href='../modules/moduleView.html?name="+this.f_name+"'>"+this.f_name+"</a>";
                    str += "</li>";
					$("#ck").append(str);
				}
				if(this.f_authId=="采购管理"){
					var str="";
					str += "<li>";
					str += "<input name='f_authId' value='"+this.f_id+"' type='checkbox'/>";
					str += "<a href='../modules/moduleView.html?name="+this.f_name+"'>"+this.f_name+"</a>";
                    str += "</li>";
					$("#cg").append(str);
				}
				if(this.f_authId=="数据统计"){
					var str="";
					str += "<li>";
					str += "<input name='f_authId' value='"+this.f_id+"' type='checkbox'/>";
					str += "<a href='../modules/moduleView.html?name="+this.f_name+"'>"+this.f_name+"</a>";
                    str += "</li>";
					$("#tj").append(str);
				}
				if(this.f_authId=="系统管理"){
					var str="";
					str += "<li>";
					str += "<input name='f_authId' value='"+this.f_id+"' type='checkbox'/>";
					str += "<a href='../modules/moduleView.html?name="+this.f_name+"'>"+this.f_name+"</a>";
                    str += "</li>";
					$("#xt").append(str);
				}
			});
		}
	});
}
function selectOneModule(){
	var f_id = getUrlParam("id");
	$("input[name='f_positionId']").val(f_id);
	$.ajax({
		url:"selectOneModule.action",
		data:{"f_id":f_id},
		dataType:"json",
		async:false,
		type:"post",
		success:function(result){
			for(var i=0;i<result.list.length;i++){
                $.each($(".hidden input"),function (j,e) {
                    if(result.list[i].f_authId == $(e).val()){
                        $(e).prop("checked","checked");
                    }
                })
            }
		}
	});
}
function updateAuth(f_id){
	var f_positionId = $("input[name='f_positionId']").val();
	removeAuth(f_positionId);
    $("input[name='f_authId']").each(function(){
    	if($(this).prop("checked")){
    		 addAuth(f_positionId,$(this).val());
        }
    });
    alert("赋权成功！");
    window.location.href="positionList.html";
    
}
function addAuth(f_positionId,f_authId){
	$.ajax({
		url:"addAuth.action",
		data:{"f_positionId":f_positionId,"f_authId":f_authId},
		dataType:"json",
		async:false,
		type:"post",
		success:function(result){
			
		}
	});
}
function removeAuth(f_positionId,f_authId){
	$.ajax({
		url:"removeAuth.action",
		data:{"f_positionId":f_positionId},
		dataType:"json",
		async:false,
		type:"post",
		success:function(result){
			
		}
	});
}
