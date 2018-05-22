package com.satz.common.util;

import static com.satz.common.util.Constants.DEFAULT_AC_ENERGY;
import static com.satz.common.util.Constants.DEFAULT_LIGHT_ENERGY;

import java.util.ArrayList;
import java.util.List;

import com.satz.infra.electricals.AirConditioner;
import com.satz.infra.electricals.Light;
import com.satz.infra.entities.Corridor;
import com.satz.infra.entities.Floor;
import com.satz.infra.entities.Hotel;

public class CommonUtil {

	/**
	 * builder for hotel object
	 * 
	 * @param noOfFloors
	 * @param noOfMainCorrs
	 * @param noOfSubCorrs
	 * @return
	 */
	public static Hotel buildHotel(int noOfFloors, int noOfMainCorrs, int noOfSubCorrs) {
		Light light = null;
		AirConditioner ac = null;
		List<Floor> floorList = new ArrayList<>();

		for (int index = 1; index <= noOfFloors; index++) {
			List<Corridor> corrList = new ArrayList<>();
			for (int i = 1; i <= noOfMainCorrs; i++) {
				light = new Light(DEFAULT_LIGHT_ENERGY);
				light.setStatus(true);
				ac = new AirConditioner(DEFAULT_AC_ENERGY);
				ac.setStatus(true);
				corrList.add(new Corridor(CorridorType.MAIN, i, light, ac));
			}

			for (int j = 1; j <= noOfSubCorrs; j++) {
				light = new Light(DEFAULT_LIGHT_ENERGY);
				ac = new AirConditioner(DEFAULT_AC_ENERGY);
				ac.setStatus(true);
				corrList.add(new Corridor(CorridorType.SUB, j, light, ac));
			}

			floorList.add(new Floor(index, corrList));
		}
		return new Hotel("PARK INN",floorList);

	}
}
