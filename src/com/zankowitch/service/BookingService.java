package com.zankowitch.service;

import com.zankowitch.base.DBCar;
import com.zankowitch.base.DBDriver;
import com.zankowitch.pojo.Car;
import com.zankowitch.pojo.CarWishes;
import com.zankowitch.pojo.Driver;

import java.util.ArrayList;
import java.util.concurrent.*;

public class BookingService {

	private Semaphore semaphore;
	private Boolean isRunning = false;
	private Future<?> future;
	private ScheduledExecutorService executor;
	private DBCar dbCar;
	private DBDriver dbDriver;

	public BookingService(int permits, DBCar dbCar, DBDriver dbDriver) {
		this.dbCar = dbCar;
		this.dbDriver = dbDriver;
		this.future = null;
		this.semaphore = new Semaphore(permits);
		this.executor = Executors.newScheduledThreadPool(1);
	}

	public void pause() {
		if (!isRunning)
			return;
		future.cancel(true);
		isRunning = false;
	}

	public void resume() {
		start();
		System.out.println("Booking service has started !!!! ");
	}

	public void stop() {
		executor.shutdownNow();
		System.out.println("service stopped");
	}

	private void bookCar() {

		//check if car is free
		ArrayList<Car> _cars = new ArrayList<>();
		for (Car car : dbCar.list()) {
			if (null == car.getDriver())
				_cars.add(car);
		}


		CarWishes _cw;
		for (Driver driver : dbDriver.list()) {
			if (!driver.getHasBooked()) {
				_cw = driver.getCarWishes();
				if(null == _cw)
					return;
				for (Car car : _cars) {
					if (car.getHorsePower() == _cw.getHorsePower() && car.getSeats() == _cw.getSeats()) {
						System.out.println("Car has been found !! ");
						driver.setHasBooked(true);
						car.setDriver(driver);
						System.out.println(car);
					}
				}
			}
		}
	}


	private void start() {
		if (isRunning)
			return;
		isRunning = true;
		future = executor.scheduleAtFixedRate(() -> {
			try {
				semaphore.acquire();
				bookCar();
				semaphore.release();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}, 0, 1000, TimeUnit.MILLISECONDS);
	}
}
