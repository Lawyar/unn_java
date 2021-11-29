package Animals;

public interface IAnimal
{
    String getAnimal_type(); //predators, herbivores
    String get_name();
    String get_class(); //fish, amphibians, birds, reptiles, mammals
    String get_voice();

    void set_name(String name);
    void set_voice(String voice);

    String toString();
}
