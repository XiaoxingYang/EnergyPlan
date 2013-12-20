package com.yxx.model;

public class TransportBean {
	private String departure;
	private String destination;
	private String vehicle;
	private int routeNo;
	private String leavingTime;
	private String arrivingTime;
	private int duration;
	private String durationText;
	private int distance;
	private String distanceText;
	private float carbon;
	
	public String getDeparture() {
		return departure;
	}
	public void setDeparture(String departure) {
		this.departure = departure;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getVehicle() {
		return vehicle;
	}
	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}
	public int getRouteNo() {
		return routeNo;
	}
	public void setRouteNo(int routeNo) {
		this.routeNo = routeNo;
	}
	public String getLeavingTime() {
		return leavingTime;
	}
	public void setLeavingTime(String leavingTime) {
		this.leavingTime = leavingTime;
	}
	public String getArrivingTime() {
		return arrivingTime;
	}
	public void setArrivingTime(String arrivingTime) {
		this.arrivingTime = arrivingTime;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public float getCarbon() {
		return carbon;
	}
	public void setCarbon(float carbon) {
		this.carbon = carbon;
	}
	public String getDurationText() {
		return durationText;
	}
	public void setDurationText(String durationText) {
		this.durationText = durationText;
	}
	public String getDistanceText() {
		return distanceText;
	}
	public void setDistanceText(String distanceText) {
		this.distanceText = distanceText;
	}
	

}
