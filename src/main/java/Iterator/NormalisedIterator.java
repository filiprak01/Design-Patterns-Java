package Iterator;

public class NormalisedIterator implements Iterator {
    private Iterator<Double> iterator;
    private Double sum;

    NormalisedIterator(Iterator<Double> iterator) {
        this.iterator = iterator;
        this.sum = VectorSum(iterator);
    }

    private Double VectorSum(Iterator<Double> iterator){
        double sum= 0.0;
        iterator.Reset();
        sum+= Math.pow(iterator.Current(),2.0);
        while(iterator.Next()){
            sum+=Math.pow(iterator.Current(),2.0);
        }
        iterator.Reset();
        sum = Math.sqrt(sum);
        return sum;
    }

    @Override
    public Object Current() {
        return iterator.Current()/sum;
    }

    @Override
    public Boolean Next() {
        return iterator.Next();
    }

    @Override
    public Boolean Reset() {
        return iterator.Reset();
    }
}
