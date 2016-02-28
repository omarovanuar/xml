package com.epam.anuar.store;

import com.epam.anuar.store.factory.PerformFactory;

public class Runner {
    public static void main(String[] args) {
        PerformFactory performFactory = new PerformFactory();
        performFactory.perform();
    }
}
