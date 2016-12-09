package cn.edu.cuit.ftbs.service.impl.test;

import static org.junit.Assert.*;

import org.junit.Test;

import cn.edu.cuit.ftbs.entity.Customer;
import cn.edu.cuit.ftbs.entity.Flight;
import cn.edu.cuit.ftbs.entity.Ticket;
import cn.edu.cuit.ftbs.service.ITicketService;
import cn.edu.cuit.ftbs.service.impl.TicketServicelmpl;

public class TicketServicelmplTest {

	@Test
	public void testAddTicket() throws Exception {
		Flight flightinfo = new Flight("1");
		Customer customer =new Customer("1");
		Ticket ticket = new Ticket("1","头等舱",flightinfo,customer);
		ITicketService its = new TicketServicelmpl();
		its.addTicket(ticket);
	}

	@Test
	public void testDeleteTicket() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateTicket() {
		fail("Not yet implemented");
	}

	@Test
	public void testQueryTicket() {
		fail("Not yet implemented");
		
	}

}
