package org.inventivetalent.vectors.d2;

import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@SuppressWarnings({"unused", "WeakerAccess"})
public class Vector2DDouble implements IVector2D<Double> {

	public static final Vector2DDouble ZERO = new Vector2DDouble(0, 0);

	@Expose private final double x;
	@Expose private final double y;

	public Vector2DDouble(Vector2DInt intVector) {
		this(intVector.getX().doubleValue(), intVector.getY().doubleValue());
	}

	// Add

	public Vector2DDouble add(Vector2DDouble other) {
		return new Vector2DDouble(this.x + other.x, this.y + other.y);
	}

	public Vector2DDouble add(double x, double y) {
		return new Vector2DDouble(this.x + x, this.y + y);
	}

	public Vector2DDouble add(double d) {
		return add(d, d);
	}

	// Subtract

	public Vector2DDouble subtract(Vector2DDouble other) {
		return new Vector2DDouble(this.x - other.x, this.y - other.y);
	}

	public Vector2DDouble subtract(double x, double y) {
		return new Vector2DDouble(this.x - x, this.y - y);
	}

	public Vector2DDouble subtract(double d) {
		return subtract(d, d);
	}

	// Multiply

	public Vector2DDouble multiply(Vector2DDouble other) {
		return new Vector2DDouble(this.x * other.x, this.y * other.y);
	}

	public Vector2DDouble multiply(double x, double y) {
		return new Vector2DDouble(this.x * x, this.y * y);
	}

	public Vector2DDouble multiply(double d) {
		return multiply(d, d);
	}

	// Divide

	public Vector2DDouble divide(Vector2DDouble other) {
		return new Vector2DDouble(this.x / other.x, this.y / other.y);
	}

	public Vector2DDouble divide(double x, double y) {
		return new Vector2DDouble(this.x / x, this.y / y);
	}

	public Vector2DDouble divide(double d) {
		return divide(d, d);
	}

	// Length

	public double lengthSquared() {
		return square(this.x) + square(this.y);
	}

	public double length() {
		return Math.sqrt(lengthSquared());
	}

	// Distance

	public double distanceSquared(Vector2DDouble other) {
		return square(this.x - other.x) + square(this.y - other.y);
	}

	public double distance(Vector2DDouble other) {
		return Math.sqrt(lengthSquared());
	}

	// Dot

	public double dot(Vector2DDouble other) {
		return (this.x * other.x) + (this.y * other.y);
	}

	// Angle

	public double angle(Vector2DDouble other) {
		return Math.acos(this.dot(other) / (this.length() * other.length()));
	}

	// Midpoint

	public Vector2DDouble midpoint(Vector2DDouble other) {
		double x = (this.x + other.x) / 2.0D;
		double y = (this.y + other.y) / 2.0D;
		return new Vector2DDouble(x, y);
	}

	// Cross Product

	public Vector2DDouble crossProduct(Vector2DDouble other) {
		double x = (this.y * other.x) - (other.y * this.x);
		double y = (this.x * other.y) - (other.x * this.y);
		return new Vector2DDouble(x, y);
	}

	// Normalize

	public Vector2DDouble normalize() {
		return divide(length());
	}

	@Override
	public Double getX() {
		return x;
	}

	@Override
	public Double getY() {
		return y;
	}

	@Override
	public Vector2DDouble clone() {
		return new Vector2DDouble(this.x, this.y);
	}

	static double square(double d) {
		return d * d;
	}

}
