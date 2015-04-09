package mefju.testswt;

public class TestData {

	public TestData() {
		// TODO Auto-generated constructor stub
		System.out.println("constructing testdata");
	}
	private String name = "not yet set";

	public String getName() {
		System.out.println("getting name: '" + name + "'\n");
		return name;
	}

	public void setName(String name) {
		System.out.println("setting name to '" + name + "'\n");
		this.name = name;
	}
}
