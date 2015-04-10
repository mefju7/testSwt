package mefju.testswt.data;

public class GeoPoint implements IGeoPoint {
	/**
	 * @param latitude
	 * @param longitude
	 */
	public GeoPoint(double latitude, double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}

	private double latitude,longitude;

	@Override
	public double getLongitude() {
		return longitude;
	}

	@Override
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	@Override
	public double getLatitude() {
		return latitude;
	}

	@Override
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	
	public static class Builder implements IGeoPoint.Builder{
		@Override
		public IGeoPoint create(double latitude, double longitude) {
			// TODO Auto-generated method stub
			return new GeoPoint(latitude,longitude);
		}
		
	}
}
