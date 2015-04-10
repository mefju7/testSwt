package mefju.testswt;

import mefju.testswt.data.GeoPoint;

public class TestData {

	public TestData() {
		// TODO Auto-generated constructor stub
		System.out.println("constructing testdata");
	}
	
	private String name = "not yet set";

	private GeoPoint wp=new GeoPoint(64.5, 9.75);
	
	public String getName() {
		System.out.println("getting name: '" + name + "'\n");
		return name;
	}

	public void setName(String name) {
		System.out.println("setting name to '" + name + "'\n");
		this.name = name;
	}

	public  GeoPoint getWp() {
		return wp;
	}

	public void setWp(GeoPoint wp) {
		this.wp = wp;
	}
}
