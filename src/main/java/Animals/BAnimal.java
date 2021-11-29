package Animals;

public class BAnimal
{
    public static Animal build(AnimalKind kind)
    {
        Animal res = null;
        switch (kind)
        {
            case Cat:
                res = new Cat();
                break;
            case Giraffe:
                res = new Giraffe();
                System.out.println("FFFFFFFFFFFFFFFFFF");
                break;
            case Crocodile:
                break;
            default:
                throw new IllegalArgumentException("Wrong animal kind:" + kind);
        }
        return res;
    }
}
