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

package org.inventivetalent.vectors.d3;

import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Vector3DInt implements IVector3D<Integer> {

	public static final Vector3DInt ZERO = new Vector3DInt(0, 0, 0);

	@Expose public final int x;
	@Expose public final int y;
	@Expose public final int z;

	public Vector3DInt(Vector3DDouble doubleVector) {
		this(doubleVector.getX().intValue(), doubleVector.getY().intValue(), doubleVector.getZ().intValue());
	}

	// Add

	public Vector3DInt add(Vector3DInt other) {
		return new Vector3DInt(this.x + other.x, this.y + other.y, this.z + other.z);
	}

	public Vector3DInt add(int x, int y, int z) {
		return new Vector3DInt(this.x + x, this.y + y, this.z + z);
	}

	public Vector3DInt add(int i) {
		return add(i, i, i);
	}

	// Subtract

	public Vector3DInt subtract(Vector3DInt other) {
		return new Vector3DInt(this.x - other.x, this.y - other.y, this.z - other.z);
	}

	public Vector3DInt subtract(int x, int y, int z) {
		return new Vector3DInt(this.x - x, this.y - y, this.z - z);
	}

	public Vector3DInt subtract(int i) {
		return subtract(i, i, i);
	}

	// Multiply

	public Vector3DInt multiply(Vector3DInt other) {
		return new Vector3DInt(this.x * other.x, this.y * other.y, this.z * other.y);
	}

	public Vector3DInt multiply(int x, int y, int z) {
		return new Vector3DInt(this.x * x, this.y * y, this.z * z);
	}

	public Vector3DInt multiply(int i) {
		return multiply(i, i, i);
	}

	// Divide

	public Vector3DInt divide(Vector3DInt other) {
		return new Vector3DInt(this.x / other.x, this.y / other.y, this.z / other.z);
	}

	public Vector3DInt divide(int x, int y, int z) {
		return new Vector3DInt(this.x / x, this.y / y, this.z / z);
	}

	public Vector3DInt divide(int i) {
		return divide(i, i, i);
	}

	// Length

	public double lengthSquared() {
		return square(this.x) + square(this.y) + square(this.z);
	}

	public double length() {
		return Math.sqrt(lengthSquared());
	}

	// Distance

	public double distanceSquared(Vector3DInt other) {
		return square(this.x - other.x) + square(this.y - other.y) + square(this.z - other.z);
	}

	public double distance(Vector3DInt other) {
		return Math.sqrt(distanceSquared(other));
	}

	// Dot

	public double dot(Vector3DInt other) {
		return (this.x * other.x) + (this.y * other.y) + (this.z * other.z);
	}

	// Angle

	public double angle(Vector3DInt other) {
		return Math.acos(this.dot(other) / (this.length() * other.length()));
	}

	// Midpoint

	public Vector3DInt midpoint(Vector3DInt other) {
		int x = (int) ((this.x + other.x) / 2.0D);
		int y = (int) ((this.y + other.y) / 2.0D);
		int z = (int) ((this.z + other.z) / 2.0D);
		return new Vector3DInt(x, y, z);
	}

	// Cross Product

	public Vector3DInt crossProduct(Vector3DInt other) {
		int x = (this.y * other.z) - (other.y * this.z);
		int y = (this.z * other.x) - (other.z * this.x);
		int z = (this.x * other.y) - (other.x * this.y);
		return new Vector3DInt(x, y, z);
	}

	// Normalize

	public Vector3DInt normalize() {
		double length = this.length();
		double x = this.x / length;
		double y = this.y / length;
		double z = this.z / length;
		return new Vector3DInt((int) x, (int) y, (int) z);
	}

	// Inside of

	public boolean isInBox(Vector3DInt min, Vector3DInt max) {
		return this.x >= min.x && this.x <= max.x && this.y >= min.y && this.y <= max.y && this.z >= min.z && this.z <= max.z;
	}

	public boolean isInSphere(Vector3DInt center, double radius) {
		return (square(center.x - this.x) + square(center.y - this.y) + square(center.z - this.z)) <= square(radius);
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
	public Integer getZ() {
		return z;
	}

	public Vector3DInt clone() {
		return new Vector3DInt(this.x, this.y, this.z);
	}

	static double square(double d) {
		return d * d;
	}

}
