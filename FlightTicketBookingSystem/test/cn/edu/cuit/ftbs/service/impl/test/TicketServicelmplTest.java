package cn.edu.cuit.ftbs.service.impl.test;

import java.util.List;

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
		Customer customer =new Customer("xiaoxing");
		Ticket ticket = new Ticket("头等舱","6",flightinfo,customer);
		ITicketService its = new TicketServicelmpl();
		its.addTicket(ticket);
	}

	@Test
	public void testDeleteTicket() {
		ITicketService its = new TicketServicelmpl();
		its.deleteTicket("4");
	}

	@Test
	public void testUpdateTicket() {
		ITicketService its = new TicketServicelmpl();
		Flight flightinfo = new Flight("1");
		Customer customer =new Customer("xiaodeng");
		Ticket ticket = new Ticket("经济舱","7",flightinfo,customer);
		its.updateTicket(ticket);
	}

	@Test
	public void testQueryTicket() {
		List<Ticket> ticket;
		ITicketService its = new TicketServicelmpl();
		ticket = its.queryTicket("xiaodeng");
		for(Ticket i: ticket){
		System.out.println(i.getSeatClass());
		System.out.println(i.getTicketNum());
		System.out.println(i.getCustomer().getUsername());
		System.out.println(i.getFlightInfo().getId());
		}
		
	}

}
