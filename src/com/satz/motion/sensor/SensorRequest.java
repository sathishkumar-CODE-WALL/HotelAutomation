package com.satz.motion.sensor;

import com.satz.common.util.CorridorType;

public class SensorRequest {
	
	boolean isMovement;
	int floorNo;
	CorridorType corridorType;
	int corridorNo;
	
	public SensorRequest(boolean isMovement,int floorNo,CorridorType corridorType,int corridorNo){
		this.isMovement=isMovement;
		this.floorNo=floorNo;
		this.corridorType=corridorType;
		this.corridorNo=corridorNo;
	}
	
	public boolean isMovement() {
		return isMovement;
	}
	public void setMovement(boolean isMovement) {
		this.isMovement = isMovement;
	}
	public int getFloorNo() {
		return floorNo;
	}
	public void setFloorNo(int floorNo) {
		this.floorNo = floorNo;
	}
	public CorridorType getCorridorType() {
		return corridorType;
	}
	public void setCorridorType(CorridorType corridorType) {
		this.corridorType = corridorType;
	}
	public int getCorridorNo() {
		return corridorNo;
	}
	public void setCorridorNo(int corridorNo) {
		this.corridorNo = corridorNo;
	}
	
	public String toString(){
		return "\nMovement:"+this.isMovement+"\nFloorNo:"+this.floorNo+"\nCorridorType:"+this.corridorType+"\nCorrNo:"+this.corridorNo;
	}
	
}
