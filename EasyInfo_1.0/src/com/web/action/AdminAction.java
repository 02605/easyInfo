package com.web.action;
import com.domain.AdminLogin;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.AdminService;


public class AdminAction extends ActionSupport implements ModelDriven<AdminLogin>{

	private AdminLogin adminLogin = new AdminLogin();
	private AdminService adminService;


	public String login() throws Exception{
		System.out.println("adminAction.........");
		//1调用service执行登陆逻辑
		AdminLogin admin = adminService.getAdminLoginByTea_id(adminLogin);
		//2将admin放入session域中
		ActionContext.getContext().getSession().put("admin", admin);
		//3重定向到首页 
		return "toHome";
	}


	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	@Override
	public AdminLogin getModel() {
		return adminLogin;
	}

	
}
