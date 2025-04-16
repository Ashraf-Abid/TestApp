package com.solvians.showcase;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

public class CertificateUpdate {

    private long timeStamp;
    private String ISIN;
    private double bidPrice;
    private int bidSize;
    private double askPrice;
    private int askSize;
    private LocalDate maturityDate;

    public CertificateUpdate() {
        ThreadLocalRandom rand = ThreadLocalRandom.current();
        this.timeStamp = System.currentTimeMillis();
        this.ISIN = ISINGenerator.generateISIN();
        this.bidPrice = getRoundNumber(rand.nextDouble(100.00, 200.01));
        this.bidSize = rand.nextInt(1000, 5001);
        this.askPrice = getRoundNumber(rand.nextDouble(100.00, 200.01));
        this.askSize = rand.nextInt(1000, 10001);
        this.maturityDate = LocalDate.now().plusDays(rand.nextInt(1, 730));
        System.out.println(ISIN);
    }

    private static double getRoundNumber(double value) {
        return (double) Math.round(value * 100) / 100;
    }


}
