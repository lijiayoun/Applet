package com.ssm.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.crud.beans.Employee;
import com.ssm.crud.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	/*
	 * ��ѯԱ�����ݣ���ҳ��ѯ��
	 * 
	 */
	@RequestMapping("/emps")
	public String getEmps(@RequestParam(value = "pn",defaultValue = "1") Integer pn,Model model){
		
		//����PageHelper��ҳ��ѯ
		//�ڲ�ѯ֮ǰֻ��Ҫ����:����ҳ��+ÿҳ�Ĵ�С
		PageHelper.startPage(pn, 5);
		
		//startPage��������������ѯ���Ƿ�ҳ��ѯ
		List<Employee> emps=employeeService.getAll();
		
		//ʹ��PageInfo��װ��ѯ��Ľ����ֻ��ҪPageInfo����ҳ������ˡ�
		//��װ����ϸ�ķ�ҳ��Ϣ�����������ǲ�ѯ����������,����������ʾ��ҳ��
		PageInfo page = new PageInfo(emps,5);
		model.addAttribute("pageInfo",page);
		
		return "list";
	}

}