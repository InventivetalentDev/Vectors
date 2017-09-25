package org.inventivetalent.vectors.d2;

import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@SuppressWarnings({"unused", "WeakerAccess"})
public class Vector2DInt implements IVector2D<Integer> {

	public static final Vector2DInt ZERO = new Vector2DInt(0, 0);

	@Expose private final int x;
	@Expose private final int y;

	public Vector2DInt(Vector2DDouble doubleVector) {
		this(doubleVector.getX().intValue(), doubleVector.getY().intValue());
	}

	// Add

	public Vector2DInt add(Vector2DInt other) {
		return new Vector2DInt(this.x + other.x, this.y + other.y);
	}

	public Vector2DInt add(int x, int y) {
		return new Vector2DInt(this.x + x, this.y + y);
	}

	public Vector2DInt add(int i) {
		return add(i, i);
	}

	// Subtract

	public Vector2DInt subtract(Vector2DInt other) {
		return new Vector2DInt(this.x - other.x, this.y - other.y);
	}

	public Vector2DInt subtract(int x, int y) {
		return new Vector2DInt(this.x - x, this.y - y);
	}

	public Vector2DInt subtract(int i) {
		return subtract(i, i);
	}

	// Multiply

	public Vector2DInt multiply(Vector2DInt other) {
		return new Vector2DInt(this.x * other.x, this.y * other.y);
	}

	public Vector2DInt multiply(int x, int y) {
		return new Vector2DInt(this.x * x, this.y * y);
	}

	public Vector2DInt multiply(int i) {
		return multiply(i, i);
	}

	// Divide

	public Vector2DInt divide(Vector2DInt other) {
		return new Vector2DInt(this.x / other.x, this.y / other.y);
	}

	public Vector2DInt divide(int x, int y) {
		return new Vector2DInt(this.x / x, this.y / y);
	}

	public Vector2DInt divide(int i) {
		return divide(i, i);
	}

	// Length

	public double lengthSquared() {
		return square(this.x) + square(this.y);
	}

	public double length() {
		return Math.sqrt(lengthSquared());
	}

	// Distance

	public double distanceSquared(Vector2DInt other) {
		return square(this.x - other.x) + square(this.y - other.y);
	}

	public double distance(Vector2DInt other) {
		return Math.sqrt(lengthSquared());
	}

	// Dot

	public double dot(Vector2DInt other) {
		return (this.x * other.x) + (this.y * other.y);
	}

	// Angle

	public double angle(Vector2DInt other) {
		return Math.acos(this.dot(other) / (this.length() * other.length()));
	}

	// Midpoint

	public Vector2DInt midpoint(Vector2DInt other) {
		double x = (this.x + other.x) / 2.0D;
		double y = (this.y + other.y) / 2.0D;
		return new Vector2DInt((int) x, (int) y);
	}

	// Cross Product

	public Vector2DInt crossProduct(Vector2DInt other) {
		double x = (this.y * other.x) - (other.y * this.x);
		double y = (this.x * other.y) - (other.x * this.y);
		return new Vector2DInt((int) x, (int) y);
	}

	// Normalize

	public Vector2DInt normalize() {
		double length = this.length();
		double x = this.x / length;
		double y = this.y / length;
		return new Vector2DInt((int) x, (int) y);
	}

	@Override
	public Integer getX() {
		return x;
	}

	@Override
	public Integer getY() {
		return y;
	}

	@Override
	public Vector2DInt clone() {
		return new Vector2DInt(this.x, this.y);
	}

	static double square(double d) {
		return d * d;
	}

}
