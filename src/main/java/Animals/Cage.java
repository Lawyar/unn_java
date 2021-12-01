package Animals;

import Animals.Animal;

public class Cage
{
    private boolean is_full;
    private Animal myCagedAnimal;

    Cage()
    {
        is_full = false;
    };

    public Cage(Animal animal)
    {
        myCagedAnimal = animal;
        is_full = true;
    }

    public void setCagedAnimal(Animal animal)
    {
        this.myCagedAnimal = animal;
        is_full = true;
    }
    public void clear()
    {
        is_full = false;
    }

    public boolean isFull()
    {
        return is_full;
    }
    public Animal getMyCagedAnimal()
    {
        return myCagedAnimal;
    }

}
