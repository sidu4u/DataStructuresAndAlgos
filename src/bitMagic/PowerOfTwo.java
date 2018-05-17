package bitMagic;

import java.math.BigInteger;

public class PowerOfTwo {


    public static void main(String args[])
    {
        System.out.println(cyclicLeftShiftByOne(BigInteger.valueOf(5)));
    }

    private static BigInteger allOnes(int L)
    {
        return BigInteger.ZERO.setBit(L).subtract(BigInteger.ONE);
    }

    private static BigInteger cyclicLeftShiftByOne(BigInteger value)
    {
        int bitLength = value.bitLength();

        return value.shiftLeft(1).or(value.shiftRight(bitLength-1)).and(allOnes(bitLength));
    }

}
