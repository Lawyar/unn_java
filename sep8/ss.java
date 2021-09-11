package sep8;

public class ss
{
    private static int _a, _b, _c, _n;
    ss(int a, int b, int c, int n)
    {
        _a = a;
        _b = b;
        _c = c;
        _n = n;
    }

    public static double st_sum()
    {
        double res = 1;
        int i = 1;
        int nd = 2;
        
        while(i != _n)
        {
            res += 1;
            for(double j = 2; j <= nd; j++)
            {
                double tmp = 1 / j;
                res += tmp;
            }
            i++;
            nd++;
        }
        return res;
    }

    public static void triangle()
    {
        int gip = 0;
        int cat1, cat2;
        if(_a > _b && _a > _c)
        {
            cat1 = _b;
            cat2 = _c;
            gip = _a;
        }
        else if(_b > _a && _b > _c)
        {
            cat1 = _a;
            cat2 = _c;
            gip = _b;
        }
        else
        {
            cat1 = _a;
            cat2 = _b;
            gip = _c;
        }

        if(cat1 * cat1 + cat2 * cat2 == gip * gip)
        {
            System.out.println("Прямой");
        }
        else if(cat1 * cat1 + cat2 * cat2 > gip * gip)
        {
            System.out.println("Острый");
        }
        else
        {
            System.out.println("Тупой");
        }
    }
}