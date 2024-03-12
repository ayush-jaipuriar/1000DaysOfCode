package JavaTheory;

import java.util.List;

class Animal {};

class Dog extends Animal {

}

class InvarianceAndCovariance {
    void addAnimals(List<? extends Animal> animals) {
        //animals.add(new Dog());  // Why does this NOT compile?
    }
    
}
