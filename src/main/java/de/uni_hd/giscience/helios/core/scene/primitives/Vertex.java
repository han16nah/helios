package de.uni_hd.giscience.helios.core.scene.primitives;

import java.io.Serializable;

import javax.vecmath.Color4f;

import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;

public class Vertex implements Serializable {

	private static final long serialVersionUID = 4530961171798023308L;
	public Vector3D pos;
	public Vector3D normal;
	public Color4f color;
	public Vector2D texcoords;

	public Vertex copy() {
		Vertex v = new Vertex();
		v.pos = new Vector3D(pos.getX(), pos.getY(), pos.getZ());
		v.normal = new Vector3D(normal.getX(), normal.getY(),normal.getZ());
		v.color = new Color4f(color.x, color.y, color.z, color.w);
		v.texcoords = new Vector2D(texcoords.getX(), texcoords.getY());
		
		return v;
	}
	
	
	public static double[] matxvec(double[][] mat, double[] vec) {
		double[] res = new double[3];

	    for (int i = 0; i < 3; i++) {
	        double tmp = 0;
	        for (int j = 0; j < 3; j++) {
	        	tmp += mat[i][j] * vec[j]; 
	        }
	        res[i] = tmp;
	    }

	    return res;
	}
	
	public static Vertex rotateVertex(Vertex v, double[][] rotationMatrix) {
		double[] vector = new double[] {v.getX(), v.getY(), v.getZ()};
		double[] result = matxvec(rotationMatrix, vector);
		Vertex newVert = new Vertex();
		newVert.pos = new Vector3D(result[0], result[1], result[2]); 
		
		return newVert;
	}
	
	
	public double getX() {
		return this.pos.getX();
	}

	public double getY() {
		return this.pos.getY();
	}

	public double getZ() {
		return this.pos.getZ();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((normal == null) ? 0 : normal.hashCode());
		result = prime * result + ((pos == null) ? 0 : pos.hashCode());
		result = prime * result + ((texcoords == null) ? 0 : texcoords.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vertex other = (Vertex) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (normal == null) {
			if (other.normal != null)
				return false;
		} else if (!normal.equals(other.normal))
			return false;
		if (pos == null) {
			if (other.pos != null)
				return false;
		} else if (!pos.equals(other.pos))
			return false;
		if (texcoords == null) {
			if (other.texcoords != null)
				return false;
		} else if (!texcoords.equals(other.texcoords))
			return false;
		return true;
	}

}
