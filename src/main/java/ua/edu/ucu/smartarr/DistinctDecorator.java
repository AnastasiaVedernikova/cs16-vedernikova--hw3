package ua.edu.ucu.smartarr;

import ua.edu.ucu.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator{
    SmartArray ar;
    public DistinctDecorator(SmartArray smartArray) {
        super(smartArray);
        this.ar = smartArray;
    }

//    public Object[] modify(){
//        Object[] NewArr = new Object[]{};
//        Object[] objects  = this.ar.toArray();
//        //modifications
//        for (int i = 0; i < objects.length; i++) {
//            if (!(Arrays.asList(NewArr).contains(objects[i]))){
//                ArrayList<Object> temp = new ArrayList<Object>(Arrays.asList(NewArr));
//                temp.add(objects[i]);
//                NewArr = temp.toArray();
//            }
//        }
//        return NewArr;
//    }
    public Object[] modifys(){
        //delete duplicate if list is sorted
        Object[] objects  = this.ar.toArray();
        for (int i = 0; i < objects.length-1; i++) {
            if (objects[i].getClass().equals(Student.class)) {
                if (((Student)objects[i]).equals((Student)objects[i + 1])) {
                    ArrayList<Object> temp = new ArrayList<Object>(Arrays.asList(objects));
                    temp.remove(objects[i + 1]);
                    objects = temp.toArray();
                }
            }else{
                if (objects[i].equals(objects[i + 1])) {
                    ArrayList<Object> temp = new ArrayList<Object>(Arrays.asList(objects));
                    temp.remove(objects[i + 1]);
                    objects = temp.toArray();
                }
            }
        }
        return objects;
    }
    @Override
    public String operationDescription(){
        return this.smartArray.operationDescription()+"DistinctDecorator";

    }
    @Override
    public Object[] toArray(){
        return this.modifys();
    }

    @Override
    public int size(){
        return this.modifys().length;
    }


}
