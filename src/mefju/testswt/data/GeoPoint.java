package mefju.testswt.data;

public class GeoPoint implements IGeoPoint {
	/* (non-Javadoc)
	 * @see mefju.testswt.data.IGeoPoint#getLatitude()
	 */
	@Override
	public double getLatitude() {
		return latitude;
	}

	/* (non-Javadoc)
	 * @see mefju.testswt.data.IGeoPoint#getLongitude()
	 */
	@Override
	public double getLongitude() {
		return longitude;
	}

	
	public GeoPoint(double latitude, double longitude) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;

	}

	private double latitude;
	/* (non-Javadoc)
	 * @see mefju.testswt.data.IGeoPoint#setLatitude(double)
	 */
	@Override
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	/* (non-Javadoc)
	 * @see mefju.testswt.data.IGeoPoint#setLongitude(double)
	 */
	@Override
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	private double longitude;

}