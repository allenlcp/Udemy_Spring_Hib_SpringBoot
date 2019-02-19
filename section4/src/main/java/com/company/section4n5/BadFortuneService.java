package com.company.section4n5;

import java.util.Random;

public class BadFortuneService implements FortuneService {
    public String getFortune() {
        String[] data = {
                "Random fortune 1",
                "Random fortune 2",
                "Random fortune 3"
        };
        Random random = new Random();
        int index = random.nextInt(data.length);
        return data[index];
    }
}
