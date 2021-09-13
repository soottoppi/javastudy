package prob01;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Gugudan {

	static int resultNumber = 0;

	public static void main(String[] args) {
		int l = randomize(1, 9);
		int r = randomize(1, 9);

		resultNumber = l * r;
		
		
		int[] answerNumbers = randomizeAnswers();
		int loc = randomize(0, 8);
		answerNumbers[loc] = resultNumber;

		System.out.println(l + " x " + r + " = ?");

		int length = answerNumbers.length;
		for (int i = 0; i < length; i++) {
			if (i % 3 == 0) {
				System.out.print("\n");
			} else {
				System.out.print("\t");
			}

			System.out.print(answerNumbers[i]);
		}

		System.out.print("\n\n");
		System.out.print("answer:");

		
		Scanner s = new Scanner(System.in);
		int answer = s.nextInt();
		s.close();

		System.out.println((answer == resultNumber) ? "정답" : "오답");
	}

	private static int randomize(int lNum, int rNum) {
		int random = (int) (Math.random() * rNum) + lNum;
		return random;
	}

	private static int[] randomizeAnswers() {
		/* 코드 작성(수정 가능) */
		Set<Integer> set = new HashSet<>();

		final int COUNT_ANSWER_NUMBER = 9;
		int[] boardNumbers = new int[COUNT_ANSWER_NUMBER];
		
		// 랜덤한 값을 boardNumbers 배열에 입력
		for(int i=0; i<COUNT_ANSWER_NUMBER; i++) {
			int randomValue = randomize(1, 9) * randomize(1, 9);
			if(set.contains(randomValue)) {
				// HashSet에 있을 경우 계속해서 랜덤값 생성
				while(true) {
					randomValue = randomize(1, 9) * randomize(1, 9);
					if(!set.contains(randomValue)) {
						break;
					}
				}
			}
			set.add(randomValue);
			boardNumbers[i] = randomValue;
		}
		
		return boardNumbers;
	}
	
	
}
