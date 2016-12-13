package cn.edu.cuit.ftbs.service.impl.test;

import org.junit.Test;

import cn.edu.cuit.ftbs.entity.Customer;
import cn.edu.cuit.ftbs.service.ICustomerService;
import cn.edu.cuit.ftbs.service.impl.CustomerServiceImpl;
/**
 * 对数据访问层update方法进行单元测试
 * @author 陈星
 */
public class CustomerServiceImplTest {
	private ICustomerService iCustomerService = new CustomerServiceImpl();
	private Customer customer;


	@Test
	public void testUpdateCustomer() throws Exception {
		customer = iCustomerService.qureyCustomer("dengyi");
		System.out.println(customer.getUsername());
		customer.setSex("女");
		iCustomerService.updateCustomer(customer);
	}

}
