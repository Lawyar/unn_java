package Animals;

public abstract class Animal
{
    protected String _animal_type;
    protected String _animal_name;
    protected String _animal_class;
    protected String _animal_voice;

    Animal()
    {
        _animal_type = _animal_name = _animal_class = _animal_voice = null;
    }
    public String getAnimal_type() //predators, herbivores
    {
        return this._animal_type;
    }
   public String getAnimal_name()
    {
        return this._animal_name;
    }
    public String getAnimal_class() //fish, amphibians, birds, reptiles, mammals
    {
        return this._animal_class;
    }
    public String getAnimal_voice()
    {
        return this._animal_voice;
    }

    protected void setAnimal_type(String animal_type)
    {
        this._animal_type = animal_type;
    }
    public void setAnimal_name(String animal_name)
    {
        this._animal_name = animal_name;
    }
    protected void setAnimal_class(String animal_class)
    {
        this._animal_class = animal_class;
    }
    public void setAnimal_voice(String animal_voice)
    {
        this._animal_voice = animal_voice;
    }
}
