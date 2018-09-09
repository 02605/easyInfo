//使用ajax加载数据字典,生成select
//参数1: 数据字典类型 (dict_type_code)
//参数2: 将下啦选放入的标签id
//参数3: 生成下拉选时,select标签的name属性值
//参数4: 数据类别iteam
//参数5:需要回显时,选中哪个option
function loadSelect(typecode,positionId,selectname,iteam,selectedId){
	//1 创建select对象,将name属性指定
	var $select =  $("<select name="+selectname+" ></select><br>");
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