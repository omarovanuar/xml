package com.epam.anuar.store.factory;

import com.epam.anuar.store.model.*;
import org.joda.money.Money;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.epam.anuar.store.model.Service.formatDate;

public class PerformFactory {

    public void perform(){

        List<Product> productArray = new ArrayList<>();

        Product product1 = new Product(100, "Acoustic Guitar Ibanez-NX-630", Money.parse("KZT 360.99"), 3);
        product1.addParameter("color", "red-black");
        product1.addParameter("stringsNumber", "12");
        product1.addParameter("fretNumber", "20");
        productArray.add(product1);

        Product product2 = new Product(101, "Electroguitar Fender-Squire-MM60", Money.parse("KZT 500.65"), 5);
        product2.addParameter("color", "black");
        product2.addParameter("stringsNumber", "6");
        product2.addParameter("fretNumber", "20");
        product2.addParameter("pickUpScheme", "H_S");
        product2.addParameter("toneRegulatorNumber", "2");
        productArray.add(product2);

        Product product3 = new Product(102, "Electro-acoustic guitar Fender SXC", Money.parse("KZT 415.48"),3);
        product3.addParameter("color", "brown");
        product3.addParameter("stringsNumber", "6");
        product3.addParameter("fretNumber", "21");
        product3.addParameter("volumeInstallation", "regulator");
        product3.addParameter("preamplifier", "yes");
        productArray.add(product3);

        Product product4 = new Product(103, "Amplifier Samsung-SuperBass-s300", Money.parse("KZT 222.35"), 2);
        product4.addParameter("powerCapacity", "150V");
        product4.addParameter("guitarInput", "AUX");
        product4.addParameter("dimension", "20x20x30");
        product4.addParameter("weight", "12 kg");
        productArray.add(product4);

        Product product5 = new Product(104, "Effectprocessor YAMAHA-EP300", Money.parse("KZT 214.65"), 2);
        product5.addParameter("effectNumber", "20");
        product5.addParameter("userProgramNumber", "10");
        product5.addParameter("tuner", "yes");
        productArray.add(product5);

        Product product6 = new Product(105, "Case for Fender Squire electroguitar", Money.parse("KZT 21.3"), 10);
        product6.addParameter("color", "black");
        productArray.add(product6);

        Product product7 = new Product(106, "Guitar strings D'dario", Money.parse("KZT 10.5"), 35);
        product7.addParameter("diameters", "10, 11, 12, 13, 14, 15");
        product7.addParameter("material", "Silver");
        productArray.add(product7);

        Collections.sort(productArray, Service.PRODUCT_PRICE_COMPARATOR);


        ArrayList<User> userList = new ArrayList<>();
        userList.add(new User(1, User.Status.ADMIN,
                "Togayev Noyan",
                "Yzeva 16-22",
                "8-707-4728462",
                "Center Credit 2345-8797-1652-5432",
                "togayev.n@mail.ru",
                Money.parse("KZT 10000")));
        userList.add(new User(2, User.Status.MODERATOR,
                "Daukaev Roman",
                "17 mkr-33",
                "8-771-8973285",
                "Center Credit 8974-2143-0823-2948",
                "simuran@mail.ru",
                Money.parse("KZT 20000")));
        userList.add(new User(3, User.Status.REGISTERED_USER,
                "Golovin Mikhail",
                "Gogolya 13-41",
                "8-701-8923753",
                "Forte Bank 8973-2421-4235-4643",
                "mike91@mail.ru",
                Money.parse("KZT 30000")));
        userList.add(new User(4, User.Status.REGISTERED_USER,
                "Almukhanov Aset",
                "Shahterov 2-15",
                "8-701-2342420",
                "Halyk Bank 3257-9142-5632-6321",
                "almukhanov@mail.ru",
                Money.parse("KZT 20000")));
        userList.add(new User(5, User.Status.REGISTERED_USER,
                "Smagulova Dinara",
                "Mira B. 27a-6",
                "8-778-7774799",
                "Kaspi Bank 9752-8298-1841-5216",
                "dinara_16_92@mail.ru",
                Money.parse("KZT 50000")));
        userList.forEach(System.out::println);
        System.out.println();

        Cart cart1 = new Cart(1000, formatDate("03.02.2015 15:00"));
        cart1.addCartProduct(product1, product6, product7);
        cart1.calculateProductListPrice();
        Cart cart2 = new Cart(1001, formatDate("23.04.2015 12:17"));
        cart2.addCartProduct(product2, product5, product6);
        cart2.calculateProductListPrice();

        System.out.println(cart1);
        System.out.println(cart2 + "\n");

        Order order1 = new Order(200, userList.get(2), cart1, formatDate("03.02.2015 15:24"));
        Order order2 = new Order(201, userList.get(4), cart2, formatDate("24.04.2015 14:17"));

        System.out.println(order1);
        System.out.println(order2 + "\n");

        ShipmentReceipt shipment1 = new ShipmentReceipt(500, "KAZPOST", Money.parse("KZT 300"), "Golubie prudi 13-1", order1);
        ShipmentReceipt shipment2 = new ShipmentReceipt(501, "KAZPOST", Money.parse("KZT 300"), "Satibaldina 4-13", order1);

        System.out.println(shipment1 + "\n" + shipment2);
    }



}
