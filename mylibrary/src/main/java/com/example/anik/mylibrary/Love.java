package com.example.anik.mylibrary;

/**
 * Created by Anik on 26-Mar-15.
 */
public class Love {
    public static String calculate(String userOne, String userTwo){
        // it's a trick, if my name is in the string, then boom :D :P
        if(userOne.toLowerCase().contains("siraj") || userTwo.toLowerCase().contains("siraj"))
            return String.format("Love between %s and %s is %d%%.", userOne, userTwo, 100);
        //vaiable declaration
        String one = userOne.toLowerCase();
        String two = userTwo.toLowerCase();
        String strippedOne = one,
                strippedTwo = two;
        // strip existing character from second string what exists in first string
        for(char c: one.toCharArray())
            strippedTwo = strippedTwo.replace(""+c, "");
        // strip existing characters from first string what exists in second string
        for(char c: two.toCharArray())
            strippedOne = strippedOne.replace(""+c, "");
        // variable declaration
        int firstValue = 0,
                secondValue = 0;
        // calculate the ascii value of the first string
        for(char c: strippedOne.toCharArray())
            firstValue += (int)c;
        // varaible declaration
        int singleValueOne = 0;
        // if the first ascii equivalent number of first string is greater than 10
        // or the calculation of the first string in single digit representation is greater than 10,
        // then perform this calculation
        while(firstValue >= 10 || singleValueOne >= 10){
            if(firstValue < 10){
                firstValue = singleValueOne + firstValue;
                singleValueOne = 0;
            }
            singleValueOne += firstValue % 10;
            firstValue /= 10;
        }
        // add the very last first value to the single value one
        singleValueOne += firstValue;
        // calculate the ascii value of the second string
        for(char c: strippedTwo.toCharArray())
            secondValue += (int)c;
        // variable declaration
        int singleValueTwo = 0;
        // if the second ascii equivalent number of second string is greater than 10
        // or the calculation of the second string in single digit representation is greater than 10,
        // then perform this calculation
        while(secondValue >= 10 || singleValueTwo >= 10){
            if(secondValue < 10){
                secondValue = singleValueTwo + secondValue;
                singleValueTwo = 0;
            }
            singleValueTwo += secondValue % 10;
            secondValue /= 10;
        }
        // add the very last first value to the single value one
        singleValueTwo += secondValue;
        if(singleValueTwo == 0)
            return String.format("Wow, Infinite love between %s & %s", userOne, userTwo);
        if(singleValueOne > singleValueTwo){
            int temp = singleValueOne;
            singleValueOne = singleValueTwo;
            singleValueTwo = temp;
        }
        float percentage = (float) singleValueOne / (float) singleValueTwo;
        System.out.println(percentage);
        percentage *= 100;
        return String.format("Love between %s and %s is %.1f%%.", userOne, userTwo, percentage);
    }
}
