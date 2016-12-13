package cn.edu.cuit.ftbs.ui.test;

import cn.edu.cuit.ftbs.entity.Customer;
import cn.edu.cuit.ftbs.service.ICustomerService;
import cn.edu.cuit.ftbs.service.impl.CustomerServiceImpl;
import cn.edu.cuit.ftbs.ui.UserInfoFrame;

/**
 * 测试用户信息窗体
 *
 * @author 陈星
 */
public class UserInfoFrameTest {
	static ICustomerService ics = new CustomerServiceImpl();
	static Customer customer;
	/*
	public static void main(String[] args) {
		try {
			customer = ics.qureyCustomer("dengyi");
		} catch (Exception e) {
			e.printStackTrace();
		}
		UserInfoFrame userinfo = new UserInfoFrame(customer);
		userinfo.setVisible(true);
	}*/

}
