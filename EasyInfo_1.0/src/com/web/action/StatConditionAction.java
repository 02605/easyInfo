package com.web.action;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Convert;
import javax.persistence.Converts;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.omg.CORBA.PRIVATE_MEMBER;

import com.domain.Teacher;
import com.domain.Thesis;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.BaseDictService;
import com.service.BaseService;
import com.service.TeacherService;
import com.service.ThesisService;
import com.utilBeanS.QueryCondition;
import com.utils.PageBean;

@SuppressWarnings("all")
public class StatConditionAction extends ActionSupport implements
		ModelDriven<QueryCondition> {

	private QueryCondition queryCondition = new QueryCondition();
	private TeacherService teacherService;
	private ThesisService thesisService;// 论文service
	private Integer currentPage;
	private Integer pageSize;
	private String beginTime;
	private String endTime;

	public String list() throws Exception {
		PageBean pb = null;
		DetachedCriteria dc = null;
		
		// 查询教师基本信息
		if (queryCondition.getCondition().equalsIgnoreCase("a")) {
			dc = DetachedCriteria.forClass(Teacher.class);
			// 封装离线查询对象，获取结果			
			List list = getAfterSelectTeaList();
			if (list != null) {
				dc.add(Restrictions.in("tea_id", list));
				dc=getTimeCondition(dc, "tea_workDate");
				// 1 调用Service查询分页数据(PageBean)
				pb = teacherService.getPageBean(dc, currentPage, pageSize);
			}
		}
		// 论文信息
		if (queryCondition.getCondition().equalsIgnoreCase("b")) {
			dc = DetachedCriteria.forClass(Thesis.class);
			List list = getAfterSelectThesis();
			if (list != null) {
				dc.add(Restrictions.in("the_id", list));
				dc=getTimeCondition(dc, "the_pubTime");
				// 1 调用Service查询分页数据(PageBean)
				pb = thesisService.getPageBean(dc, currentPage, pageSize);
			}
		}
		// 2 将PageBean放入request域,转发到列表页面显示
		ActionContext.getContext().put("pageBean", pb);
		return "list";
	}
	
	//加入时间条件进行查询
	private DetachedCriteria getTimeCondition(DetachedCriteria dc,String sqlTimeName) throws ParseException{
		DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		
		  if(StringUtils.isNotBlank(beginTime)){//查询指定时间之后的记录   
			  Date beginDate=df.parse((beginTime));
			    dc.add(Restrictions.ge(sqlTimeName,beginDate));  
		  }
		 if(StringUtils.isNotBlank(endTime)){ //查询指定时间之前的记录            
			 Date endDate=df.parse((endTime));  
			   dc.add(Restrictions.le(sqlTimeName,endDate)); 
		 }
			  return dc;
		}
	private List getAfterSelectTeaList() {
		DetachedCriteria dc1 = DetachedCriteria.forClass(Teacher.class);
		if (StringUtils.isNotBlank(queryCondition.getTea_id())) {
			dc1.add(Restrictions.like("tea_id",
					"%" + queryCondition.getTea_id() + "%"));
		}
		if (StringUtils.isNotBlank(queryCondition.getTea_name())) {
			dc1.add(Restrictions.like("tea_name",
					"%" + queryCondition.getTea_name() + "%"));
		}
		if (StringUtils.isNotBlank(queryCondition.getTea_gender())) {
			dc1.createAlias("tea_gender", "baseDict1");
			dc1.add(Restrictions.eq("baseDict1.dict_id",
					queryCondition.getTea_gender()));
		}
		if (StringUtils.isNotBlank(queryCondition.getTea_nation())) {
			dc1.createAlias("tea_nation", "baseDict2");
			dc1.add(Restrictions.eq("baseDict2.dict_id",
					queryCondition.getTea_nation()));
		}
		if (StringUtils.isNotBlank(queryCondition.getTea_political())) {
			dc1.createAlias("tea_political", "baseDict3");
			dc1.add(Restrictions.eq("baseDict3.dict_id",
					queryCondition.getTea_political()));
		}
		if (StringUtils.isNotBlank(queryCondition.getTea_jobTitel())) {
			dc1.createAlias("tea_jobTitel", "baseDict4");
			dc1.add(Restrictions.eq("baseDict4.dict_id",
					queryCondition.getTea_jobTitel()));
		}
		if (StringUtils.isNotBlank(queryCondition.getTea_eduBG())) {
			dc1.createAlias("tea_eduBG", "baseDict5");
			dc1.add(Restrictions.eq("baseDict5.dict_id",
					queryCondition.getTea_eduBG()));
		}
		if (StringUtils.isNotBlank(queryCondition.getTea_degree())) {
			dc1.createAlias("tea_degree", "baseDict6");
			dc1.add(Restrictions.eq("baseDict6.dict_id",
					queryCondition.getTea_degree()));
		}
		if (StringUtils.isNotBlank(queryCondition.getTea_dep())) {
			dc1.createAlias("tea_dep", "baseDict7");
			dc1.add(Restrictions.eq("baseDict7.dict_id",
					queryCondition.getTea_dep()));
		}
		if (StringUtils.isNotBlank(queryCondition.getTea_enable())) {
			dc1.createAlias("tea_enable", "baseDict8");
			dc1.add(Restrictions.eq("baseDict8.dict_id",
					queryCondition.getTea_enable()));
		}
		if (StringUtils.isNotBlank(queryCondition.getTea_role())) {
			dc1.createAlias("tea_role", "baseDict9");
			dc1.add(Restrictions.eq("baseDict9.dict_id",
					queryCondition.getTea_role()));
		}
		// 设置只查询tea_id列
		dc1.setProjection(Projections.distinct(Projections.property("tea_id")));
		List list = teacherService.getAnyTypeList(dc1);
		dc1.setProjection(null);
		return list;
	}

	private List<Thesis> getAfterSelectThesis() {
		// 封装离线查询对象，获取teacher_tea_id结果
		List list = getAfterSelectTeaList();
		List list2 = null;
		if (list != null) {
			DetachedCriteria dc2 = DetachedCriteria.forClass(Thesis.class);
			// 建立引用
			dc2.createAlias("tea_id", "teacher");
			dc2.createAlias("the_level", "baseDict");
			dc2.add(Restrictions.in("teacher.tea_id", list));
			if (StringUtils.isNotBlank(queryCondition.getThe_level())) {
				// 论文层次
				dc2.add(Restrictions.eq("baseDict.dict_id",
						queryCondition.getThe_level()));
			}
			if (StringUtils.isNotBlank(queryCondition.getThe_author())) {
				// 论文作者
				dc2.add(Restrictions.or(
						Restrictions.like("the_firstAuthor", "%"
								+ queryCondition.getThe_author() + "%"),
						Restrictions.like("the_otherAuthor", "%"
								+ queryCondition.getThe_author() + "%")));
			}
			if (StringUtils.isNotBlank(queryCondition.getThe_title())) {
				// 论文题目
				dc2.add(Restrictions.like("the_title",
						"%" + queryCondition.getThe_title() + "%"));
			}
			if (StringUtils.isNotBlank(queryCondition.getThe_periodical())) {
				// 发表刊物名称
				dc2.add(Restrictions.like("the_periodical", "%"
						+ queryCondition.getThe_periodical() + "%"));
			}
			// 设置只查询the_id列
			dc2.setProjection(Projections.distinct(Projections
					.property("the_id")));
			list2 = thesisService.getAnyTypeList(dc2);
			dc2.setProjection(null);
		}
		return list2;
	}

	@Override
	public QueryCondition getModel() {
		return queryCondition;
	}

	public QueryCondition getQueryCondition() {
		return queryCondition;
	}

	public void setQueryCondition(QueryCondition queryCondition) {
		this.queryCondition = queryCondition;
	}

	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
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

	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}
	
	public void setThesisService(ThesisService thesisService) {
		this.thesisService = thesisService;
	}
}
