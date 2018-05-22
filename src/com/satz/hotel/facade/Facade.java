package com.satz.hotel.facade;

import java.util.Scanner;

import com.satz.common.util.CommonUtil;
import com.satz.common.util.CorridorType;
import com.satz.infra.entities.Hotel;
import com.satz.motion.sensor.SensorHandler;
import com.satz.motion.sensor.SensorRequest;

public class Facade {

	/**
	 * get inputs from user - hotel infra details & sensor input
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);

		System.out.println("Number of floors:");
		int noOfFloors = scanner.nextInt();
		System.out.println("Number of M.Corridor(s):");
		int noOfMainCorrs = scanner.nextInt();
		System.out.println("Number of S.Corridor(s):");
		int noOfSubCorrs = scanner.nextInt();

		Hotel hotel = CommonUtil.buildHotel(noOfFloors, noOfMainCorrs, noOfSubCorrs);
		hotel.displayStatus();

		String proceed = null;
		do {
			System.out.println("\nInput from Sensor:");
			System.out.println("Movement(true/false):");
			String movement = scanner.next();
			do {
				if (!movement.matches("true|TRUE|false|FALSE")) {
					System.out.println("Invalid input, enter only 'true' or 'false'");
					movement = scanner.next();
				}
			} while (!movement.matches("true|TRUE|false|FALSE"));
			boolean movementFound = Boolean.valueOf(movement);

			System.out.println("Floor no:");
			int floorNo = Integer.parseInt(scanner.next());
			System.out.println("Sub-Corridor no:");
			int corrNo = scanner.nextInt();
			SensorRequest sensorRequest = new SensorRequest(movementFound, floorNo, CorridorType.SUB, corrNo);
			feedSensorInput(sensorRequest, hotel);

			System.out.println("Do you wanna continue with another sensor signal(y/n)");
			proceed = scanner.next();
			do {
				if (!proceed.matches("y|Y|n|N")) {
					System.out.println("Invalid input, enter only 'y/Y' or 'n/N'");
					proceed = scanner.next();
				}
			} while (!proceed.matches("y|Y|n|N"));

		} while (proceed.equalsIgnoreCase("y"));

		scanner.close();
	}

	/**
	 * fed sensor input and hotel to power optimizer
	 * 
	 * @param sensorRequest
	 * @param hotel
	 */
	private static void feedSensorInput(SensorRequest sensorRequest, Hotel hotel) {
		SensorHandler.handleSensorRequest(sensorRequest, hotel);
		hotel.displayStatus();
	}

}
