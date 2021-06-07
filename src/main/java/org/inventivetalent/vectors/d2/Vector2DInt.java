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

public class Vector2DInt implements IVector2D<Integer> {

	public static final Vector2DInt ZERO = new Vector2DInt(0, 0);

	@Expose private final int x;
	@Expose private final int y;

	public Vector2DInt(Vector2DDouble doubleVector) {
		this(doubleVector.getX().intValue(), doubleVector.getY().intValue());
	}

	public Vector2DInt(int x, int y) {
		this.x = x;
		this.y = y;
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

	public Vector2DInt clone() {
		return new Vector2DInt(this.x, this.y);
	}

	static double square(double d) {
		return d * d;
	}

}
