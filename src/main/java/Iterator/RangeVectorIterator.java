package Iterator;

public class RangeVectorIterator implements Iterator<Double> {
    private RangeVector vector;
    private Double offset;
    private Integer count;
    private Integer size;

    RangeVectorIterator(RangeVector vector, int size) {
        this.vector = vector;
        this.count = 0;
        this.size = size;
        this.offset = (vector.getLast() - vector.getFirst())/size;
    }

    @Override
    public Double Current() {
        return vector.getFirst() + offset*count;
    }

    @Override
    public Boolean Next() {
        if(count < size){
            count++;
            return  true;
        }
        return false;
    }

    @Override
    public Boolean Reset() {
        count = 0;
        return true;
    }
}
