package com.dao;

import java.util.ArrayList;

import com.domain.Teacher;

public interface getListFromDBDao extends BaseDao<Teacher> {
	ArrayList<Object> getList(String tea_id);
}
