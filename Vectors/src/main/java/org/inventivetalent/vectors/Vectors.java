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

package org.inventivetalent.vectors;

import org.inventivetalent.vectors.d2.Vector2DDouble;
import org.inventivetalent.vectors.d2.Vector2DInt;
import org.inventivetalent.vectors.d3.Vector3DDouble;
import org.inventivetalent.vectors.d3.Vector3DInt;

import java.util.Random;

public class Vectors {

	static final Random RANDOM = new Random();

	// Min

	public static Vector3DDouble min(Vector3DDouble a, Vector3DDouble b) {
		return new Vector3DDouble(Math.min(a.getX(), b.getX()), Math.min(a.getY(), b.getY()), Math.min(a.getZ(), b.getZ()));
	}

	public static Vector3DInt min(Vector3DInt a, Vector3DInt b) {
		return new Vector3DInt(Math.min(a.getX(), b.getX()), Math.min(a.getY(), b.getY()), Math.min(a.getZ(), b.getZ()));
	}

	public static Vector2DDouble min(Vector2DDouble a, Vector2DDouble b) {
		return new Vector2DDouble(Math.min(a.getX(), b.getX()), Math.min(a.getY(), b.getY()));
	}

	public static Vector2DInt min(Vector2DInt a, Vector2DInt b) {
		return new Vector2DInt(Math.min(a.getX(), b.getX()), Math.min(a.getY(), b.getY()));
	}

	// Max

	public static Vector3DDouble max(Vector3DDouble a, Vector3DDouble b) {
		return new Vector3DDouble(Math.max(a.getX(), b.getX()), Math.max(a.getY(), b.getY()), Math.max(a.getZ(), b.getZ()));
	}

	public static Vector3DInt max(Vector3DInt a, Vector3DInt b) {
		return new Vector3DInt(Math.max(a.getX(), b.getX()), Math.max(a.getY(), b.getY()), Math.max(a.getZ(), b.getZ()));
	}

	public static Vector2DDouble max(Vector2DDouble a, Vector2DDouble b) {
		return new Vector2DDouble(Math.max(a.getX(), b.getX()), Math.max(a.getY(), b.getY()));
	}

	public static Vector2DInt max(Vector2DInt a, Vector2DInt b) {
		return new Vector2DInt(Math.max(a.getX(), b.getX()), Math.max(a.getY(), b.getY()));
	}

	// Random

	public static Vector3DDouble random3DDouble() {
		return new Vector3DDouble(RANDOM.nextDouble(), RANDOM.nextDouble(), RANDOM.nextDouble());
	}

	public static Vector3DInt random3DInt() {
		return new Vector3DInt(RANDOM.nextInt(), RANDOM.nextInt(), RANDOM.nextInt());
	}

	public static Vector3DInt random3DInt(int x, int y, int z) {
		return new Vector3DInt(RANDOM.nextInt(x), RANDOM.nextInt(y), RANDOM.nextInt(z));
	}

	public static Vector3DInt random3DInt(int i) {
		return random3DInt(i, i, i);
	}

	public static Vector2DDouble random2DDouble() {
		return new Vector2DDouble(RANDOM.nextDouble(), RANDOM.nextDouble());
	}

	public static Vector2DInt random2DInt() {
		return new Vector2DInt(RANDOM.nextInt(), RANDOM.nextInt());
	}

	public static Vector2DInt random2DInt(int x, int y) {
		return new Vector2DInt(RANDOM.nextInt(x), RANDOM.nextInt(y));
	}

	public static Vector2DInt random2DInt(int i) {
		return random2DInt(i, i);
	}

}
