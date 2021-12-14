package Animals;

public abstract class Animal implements IAnimal
{
    protected AnimalType myAnimalType;
    protected String myAnimalName;
    protected AnimalClass myAnimalClass;
    protected String myAnimalVoice;
    protected AnimalKind myAnimalKind;

    Animal()
    {
        myAnimalType = AnimalType.NoType;
        myAnimalName = " ";
        myAnimalClass = AnimalClass.NoClass;
        myAnimalVoice = " ";
        myAnimalKind = AnimalKind.NoKind;
    }

    @Override
    public AnimalType getType() //predators, herbivores
    {
        return this.myAnimalType;
    }

    @Override
    public String getName()
    {
        return this.myAnimalName;
    }

    @Override
    public AnimalClass get_class() //fish, amphibians, birds, reptiles, mammals
    {
        return this.myAnimalClass;
    }
    @Override
    public String getVoice()
    {
        return this.myAnimalVoice;
    }

    @Override
    public AnimalKind getKind()
    {
        return myAnimalKind;
    }

    @Override
    public void setName(String name)
    {
        this.myAnimalName = name;
    }

    @Override
    public void setVoice(String voice)
    {
        this.myAnimalVoice = voice;
    }

    @Override
    public String toString()
    {
        return myAnimalType.toString() + " " + myAnimalClass.toString() + " " + myAnimalName + " " + myAnimalVoice;
    }

    @Override
    public boolean equals(Animal animal) {
        if(this.getKind() == animal.getKind() && this.getType() == animal.getType() &&
        this.getClass() == animal.getClass())
        {
            return true;
        }
        return false;
    }
}
