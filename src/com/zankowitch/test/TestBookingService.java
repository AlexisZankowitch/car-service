package com.zankowitch.test;

import com.zankowitch.base.DBCar;
import com.zankowitch.base.DBDriver;
import com.zankowitch.entity.DBEntity;
import com.zankowitch.pojo.Car;
import com.zankowitch.pojo.CarWishes;
import com.zankowitch.pojo.Driver;
import com.zankowitch.service.BookingService;

import java.util.Objects;
import java.util.Scanner;

public class TestBookingService {


	/**
	 * Read stdin commands
	 *
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {

		DBDriver dbDriver = new DBDriver(new DBEntity<>());
		DBCar dbCar = new DBCar(new DBEntity<>());
		BookingService bookingService = new BookingService(1, dbCar, dbDriver);

		bookingService.resume();

		Scanner sc = new Scanner(System.in);
		System.out.println("write 0 to stop");
		System.out.println("What do you want to do ? \n" +
			"1 create car\n" +
			"2 create driver\n" +
			"3 list car \n" +
			"4 list driver \n" +
			"5 delete a car \n" +
			"6 delete a driver \n" +
			"7 instructions");
		int c = 1;
		String str;
		Car _car;
		Driver _driver;
		CarWishes _cw;
		while (c != 0) {
			c = sc.nextInt();
			switch (c) {
				case 1:
					System.out.print("please enter : model horsepower constructor registration seats.");
					System.out.println("ex: C3 7 Citroen 1A7ER 2");
					sc.nextLine();
					str = sc.nextLine();
					String[] car = str.split(" ", -1);
					if (car.length != 5) {
						System.out.println("error");
						break;
					}
					_car = new Car(car[0], Integer.parseInt(car[1]), car[2], car[3], Integer.parseInt(car[4]));
					dbCar.put(_car, _car.getId());
					break;
				case 2:
					System.out.print("please enter : name lastname. ex: alexis zankowitch");
					sc.nextLine();
					str = sc.nextLine();
					String[] driver = str.split(" ", -1);
					if (driver.length != 2) {
						System.out.println("error");
						break;
					}
					_driver = new Driver(driver[0], driver[1]);
					System.out.println("please enter horsePower seats. ex: 7 2");
					str = sc.nextLine();
					String[] cw = str.split(" ", -1);
					if (cw.length != 2) {
						System.out.println("error");
						break;
					}
					_cw = new CarWishes(Integer.parseInt(cw[0]), Integer.parseInt(cw[1]));
					_driver.setCarWishes(_cw);
					dbDriver.put(_driver, _driver.getId());
					break;
				case 3:
					System.out.println(dbCar.list());
					break;
				case 4:
					System.out.println(dbDriver.list());
					break;
				case 5:
					System.out.println("1 = deleted, 0 = can't delete");
					System.out.println("write car id to delete");
					sc.nextLine();
					str = sc.nextLine();
					System.out.println(dbCar.delete(str));
					break;
				case 6:
					System.out.println("1 = deleted, 0 = can't delete");
					System.out.println("write driver id to delete");
					sc.nextLine();
					str = sc.nextLine();
					System.out.println(dbDriver.delete(str));
					break;
				case 7:
					System.out.println("write exit to stop");
					System.out.println("What do you want to do ?\n" +
						"1 create car\n" +
						"2 create driver\n" +
						"3 list car \n" +
						"4 list driver \n" +
						"5 delete a car \n" +
						"6 delete a driver \n" +
						"7 instructions");
					break;
				case 0:
					System.out.println("Exiting...");
					bookingService.stop();
					break;
				default:
					System.out.println("Not supported yet");
					break;
			}

		}


	}
}
