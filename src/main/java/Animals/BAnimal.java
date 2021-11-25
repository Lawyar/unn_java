package Animals;

public class BAnimal
{
    public static Animal build(AnimalName name)
    {
        Animal res = null;
        switch (name)
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
                throw new IllegalArgumentException("Wrong animal name:" + name);
        }
        return res;
    }
}
