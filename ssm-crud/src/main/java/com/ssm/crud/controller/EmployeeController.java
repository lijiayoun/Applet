package com.ssm.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.crud.beans.Employee;
import com.ssm.crud.beans.Msg;
import com.ssm.crud.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	//此处应引入jackson包支持json数据
	@RequestMapping("/emps")
	@ResponseBody  //@ResponseBody可以自动地把返回的数据转化为json字符串
	public Msg getEmpsWithJson(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {
		
		PageHelper.startPage(pn, 5);

		List<Employee> emps = employeeService.getAll();

		PageInfo page = new PageInfo(emps, 5);
		return Msg.success().add("pageInfo", page);
	}

	/*
	  * 查询员工数据（分页查询）
	 * 
	 */
	// @RequestMapping("/emps")
	public String getEmps(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {


		//引入PageHelper分页查询
		//在查询之前只需要调用:传入页码+每页的大小
		PageHelper.startPage(pn, 5);

		//startPage后面紧跟的这个查询就是分页查询		
		List<Employee> emps = employeeService.getAll();


		//使用PageInfo包装查询后的结果，只需要PageInfo交给页面就行了。
		//封装了详细的分页信息，包括有我们查询出来的数据,传入连续显示的页数
		PageInfo page = new PageInfo(emps, 5);
		model.addAttribute("pageInfo", page);
		
		return "list";
	}

}