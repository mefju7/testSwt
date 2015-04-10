package mefju.testswt.data;

public interface IGeoPoint {

	public abstract void setLatitude(double latitude);

	public abstract double getLatitude();

	public abstract void setLongitude(double longitude);

	public abstract double getLongitude();
	
	public interface Builder
	{
		public abstract IGeoPoint create(double latitude, double longitude);
	}
}

