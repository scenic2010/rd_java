package scenic.study.basic_knowledge.sort;

public class Ex33 {
	public static void main(String args[]) {
		int i, j;
		int a[][];
		a = new int[8][8];
		for (i = 0; i < 8; i++) {
			a[i][i] = 1;
			a[i][0] = 1;
		}
		for (i = 2; i < 8; i++) {
			for (j = 1; j <= i - 1; j++) {
				a[i][j] = a[i - 1][j - 1] + a[i - 1][j];
			}
		}
		for (i = 0; i < 8; i++) {
			for (j = 0; j < i; j++) {
				System.out.printf("\t" + a[i][j]);
			}
			System.out.println();
		}
	}
}
