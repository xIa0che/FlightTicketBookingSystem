package cn.edu.cuit.ftbs.entity;

import java.util.Date;

public class Flight {
	String flightNum;
	String airline;
	String planeType;
	String depatureCity;
	String arrivalCity;
	Date departureTime;
	Date arrivalTime;

	public Flight(String flightNum, String airline, String planeType, String depatureCity, String arrivalCity,
			Date departureTime, Date arrivalTime) {
		this.flightNum = flightNum;
		this.airline = airline;
		this.planeType = planeType;
		this.depatureCity = depatureCity;
		this.arrivalCity = arrivalCity;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
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
}
