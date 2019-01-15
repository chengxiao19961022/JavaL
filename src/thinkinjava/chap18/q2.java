package thinkinjava.chap18;

import static net.mindview.util.Print.*;

import java.io.*;
import java.util.*;
import java.util.regex.*;

class SortedDirList{

    private File path;

    public SortedDirList(){
        path = new File(".");
    }

    public SortedDirList(String path){
        this.path = new File(path);
    }

    public String[] list(){
        String[] list = path.list();
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        return list;
    }

    public String[] list(final String fn_regex){
        String[] list = path.list(new FilenameFilter() {
            private Pattern pattern = Pattern.compile(fn_regex);
            @Override
            public boolean accept(File dir, String name) {
                return pattern.matcher(name).matches();
            }
        });
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        return list;
    }
}
public class q2 {
    public static void main(String args[]) {
// Default constructor == current directory
        SortedDirList dir = new SortedDirList("/Users/chengxiao/Desktop/learn_to_death/java/helloword/src/io/");
        print(Arrays.asList(dir.list(".*\\.java")));
    }
}
