public class Zoo
{
    private final int cages_quantity = 4;
    private Cage[] cages;
    private void cages_init()
    {
        this.cages = new Cage[cages_quantity];
        for (int i = 0; i < cages_quantity; i++)
        {
            this.cages[i] = new Cage();
        }
    }

    public Zoo()
    {
        cages_init();
    };

    public Zoo(Animal ... animals)
    {
        cages_init();

        for(int i = 0; i < animals.length; i++)
        {
            try
            {
                if(i > this.cages_quantity - 1)
                {
                    throw new ArrayStoreException("NOT ENOUGH CAGES");
                }
                this.cages[i].setCaged_animal(animals[i]);
            }
            catch (ArrayStoreException e)
            {
                System.out.println(e.getMessage());
                return;
            }
        }
    }

    public void add_animal(Animal animal)
    {
        for (int i = 0; i < this.cages_quantity; i++)
        {
            if(!this.cages[i].get_status())
            {
                this.cages[i].setCaged_animal(animal);
                return;
            }
        }
        throw new ArrayStoreException("CAGES ARE FULL");
    }

    public void remove_animal(int cage_index)
    {
        if(cage_index < 0 || cage_index >= cages_quantity)
        {
            throw new ArrayIndexOutOfBoundsException("INCORRECT INDEX");
        }
        if(cages[cage_index].get_status())
        {
            cages[cage_index].clean();
        }
    }

    public String voice_from_cage(int cage_index)
    {
        if(cage_index < 0 || cage_index >= cages_quantity)
        {
            throw new ArrayIndexOutOfBoundsException("INCORRECT INDEX");
        }
        if(!cages[cage_index].get_status())
        {
            return "silence";
        }
        return cages[cage_index].getCaged_animal().getAnimal_voice();
    }

    public int getCages_quantity()
    {
        return cages_quantity;
    }
}
