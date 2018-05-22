package com.satz.command;

import com.satz.infra.electricals.ElectricalUnit;

public class CommandON implements Command{

	ElectricalUnit electricalUnit;
	
	public CommandON(ElectricalUnit electricalUnit){
		this.electricalUnit = electricalUnit;
	}
	
	@Override
	public void execute() {
		electricalUnit.switchON();
	}

}
