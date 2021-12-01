package Animals;

import java.util.Objects;

public class BAnimal
{
    public static Cage build(AnimalKind kind)
    {
        Cage res = new Cage();
        switch (kind)
        {
            case Cat:
                res.setCagedAnimal(new Cat());
                break;
            case Giraffe:
                res.setCagedAnimal(new Giraffe());
                break;
            case Crocodile:
                res.setCagedAnimal(new Crocodile());
                break;
            case NoKind:
                res.setCagedAnimal(new NoKindAnimal());
                break;
            default:
                throw new IllegalArgumentException("Wrong animal kind:" + kind);
        }
        return res;
    }
    public static Cage build(String kind)
    {
        for(AnimalKind k:AnimalKind.values())
        {
            if(Objects.equals(k.toString(), kind))
            {
                return build(k);
            }
        }
        return null;
    }
}
