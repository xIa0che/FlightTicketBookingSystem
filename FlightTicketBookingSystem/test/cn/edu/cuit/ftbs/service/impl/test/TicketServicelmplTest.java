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
		Customer customer =new Customer("xiaodeng");
		Ticket ticket = new Ticket("头等舱","3",flightinfo,customer);
		ITicketService its = new TicketServicelmpl();
		its.addTicket(ticket);
	}

	@Test
	public void testDeleteTicket() {
		ITicketService its = new TicketServicelmpl();
		its.deleteTicket("xiaodeng");
	}

	@Test
	public void testUpdateTicket() {
		ITicketService its = new TicketServicelmpl();
		its.updateTicket("xiaodeng");
		System.out.println("chenggong");
	}

	@Test
	public void testQueryTicket() {
		ITicketService its = new TicketServicelmpl();
		Ticket ticket = its.queryTicket("xiaodeng");
		System.out.println(ticket.getSeatClass());
		System.out.println(ticket.getTicketNum());
		System.out.println(ticket.getCustomer().getUsername());
		System.out.println(ticket.getFlightInfo().getId());
		
	}

}
