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
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.util.Vector;

public class Vector3DDouble implements IVector3D<Double> {

	public static final Vector3DDouble ZERO = new Vector3DDouble(0, 0, 0);

	@Expose private final double x;
	@Expose private final double y;
	@Expose private final double z;

	public Vector3DDouble(Vector3DInt intVector) {
		this(intVector.getX().doubleValue(), intVector.getY().doubleValue(), intVector.getZ().doubleValue());
	}

	public Vector3DDouble(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public Vector3DDouble(Vector vector) {
		this(vector.getX(), vector.getY(), vector.getZ());
	}

	public Vector3DDouble(Location location) {
		this(location.toVector());
	}

	// Add

	public Vector3DDouble add(Vector3DDouble other) {
		return new Vector3DDouble(this.x + other.x, this.y + other.y, this.z + other.z);
	}

	public Vector3DDouble add(double x, double y, double z) {
		return new Vector3DDouble(this.x + x, this.y + y, this.z + z);
	}

	public Vector3DDouble add(double d) {
		return add(d, d, d);
	}

	// Subtract

	public Vector3DDouble subtract(Vector3DDouble other) {
		return new Vector3DDouble(this.x - other.x, this.y - other.y, this.z - other.z);
	}

	public Vector3DDouble subtract(double x, double y, double z) {
		return new Vector3DDouble(this.x - x, this.y - y, this.z - z);
	}

	public Vector3DDouble subtract(double d) {
		return subtract(d, d, d);
	}

	// Multiply

	public Vector3DDouble multiply(Vector3DDouble other) {
		return new Vector3DDouble(this.x * other.x, this.y * other.y, this.z * other.y);
	}

	public Vector3DDouble multiply(double x, double y, double z) {
		return new Vector3DDouble(this.x * x, this.y * y, this.z * z);
	}

	public Vector3DDouble multiply(double d) {
		return multiply(d, d, d);
	}

	// Divide

	public Vector3DDouble divide(Vector3DDouble other) {
		return new Vector3DDouble(this.x / other.x, this.y / other.y, this.z / other.z);
	}

	public Vector3DDouble divide(double x, double y, double z) {
		return new Vector3DDouble(this.x / x, this.y / y, this.z / z);
	}

	public Vector3DDouble divide(double d) {
		return divide(d, d, d);
	}

	// Length

	public double lengthSquared() {
		return square(this.x) + square(this.y) + square(this.z);
	}

	public double length() {
		return Math.sqrt(lengthSquared());
	}

	// Distance

	public double distanceSquared(Vector3DDouble other) {
		return square(this.x - other.x) + square(this.y - other.y) + square(this.z - other.z);
	}

	public double distance(Vector3DDouble other) {
		return Math.sqrt(distanceSquared(other));
	}

	// Dot

	public double dot(Vector3DDouble other) {
		return (this.x * other.x) + (this.y * other.y) + (this.z * other.z);
	}

	// Angle

	public double angle(Vector3DDouble other) {
		return Math.acos(this.dot(other) / (this.length() * other.length()));
	}

	// Midpoint

	public Vector3DDouble midpoint(Vector3DDouble other) {
		double x = (this.x + other.x) / 2.0D;
		double y = (this.y + other.y) / 2.0D;
		double z = (this.z + other.z) / 2.0D;
		return new Vector3DDouble(x, y, z);
	}

	// Cross Product

	public Vector3DDouble crossProduct(Vector3DDouble other) {
		double x = (this.y * other.z) - (other.y * this.z);
		double y = (this.z * other.x) - (other.z * this.x);
		double z = (this.x * other.y) - (other.x * this.y);
		return new Vector3DDouble(x, y, z);
	}

	// Normalize

	public Vector3DDouble normalize() {
		return divide(length());
	}

	// Inside of

	public boolean isInBox(Vector3DDouble min, Vector3DDouble max) {
		return this.x >= min.x && this.x <= max.x && this.y >= min.y && this.y <= max.y && this.z >= min.z && this.z <= max.z;
	}

	public boolean isInSphere(Vector3DDouble center, double radius) {
		return (square(center.x - this.x) + square(center.y - this.y) + square(center.z - this.z)) <= square(radius);
	}

	public Vector toBukkitVector() {
		return new Vector(this.x, this.y, this.z);
	}

	public Location toBukkitLocation(World world) {
		return toBukkitVector().toLocation(world);
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
	public Double getZ() {
		return z;
	}

	public Vector3DDouble clone() {
		return new Vector3DDouble(this.x, this.y, this.z);
	}

	static double square(double d) {
		return d * d;
	}

}
