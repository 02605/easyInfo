//使用ajax加载数据字典,生成select
//参数1: 数据字典类型 (dict_type_code)
//参数2: 将下啦选放入的标签id
//参数3: 生成下拉选时,select标签的name属性值
//参数4: 数据类别iteam
//参数5:需要回显时,选中哪个option
function loadSelect(typecode,positionId,selectname,iteam,selectedId){
	//1 创建select对象,将name属性指定,并为条件增加可选择性
	var $select =  $("<select name="+selectname+" ></select><br/>");
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

//加载所需下拉选项
function loadSelectmes(typecode,positionId,selectname,selectedId){
	//1 创建select对象,将name属性指定,并为条件增加可选择性
	var $select =  $("<select name="+selectname+" ></select><br/>");
	//2 使用jquery 的ajax 方法,访问后台Action
	$.post("${pageContext.request.contextPath}/BaseDictAction", { dict_type_code:typecode},
	  function(data){
	   		//遍历
	//3 返回json数组对象,对其遍历
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

//selectInfo:查询类别编号
function addSelectInfo() {
		loadSelect("001","genderDiv","teacher.tea_gender.dict_id","请选择性别",0);
		loadSelect("002","deptDiv","teacher.tea_dep.dict_id","请选择所属院系",0);
}

//加载下拉选项到指定div
function addUserSelectInfo(dict_id1,dict_id2) {
	loadSelectmes("017","stateDiv","state",dict_id1);
	loadSelectmes("018","roleDiv","teacher.tea_role.dict_id",dict_id2);
}
