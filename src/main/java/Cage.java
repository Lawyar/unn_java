import Animals.Animal;

public class Cage
{
    private boolean is_full;
    private Animal caged_animal;

    Cage()
    {
        is_full = false;
    };

    public Cage(Animal animal)
    {
        caged_animal = animal;
        is_full = true;
    }

    public void setCaged_animal(Animal animal)
    {
        this.caged_animal = animal;
        is_full = true;
    }
    public void clear()
    {
        is_full = false;
    }

    public boolean get_status()
    {
        return is_full;
    }
    public Animal getCaged_animal()
    {
        return caged_animal;
    }

}
