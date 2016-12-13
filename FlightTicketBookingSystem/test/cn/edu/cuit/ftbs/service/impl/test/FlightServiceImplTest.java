package cn.edu.cuit.ftbs.service.impl.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import cn.edu.cuit.ftbs.entity.Flight;
import cn.edu.cuit.ftbs.service.IFlightService;
import cn.edu.cuit.ftbs.service.impl.FlightServiceImpl;

/**
 * 航班业务逻辑单元测试
 * @author xIa0che
 *
 */
public class FlightServiceImplTest {
	private IFlightService iFlightService = new FlightServiceImpl();
	private static SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	private static Date departureTime;
	private static Date arrivalTime;
	private static Flight flight;

	@BeforeClass
	public static void setupBeforeClass() throws ParseException{
		departureTime = ft.parse("2016-12-17 19:00");
		arrivalTime = ft.parse("2016-12-17 22:15");
		flight = new Flight("CA99992016-12-17", "CA9999", "中国国际航空公司", "320", "北京", "成都",
				departureTime, arrivalTime, 1690, 1610, 1140);
	}

	@Test
	public void testAddFlight() {
		iFlightService.addFlight(flight);
	}

	@Test
	public void testDeleteFlight() {
		iFlightService.deleteFlight("CA41942016-12-08");
	}

	@Test
	public void testUpdateFlight() {
		flight = new Flight("CA41942016-12-08", "CA4194", "中国国际航空公司", "737", "北京", "成都",
				departureTime, arrivalTime, 1690, 1610, 1140);
		iFlightService.updateFlight(flight);
	}

	@Test
	public void testQueryFlight() {
		List<Flight> flightList;
		flightList = iFlightService.queryFlight("北京", "成都", departureTime);
		for (Flight i : flightList){
			System.out.println(i.getId());
		}
	}

	@Test
	public void testQueryFlightAddAirline(){
		List<Flight> flightList;
		flightList =
				iFlightService.queryFlight("北京", "成都", departureTime, "中国国际航空公司");
		for (Flight i : flightList){
			System.out.println(i.getId());
		}
	}

	@Test
	public void testQueryFlightByid(){
		String id = "CA41102016-12-17";
		Flight flight = iFlightService.queryFlight(id);
		System.out.println(flight.getFlightNum());
	}

	@Test
	public void testQueryFlightByAirline(){
		String airline = "中国国际航空公司";
		List<Flight> flightList = iFlightService.queryFlightByAirline(airline);
		for (Flight flight : flightList){
			System.out.println(flight.getFlightNum());
		}
	}
}
