package Activities;

@FunctionalInterface
interface Addable {
    int add(int a, int b);
}
public class Activity12 implements Addable{
    public static void main(String[] args) {

        // Lambda expression without return keyword.
        Addable ad1 = (int a, int b) -> (a + b);
        System.out.println(ad1.add(10, 20));
        // Lambda expression with return keyword.
        Addable ad2 = (int a, int b) -> {
            return (a + b);
        };   
        System.out.println(ad2.add(100, 200));
    }

@Override
	public int add(int a, int b) {
	// TODO Auto-generated method stub
	return 2;
}
  

}