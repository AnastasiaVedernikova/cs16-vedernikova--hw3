package ua.edu.ucu.smartarr;

import ua.edu.ucu.SmartArrayApp;
import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import ua.edu.ucu.Student;

/**
 * Created by cs.ucu.edu.ua on 15.11.2016.
 */
public class Main {

    public static void main(String[] args) {
        Integer[] integers = {-1, 2, 0, 1, -5, 3, 1};
        SmartArray sa = new BaseArray(integers);
        MyPredicate pr = new MyPredicate()
        {@Override  public boolean test(Object t) {
                return ((Integer) t) > 0;  }  };

        sa = new FilterDecorator(sa,pr);
//        System.out.println(Arrays.toString(sa.toArray()));
//        System.out.println(sa.size());

        MyFunction func = new MyFunction() {  @Override  public Object apply(Object t) {  return 2 * ((Integer) t);  }  };

        sa = new MapDecorator(sa,func);
        //System.out.println(Arrays.toString(sa.toArray()));

        MyComparator cmp = new MyComparator() {  @Override  public int compare(Object o1, Object o2) {  return ((Integer) o1) - ((Integer) o2);  }  };

        sa = new SortDecorator(sa, cmp);
       // System.out.println(Arrays.toString(sa.toArray()));

        sa = new DistinctDecorator(sa);
      //  System.out.println(Arrays.toString(sa.toArray()));

        Student[] students = {  new Student("Ivar", "Grimstad", 3.9, 2),
                new Student("Ittai", "Zeidman", 4.5, 1),
                new Student("Antons", "Kranga", 4.0, 2),
                new Student("Burr", "Sutter", 4.2, 2),
                new Student("Philipp", "Krenn", 4.3, 3),
                new Student("Tomasz", "Borek", 4.1, 2),
                new Student("Ittai", "Zeidman", 4.5, 1),
                new Student("Burr", "Sutter", 4.2, 2)};

        String[] studentNames = SmartArrayApp.findDistinctStudentNamesFrom2ndYearWithGPAgt4AndOrderedBySurname(students);
        System.out.println(Arrays.toString(studentNames));





    }
}
