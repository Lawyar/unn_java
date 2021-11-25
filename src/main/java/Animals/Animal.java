package Animals;

public abstract class Animal
{
    protected AnimalType _animal_type;
    protected AnimalName _animal_name;
    protected AnimalClass _animal_class;
    protected String _animal_voice;

    Animal()
    {
        _animal_type = AnimalType.NoType;
        _animal_name = AnimalName.NoName;
        _animal_class = AnimalClass.NoClass;
        _animal_voice = "SILENCE";
    }
    public String getAnimal_type() //predators, herbivores
    {
        return this._animal_type.toString();
    }
    public String getAnimal_name()
    {
        return this._animal_name.toString();
    }
    public String getAnimal_class() //fish, amphibians, birds, reptiles, mammals
    {
        return this._animal_class.toString();
    }
    public String getAnimal_voice()
    {
        return this._animal_voice;
    }

    protected void setAnimal_type(AnimalType animal_type)
    {
        this._animal_type = animal_type;
    }
    protected void setAnimal_name(AnimalName animal_name)
    {
        this._animal_name = animal_name;
    }
    protected void setAnimal_class(AnimalClass animal_class)
    {
        this._animal_class = animal_class;
    }
    public void setAnimal_voice(String animal_voice)
    {
        this._animal_voice = animal_voice;
    }
}
