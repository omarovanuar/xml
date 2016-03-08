package com.epam.anuar.store.factory;

import com.epam.anuar.store.model.*;
import org.joda.money.Money;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PerformFactory {

    public void perform(){

        List<Product> productArray = new ArrayList<>();

        Product product1 = new Product(100, "Acoustic Guitar Ibanez-NX-630", Money.parse("KZT 360.99"));
        product1.addParameter("color", "red-black");
        product1.addParameter("Strings Number", "12");
        product1.addParameter("Fret Number", "20");
        productArray.add(product1);

        Product product2 = new Product(101, "Electroguitar Fender-Squire-MM60", Money.parse("KZT 500.65"));
        product2.addParameter("color", "black");
        product2.addParameter("Strings Number", "6");
        product2.addParameter("Fret Number", "20");
        product2.addParameter("Pick-up Scheme", "H_S");
        product2.addParameter("Number of tone regulators", "2");
        productArray.add(product2);

        Product product3 = new Product(102, "Electro-acoustic guitar Fender SXC", Money.parse("KZT 415.48"));
        product3.addParameter("color", "brown");
        product3.addParameter("Strings Number", "6");
        product3.addParameter("Fret Number", "21");
        product3.addParameter("Volume installation", "regulator");
        product3.addParameter("Preamplifier", "yes");
        productArray.add(product3);

        Product product4 = new Product(103, "Amplifier Samsung-SuperBass-s300", Money.parse("KZT 222.35"));
        product4.addParameter("Power capacity", "150V");
        product4.addParameter("Guitar input", "AUX");
        product4.addParameter("Dimension", "20x20x30");
        product4.addParameter("Weight", "12 kg");
        productArray.add(product4);

        Product product5 = new Product(104, "Effectprocessor YAMAHA-EP300", Money.parse("KZT 214.65"));
        product5.addParameter("Effect number", "20");
        product5.addParameter("User-Program number", "10");
        product5.addParameter("Tuner", "yes");
        productArray.add(product5);

        Product product6 = new Product(105, "Case for Fender Squire electroguitar", Money.parse("KZT 21.3"));
        product6.addParameter("color", "black");
        productArray.add(product6);

        Product product7 = new Product(106, "Guitar strings D'dario", Money.parse("KZT 10.5"));
        product7.addParameter("Diameters", "10, 11, 12, 13, 14, 15");
        product7.addParameter("Material", "Silver");
        productArray.add(product7);


        Collections.sort(productArray, Service.PRODUCT_PRICE_COMPARATOR);
        System.out.println(productArray + "\n");
        System.out.println(Service.search(productArray, product3) + "\n");

        ArrayList<User> userList = new ArrayList<>();
        userList.add(new User(1, User.Status.ADMIN, "Togayev Noyan", "8-707-4728462", "togayev.n@mail.ru"));
        userList.add(new User(2, User.Status.MODERATOR, "Daukaev Roman", "8-771-8973285", "simuran@mail.ru"));
        userList.add(new User(3, User.Status.REGISTERED_USER, "Golovin Mikhail", "8-701-8923753", "mike91@mail.ru"));
        userList.add(new User(4, User.Status.GUEST, "Almukhanov Aset", "8-701-2342420", "almukhanov@mail.ru"));
        userList.add(new User(5, User.Status.REGISTERED_USER, "Smagulova Dinara", "8-778-7774799", "dinara_16_92@mail.ru"));
        userList.forEach(System.out::println);
        System.out.println();

        DateTimeFormatter df = DateTimeFormat.forPattern("dd.MM.yyyy HH:mm");

        Cart cart1 = new Cart(1000, df.parseDateTime("03.02.2015 15:00"));
        cart1.addCartProduct(product1, product6, product7);
        cart1.calculateProductListPrice();
        Cart cart2 = new Cart(1001, df.parseDateTime("23.04.2015 12:17"));
        cart2.addCartProduct(product2, product5, product6);
        cart2.calculateProductListPrice();

        System.out.println(cart1);
        System.out.println(cart2 + "\n");

        Order order1 = new Order(200, userList.get(2), "MasterCard 9082-3213-4249-4598", cart1);
        Order order2 = new Order(201, userList.get(4), "VISA 5031-7623-4292-0885", cart2);

        System.out.println(order1);
        System.out.println(order2 + "\n");

    }



}
