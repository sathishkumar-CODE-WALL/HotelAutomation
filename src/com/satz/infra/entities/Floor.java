package com.satz.infra.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.satz.common.util.CorridorType;

public class Floor {
	
	int floorNo;
	List<Corridor> corridorList = new ArrayList<>();

	public Floor(int floorNo, List<Corridor> corridorList){
		this.floorNo = floorNo;
		this.corridorList = corridorList;
	}
	public Floor(int floorNo){
		this.floorNo = floorNo;
	}
	
	public int getFloorNo() {
		return floorNo;
	}

	public void setFloorNo(int floorNo) {
		this.floorNo = floorNo;
	}

	public List<Corridor> getCorridorList() {
		return corridorList;
	}
	
	public List<Corridor> getCorridorList(CorridorType corridorType) {
		return this.corridorList.stream().filter(corridor->corridor.getCorridorType().equals(corridorType)).collect(Collectors.toList());
	}

	public void setCorridorList(List<Corridor> corridorList) {
		this.corridorList = corridorList;
	}
	
	public Corridor getCorridor(CorridorType corrType, int corrNo){
		return this.getCorridorList().stream().filter(corridor->corridor.getCorridorNo()==corrNo && corridor.getCorridorType().equals(corrType)).findAny().orElse(null);
	}
	
	public double getTotalEnergyConsumed(){
		return this.getCorridorList().stream().mapToDouble(corr->corr.getTotalEnergyConsumed()).sum();
	}
	

}
