import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import Animals.Animal;
import Animals.AnimalClass;
import Animals.AnimalType;

public class Zoo
{
    private int cages_quantity;
    private ArrayList<Cage> cages;
    private Set<AnimalClass> unique_classes;
    private void cages_init(int cages_quantity)
    {
        this.cages_quantity = cages_quantity;
        this.cages = new ArrayList<>();
        this.unique_classes = new HashSet<>();
    }
    private int type_quantity(AnimalType type)
    {
        int res = 0;
        for(int i = 0; i < cages_quantity; i++)
        {
            AnimalType tmpType = cages.get(i).getCaged_animal().get_type();
            if(Objects.equals(tmpType, type))
            {
                res++;
            }
        }
        return res;
    }

    public Zoo(int cages_quantity)
    {
        cages_init(cages_quantity);
    }

    public Zoo(Animal ... animals)
    {
        cages_init(animals.length);

        for(int i = 0; i < animals.length; i++)
        {
            try
            {
                if(i > this.cages_quantity - 1)
                {
                    throw new ArrayStoreException("NOT ENOUGH CAGES");
                }
                Cage tmp = new Cage(animals[i]);
                this.cages.add(tmp);
                this.unique_classes.add(animals[i].get_class());
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
            if(!this.cages.get(i).get_status())
            {
                this.cages.get(i).setCaged_animal(animal);
                this.unique_classes.add(this.cages.get(i).getCaged_animal().get_class());
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
        if(cages.get(cage_index).get_status())
        {
            cages.get(cage_index).clear();
        }

        for(int i = 0; i < cages_quantity; i++)
        {
            unique_classes.add(cages.get(i).getCaged_animal().get_class());
        }
    }

    public String voice_from_cage(int cage_index)
    {
        if(cage_index < 0 || cage_index >= cages_quantity)
        {
            throw new ArrayIndexOutOfBoundsException("INCORRECT INDEX");
        }
        if(!cages.get(cage_index).get_status())
        {
            return "-";
        }
        return cages.get(cage_index).getCaged_animal().get_voice();
    }

    public String animal_info(int cage_index)
    {
        return this.cages.get(cage_index).toString();
    }

    public int getCages_quantity()
    {
        return cages_quantity;
    }

    public int getHerbivores_quantity()
    {
        return type_quantity(AnimalType.Herbivores);
    }
    public int getPredators_quantity()
    {
        return type_quantity(AnimalType.Predators);
    }
    public Set<AnimalClass> getUnique_classes()
    {
        return this.unique_classes;
    }
    public void buy_cage()
    {
        cages_quantity++;
        cages.add(new Cage());
    }
}
