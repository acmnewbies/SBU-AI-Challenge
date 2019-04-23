
package SideClasses;

public class Car {

	private String model;
	private String color;

	public Car(String model, String color) {
		this.model = model;
		this.color = color;
	}

	public Car () {

	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "(" + model + "," + color + ")";
	}
}
