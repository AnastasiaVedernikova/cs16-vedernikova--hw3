package ua.edu.ucu.smartarr;

import java.util.ArrayList;
import java.util.Arrays;

// Base array for decorators
public class BaseArray implements SmartArray{
    public Object[] arr = new Object[]{};
    public BaseArray(Object[] arr){
        this.arr = arr;
    }
    public Object[] toArray(){
        return this.arr;

    }
    public String operationDescription(){
        return "BaseArray";
    }
    public int size(){
        return this.arr.length;
    }


}
