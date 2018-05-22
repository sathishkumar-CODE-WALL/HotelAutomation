package com.satz.hotel.facade;

import static com.satz.common.util.Constants.MAINPOWER;
import static com.satz.common.util.Constants.SUBPOWER;
import static com.satz.common.util.Constants.DEFAULT_AC_ENERGY;

import java.util.List;

import com.satz.command.CommandOFF;
import com.satz.command.CommandON;
import com.satz.common.util.CorridorType;
import com.satz.infra.entities.Corridor;
import com.satz.infra.entities.Floor;
import com.satz.infra.entities.Hotel;

public class PowerOptimizer {

	/**
	 * Optimization of power based on threshold power and energy consumed
	 * 
	 * sub corridor's acs are switched on/off for optimization
	 * 
	 * @param hotel
	 * @param floorNo
	 */
	public static void optimize(Hotel hotel, int floorNo) {

		Floor floor = hotel.getFloor(floorNo);
		List<Corridor> subCorridorList = hotel.getFloor(floorNo).getCorridorList(CorridorType.SUB);

		double thresholdPower = (hotel.getFloor(floorNo).getCorridorList(CorridorType.MAIN).size() * MAINPOWER)
				+ (hotel.getFloor(floorNo).getCorridorList(CorridorType.SUB).size() * SUBPOWER);

		if (floor.getTotalEnergyConsumed() > thresholdPower) {
			for (Corridor corridor : subCorridorList) {
				if (corridor.getAc().isStatus()) {
					CommandOFF acOff = new CommandOFF(corridor.getAc());
					acOff.execute();
					if (floor.getTotalEnergyConsumed() <= thresholdPower)
						break;
				}
			}
		} else if (thresholdPower - floor.getTotalEnergyConsumed() >= DEFAULT_AC_ENERGY) {
			for (Corridor corridor : subCorridorList) {
				if (!corridor.getAc().isStatus()) {
					CommandON acOn = new CommandON(corridor.getAc());
					acOn.execute();
					if (floor.getTotalEnergyConsumed() >= thresholdPower)
						break;
				}

			}
		}
	}

}
