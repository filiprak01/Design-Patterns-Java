package Iterator;

import org.javatuples.Pair;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Iterator_Main {
    public static void main(String[] args) {
        String s;
        List<Pair<Integer,Double>> pairList = new ArrayList<Pair<Integer, Double>>();
        pairList.add(new Pair<Integer, Double>(1,2.0));
        pairList.add(new Pair<Integer, Double>(2,4.5));
        pairList.add(new Pair<Integer,Double>(5,3.2));
        pairList.add(new Pair<Integer,Double>(9,2.5));
        SparseVector v1 = new SparseVector(12,pairList);
        RangeVector v2 = new RangeVector(5.0,16.0);
        System.out.println("----------Sparse Vector----------");
        SparseVectorIterator it1 = new SparseVectorIterator(v1);
        Iterators.Print(it1);
        System.out.println("----------Range Vector----------");
        RangeVectorIterator it2 = new RangeVectorIterator(v2,11);
        Iterators.Print(it2);
        System.out.println("----------Sparse Vector Normalised----------");
        NormalisedIterator it3 = new NormalisedIterator(it1);
        Iterators.Print(it3);
        System.out.println("----------Range Vector Hadamard----------");
        HadamardIterator it4 = new HadamardIterator(it1, it2, 12);
        Iterators.Print(it4);
    }
}
