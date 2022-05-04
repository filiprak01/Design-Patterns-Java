package Iterator;

public class SparseVectorIterator implements Iterator<Double> {
    private SparseVector vector;
    private Integer count;

    SparseVectorIterator(SparseVector vector) {
        this.vector = vector;
        this.count = 0;
    }

    @Override
    public Double Current() {
        for(int i = 0; i < vector.getPairs().size(); i++){
            if(vector.getPairs().get(i).getValue0().equals(count) ){
                return vector.getPairs().get(i).getValue1();
            }
        }
        return 0.0;
    }

    @Override
    public Boolean Next() {
        if (count+1 < vector.getSize()) {
            count++;
            return true;
        }
        return false;
    }

    @Override
    public Boolean Reset() {
        count = 0;
        return true;
    }
}
