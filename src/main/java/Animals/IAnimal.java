package Animals;

public interface IAnimal
{
    AnimalType getType(); //predators, herbivores
    String getName();
    AnimalClass get_class(); //fish, amphibians, birds, reptiles, mammals
    String getVoice();
    AnimalKind getKind();

    void setName(String name);
    void setVoice(String voice);

    String toString();

    boolean equals(Animal animal);
}
