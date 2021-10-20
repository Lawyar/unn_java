public class App
{
    public static void main( String[] args )
    {
        Animal ani = new Animal();
        ani.setAnimal_type("predator");
        ani.setAnimal_name("croco");
        ani.setAnimal_class("reptile");
        ani.setAnimal_voice("crya");
        System.out.println( "Ani: " + ani.getAnimal_type() + "\t" + ani.getAnimal_name() + "\t"
                            + ani.getAnimal_class() + "\t" + ani.getAnimal_voice() + "\n");
        Animal ani2 = new Animal("herbivore", "giraffe", "mammal", "uuuu");
        System.out.println( "Ani2: " + ani2.getAnimal_type() + "\t" + ani2.getAnimal_name() + "\t"
                + ani2.getAnimal_class() + "\t" + ani2.getAnimal_voice() + "\n");
    }
}
