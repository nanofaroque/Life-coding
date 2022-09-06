package effort_2022;

public class UnionFindPathCompression {
    static class Subset {
        int parent;
        int rank;

        Subset(int parent, int rank) {
            this.parent = parent;
            this.rank = rank;
        }
    }

    int find(Subset[] subsets, int x) {
        while (subsets[x].parent != x) {
            x = subsets[x].parent;
        }
        return subsets[x].parent;
    }

    void Union(Subset[] subsets, int x, int y) {
        int a = find(subsets, x);
        int b = find(subsets, y);

        if (subsets[a].rank >= subsets[b].rank) {
            //merge
            int p = subsets[a].parent;
            subsets[b].parent = p;
            subsets[a].rank += 1;
        } else {
            int p = subsets[b].parent;
            subsets[a].parent = p;
            subsets[b].rank += 1;
        }

    }

    int isCycle(Subset[] subsets, int src, int dest) {
        int x = find(subsets, src);
        int y = find(subsets, dest);
        if (x == y){
            System.out.println("cycle is detected");
            return 1;
        }else
            Union(subsets, x, y);
        return 0;
    }

    public static void main(String[] args) {
        int V = 7;

        Subset[] subsets = new Subset[V];
        for (int i = 0; i < V; i++) {
            subsets[i] = new Subset(i, 0);
        }

        UnionFindPathCompression p = new UnionFindPathCompression();
        System.out.println(p.isCycle(subsets,0,1));
        System.out.println(p.isCycle(subsets,1,2));
        System.out.println(p.isCycle(subsets,0,2));
        System.out.println(subsets);


    }
}
