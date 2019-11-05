package com.cg.cbs.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "locations")
@NamedQuery(name = "getCoordinates", query = "FROM Location where location=?1")
@NamedQuery(name = "getLocations", query = "FROM Location")
public class Location {
	
	@Id
	@Column(name = "location_id")
	private int locationId;
	
	@Column(name = "location")
	private String location;
	
	@Column(name = "x_coordinate")
	private int xCoordinate;
	
	@Column(name = "y_coordinate")
	private int yCoordinate;
	
	public Location() {
		
	}
	
	public Location(int locationId, String location, int xCoordinate, int yCoordinate) {
		super();
		this.locationId = locationId;
		this.location = location;
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
	}
	
	public int getLocationId() {
		return locationId;
	}
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
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
