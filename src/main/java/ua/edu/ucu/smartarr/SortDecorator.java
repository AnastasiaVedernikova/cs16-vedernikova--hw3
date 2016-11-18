package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;

import java.lang.reflect.Array;
import java.util.Arrays;

// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator{
    MyComparator com;
    public SortDecorator(SmartArray smartArray, MyComparator myComparator) {
        super(smartArray);
        this.com = myComparator;

    }
    public Object[] modify(){
        Object[] objects  = this.smartArray.toArray();
        //modifications
        Arrays.sort(objects,this.com);
        return objects;
    }
    @Override
    public String operationDescription(){
        return this.smartArray.operationDescription()+"FilterDecorator";

    }
    @Override
    public Object[] toArray(){
        return this.modify();
    }

    @Override
    public int size(){
        return this.modify().length;
    }


}
