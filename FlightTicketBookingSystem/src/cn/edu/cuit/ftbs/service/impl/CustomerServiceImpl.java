package cn.edu.cuit.ftbs.service.impl;

import cn.edu.cuit.ftbs.dao.ICustomerDao;
import cn.edu.cuit.ftbs.dao.impl.CustomerDaoImpl;
import cn.edu.cuit.ftbs.entity.Customer;
import cn.edu.cuit.ftbs.service.ICustomerService;

/**
 * ICustomerService接口实现类
 * @author 陈星
 */
public class CustomerServiceImpl implements ICustomerService {
	ICustomerDao cd = new CustomerDaoImpl();

	@Override
	public boolean login(String username, String password) {
		try {
			return cd.checkCustomer(username, password);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean register(Customer customer) {
		try {
			return cd.doCreate(customer);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		try {
			return cd.doUpdate(customer);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Customer qureyCustomer(String username) {
		try {
			return cd.findByusername(username);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addCustomer(Customer customer) {
		try {
			return cd.doCreate(customer);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void logout(String customerID) {

	}

}
