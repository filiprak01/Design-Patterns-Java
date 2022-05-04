package Iterator;

class Iterators {
     static void Print(Iterator iterator){
        iterator.Reset();
        System.out.print(iterator.Current());
        while(iterator.Next()){
          System.out.print(" "+iterator.Current());
        }
        System.out.print("\n");
    }
}
