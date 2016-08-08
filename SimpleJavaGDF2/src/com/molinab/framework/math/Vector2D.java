package com.molinab.framework.math;

/**
 *	Vector2D represents a two-dimensional vector represented using x and y components.
 *	Vector2D can be uesd to represent things like position, velocity and acceleration.
 *
 *	See Background and Scrollable classes to see examples of Vector2D in action.
 */

public class Vector2D {
	
	public float x, y;
	public Vector2D clone;
	
	public Vector2D(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public void add(Vector2D other) {
		this.x += other.x;
		this.y += other.y;
	}
	
	public Vector2D scale(float scalar) {
		x *= scalar;
		y *= scalar;
		return this;
	}
	
	public float getMagnitude() {
		return (float) Math.sqrt((x * x) + (y * y));
	}
	
	// Retrieve a clone Vector2D with identical x and y values to the instance.
	public Vector2D getClone() {
		if (clone != null) {
			clone.x = x;
			clone.y = y;
			return clone;
		} 
		clone = new Vector2D(x, y);
		return clone;
	}
	
}
