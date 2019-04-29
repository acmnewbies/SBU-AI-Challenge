
package SideClasses;

public class Person {

	private String firstName, lastName;
	private long age;
	private Address address;
	private Car[] cars;

	public Person() {
		this.address = new Address();
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getAge() {
		return age;
	}

	public void setAge(long age) {
		this.age = age;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Car[] getCars() {
		return cars;
	}

	public void setCars(Car[] cars) {
		this.cars = cars;
	}

	@Override
	public String toString() {
		String returnValue = "(" + firstName + "," + lastName + "," + age + "," + address + ",(";
		for ( int i = 0; i < cars.length; i++ )
			returnValue = returnValue.concat( cars[i].toString() );
		returnValue = returnValue.concat( ")" );
		return returnValue;
	}
}
