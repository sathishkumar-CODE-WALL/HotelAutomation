package com.satz.motion.sensor;

import com.satz.command.CommandOFF;
import com.satz.command.CommandON;
import com.satz.hotel.facade.PowerOptimizer;
import com.satz.infra.entities.Corridor;
import com.satz.infra.entities.Hotel;

public class SensorHandler {

	/**
	 * based on motion, sitch on/off light and call powerOptimizer
	 * 
	 * @param sensorReq
	 * @param hotel
	 */
	public static void handleSensorRequest(SensorRequest sensorReq, Hotel hotel) {

		Corridor corr = hotel.getFloor(sensorReq.getFloorNo()).getCorridor(sensorReq.getCorridorType(),
				sensorReq.getCorridorNo());

		if (!sensorReq.isMovement()) {
			CommandOFF lightOff = new CommandOFF(corr.getLight());
			lightOff.execute();
			PowerOptimizer.optimize(hotel, sensorReq.getFloorNo());
		} else {
			if (!corr.getLight().isStatus()) {
				CommandON lightOn = new CommandON(corr.getLight());
				lightOn.execute();
				PowerOptimizer.optimize(hotel, sensorReq.getFloorNo());
			}
		}
	}
}
