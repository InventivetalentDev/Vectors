/*
 * Copyright 2016 inventivetalent. All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without modification, are
 *  permitted provided that the following conditions are met:
 *
 *     1. Redistributions of source code must retain the above copyright notice, this list of
 *        conditions and the following disclaimer.
 *
 *     2. Redistributions in binary form must reproduce the above copyright notice, this list
 *        of conditions and the following disclaimer in the documentation and/or other materials
 *        provided with the distribution.
 *
 *  THIS SOFTWARE IS PROVIDED BY THE AUTHOR ''AS IS'' AND ANY EXPRESS OR IMPLIED
 *  WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 *  FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE AUTHOR OR
 *  CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 *  CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 *  SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 *  ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 *  NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 *  ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 *  The views and conclusions contained in the software and documentation are those of the
 *  authors and contributors and should not be interpreted as representing official policies,
 *  either expressed or implied, of anybody else.
 */

package org.inventivetalent.vectors.d2;

import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
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

	public Vector2DDouble clone() {
		return new Vector2DDouble(this.x, this.y);
	}

	static double square(double d) {
		return d * d;
	}

}
