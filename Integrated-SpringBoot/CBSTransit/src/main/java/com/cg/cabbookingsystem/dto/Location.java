package com.cg.cabbookingsystem.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

/**
 * Data transfer object class for Location object.
 *
 * @author Aman Dungarwal
 * @version 1.0
 */
@Entity
@NamedQuery(name = "fetchByName", query = "FROM Location Where name=:name")
public class Location {

	/** The location id. */
	@Id
	private int locationId;

	/** The name. */
	@Column(length = 50)
	private String name;

	/** The x coordinate. */
	private int xCoordinate;

	/** The y coordinate. */
	private int yCoordinate;

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the x coordinate.
	 *
	 * @return the x coordinate
	 */
	public int getxCoordinate() {
		return xCoordinate;
	}

	/**
	 * Sets the x coordinate.
	 *
	 * @param xCoordinate the new x coordinate
	 */
	public void setxCoordinate(int xCoordinate) {
		this.xCoordinate = xCoordinate;
	}

	/**
	 * Gets the y coordinate.
	 *
	 * @return the y coordinate
	 */
	public int getyCoordinate() {
		return yCoordinate;
	}

	/**
	 * Sets the y coordinate.
	 *
	 * @param yCoordinate the new y coordinate
	 */
	public void setyCoordinate(int yCoordinate) {
		this.yCoordinate = yCoordinate;
	}
}