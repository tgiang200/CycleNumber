package excercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainClass {
	
	public List<Integer> inputNumber(){
		List<Integer> input = new ArrayList<Integer>();
		Scanner sc = new Scanner(System.in);
		System.out.print("Input number: ");
		int n = sc.nextInt();
		for (int i=0; i<n; i++){
			System.out.print("Input element "+i+": ");
			int e = sc.nextInt();
			input.add(e);
		}
		System.out.println("Input: "+input);
		sc.close();
		return input;
	}
	public static void main (String [] args){
		List<Integer> list = new MainClass().inputNumber();
		NumberCycle nc= new NumberCycle(list);
		List<Integer> result = (nc.getResult());
		System.out.println("Output: ");
		for (int i=0; i<result.size(); i++){
			System.out.println("index "+result.get(i)+"=>"+list.get(result.get(i)));
		}
	}
}
