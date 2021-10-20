public class Cage
{
    private boolean is_full;
    private Animal caged_animal;

    Cage()
    {
        caged_animal = new Animal();
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
    public void clean()
    {
        this.caged_animal = new Animal();
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
