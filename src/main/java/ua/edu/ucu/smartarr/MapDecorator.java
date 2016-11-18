package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator {
    MyFunction fun;
    public MapDecorator(SmartArray smartArray, MyFunction myFunction){
        super(smartArray);
        this.fun = myFunction;
    }
    public Object[] modify(){
        Object[] objects  = this.smartArray.toArray();
        //modifications
        for (int i = 0; i < objects.length; i++) {
            objects[i] = fun.apply(objects[i]);
        }
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
