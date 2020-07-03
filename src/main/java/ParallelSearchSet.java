import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhouwq
 * @date 2020/6/4 20:27
 */

public class ParallelSearchSet<T> {

    private Map<T, T> parent;
    private Map<T, Integer> weight;

    private List<T> list;

    public ParallelSearchSet(List<T> list) {
        this.list = list;
        parent = new HashMap<>(list.size());
        weight = new HashMap<>(list.size());
        initParentMapping();
    }

    private void initParentMapping() {
        list.forEach(e -> {
            parent.put(e, e);
            weight.put(e, 1);
        });
    }

    public T findParent(T son){
        T result = son;
        T parentT = this.parent.get(son);
        while (parentT != null && parentT != son) {
            son = this.parent.get(son);
        }
        this.parent.put(result, son);
        return son;
    }

    public void union(T t1, T t2) {
        if (t1 == null || t2 == null) {
            return;
        }
        T parent1 = findParent(t1);
        T parent2 = findParent(t2);
        if (parent1 == parent2) {
            return;
        }
        int rank1 = weight.get(parent1);
        int rank2 = weight.get(parent2);
        if (rank1 <= rank2) {
            parent.put(parent1, parent2);
            weight.put(parent2, rank1 + rank2);
        } else {
            parent.put(parent2, parent1);
            weight.put(parent1, rank1 + rank2);
        }
    }

    public static void main(String[] args) {
        int[] parent = new int[26];
        for (int i = 1; i <= 26; i++) {
            parent[i - 1] = i;
        }
        System.out.println();
    }


}

