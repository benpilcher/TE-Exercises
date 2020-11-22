package com.techelevator;

public class RectangleWall extends Wall {

	private int length;
	private int height;
	
	public RectangleWall (String name, String color, int length, int height) {
		super(name, color);
		this.length = length;
		this.height = height;
	}

	@Override
	public int getArea() {
		return this.length * this.height;
	}
	
	public String toString() {
		return getName() + " (" + getLength() + "x" + getHeight() + ") " + "rectangle";
	}
	
	public int getLength() {
		return length;
	}

	public int getHeight() {
		return height;
	}
	
}
