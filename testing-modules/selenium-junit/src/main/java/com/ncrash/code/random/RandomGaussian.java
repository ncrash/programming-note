package com.ncrash.code.random;

import java.util.Random;

public class RandomGaussian {
  public RandomGaussian() {}

  private Random fRandom = new Random();

  public double getGaussian(double aMean, double aVariance) {
    return aMean + fRandom.nextGaussian() * aVariance;
  }
}
