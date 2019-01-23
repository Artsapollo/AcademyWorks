package HW8;

import java.lang.reflect.*;
import java.util.Arrays;

public class Garden {
    public static void main(String[] args) {
        Animal animal = new Animal("Cat", 3);
        Method[] method = animal.getClass().getDeclaredMethods();
        System.out.println(Arrays.toString(method));
        System.out.println();

        //Changing object in private method
        try {
            Method method1 = animal.getClass().getDeclaredMethod("someInternalLogic");
            method1.setAccessible(true);
            method1.invoke(animal);
            System.out.println(animal);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }


        //Getting constructor from class
        Constructor[] constructors  = animal.getClass().getConstructors();
        for(Constructor constructor : constructors){
            Class[] paramTypes = constructor.getParameterTypes();
            for(Class paramType : paramTypes){
                System.out.println(paramType.getName() + " ");
            }
            System.out.println();
        }

        //Created new object from private constructor
        try {
            Class clas = Class.forName(Animal.class.getName());
            Class[] params = {String.class, int.class};
            animal = (Animal) clas.getConstructor(params).newInstance("Dog", 7);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(animal);

    }


}
