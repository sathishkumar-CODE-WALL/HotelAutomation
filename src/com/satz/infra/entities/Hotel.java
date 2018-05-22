package com.satz.infra.entities;

import java.util.ArrayList;
import java.util.List;

import com.satz.common.util.CorridorType;

public class Hotel {
	
	String hotelName;
	List<Floor> floors= new ArrayList<Floor>();
	
	public Hotel(String hotelName, List<Floor> floors){
		this.floors = floors;
		this.hotelName=hotelName;
	}
	
	public Hotel(List<Floor> floors){
		this.floors=floors;
	}
	
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public List<Floor> getFloors() {
		return floors;
	}
	public void setFloors(List<Floor> floors) {
		this.floors = floors;
	}
	
	public Floor getFloor(int floorId){
		return this.getFloors().stream().filter(floor->floor.getFloorNo()==floorId).findAny().orElse(null);
	}
	
	public void displayStatus(){
		for(Floor floor : this.getFloors()){
			System.out.println("Floor No:"+floor.getFloorNo());
			for(Corridor corridor : floor.getCorridorList()){
				corridor.displayStatus();
			}
		}
	}
	
	public double getTotalEnergyConsumption(){
		double energy=0.0;
		for(Floor floor : this.getFloors()){
			energy+=floor.getCorridorList().stream().mapToDouble(corr->corr.getTotalEnergyConsumed()).sum();
		}
		return energy;
	}
	
	
	public int floorCount(){
		return this.floors.size();
	}
	
	public long getTotalCorrCountByType(CorridorType corrType){
		long totalCorr=0l;
		for(Floor floor : this.getFloors()){
			totalCorr+=floor.getCorridorList().stream().filter(corr-> corr.getCorridorType()==corrType).count();
		}
		return totalCorr;
	}
	
	public long getTotalCorrCount(CorridorType corrType){
		long totalCorr=0l;
		for(Floor floor : this.getFloors()){
			totalCorr+=floor.getCorridorList().stream().count();
		}
		return totalCorr;
	}
	
		
}
