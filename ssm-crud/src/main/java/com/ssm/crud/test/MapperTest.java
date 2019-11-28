package com.ssm.crud.test;

import java.util.List;
import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ssm.crud.beans.Department;
import com.ssm.crud.beans.Employee;
import com.ssm.crud.dao.DepartmentMapper;
import com.ssm.crud.dao.EmployeeMapper;
/* ����SpringTestģ��
 * @ContextConfigurationָ��spring�����ļ�λ��
 * ֱ��autowired
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:applicationContext.xml"})
public class MapperTest {
	@Autowired
	DepartmentMapper departmentMapper;
	@Autowired
	EmployeeMapper employeeMapper;
	@Autowired
	SqlSession sqlSession;
	@Test
	public void TestCRUD() {
		
//		ApplicationContext context=new ClassPathXmlApplicationContext("resources/applicationContext.xml");
//
//		departmentMapper.insertSelective(new Department(null,"������"));
//		departmentMapper.insertSelective(new Department(null,"����"));
		
		//������sqlSession
//		for() {
//			employeeMapper.insertSelective(new Employee(null,"Jerry","m","Jerry@ssm.com",1));
//			
//		}
		
//		EmployeeMapper mapper =sqlSession.getMapper(EmployeeMapper.class);
//		
//		for(int i=0;i<100;i++) {
//			String uid=UUID.randomUUID().toString().substring(0,5)+i;
//			mapper.insertSelective(new Employee(null,uid,"M",uid+"@ssm.com",1));
//			
//		}
//		
//		System.out.println("������ɣ�");
		
		//��ѯidΪ1��Ա����Ϣ���Լ������ڲ�����Ϣ
//		Employee employee=employeeMapper.selectByPrimaryKeyWithDept(1);
//		System.out.println(employee);
		
		Department department=departmentMapper.selectByPrimaryKeyWithEmp(2);
		System.out.println(department);
	
	}
}