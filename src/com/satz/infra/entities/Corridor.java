package com.satz.infra.entities;

import com.satz.common.util.CorridorType;
import com.satz.infra.electricals.AirConditioner;
import com.satz.infra.electricals.Light;

public class Corridor {

	CorridorType corridorType;
	int corridorNo;
	Light light;
	AirConditioner ac;
	
	public Corridor(CorridorType corridorType,int corridorNo,Light light,AirConditioner ac){
		this.corridorType=corridorType;
		this.corridorNo=corridorNo;
		this.light=light;
		this.ac=ac;
	}
	
	public Corridor(CorridorType corridorType,int corridorNo){
		this.corridorType=corridorType;
		this.corridorNo=corridorNo;
	}
	 
	public double getTotalEnergyConsumed(){
		return this.light.energyConsumed() + this.ac.energyConsumed();
	}

	public void displayStatus(){
		System.out.print(this.getCorridorType().toString()+" Corridor "+this.getCorridorNo());
		System.out.print("	Light :"+(this.light.isStatus()?"ON":"OFF"));
		System.out.print("	AC status:"+(this.ac.isStatus()?"ON":"OFF"));
		System.out.println();
	}
	
	public Corridor(int corridorNo){
		this.corridorNo=corridorNo;
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

	public Light getLight() {
		return light;
	}

	public void setLight(Light light) {
		this.light = light;
	}

	public AirConditioner getAc() {
		return ac;
	}

	public void setAc(AirConditioner ac) {
		this.ac = ac;
	}
	
}
