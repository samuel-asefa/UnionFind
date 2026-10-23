public class UF_BenchMark {

	public static void main(String[] args) {

		int N = 10_000; // #Nodes
		int U = 250_000_000; // #Unions
		int F = 3*N; // #Finds

		double totalTime = 0;

		for (int j = 0; j < 5; j++) {
			CodeTimer.start();

			//
			UF uf = new UF_FastFind(N); // can try fast union // UF_FastUnionWeightedPC // UF
			for(int i = 0; i < U; i++) {
				int nodeA = (int)(Math.random()*N);
				int nodeB = (int)(Math.random()*N);
				uf.union(nodeA, nodeB);
				nodeA = (int)(Math.random()*N);
				nodeB = (int)(Math.random()*N);
				uf.connected(nodeA, nodeB);
			}
			String time = CodeTimer.stop();
			System.out.println("Runs: " + U);
			System.out.println("time ->"+time);
			totalTime += Double.parseDouble(time.substring(0, time.length() - 2).trim());
			//U *= 5;
		}

		System.out.println("Total Time: " + totalTime);

	}

}