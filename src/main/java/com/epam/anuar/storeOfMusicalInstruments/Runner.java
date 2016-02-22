package com.epam.anuar.storeOfMusicalInstruments;

import com.epam.anuar.storeOfMusicalInstruments.factory.PerformFactory;

public class Runner {
    public static void main(String[] args) {
        PerformFactory performFactory = new PerformFactory();
        performFactory.perform();
    }
}
