package com.applus.task;

import java.util.Random;


public class RandomNumbers {
   private Random random = new Random();
   private int firstNum;
   private int secondNum;
   private double percentage;
   private int betweenNum;

   public RandomNumbers(){

   }

   public void randomize(int _min, int _max){
        // Belirli bir aralıktaki rastgele sayıları al
       int min = _min;  // Minimum değer
       int max = _max;  // Maksimum değer

       // Rastgele iki farklı sayı almak için
       int randomNumber1 = random.nextInt(max - min + 1) + min;
       int randomNumber2;

       // İlk sayının dışında bir ikinci sayı almak için do-while döngüsü kullan
       do {
           randomNumber2 = random.nextInt(max - min + 1) + min;
       } while (randomNumber2 == randomNumber1);

       firstNum = Math.min(randomNumber1, randomNumber2);
       secondNum = Math.max(randomNumber1, randomNumber2);


       // İlk aralıktan rastgele bir sayı al
       int randomNumberBetween = random.nextInt(secondNum - firstNum + 1) + firstNum;
       betweenNum = randomNumberBetween;
       percentage = (((double) (betweenNum - firstNum)) / (secondNum - firstNum)) * 100.0;
   }

   public int getFirstNumber(){
return firstNum;
   }

    public int getSecondNumber(){
return secondNum;
    }

    public double getPercentage(){
        return percentage;
    }

    public int getBetweenNum(){
        return betweenNum;
    }

}
