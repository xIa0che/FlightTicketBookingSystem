package cn.edu.cuit.ftbs.entity;

import java.util.Set;

public class Cabin {
	Set<String> firstClassCabinLayout;
	Set<String> businessClassLayout;
	Set<String> economyClassLayout;
	int firstClassCabinNum;
	int businessClassCabinNum;
	int economyClassCabinNum;
	double firstClassCabinPrice;
	double businessClassCabinPrice;
	double economyClassCabinPrice;

	public Cabin(int firstClassCabinNum, int businessClassCabinNum, int economyClassCabinNum,
			double firstClassCabinPrice, double businessClassCabinPrice, double economyClassCabinPrice) {
		this.firstClassCabinNum = firstClassCabinNum;
		this.businessClassCabinNum = businessClassCabinNum;
		this.economyClassCabinNum = economyClassCabinNum;
		this.firstClassCabinPrice = firstClassCabinPrice;
		this.businessClassCabinPrice = businessClassCabinPrice;
		this.economyClassCabinPrice = economyClassCabinPrice;
	}

	public Set<String> getFirstClassCabinLayout() {
		return firstClassCabinLayout;
	}
	public void setFirstClassCabinLayout(Set<String> firstClassCabinLayout) {
		this.firstClassCabinLayout = firstClassCabinLayout;
	}
	public Set<String> getBusinessClassLayout() {
		return businessClassLayout;
	}
	public void setBusinessClassLayout(Set<String> businessClassLayout) {
		this.businessClassLayout = businessClassLayout;
	}
	public Set<String> getEconomyClassLayout() {
		return economyClassLayout;
	}
	public void setEconomyClassLayout(Set<String> economyClassLayout) {
		this.economyClassLayout = economyClassLayout;
	}
	public int getFirstClassCabinNum() {
		return firstClassCabinNum;
	}
	public void setFirstClassCabinNum(int firstClassCabinNum) {
		this.firstClassCabinNum = firstClassCabinNum;
	}
	public int getBusinessClassCabinNum() {
		return businessClassCabinNum;
	}
	public void setBusinessClassCabinNum(int businessClassCabinNum) {
		this.businessClassCabinNum = businessClassCabinNum;
	}
	public int getEconomyClassCabinNum() {
		return economyClassCabinNum;
	}
	public void setEconomyClassCabinNum(int economyClassCabinNum) {
		this.economyClassCabinNum = economyClassCabinNum;
	}
	public double getFirstClassCabinPrice() {
		return firstClassCabinPrice;
	}
	public void setFirstClassCabinPrice(double firstClassCabinPrice) {
		this.firstClassCabinPrice = firstClassCabinPrice;
	}
	public double getBusinessClassCabinPrice() {
		return businessClassCabinPrice;
	}
	public void setBusinessClassCabinPrice(double businessClassCabinPrice) {
		this.businessClassCabinPrice = businessClassCabinPrice;
	}
	public double getEconomyClassCabinPrice() {
		return economyClassCabinPrice;
	}
	public void setEconomyClassCabinPrice(double economyClassCabinPrice) {
		this.economyClassCabinPrice = economyClassCabinPrice;
	}

}
