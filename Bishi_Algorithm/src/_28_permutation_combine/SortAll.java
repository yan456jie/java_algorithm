package _28_permutation_combine;


public class SortAll
{
    static char [] data = {'a','b','c'};
    public static void main(String [] args)
    {
        sort(data,0);
    }
    public static void sort(char [] data,int begin)
    {
        //ֹͣ
        if(begin>=data.length)
        {
            System.out.println(new String(data));
        }
        char temp;
        for(int i=begin; i<data.length;i++)
        {
            if(data[begin]!=data[i])
            {
                temp = data[i];
                data[i] = data[begin];
                data[begin] = temp;
            }
            sort(data,begin+1);
            if(data[begin]!=data[i])
            {
                temp = data[i];
                data[i] = data[begin];
                data[begin] = temp;
            }
        }
    }
}