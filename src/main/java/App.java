import Animals.Animal;
import Animals.AnimalName;
import Animals.BAnimal;

import java.util.Set;


public class App
{
    public static void main( String[] args )
    {
        Animal kitty1 = BAnimal.build(AnimalName.Cat);
        Animal kitty2 = BAnimal.build(AnimalName.Cat);
        Animal Giraffe1 = BAnimal.build(AnimalName.Giraffe);

        System.out.println(Giraffe1.getAnimal_type());
        Zoo zoo1 = new Zoo(kitty1, kitty2, Giraffe1);
        for(int i = 0; i < zoo1.getCages_quantity(); i++)
        {
            System.out.println(zoo1.voice_from_cage(i));
        }
        Set<String> uniq = zoo1.getUnique_classes();
        for(String el:uniq)
        {
            System.out.println(el);
        }
        int a = zoo1.getCages_quantity();;
        int b = zoo1.getHerbivores_quantity();;
        int c = zoo1.getPredators_quantity();

        System.out.println(a + " " + b + " " + c);
    }

}
