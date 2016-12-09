package cn.edu.cuit.ftbs.entity;

/**
 * 机票实体类
 * @author 邓义
 *
 */
public class Ticket {
	
    private  String seatClass;
    private  String ticketNum;
    private Flight flightInfo;
    private Customer customer;


    public Ticket(){}

    public Ticket( String ticketNum,String seatClass){
    	setSeatClass(seatClass);
    	setTicketNum(ticketNum);
    }

	public Ticket(String seatClass, String ticketNum, Flight flightInfo, Customer customer) {
		super();
		this.seatClass = seatClass;
		this.ticketNum = ticketNum;
		this.flightInfo = flightInfo;
		this.customer = customer;
	}

	public  String getSeatClass() {
		return seatClass;
	}

	public void setSeatClass(String seatClass) {
		this.seatClass = seatClass;
	}

	public  String getTicketNum() {
		return ticketNum;
	}

	public void setTicketNum(String ticketNum) {
		this.ticketNum = ticketNum;
	}

	public Flight getFlightInfo() {
		return flightInfo;
	}

	public void setFlightInfo(Flight flightInfo) {
		this.flightInfo = flightInfo;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


}
