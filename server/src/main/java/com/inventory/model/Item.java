package com.inventory.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	String name;
	String Skunum;
	Integer weight;
	Integer sensor_id;
	Integer quantity;
	Integer row;
	Integer col;
	Integer x;
	Integer y;
	Integer z;
	public Item() { }

	public Item(Long id, String name, String skunum, Integer weight, Integer sensor_id, Integer quantity, Integer row, Integer col, Integer x, Integer y, Integer z) {
		this.id = id;
		this.name = name;
		this.Skunum = skunum;
		this.weight = weight;
		this.sensor_id = sensor_id;
		this.quantity = quantity;
		this.row = row;
		this.col = col;
		this.y = y;
		this.z = z;
		this.x = x;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCol() {
		return col;
	}

	public void setCol(Integer col) {
		this.col = col;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public Integer getRow() {
		return row;
	}

	public Integer getSensor_id() {
		return sensor_id;
	}

	public Integer getWeight() {
		return weight;
	}

	public Integer getX() {
		return x;
	}

	public Integer getY() {
		return y;
	}

	public Integer getZ() {
		return z;
	}

	public String getSkunum() {
		return Skunum;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public void setRow(Integer row) {
		this.row = row;
	}

	public void setSensor_id(Integer sensor_id) {
		this.sensor_id = sensor_id;
	}

	public void setSkunum(String skunum) {
		this.Skunum = skunum;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public void setX(Integer x) {
		this.x = x;
	}

	public void setY(Integer y) {
		this.y = y;
	}

	public void setZ(Integer z) {
		this.z = z;
	}
}
