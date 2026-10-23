public class UF_FastUnionWeighted implements UF {
    private int[] parent;
    private int[] size;
    private int numGroups;

    public UF_FastUnionWeighted(int n) {
        numGroups = n;
        parent = new int[n];
        size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int id) {
        while (id != parent[id]) {
            id = parent[id];
        }
        return id;
    }

    public int numNodes() {
        return parent.length;
    }

    public boolean connected(int id1, int id2) {
        return find(id1) == find(id2);
    }

    public void union(int id1, int id2) {
        int root1 = find(id1);
        int root2 = find(id2);

        if (root1 == root2)
            return;

        // Attach the smaller tree under the larger tree.
        if (size[root1] < size[root2]) {
            parent[root1] = root2;
            size[root2] += size[root1];
        } else {
            parent[root2] = root1;
            size[root1] += size[root2];
        }

        numGroups--;
    }

    public int numGroups() {
        return numGroups;
    }

    public void display() {
        System.out.println("Node\tGroup");
        for (int i = 0; i < parent.length; i++) {
            System.out.println(i + " ->\t" + find(i));
        }
    }
}