package BinarySearchAndSorting;

import java.io.*;
import java.util.Arrays;

public class BiggestOfThree
{
    private static int[] ReadData() throws IOException
    {
        var reader = new BufferedReader(new InputStreamReader(System.in));
        var readValues = reader.readLine().split(" ");
        reader.close();

        return Arrays.stream(readValues).mapToInt(Integer::parseInt).toArray();
    }

    public int mySqrt(int x) {
        var result = 0L;
        for(var sqrt = 1L; sqrt <= x; sqrt++)
        {
            if(sqrt * sqrt < x)
            {
                result = sqrt;
            }
            else
            {
                break;
            }
        }
        return (int)result;
    }

    private static int[] GetThreeNumbersWithMaximumMultiplication(int[] values)
    {
        Arrays.sort(values);

        var count = values.length;
        var firstResult = (long) values[count - 1] * values[count - 2] * values[count - 3];
        var secondResult = (long) values[0] * values[1] * values[count - 1];

        if (firstResult > secondResult) {
            return new int[]{values[count - 1], values[count - 2], values[count - 3]};
        } else {
            return new int[]{values[0], values[1], values[count - 1]};
        }
    }

    private static void Print(int[] values) throws IOException
    {
        var writer = new BufferedWriter(new OutputStreamWriter(System.out));
        for (var value: values)
        {
            writer.write(value + " ");
        }
        writer.close();
    }
}
