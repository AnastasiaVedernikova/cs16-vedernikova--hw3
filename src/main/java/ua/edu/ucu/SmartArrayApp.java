package ua.edu.ucu;

import java.util.ArrayList;
import java.util.Arrays;
import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;
import ua.edu.ucu.smartarr.*;

public class SmartArrayApp {

    public static Integer[]
            filterPositiveIntegersSortAndMultiplyBy2(Integer[] integers) {

        MyPredicate pr = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Integer) t) > 0;
            }
        };

        MyComparator cmp = new MyComparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Integer) o1) - ((Integer) o2);
            }
        };

        MyFunction func = new MyFunction() {
            @Override
            public Object apply(Object t) {
                return 2 * ((Integer) t);
            }
        };

        // Input: [-1, 2, 0, 1, -5, 3]
        SmartArray sa = new BaseArray(integers);

        sa = new FilterDecorator(sa, pr); // Result: [2, 1, 3];
        sa = new SortDecorator(sa, cmp); // Result: [1, 2, 3]
        sa = new MapDecorator(sa, func); // Result: [2, 4, 6]

        // Alternative
//        sa = new MapDecorator(
//                    new SortDecorator(
//                        new FilterDecorator(sa, pr),
//                    cmp),
//                func);
        Object[] result = sa.toArray();
        return Arrays.copyOf(result, result.length, Integer[].class);
    }

    public static String[] findDistinctStudentNamesFrom2ndYearWithGPAgt4AndOrderedBySurname(Student[] students) {

        // Hint: to convert Object[] to String[] - use the following code
        //Object[] result = studentSmartArray.toArray();
        //return Arrays.copyOf(result, result.length, String[].class);

        SmartArray a = new BaseArray(students);

        MyComparator cmp = new MyComparator() {
            @Override
            public int compare(Object o1, Object o2) {
                int message = 0;//min
                String st = "";
                if (((Student) o1).getSurname().length() < ((Student) o2).getSurname().length()) {
                    st = ((Student) o1).getSurname();
                } else {
                    st = ((Student) o2).getSurname();
                }
                for (int i = 0; i < st.length(); ++i) {
                    message = ((Student) o1).getSurname().charAt(i) - ((Student) o2).getSurname().charAt(i);
                    if (message != 0) {
                        return message;
                    }
                }

                return message;
            }
        };
        a = new SortDecorator(a, cmp);
      //  System.out.println(Arrays.toString(a.toArray()));

        MyPredicate pre = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return (((Student) t).getYear() == 2 && ((Student) t).getGPA() >= 4);
            }
        };
        a = new FilterDecorator(a, pre);
       // System.out.println(Arrays.toString(a.toArray()));

        a = new DistinctDecorator(a);
      //  System.out.println(Arrays.toString(a.toArray()));
        Object[] stud = a.toArray();
        String[] result = new String[]{};//convert to String
        for (Object st: stud){
            String str = "";
            str += ((Student)st).getSurname() + " " + ((Student)st).getName();
            ArrayList<String> temp = new ArrayList<String>(Arrays.asList(result));
            temp.add(str);
            result = temp.toArray(new String[0]);
        }

       // System.out.println(Arrays.toString(result));

        return result;
    }
}
