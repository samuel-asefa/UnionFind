# Union Find

Java implementations of Union Find (Disjoint Set Union) from my Data Structures coursework at South Brunswick High School. This repository follows the progression from Quick Find to weighted Quick Union with path compression, with a shared interface, a timing harness, and small input datasets.

## Implementations

| File | Approach |
| --- | --- |
| `UF_FastFind.java` | Quick Find: stores each node's component ID directly. |
| `UF_FastUnion.java` | Quick Union: follows parent links to a root. |
| `UF_FastUnionWeighted.java` | Weighted Quick Union: attaches the smaller tree to the larger tree. |
| `UF_FastUnionWeightedPC.java` | Weighted Quick Union with full path compression during `find`. |

## Supporting files

| File | Purpose |
| --- | --- |
| `UF.java` | Shared interface for all four implementations. |
| `UF_BenchMark.java` | Times repeated union and connectivity operations using a selected implementation. |
| `CodeTimer.java` | Measures elapsed time with `System.nanoTime()`. |
| `uf_tiny.txt` | Sample input with 10 nodes. |
| `uf_small.txt` | Sample input with 50 nodes. |

## Time complexity

Here, N is the number of nodes. Bounds are worst case unless marked amortized.

| Implementation | `find` / `connected` | `union` |
| --- | --- | --- |
| Quick Find | O(1) | O(N) |
| Quick Union | O(N) | O(N) |
| Weighted Quick Union | O(log N) | O(log N) |
| Weighted Quick Union + path compression | O(alpha(N)) amortized | O(alpha(N)) amortized |

`alpha(N)` is the inverse Ackermann function, which grows extremely slowly. All four implementations use O(N) space and take O(N) time to initialize.

## Compile and run

Requires a Java JDK. From the repository folder:

```sh
javac *.java
java UF_FastFind
java UF_FastUnion
```

The two classes above include demonstration `main` methods. The weighted implementations can be used through the same `UF` interface in a driver program.

```java
UF uf = new UF_FastUnionWeightedPC(10);

uf.union(0, 2);
uf.union(2, 4);
uf.union(5, 7);
uf.union(2, 5);

System.out.println(uf.connected(0, 7)); // true
System.out.println(uf.numGroups());    // 6
```

## Timing experiments

In `UF_BenchMark.java`, replace `new UF_FastFind(N)` with the implementation you want to try. For an initial run, lower `U` from `250_000_000` to `100_000`, then recompile:

```sh
javac *.java
java UF_BenchMark
```

The harness runs five rounds. Each iteration performs one `union` and one `connected` call on randomly selected nodes. Timings include random number generation and initialization; each run generates new inputs, so this is a classroom timing experiment rather than a controlled performance comparison.

## Input format

The text files begin with a node count, followed by pairs of nodes to connect. The current programs do not read these files automatically.

## Course context

Collected by Samuel Asefa as part of Data Structures coursework. The original Java source files are preserved in this archive.
