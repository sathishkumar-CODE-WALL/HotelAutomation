package com.satz.infra.electricals;

public class Light extends ElectricalUnit{

	boolean status;
	double powerConsumptionPerHour;
	
	public Light(double powerConsumptionPerHour){
		this.powerConsumptionPerHour = powerConsumptionPerHour;
	}

	@Override
	public void switchON() {
		this.setStatus(true);		
	}

	@Override
	public void switchOFF() {
		this.setStatus(false);		
	}
	
	public double energyConsumed(){
		return this.status?this.powerConsumptionPerHour:0;
	}

	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public double getPowerConsumptionPerHour() {
		return powerConsumptionPerHour;
	}
	public void setPowerConsumptionPerHour(double powerConsumptionPerHour) {
		this.powerConsumptionPerHour = powerConsumptionPerHour;
	}

	
}
