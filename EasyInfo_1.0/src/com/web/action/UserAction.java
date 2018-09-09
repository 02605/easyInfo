package com.web.action;

import java.util.ArrayList;

import com.domain.AdminLogin;
import com.domain.BaseDict;
import com.domain.Teacher;
import com.domain.User;
import com.domain.UserLogin;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.AdminService;
import com.service.BaseDictService;
import com.service.TeacherService;
import com.service.UserService;
import com.utils.PageBean;

@SuppressWarnings("serial")
public class UserAction extends ActionSupport implements ModelDriven<UserLogin> {

	private UserService userService;
	private BaseDictService baseDictService;
	private AdminService adminService;
	private UserLogin userLogin = new UserLogin();
	private AdminLogin adminLogin = new AdminLogin();
	private BaseDict baseDict =new BaseDict();
	private Teacher teacher =new Teacher();
	private TeacherService teacherService;
	private Integer currentPage;
	private Integer pageSize;
	private  String state;
	//用户登录
	public String login() throws Exception {
		// 1调用service执行登陆逻辑
		UserLogin user = userService.getUserLoginByTea_id(userLogin);
		ArrayList<Object> teacherInfo=teacherService.getAllTeacherByid(user);
		// 2将userlogin放入session域中
		ActionContext.getContext().getSession().put("user", user);
		ActionContext.getContext().getSession().put("teacherInfo", teacherInfo);
		// 3重定向到首页
		return "toHome";
	}
    //查询用户列表
	public String list() throws Exception {
		// 1 调用Service查询分页数据(PageBean)
		PageBean pb = userService.getPageBean(userLogin.getTea_id(), currentPage, pageSize);
		// 2 将PageBean放入request域,转发到列表页面显示
		ActionContext.getContext().put("pageBean", pb);
		return "list";
	}
    //跳转到用户编辑页
	public String toUpdate() throws Exception {
		User userMes = this.userService.getUserMesByid(userLogin.getTea_id());
		ActionContext.getContext().put("user", userMes);
		return "edit";
	}
    //更新账户信息
	public String update() throws Exception {	
		//获取teacher和adminlogin表的单一对象信息以便于进行更新
		teacher=teacherService.getTeacherByid(userLogin.getTea_id());
		//从数据字典中查询完整的外键对应实体更新到数据库
		baseDict=baseDictService.getListById(state).get(0); 
		userLogin.setUser_state(baseDict);
		teacher.setTea_enable(userLogin.getUser_state());
		baseDict=baseDictService.getListById(teacher.getTea_role().getDict_id()).get(0);
		teacher.setTea_role(baseDict);
		userService.updateUser(userLogin,teacher);
		if(!teacher.getTea_role().getDict_item_name().equals("普通用户")){
			adminLogin=adminService.getAdminByid(userLogin.getTea_id());
			adminLogin.setAdmin_password(userLogin.getUser_password());
			adminLogin.setAdmin_state(userLogin.getUser_state());
			adminService.update(adminLogin);
		}
		return "success";
	}
    //重置密码
	public String resetpwd() throws Exception {
		String initpassword = "000000";
		userLogin=userService.getUserByid(userLogin.getTea_id());
		teacher=teacherService.getTeacherByid(userLogin.getTea_id());		
		userLogin.setUser_password(initpassword);
		userService.updateUser(userLogin,teacher);
		if(!teacher.getTea_role().getDict_item_name().equals("普通用户")){
			adminLogin=adminService.getAdminByid(userLogin.getTea_id());
			adminLogin.setAdmin_password(initpassword);
		    adminService.update(adminLogin);
		}
		return "success";
	}
	//冻结账户
	public String blockUser() throws Exception {
		userLogin=userService.getUserByid(userLogin.getTea_id());
		teacher=teacherService.getTeacherByid(userLogin.getTea_id());
		baseDict=baseDictService.getListByItemName("冻结").get(0);
		userLogin.setUser_state(baseDict);
		teacher.setTea_enable(baseDict);
		userService.updateUser(userLogin,teacher);
		if(!teacher.getTea_role().getDict_item_name().equals("普通用户")){
			adminLogin=adminService.getAdminByid(userLogin.getTea_id());
			adminLogin.setAdmin_state(baseDict);
		    adminService.update(adminLogin);
		}		
		return "success";
	}
	//删除账户
	public String delete() throws Exception {
		userLogin=userService.getUserByid(userLogin.getTea_id());
		teacher=teacherService.getTeacherByid(userLogin.getTea_id());
		if(!teacher.getTea_role().getDict_item_name().equals("普通用户")){
			adminLogin=adminService.getAdminByid(userLogin.getTea_id());
		    adminService.delete(adminLogin);
		}
		userService.deleteUser(userLogin,teacher);
		return "success";
	}
	//注册账户
	public String save() throws Exception {
		baseDict=baseDictService.getListByItemName(state).get(0); 
		userLogin.setUser_state(baseDict);
		//在添加到userlogin表的同时将信息更新到Teacher表
		teacher.setTea_id(userLogin.getTea_id());
		teacher.setTea_enable(userLogin.getUser_state());
		baseDict=baseDictService.getListByItemName(teacher.getTea_role().getDict_item_name()).get(0);
		teacher.setTea_role(baseDict);
		baseDict=baseDictService.getListById(teacher.getTea_gender().getDict_id()).get(0);
		teacher.setTea_gender(baseDict);
		baseDict=baseDictService.getListById(teacher.getTea_dep().getDict_id()).get(0);
		teacher.setTea_dep(baseDict);
		userService.saveUser(userLogin,teacher);
//		//如果注册的新用户为管理员，则同时在adminLogin表中加入信息
		if(teacher.getTea_role().getDict_item_name().equals("管理员")){
			adminLogin.setTea_id(userLogin.getTea_id());
			adminLogin.setAdmin_password(userLogin.getUser_password());
			adminLogin.setAdmin_state(userLogin.getUser_state());
			adminService.save(adminLogin);
		}
		return "success";
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setBaseDictService(BaseDictService baseDictService) {
		this.baseDictService = baseDictService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}

	public UserLogin getModel() {
		return userLogin;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public BaseDict getBaseDict() {
		return baseDict;
	}

	public void setBaseDict(BaseDict baseDict) {
		this.baseDict = baseDict;
	}

	public Teacher getTeacher() {
		return teacher;
	}
	
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
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