package Iterator;

public class HadamardIterator implements Iterator<Double> {
    private Iterator iteratorForward;
    private Iterator iteratorBackward;
    private Integer count;
    private Integer size;

    HadamardIterator(Iterator<Double> iteratorForward, Iterator<Double> iteratorBackward, Integer size) {
        this.iteratorForward = iteratorForward;
        this.iteratorBackward = iteratorBackward;
        this.size = size;
        count = 0;
    }

    @Override
    public Double Current() {
        Double d1 = (Double) iteratorBackward.Current();
        Double d2 = (Double) iteratorForward.Current();
        return d1*d2;
    }

    @Override
    public Boolean Next() {
        iteratorBackward.Reset();
        for(int i = 0; i< size - count-2; i++){
            if(!iteratorBackward.Next()){
                Reset();
                return false;
            }
        }
        count ++;
        return iteratorForward.Next();
    }

    @Override
    public Boolean Reset() {
        count = 0;
        iteratorForward.Reset();
        ResetBackward();
        return true;
    }
    private Boolean ResetBackward(){
        iteratorBackward.Reset();
        for(int i = 0;  i< size-1; i++){
            iteratorBackward.Next();
        }
        return true;
    }
}
