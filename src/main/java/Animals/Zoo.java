package Animals;

import java.util.*;

public class Zoo
{
    private int myCagesNum;
    private int myRealAnimals;
    private ArrayList<Cage> myCages;
    private Set<AnimalClass> myUniqueClasses;
    private Set<Animal> myUniqueAnimals; //unique by class

    private void cagesInit(int cages_quantity)
    {
        this.myCagesNum = cages_quantity;
        this.myCages = new ArrayList<>();
        this.myUniqueClasses = new HashSet<>();
        this.myUniqueAnimals = new HashSet<>();
        myRealAnimals = 0;
    }
    private int typeQuantity(AnimalType type)
    {
        int res = 0;
        for(int i = 0; i < myCagesNum; i++)
        {
            AnimalType tmpType = myCages.get(i).getMyCagedAnimal().getType();
            if(Objects.equals(tmpType, type))
            {
                res++;
            }
        }
        return res;
    }

    private void addToUnique(Animal ani)
    {
       boolean flag = true;
       for(Cage cage:myCages) {
           if(cage.getMyCagedAnimal() != null && cage.getMyCagedAnimal().equals(ani)) {
               flag = false;
               myUniqueAnimals.remove(cage.getMyCagedAnimal());
               break;
           }
       }

       if(flag) {
           myUniqueAnimals.add(ani);
       }
    }

    public Zoo(int myCagesNum)
    {
        cagesInit(myCagesNum);
    }

    public Zoo(Animal ... animals)
    {
        cagesInit(animals.length);

        for(int i = 0; i < animals.length; i++)
        {
            try
            {
                if(i > this.myCagesNum - 1)
                {
                    throw new ArrayStoreException("NOT ENOUGH CAGES");
                }
                Cage tmp = new Cage(animals[i]);
                if(animals[i].getKind() != AnimalKind.NoKind)
                {
                    myRealAnimals++;
                }
                this.myCages.add(tmp);
                addToUnique(animals[i]);
            }
            catch (ArrayStoreException e)
            {
                System.out.println(e.getMessage());
                return;
            }
        }
    }

    public void addAnimal(Animal animal)
    {
        for (int i = 0; i < this.myCagesNum; i++)
        {
            if(!this.myCages.get(i).isFull())
            {
                addToUnique(animal);
                this.myCages.get(i).setCagedAnimal(animal);
                if(animal.getKind() != AnimalKind.NoKind)
                {
                    myRealAnimals++;
                }

                return;
            }
        }
        throw new ArrayStoreException("CAGES ARE FULL");
    }

    public void removeAnimal(int cage_index)
    {
        if(cage_index < 0 || cage_index >= myCagesNum)
        {
            throw new ArrayIndexOutOfBoundsException("INCORRECT INDEX");
        }
        if(myCages.get(cage_index).isFull())
        {
            if(myCages.get(cage_index).getMyCagedAnimal().getKind() != AnimalKind.NoKind)
            {
                myRealAnimals--;
            }
            myCages.remove(cage_index);
            myCagesNum--;
        }

        for(int i = 0; i < myCagesNum; i++)
        {
            addToUnique(this.myCages.get(i).getMyCagedAnimal());
        }
    }

    public String voiceFromCage(int cage_index)
    {
        if(cage_index < 0 || cage_index >= myCagesNum)
        {
            throw new ArrayIndexOutOfBoundsException("INCORRECT INDEX");
        }
        if(!myCages.get(cage_index).isFull())
        {
            return "-";
        }
        return myCages.get(cage_index).getMyCagedAnimal().getVoice();
    }

    public String animalInfo(int cage_index)
    {
        return this.myCages.get(cage_index).toString();
    }

    public int getCagesNum()
    {
        return myCagesNum;
    }

    public int getHerbivoresNum()
    {
        return typeQuantity(AnimalType.Herbivore);
    }
    public int getPredatorsNum()
    {
        return typeQuantity(AnimalType.Predator);
    }
    public Set<AnimalClass> getUniqueClasses()
    {
        return this.myUniqueClasses;
    }
    public Set<Animal> getUniqueAnimals()
    {
        return this.myUniqueAnimals;
    }
    public void buyCage()
    {
        myCagesNum++;
        myCages.add(new Cage());
    }

    public ArrayList<Animal> getAnimals()
    {
        ArrayList<Animal> list = new ArrayList<>();
        for(Cage c : myCages)
        {
            list.add(c.getMyCagedAnimal());
        }

        return list;
    }

    public boolean isFull()
    {
        for(Cage c : myCages)
        {
            if(!c.isFull())
            {
                return false;
            }
        }
        return true;
    }

    public int getRealAnimals() {
        return myRealAnimals;
    }
}
