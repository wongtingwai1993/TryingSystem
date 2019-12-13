public class PrintShuffleArray {

	public static void main(String[] args) {
		int test = 123456;
		String stringValue = String.valueOf(test);
		int startSmallest = 0;
		int startLargest = stringValue.length() - 1;

		int medianValue = stringValue.length() % 2 == 1 ? ((stringValue.length() + 1) / 2)
				: ((stringValue.length()) / 2);
		System.out.println(medianValue);

		String answer = "";

		while (startSmallest < medianValue) {
			System.out.println(startSmallest + "::" + startLargest);
			if (startSmallest != startLargest) {
				answer += String.valueOf(stringValue.charAt(startSmallest))
						+ String.valueOf(stringValue.charAt(startLargest));
			} else {
				answer += String.valueOf(stringValue.charAt(startSmallest));
			}

			++startSmallest;
			--startLargest;
			System.out.println(answer);
		}

		System.out.println(answer);

	}
}
