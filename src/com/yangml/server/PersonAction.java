package com.yangml.server;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;

public class PersonAction extends BaseAction{
	private String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) throws UnsupportedEncodingException {
		this.name = new String(name.getBytes("ISO-8859-1"),"utf-8");
	}
	/**
	 * 返回person的Json数据
	 * @return
	 */
	public String getPersons(){
		List<Person> list = getPList();
		JSONArray jsonArray = JSONArray.fromObject(list);
		getResponse().setContentType("text/html;charset=UTF-8");
		try {
			getResponse().getWriter().print(jsonArray.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 返回Person的信息
	 * @return
	 */
	public List<Person> getPList(){
		List<Person> list = new ArrayList<Person>();
		for(int i=0;i<10;i++){
			Person p = new Person();
			p.setName(name+i);
			p.setAge(10+i);
			p.setAddr("北京"+i);
			list.add(p);
		}
		return list;
	}
}
