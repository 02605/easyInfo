package com.web.action;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.domain.Teacher;
import com.domain.UserLogin;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.TeacherService;
import com.utils.PageBean;

public class TeacherAction extends ActionSupport implements ModelDriven<Teacher>{

	private Teacher teacher = new Teacher();
	
	private  TeacherService teacherService;
	private Integer currentPage;
	private Integer pageSize;
	public String list() throws Exception{
		System.out.println(currentPage);
				//封装离线查询对象
				DetachedCriteria dc = DetachedCriteria.forClass(Teacher.class);
				//判断并封装参数
				if(StringUtils.isNotBlank(teacher.getTea_name())){
					if(teacher.getTea_name().startsWith("2")){
						dc.add(Restrictions.like("tea_id", "%"+teacher.getTea_name()+"%"));
					}else{
						dc.add(Restrictions.like("tea_name", "%"+teacher.getTea_name()+"%"));
					}
				}
				if(StringUtils.isNotBlank(teacher.getTea_id())){
					dc.add(Restrictions.like("tea_id", "%"+teacher.getTea_id()+"%"));
				}
				
				//1 调用Service查询分页数据(PageBean)
				PageBean pb = teacherService.getPageBean(dc,currentPage,pageSize);
				
				//2 将PageBean放入request域,转发到列表页面显示
				ActionContext.getContext().put("pageBean", pb);
				return "list";
	}
	@Override
	public String execute() throws Exception {
		System.out.println("哈哈");
		return null;
	}
	
	public Teacher getModel() {
		return teacher;
	}


	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}


	public Integer getCurrentPage() {
		return currentPage;
	}


	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}


	public Integer getPageSize() {
		return pageSize;
	}


	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	
}
