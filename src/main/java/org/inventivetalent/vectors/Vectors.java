package org.inventivetalent.vectors;

import org.inventivetalent.vectors.d2.Vector2DDouble;
import org.inventivetalent.vectors.d2.Vector2DInt;
import org.inventivetalent.vectors.d3.Vector3DDouble;
import org.inventivetalent.vectors.d3.Vector3DInt;

import java.util.Random;

@SuppressWarnings({"unused", "WeakerAccess"})
public class Vectors {

	private static final Random RANDOM = new Random();

	// Center

	public static Vector3DDouble center3Double(Iterable<Vector3DDouble> vectors) {
		Vector3DDouble sum = new Vector3DDouble(0, 0, 0);
		int i = 0;
		for (Vector3DDouble vector : vectors) {
			sum = sum.add(vector);
			i++;
		}
		if (i == 0) { return sum; }
		return sum.divide((double) i);
	}

	public static Vector3DInt center3Int(Iterable<Vector3DInt> vectors) {
		Vector3DInt sum = new Vector3DInt(0, 0, 0);
		int i = 0;
		for (Vector3DInt vector : vectors) {
			sum = sum.add(vector);
			i++;
		}
		if (i == 0) { return sum; }
		return sum.divide(i);
	}

	public static Vector2DDouble center2Double(Iterable<Vector2DDouble> vectors) {
		Vector2DDouble sum = new Vector2DDouble(0, 0);
		int i = 0;
		for (Vector2DDouble vector : vectors) {
			sum = sum.add(vector);
			i++;
		}
		if (i == 0) { return sum; }
		return sum.divide((double) i);
	}

	public static Vector2DInt center2Int(Iterable<Vector2DInt> vectors) {
		Vector2DInt sum = new Vector2DInt(0, 0);
		int i = 0;
		for (Vector2DInt vector : vectors) {
			sum = sum.add(vector);
			i++;
		}
		if (i == 0) { return sum; }
		return sum.divide(i);
	}

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
