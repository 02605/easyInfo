//使用ajax加载数据字典,生成select
//参数1: 数据字典类型 (dict_type_code)
//参数2: 将下啦选放入的标签id
//参数3: 生成下拉选时,select标签的name属性值
//参数4: 数据类别iteam
//参数5:需要回显时,选中哪个option
function loadSelect(typecode,positionId,selectname,iteam,selectedId){
	//1 创建select对象,将name属性指定
	var $select =  $("<select name="+selectname+" ></select>");
	//2 添加提示选项
	$select.append($("<option value='' >"+iteam+"</option>"));
	//3 使用jquery 的ajax 方法,访问后台Action
	$.post("${pageContext.request.contextPath}/BaseDictAction", { dict_type_code:typecode},
	  function(data){
	   		//遍历
	//4 返回json数组对象,对其遍历
	   		$.each( data, function(i, json){
		// 每次遍历创建一个option对象
	   			var $option = $("<option value='"+json['dict_id']+"' >"+json["dict_item_name"]+"</option>"); 
	   			
			if(json['dict_id'] == selectedId){
			//判断是否需要回显 ,如果需要使其被选中
				$option.attr("selected","selected");
			}
		//并添加到select对象
				$select.append($option);
	   		});
	  },"json");
		
	//5 将组装好的select对象放入页面指定位置
	$("#"+positionId).append($select);
}
//selectInfo:选中的查询类别id
//selectedId:需要回显的查询类别id
/*function addSelectInfo(selectInfo,selectedId) {
	alert("selectedId:   "+selectedId);
	alert("selectInfo:   "+selectInfo);
	$("#selectDiv").empty();
	$("#"+selectedId).attr("selected","selected");
	if(selectInfo=='a'||'a'==selectedId){
	  基础信息
		
		loadSelect("001","selectDiv","tea_gender","性别",${param.tea_gender});
		loadSelect("002","selectDiv","tea_dep","所属院系",${param.tea_dep});
		loadSelect("006","selectDiv","tea_nation","民族",${param.tea_nation});
		loadSelect("007","selectDiv","tea_political","政治面貌",${param.tea_political});
		loadSelect("003","selectDiv","tea_jobTitel","职称",${param.tea_jobTitel});
		loadSelect("005","selectDiv","tea_eduBG","学历",${param.tea_eduBG});
		loadSelect("004","selectDiv","tea_degree","学位",${param.tea_degree});
	}
	if(selectInfo=='b'||'b'==selectedId){
	  论文信息
		loadSelect("008","selectDiv","the_level","论文层次",0);
	}
	if(selectInfo=='c'||'c'==selectedId){
	  专利信息
		loadSelect("009","selectDiv","pat_type","专利类型",0);
	 	loadSelect("008","selectDiv","pat_country","国家",0); 
	}
	if(selectInfo=='d'||'d'==selectedId){
	  奖励信息
		loadSelect("010","selectDiv","rew_level","奖励级别",0);
		 loadSelect("008","selectDiv","rew_levelDetail","获奖等级",0); 
		loadSelect("014","selectDiv","rew_family","奖励类别",0);
		loadSelect("015","selectDiv","rew_ascription","奖励所属",0);
	}
	if(selectInfo=='e'||'e'==selectedId){
	  教材著作
		 loadSelect("008","selectDiv","cm_location","出版地",0); 
	}
	if(selectInfo=='f'||'f'==selectedId){
	  教学评估
		loadSelect("011","selectDiv","tea_eva_grade","评估成绩",0);
	}
	if(selectInfo=='g'||'g'==selectedId){
	  纵向科研
		loadSelect("016","selectDiv","ver_nature","研究性质",0);
		loadSelect("010","selectDiv","ver_ projectLevel","立项级别",0);
		loadSelect("010","selectDiv","ver_identLevel","鉴定级别",0);
	}
	if(selectInfo=='h'||'h'==selectedId){
	  横向科研
		 loadSelect("008","selectDiv","the_level","论文层次",0); 
	}
	if(selectInfo=='i'||'i'==selectedId){
	  指导学生
		loadSelect("015","selectDiv","stu_type","队伍类型",0);
		loadSelect("010","selectDiv","stu_rewardLevel","学生获奖级别",0);
	}
	if(selectInfo=='j'||'j'==selectedId){
	  挂职实践
		 loadSelect("008","selectDiv","the_level","论文层次",0); 
	}
	if(selectInfo=='k'||'k'==selectedId){
	  培训学习
		loadSelect("012","selectDiv","tra_result","培训成果",0);
	}
	if(selectInfo=='l'||'l'==selectedId){
	  年终考核
		loadSelect("013","selectDiv","ann_rev_grade","考核结果",0);
	}
	if(selectInfo=='m'||'m'==selectedId){
	  当辅导员情况
		 loadSelect("008","selectDiv","the_level","论文层次",0); 
	}
}*/
/*动态添加文本信息及提示
 * positionId ：插入的 位置
 * textName name属性值
 * value 回显值
 * showName placeholder的值
 * title 提示框
 * className class
 */
function loadTextInfo(positionId,textName,value,showName,title,className){
	
	var $text = $("<input style='width: 220px;height: 28px' type='text'  placeholder="+showName+" name="+textName+"   title="+title+" class="+className+" value="+value+">");
	
	$("#"+positionId).append($text);
	new $.Zebra_Tooltips($('.'+className));
	
}