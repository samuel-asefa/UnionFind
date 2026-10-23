public class UF_FastUnion implements UF {
	private int[] parent; // holds nodes and associated groups
	private int numGroups;

	public UF_FastUnion(int n) {
		parent = new int[n];
		for(int i = 0; i < n; i++) {
			parent[i] = i;
		numGroups = n;
		}
	}


	//main stuff
	//stop when the parent is the same as the value
	public int find(int x) {
		while (x != parent[x]) {
			x = parent[x];
		}

		return x;
	}


	public void union(int a, int b) {
		int groupA = find(a);
		int groupB = find(b);
		if (groupA == groupB)
			return;

		//attaching groupB to the top of groupA chain
		parent[groupB] = groupA;

		numGroups--;
	}

	public boolean connected(int id1, int id2) {
		return find(id1) == find(id2);
	}


	public int numNodes() { return parent.length; }

	public int numGroups() { return numGroups; }

 @Override
    public void display() {
        for(int i = 0; i < parent.length; i++) {
			System.out.println(parent[i]);
		}
    }

	// UNIT TEST
	public static void main(String[] args){
		UF uf = new UF_FastUnion(10);
		uf.union(0,2);
		uf.union(2,4);
		uf.union(5,7);
		uf.display();
		System.out.println("Num Groups -> "+uf.numGroups());
		uf.union(2,5);
		uf.display();
		System.out.println("Num Groups -> "+uf.numGroups());
    }
}