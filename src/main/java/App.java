public class App
{
    public static void main( String[] args )
    {
        Animal ani = new Animal();
        ani.setAnimal_type("predator");
        ani.setAnimal_name("croco");
        ani.setAnimal_class("reptile");
        ani.setAnimal_voice("crya");
        Animal ani2 = new Animal("herbivore", "giraffe", "mammal", "uuuu");

        Zoo zoo = new Zoo(4);
        try
        {
            zoo.add_animal(ani);
            zoo.add_animal(ani2);
            zoo.add_animal(ani);
            zoo.add_animal(ani2);
            zoo.add_animal(ani);
            zoo.add_animal(ani2);
        }
        catch (ArrayStoreException e)
        {
            System.out.println(e.getMessage());
        }

        for (int i = 0; i < zoo.getCages_quantity(); i++)
        {
            System.out.println(zoo.voice_from_cage(i));
        }
        System.out.println("Herbivores quantity: " + zoo.getHerbivores_quantity()
                + "\tPredators quantity: " + zoo.getPredators_quantity());

        System.out.println();
        try
        {
            zoo.remove_animal(3);
            zoo.remove_animal(-1);
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println(e.getMessage());
        }

        for (int i = 0; i < zoo.getCages_quantity(); i++)
        {
            System.out.println(zoo.voice_from_cage(i));
        }
        System.out.println("Herbivores quantity: " + zoo.getHerbivores_quantity()
                + "\tPredators quantity: " + zoo.getPredators_quantity());

        System.out.println();
        Zoo zoo2 = new Zoo();
        try
        {
            zoo2 = new Zoo(ani, ani2, ani, ani2, ani, ani2);
        }
        catch (ArrayStoreException e)
        {
            System.out.println(e.getMessage());
        }
        for (int i = 0; i < zoo2.getCages_quantity(); i++)
        {
            System.out.println(zoo2.voice_from_cage(i));
        }
        System.out.println("Herbivores quantity: " + zoo2.getHerbivores_quantity()
                + "\tPredators quantity: " + zoo2.getPredators_quantity()
                + "\t" + zoo2.unique_classes());
        Animal ani3 = new Animal("predator", "fish", "shark", "sharky sharky");
        zoo2.buy_cage();
        zoo2.add_animal(ani3);
        for (int i = 0; i < zoo2.getCages_quantity(); i++)
        {
            System.out.println(zoo2.voice_from_cage(i));
        }
        System.out.println("Herbivores quantity: " + zoo2.getHerbivores_quantity()
                            + "\tPredators quantity: " + zoo2.getPredators_quantity()
                            + "\t" + zoo2.unique_classes());
    }
}
