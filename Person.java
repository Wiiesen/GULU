
public class Person {

	// TODO

	String name;
	public static int Count;
	public Person(String name) {
		Count++;
		this.name = name;
	}

	public static int getCount(){
		return Count;
	}

}
