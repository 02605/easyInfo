package com.web.action;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.dao.TeacherDao;
import com.domain.PrivateTemplate;
import com.opensymphony.xwork2.ActionSupport;
import com.service.MethodsService;
import com.utils.showExcel.excel2Picture;

public class methodUploadAction extends ActionSupport {
	private MethodsService ms;
	private TeacherDao teacher;

	private File uploadPrivateMethod; // 得到上传的文件
	private String uploadPrivateMethodContentType; // 得到文件的类型
	private String uploadPrivateMethodFileName; // 得到文件的名称

	// HttpServletRequest request = (HttpServletRequest) ActionContext
	// .getContext().get(StrutsStatics.HTTP_REQUEST);
	// String tea_id = (String) request.getAttribute("tea_id");

	/**
	 * 此处生成的地址形如 D:\\Data\\This
	 * Computer\\Desktop\\Code\\MyEclipse_workspace_ssh\
	 * \.metadata\\.me_tcat7\\webapps\\EasyInfo_1.0\\upload
	 * 看似是项目的绝对地址，在调用时无法使用，但只要在页面中使用 ServletActionContext
	 * .getServletContext().getRealPath("/upload");既可正常获取
	 * 
	 * @return
	 * @throws Exception
	 */
	public String privateMethod() throws Exception {
		// System.out.println(tea_id);
		// 获取该地址的所在服务器的真实地址
		String targetDirectory = ServletActionContext.getServletContext()
				.getRealPath("/methods/privateMethods");
		// 生成上传的文件对象
		File target = new File(targetDirectory, uploadPrivateMethodFileName);
		// 如果文件已经存在，则删除原有文件
		if (target.exists()) {
			target.delete();
		}
		// 复制file对象，实现上传
		try {
			FileUtils.copyFile(uploadPrivateMethod, target);
			// -----------------------------文件上传成功，以下为相关信息的持久化操作
			// 新建excel2Picture对象-为了获取png的图片
			excel2Picture ep = new excel2Picture();
			// pngPath为png生成的地址-暂时也是绝对地址
			String pngPath = ep.createPng(targetDirectory + "/"
					+ uploadPrivateMethodFileName);// 创建新的png并存入地址
			// 对png的地址进行干预
			File tempFile = new File(pngPath.trim());
			pngPath = tempFile.getName();
			// 新建临时模板对象
			PrivateTemplate t = new PrivateTemplate();
			// set相应的内容
			t.setPri_tem_id(1);
			// teacher相关信息，由request传来
			t.setTea_id(teacher.getById("101"));
			// 以下内容也由request传来
			t.setPri_tem_name("test1");
			t.setPri_tem_describe("world");
			// 在数据库中存储模板地址即可，文件地址会在调用的时候由action调用
			t.setPri_tem_url(uploadPrivateMethodFileName);
			t.setPri_tem_img(pngPath);
			// 存储临时模板对象
			ms.savePrivateMethods(t);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	/**
	 * 此处根据上传页面获取的 公共模板的名称，描述，等信息，写入到公共模板库中
	 * 
	 * @return
	 */
	public String publicMethod() {
		// 模仿私人模板书写即可，只需要修改几个地址就可以了。
		// -------------------------------------------------------
		// PublicTemplate t = new PublicTemplate();
		// t.setPub_tem_id(1);
		// t.setPub_tem_describe("world");
		// t.setPub_tem_url("等我处理好上传的位置之后写入");
		// t.setPub_tem_img("pngPath");
		// t.setPub_tem_name("test1");
		// ms.savePublicMethods(t);
		return SUCCESS;
	}

	public File getUploadPrivateMethod() {
		return uploadPrivateMethod;
	}

	public void setUploadPrivateMethod(File uploadPrivateMethod) {
		this.uploadPrivateMethod = uploadPrivateMethod;
	}

	public String getUploadPrivateMethodContentType() {
		return uploadPrivateMethodContentType;
	}

	public void setUploadPrivateMethodContentType(
			String uploadPrivateMethodContentType) {
		this.uploadPrivateMethodContentType = uploadPrivateMethodContentType;
	}

	public String getUploadPrivateMethodFileName() {
		return uploadPrivateMethodFileName;
	}

	public void setUploadPrivateMethodFileName(
			String uploadPrivateMethodFileName) {
		this.uploadPrivateMethodFileName = uploadPrivateMethodFileName;
	}

	// Spring配置
	public void setTeacher(TeacherDao teacher) {
		this.teacher = teacher;
	}

	public void setMs(MethodsService ms) {
		this.ms = ms;
	}
}
