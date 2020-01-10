package algorithm_2018;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Pa_1 {
	private static int number;
	static List<Group> groupArray;
	static List<Integer> minValue;

	public static void main(String[] args) throws IOException {
		//data.txt read
		File data = new File("D:\\java\\algorithm\\src\\algorithm_2018\\resource\\data.txt");

		Scanner sc = new Scanner(data);
		number = sc.nextInt();
		groupArray = new ArrayList<>((int)(number / Math.sqrt(number))+1);
		minValue = new ArrayList<>((int)(number / Math.sqrt(number))+1);

		//pre-processing
		try {
			while(sc.hasNextInt())
				preprocessing(sc);
		} catch (IOException e) {
		}
		sc.close();

		//range query
		System.out.println(rangeQuery());		
	}

	private static int rangeQuery() {
		Scanner sc = new Scanner(System.in);
		int start, end;
		start = sc.nextInt();
		end = sc.nextInt();
		sc.close();

		int arrayStartIndex = start / (int)Math.sqrt(number);
		int groupStartIndex = start % (int)Math.sqrt(number);

		int arrayEndIndex = end / (int)Math.sqrt(number);
		int groupEndIndex = end % (int)Math.sqrt(number);

		int[] startGroup = groupArray.get(arrayStartIndex).dataGroup;
		startGroup = Arrays.copyOfRange(startGroup, groupStartIndex, startGroup.length);
		int[] endGroup = groupArray.get(arrayEndIndex).dataGroup;
		endGroup = Arrays.copyOfRange(endGroup, 0, groupEndIndex+1);

		int startGroupMin = Arrays.stream(startGroup).min().getAsInt();
		int endGroupMin = Arrays.stream(endGroup).min().getAsInt();
		int min = Math.min(startGroupMin, endGroupMin);

		if(arrayStartIndex+1 < arrayEndIndex) {
			minValue = minValue.subList(arrayStartIndex+1, arrayEndIndex);
			int groupMin = minValue.stream()
					.mapToInt(Integer::intValue)
					.min()
					.getAsInt();

			min = Math.min(groupMin, min);
		}
		return min;
	}

	private static void preprocessing(Scanner sc) throws IOException {
		Group tmp = new Group();
		int groupSize = (int)Math.sqrt(number);
		tmp.dataGroup = new int[groupSize];

		for (int i = 0; i < (int)Math.sqrt(number) && sc.hasNextInt(); i++) {
			tmp.dataGroup[i] = sc.nextInt();
		}

		minValue.add( Arrays.stream(tmp.dataGroup)
				.min()
				.getAsInt());

		groupArray.add(tmp);
	}
}

class Group {
	public int[] dataGroup;
}