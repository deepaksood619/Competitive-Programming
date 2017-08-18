import java.util.Scanner;

class test {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int T = in.nextInt();
		while(T-- > 0) {

			int T0 = in.nextInt();
			int T1 = in.nextInt();
			int T2 = in.nextInt();
			int V1 = in.nextInt();
			int V2 = in.nextInt();
			int D = in.nextInt();

			int trainT1Time = (int) Math.ceil(((double)D/V1) * 60);
			int trainT2Time = (int) Math.ceil(((double)D/V2) * 60);

			int totalT1 = trainT1Time + T1;
			int totalT2 = trainT2Time + T2;

			if(T0 > T1 && T0 > T2) {
				System.out.println("-1");
			} else if(T0 <= T1 && T0 > T2) {
                // only train1 can be caught
				System.out.println(totalT1);
			} else if(T0 > T1 && T0 <= T2) {
                // only train2 can be caught
				System.out.println(totalT2);
			} else {
                // both train can be caught
				int minTime = totalT1 <= totalT2 ? totalT1 : totalT2;
				System.out.println(minTime);
			}
		}
	}
}

/*
1
5 5 8 100 90 320
*/