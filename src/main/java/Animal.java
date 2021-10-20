public class Animal
{
    String animal_type; //predators, herbivores
    String animal_name;
    String animal_class; //fish, amphibians, birds, reptiles, mammals
    String animal_voice;

    public  Animal(){ }

    public Animal(String animal_type, String animal_name, String animal_class, String animal_voice)
    {
        this.animal_type = animal_type;
        this.animal_name = animal_name;
        this.animal_class = animal_class;
        this.animal_voice = animal_voice;
    }

    public void setAnimal_type(String animal_type)
    {
        this.animal_type = animal_type;
    }
    public  void setAnimal_name(String animal_name)
    {
        this.animal_name = animal_name;
    }
    public  void setAnimal_class(String animal_class)
    {
        this.animal_class = animal_class;
    }
    public void  setAnimal_voice(String animal_voice)
    {
        this.animal_voice = animal_voice;
    }

    public String getAnimal_type()
    {
        return animal_type;
    }
    public String getAnimal_name()
    {
        return animal_name;
    }
    public String getAnimal_class()
    {
        return animal_class;
    }
    public String getAnimal_voice()
    {
        return animal_voice;
    }
}
