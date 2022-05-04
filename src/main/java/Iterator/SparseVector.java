package Iterator;

import org.javatuples.Pair;

import java.util.List;

class SparseVector {
    private Integer size;
    private List<Pair<Integer, Double>> pairs;

    SparseVector(Integer size, List<Pair<Integer, Double>> pairs) {
        this.size = size;
        this.pairs = pairs;
    }

    Integer getSize() {
        return size;
    }

    List<Pair<Integer, Double>> getPairs() {
        return pairs;
    }
}
