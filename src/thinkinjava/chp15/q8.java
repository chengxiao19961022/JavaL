package thinkinjava.chp15;
import java.util.*;
import net.mindview.util.*;

class StoryCharactor{
    private static long counter = 0;
    private final long id = counter++;

    public String toString(){
        return getClass().getSimpleName() + " " + id;
    }

}

class GoodGuy extends StoryCharactor{
    public String toString(){
        return super.toString()+" is a good guy";
    }
}

class BadGuy extends StoryCharactor{
    public String toString(){
        return super.toString()+" is a bad guy";
    }
}

class Morton extends BadGuy {}

class Frank extends BadGuy {}
class Harmonica extends GoodGuy {}
class Cheyenne extends GoodGuy {}

class CharacterGenerator implements
        Generator<StoryCharactor>, Iterable<StoryCharactor>{
    private Class<?>[] types = {
            Morton.class, Frank.class,
            Harmonica.class, Cheyenne.class
    };
    private static Random rand = new Random(47);
    public CharacterGenerator() {}
    private int size = 0;
    public CharacterGenerator(int sz) { size = sz; }

    @Override
    public StoryCharactor next() {
        try {
            return (StoryCharactor)types[rand.nextInt(types.length)].newInstance();
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }

    @Override
    public Iterator<StoryCharactor> iterator() {
        return new Iterator<StoryCharactor>() {
            int count = size;
            @Override
            public boolean hasNext() {
                return count>0;
            }

            @Override
            public StoryCharactor next() {
                if(!hasNext()) return null;

                count--;
                return CharacterGenerator.this.next();
            }

            public void remove() { // Not implemented
                throw new UnsupportedOperationException();
            }

        };
    }
}
public class q8 {

    public static void main(String[] args) {
        CharacterGenerator gen = new CharacterGenerator();
        for(int i = 0; i < 7; i++)
            System.out.println(gen.next());
        for(StoryCharactor p : new CharacterGenerator(7))
            System.out.println(p);


    }

}
