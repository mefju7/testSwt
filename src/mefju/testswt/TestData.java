package mefju.testswt;

public class TestData {

	public TestData() {
		// TODO Auto-generated constructor stub
		System.out.println("constructing testdata");
	}
	
	public static class WP
	{
		public  WP(double latitude, double longitude) {
			super();
			this.latitude = latitude;
			this.longitude = longitude;
		}

		private double latitude, longitude;

		public double getLatitude() {
			return latitude;
		}

		public void setLatitude(double latitude) {
			this.latitude = latitude;
		}

		public double getLongitude() {
			return longitude;
		}

		public void setLongitude(double longitude) {
			this.longitude = longitude;
		}
	}
	
	private String name = "not yet set";

	private WP wp=new WP(64.5, 9.75);
	
	public String getName() {
		System.out.println("getting name: '" + name + "'\n");
		return name;
	}

	public void setName(String name) {
		System.out.println("setting name to '" + name + "'\n");
		this.name = name;
	}

	public WP getWp() {
		return wp;
	}

	public void setWp(WP wp) {
		this.wp = wp;
	}
}
