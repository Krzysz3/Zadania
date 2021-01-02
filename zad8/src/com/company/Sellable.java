package com.company;

import java.math.BigDecimal;

public interface Sellable {
    boolean sell(Human seller, Human buyer, BigDecimal price);
}
