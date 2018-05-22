package com.satz.command;

import com.satz.infra.electricals.ElectricalUnit;

public class CommandOFF implements Command{

	ElectricalUnit electricalUnit;
	
	public CommandOFF(ElectricalUnit electricalUnit){
		this.electricalUnit = electricalUnit;
	}
	
	@Override
	public void execute() {
		electricalUnit.switchOFF();
	}

}
