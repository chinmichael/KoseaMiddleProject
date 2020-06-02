import java.util.*;

public class Sample {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		sc.close();

		char[][] square = new char[num][num];
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < square.length; i++) {
			for (int j = 0; j < square[0].length; j++) {
				square[i][j] = '*';
			}
		}

		if (num != 3) {
			square = vacuum(square, num);
		}

		for (int i = 0; i < square.length; i++) {
			for (int j = 0; j < square[0].length; j++) {
				if ((i + 1) % 3 == 2 && (j + 1) % 3 == 2) {
					square[i][j] = ' ';
				}
				sb.append(square[i][j]);
			}
			sb.append("\n");
		}

		System.out.print(sb);

	}

	public static char[][] vacuum(char[][] square, int num) {
		num = num / 3;

		for (int i = 0; i < square.length; i++) {
			for (int j = 0; j < square[0].length; j++) {
				if ((num < (i + 1) % (3 * num) && (i + 1) % (3 * num) <= 2 * num)
						&& (num < (j + 1) % (3 * num) && (j + 1) % (3 * num) <= 2 * num)) {
					square[i][j] = ' ';
				}
			}
		}

		if (num == 3) {
			return square;
		}

		return vacuum(square, num);
	}
}