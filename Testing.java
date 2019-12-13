
public class Testing {
	public static void main(String [] args){
		Integer input = 1001;
		Integer maxValue = input * input;
		Integer diagonals = 4;
		// Init as 1 due to center value will not cater into while diagonal loop
		Integer totalSum = 1;
		
		// 1 is center
		while(input != 1 && diagonals >= 0 ){
			totalSum += maxValue;
			// reason of -1 because of inclusive diagonal
			maxValue -= input - 1;
			diagonals--;
			
			if(diagonals == 0){
				// -2 is due to went into another spiral
				input -= 2;
				diagonals = 4;
			}
		}
		System.out.println(totalSum);
	}
}