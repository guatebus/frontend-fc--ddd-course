package com.schibsted.domain.treasure;

import java.security.SecureRandom;

public class SystemRollDice implements RollDice {
    private final SecureRandom secureRandom = new SecureRandom();
    @Override
    public int roll() {
        return secureRandom.nextInt(101);
    }
}
