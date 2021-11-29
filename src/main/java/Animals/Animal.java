package Animals;

public abstract class Animal implements IAnimal
{
    protected AnimalType _animal_type;
    protected String _animal_name;
    protected AnimalClass _animal_class;
    protected String _animal_voice;

    Animal()
    {
        _animal_type = AnimalType.NoType;
        _animal_name = "NONAME";
        _animal_class = AnimalClass.NoClass;
        _animal_voice = "SILENCE";
    }
    @Override
    public String getAnimal_type() //predators, herbivores
    {
        return this._animal_type.toString();
    }
    @Override
    public String get_name()
    {
        return this._animal_name.toString();
    }
    @Override
    public String get_class() //fish, amphibians, birds, reptiles, mammals
    {
        return this._animal_class.toString();
    }
    @Override
    public String get_voice()
    {
        return this._animal_voice;
    }

    @Override
    public void set_name(String name)
    {
        this._animal_name = name;
    }
    @Override
    public void set_voice(String voice)
    {
        this._animal_voice = voice;
    }

    @Override
    public String toString()
    {
        return _animal_type.toString() + " " + _animal_class.toString() + " " + _animal_name + " " + _animal_voice;
    }
}
