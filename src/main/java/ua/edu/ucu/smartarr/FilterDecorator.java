package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyPredicate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator{
    MyPredicate prd;
    public FilterDecorator(SmartArray smartArray, MyPredicate myPredicate){
        super(smartArray);
        this.prd = myPredicate;
    }

    @Override
    public String operationDescription(){
        return this.smartArray.operationDescription()+"FilterDecorator";

    }
    public Object[] modify(){
        Object[] objects  = this.smartArray.toArray();
        //modifications
        for (Object ob: objects){
            if (!this.prd.test(ob)){
                ArrayList<Object> temp = new ArrayList<Object>(Arrays.asList(objects));
                temp.remove(ob);
                objects = temp.toArray();
            }
        }
        return objects;
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
