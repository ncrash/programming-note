package com.ncrash.code.jackson;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Car.java
 * 
 * @author daekwon.kang
 * @since 2010. 2. 25.
 * @see
 */
public class Car {

    @NotNull
    private String manufacturer;

    @NotNull
    @Size(min = 2, max = 14)
    private String licensePlate;

    public Car(String manufacturer, String licencePlate) {

        super();
        this.setManufacturer(manufacturer);
        this.setLicensePlate(licencePlate);
    }

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public String getLicensePlate() {
		return licensePlate;
	}
}

