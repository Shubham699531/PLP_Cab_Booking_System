package com.cg.cbs.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

/**
 * DTO for holding Location Details
 * @author Akash
 *
 */
@Entity
@NamedQuery(name = "fetchByName", query = "FROM Location Where name=:name")
@NamedQuery(name = "getCoordinates" , query = "FROM Location WHERE name=:name")
@NamedQuery(name = "getAllLocations", query = "FROM Location")
public class Location {

	@Id
	private int locationId;
	@Column(length = 50)
	private String name;
	private int xCoordinate;
	private int yCoordinate;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getxCoordinate() {
		return xCoordinate;
	}

	public void setxCoordinate(int xCoordinate) {
		this.xCoordinate = xCoordinate;
	}

	public int getyCoordinate() {
		return yCoordinate;
	}

	public void setyCoordinate(int yCoordinate) {
		this.yCoordinate = yCoordinate;
	}
}