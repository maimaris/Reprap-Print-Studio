package threedc.github.com.model;

public class Bounds
{
	private Vertex min;
	private Vertex max;
	
	public void setMin(Vertex vertex)
	{
		this.min = vertex;
		
	}
	public void setMax(Vertex vertex)
	{
		this.max = vertex;
	}
	public void updateMin(Vertex v1)
	{
		min.setX(Math.min(min.getX(), v1.getX()));
		min.setY(Math.min(min.getY(), v1.getY()));
		min.setZ(Math.min(min.getZ(), v1.getZ()));
	}
	
	public void updateMax(Vertex v1)
	{
		max.setX(Math.max(max.getX(), v1.getX()));
		max.setY(Math.max(max.getY(), v1.getY()));
		max.setZ(Math.max(max.getZ(), v1.getZ()));

	}
	public void setMin(Bounds boundingBox)
	{
		min = boundingBox.min;
	}
	
	public void setMax(Bounds boundingBox)
	{
		max = boundingBox.max;
	}

	public void updateMin(Bounds boundingBox)
	{
		updateMin(boundingBox.min);
	}
	
	public void updateMax(Bounds boundingBox)
	{
		updateMax(boundingBox.max);
	}
	
	
	public Vertex calculateGeometricCentre()
	{
		float x = (max.getX() - min.getX()) / 2;
		float y = (max.getY() - min.getY()) / 2;
		float z = (max.getZ() - min.getZ()) / 2;
		
		return new Vertex(min.getX() + x, min.getY() + y, min.getZ() + z);
	}


}
