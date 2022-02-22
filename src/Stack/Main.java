package Stack;

public class Main {

	public static void main(String[] args) throws Exception {
		Stack<Integer> s = new Stack<Integer>();
		
		s.push(2);
		s.push(8);
		s.push(9);
		
		s.pop();
		s.pop();
	
		s.push(5);
		
		System.out.println(s.pop());
		
		
	}

}
