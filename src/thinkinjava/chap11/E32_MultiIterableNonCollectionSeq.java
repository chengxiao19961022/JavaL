package thinkinjava.chap11;
import thinkinjava.chap11.pets.*;

import java.util.*;

class PetSequence{
    protected Pet[] pets = Pets.createArray(8);

}

public class E32_MultiIterableNonCollectionSeq extends PetSequence
        implements Iterable<Pet>{

    public Iterator<Pet> iterator(){
        return new Iterator<Pet>() {
            private int index;

            @Override
            public boolean hasNext() {
                return index<pets.length;
            }

            @Override
            public Pet next() {
                if (hasNext()) return pets[index++];
                throw new NoSuchElementException();
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public Iterable<Pet> reverse(){
        return new Iterable<Pet>() {
            @Override
            public Iterator<Pet> iterator() {
                return new Iterator<Pet>() {
                    private int index = pets.length-1;

                    @Override
                    public boolean hasNext() {
                        return index>-1;
                    }

                    @Override
                    public Pet next() {
                        if (hasNext()) return pets[index--];
                        throw new NoSuchElementException();
                    }

                    @Override
                    public void remove() {
                        throw new UnsupportedOperationException();
                    }
                };
            }
        };
    }

    public Iterable<Pet> randomized(){
        return new Iterable<Pet>() {
            @Override
            public Iterator<Pet> iterator() {
                List<Pet> shuffled = new ArrayList<Pet>(Arrays.asList(pets));
                Collections.shuffle(shuffled, new Random(47));
                return shuffled.iterator();
            }
        };
    }

    public static void main(String[] args) {
        E32_MultiIterableNonCollectionSeq nc = new E32_MultiIterableNonCollectionSeq ();
        for(Pet pet : nc.reverse())
            System.out.print(pet + " ");
        System.out.println();
        for(Pet pet : nc.randomized())
            System.out.print(pet + " ");
        System.out.println();
        for(Pet pet : nc)
            System.out.print(pet + " ");
    }
}
