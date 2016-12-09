package cn.edu.cuit.ftbs.entity;

import java.util.Date;

/**
 * 航班实体类
 * @author xIa0che
 *
 */
public class Flight {
	String id;
	String flightNum;
	String airline;
	String planeType;
	String depatureCity;
	String arrivalCity;
	Date departureTime;
	Date arrivalTime;
	int firstClassCabinPrice;
	int businessClassCabinPrice;
	int economyClassCabinPrice;


	public Flight() {
	}


	public Flight(String id, String flightNum, String airline, String planeType, String depatureCity,
			String arrivalCity, Date departureTime, Date arrivalTime, int firstClassCabinPrice,
			int businessClassCabinPrice, int economyClassCabinPrice) {
		super();
		this.id = id;
		this.flightNum = flightNum;
		this.airline = airline;
		this.planeType = planeType;
		this.depatureCity = depatureCity;
		this.arrivalCity = arrivalCity;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.firstClassCabinPrice = firstClassCabinPrice;
		this.businessClassCabinPrice = businessClassCabinPrice;
		this.economyClassCabinPrice = economyClassCabinPrice;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public String getFlightNum() {
		return flightNum;
	}

	public void setFlightNum(String flightNum) {
		this.flightNum = flightNum;
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public String getPlaneType() {
		return planeType;
	}

	public void setPlaneType(String planeType) {
		this.planeType = planeType;
	}

	public String getDepatureCity() {
		return depatureCity;
	}

	public void setDepatureCity(String depatureCity) {
		this.depatureCity = depatureCity;
	}

	public String getArrivalCity() {
		return arrivalCity;
	}

	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}

	public Date getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}

	public Date getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}



	public int getFirstClassCabinPrice() {
		return firstClassCabinPrice;
	}



	public void setFirstClassCabinPrice(int firstClassCabinPrice) {
		this.firstClassCabinPrice = firstClassCabinPrice;
	}



	public int getBusinessClassCabinPrice() {
		return businessClassCabinPrice;
	}



	public void setBusinessClassCabinPrice(int businessClassCabinPrice) {
		this.businessClassCabinPrice = businessClassCabinPrice;
	}



	public int getEconomyClassCabinPrice() {
		return economyClassCabinPrice;
	}



	public void setEconomyClassCabinPrice(int economyClassCabinPrice) {
		this.economyClassCabinPrice = economyClassCabinPrice;
	}

}
