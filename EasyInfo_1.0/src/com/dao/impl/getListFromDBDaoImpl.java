package com.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.domain.Practice;
import com.domain.Train;
import com.dao.TeacherDao;
import com.domain.AnnualReview;
import com.domain.CompileMateria;
import com.domain.HorizontalResearch;
import com.domain.InstructedStudents;
import com.domain.Instructor;
import com.domain.Patent;
import com.domain.Reward;
import com.domain.Teacher;
import com.domain.TeachingEvaluation;
import com.domain.Thesis;
import com.domain.VerticalResearch;

public class getListFromDBDaoImpl {
	TeacherDao teacherDao;

	public void setTeacherDao(TeacherDao teacherDao) {
		this.teacherDao = teacherDao;
	}

	public ArrayList<Object> getList(String tea_id) {
		ArrayList<Object> searchResultList = new ArrayList<Object>();
		DetachedCriteria dc = DetachedCriteria.forClass(Teacher.class);
		dc.add(Restrictions.eq("tea_id", tea_id));
		List<Teacher> list = teacherDao.getList(dc);
		for (Teacher teacher : list) {
			searchResultList.add(teacher);
			//年终考核表
			Set<AnnualReview> set1 = teacher.getAnnualReviewS();
			for (AnnualReview t : set1) {
				searchResultList.add(t);
			}
			//教学质量评估表
			Set<TeachingEvaluation> set2 = teacher.getTeachingEvaluationS();
			for (TeachingEvaluation t : set2) {
				searchResultList.add(t);
			}
			//论文表
			Set<Thesis> set3 = teacher.getThesisS();
			for (Thesis t : set3) {
				searchResultList.add(t);
			}
			//纵向研究
			Set<VerticalResearch> set4 = teacher.getVerticalResearchS();
			for (VerticalResearch t : set4) {
				searchResultList.add(t);
			}
			//专利表
			Set<Patent> set5 = teacher.getPatentS();
			for (Patent t : set5) {
				searchResultList.add(t);
			}
			//横向研究
			Set<HorizontalResearch> set6 = teacher.getHorizontalResearchS();
			for (HorizontalResearch t : set6) {
				searchResultList.add(t);
			}
			//指导学生
			Set<InstructedStudents> set7 = teacher.getInstructedStudentsS();
			for (InstructedStudents t : set7) {
				searchResultList.add(t);
			}
			//挂职时间
			Set<Practice> set8 = teacher.getPracticeS();
			for (Practice t : set8) {
				searchResultList.add(t);
			}
			//培训学习
			Set<Train> set9 = teacher.getTrainS();
			for (Train t : set9) {
				searchResultList.add(t);
			}
			//奖励
			Set<Reward> set10 = teacher.getRewardS();
			for (Reward t : set10) {
				searchResultList.add(t);
			}
			//辅导员情况
			Set<Instructor> set11 = teacher.getInstructorS();
			for (Instructor t : set11) {
				searchResultList.add(t);
			}
			//教材注册表
			Set<CompileMateria> set12 = teacher.getCompileMateriaS();
			for (CompileMateria t : set12) {
				searchResultList.add(t);
			}

		}
		return searchResultList;

	}

	public ArrayList<Object> getMergeMessageList(String tea_id) {
		ArrayList<Object> searchResultList = new ArrayList<Object>();
		DetachedCriteria dc = DetachedCriteria.forClass(Teacher.class);
		dc.add(Restrictions.eq("tea_id", tea_id));
		List<Teacher> list = teacherDao.getList(dc);
		for (Teacher teacher : list) {
			Set<Thesis> set1 = teacher.getThesisS();
			for (Thesis t : set1) {
				searchResultList.add(t);
			}
			Set<Patent> set2 = teacher.getPatentS();
			for (Patent t : set2) {
				searchResultList.add(t);
			}
			Set<CompileMateria> set3 = teacher.getCompileMateriaS();
			for (CompileMateria t : set3) {
				searchResultList.add(t);
			}

		}
		return searchResultList;

	}
}
