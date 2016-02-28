package com.epam.anuar.store.factory;

import com.epam.anuar.store.model.*;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.joda.money.Money;

import java.util.*;

public class PerformFactory {

    public static final Comparator<Product> PRODUCT_PRICE_COMPARATOR = (o1, o2) -> o1.getPrice().compareTo(o2.getPrice());
    public static final Comparator<Order> ORDER_PRICE_COMPARATOR = (o1, o2) -> o1.getPrice().compareTo(o2.getPrice());
    public static final Comparator<Product> PRODUCT_TITLE_COMPARATOR = (o1, o2) -> o1.getTitle().compareTo(o2.getTitle());

    public void perform(){

        List<Product> productArray = new ArrayList<>();

        Product product1 = new Product(53, "Acoustic Guitar Ibanez-NX-630", Money.parse("KZT 360.99"));
        product1.addParameter("color", "red-black");
        product1.addParameter("Strings Number", "12");
        product1.addParameter("Fret Number", "20");
        productArray.add(product1);

        Product product2 = new Product(1, "Electroguitar Fender-Squire-MM60", Money.parse("KZT 500.65"));
        product2.addParameter("color", "black");
        product2.addParameter("Strings Number", "6");
        product2.addParameter("Fret Number", "20");
        product2.addParameter("Pick-up Scheme", "H_S");
        product2.addParameter("Number of tone regulators", "2");
        productArray.add(product2);

        Product product3 = new Product(5, "Electro-acoustic guitar Fender SXC", Money.parse("KZT 415.48"));
        product3.addParameter("color", "brown");
        product3.addParameter("Strings Number", "6");
        product3.addParameter("Fret Number", "21");
        product3.addParameter("Volume installation", "regulator");
        product3.addParameter("Preamplifier", "yes");
        productArray.add(product3);

        Product product4 = new Product(14, "Amplifier Samsung-SuperBass-s300", Money.parse("KZT 222.35"));
        product4.addParameter("Power capacity", "150V");
        product4.addParameter("Guitar input", "AUX");
        product4.addParameter("Dimension", "20x20x30");
        product4.addParameter("Weight", "12 kg");
        productArray.add(product4);

        Product product5 = new Product(3, "Effectprocessor YAMAHA-EP300", Money.parse("KZT 214.65"));
        product5.addParameter("Effect number", "20");
        product5.addParameter("User-Program number", "10");
        product5.addParameter("Tuner", "yes");
        productArray.add(product5);

        Product product6 = new Product(8, "Case for Fender Squire electroguitar", Money.parse("KZT 21.3"));
        product6.addParameter("color", "black");
        productArray.add(product6);

        Product product7 = new Product(11, "Guitar strings D'dario", Money.parse("KZT 10.5"));
        product7.addParameter("Diameters", "10, 11, 12, 13, 14, 15");
        product7.addParameter("Material", "Silver");
        productArray.add(product7);


        Collections.sort(productArray, PRODUCT_PRICE_COMPARATOR);
        System.out.println(productArray + "\n");
        System.out.println(search(productArray, product3) + "\n");

        ArrayList<User> userList = new ArrayList<>();
        userList.add(new User(1, User.Status.ADMIN, "Togayev Noyan", "8-707-4728462", "togayev.n@mail.ru"));
        userList.add(new User(2, User.Status.MODERATOR, "Daukaev Roman", "8-771-8973285", "simuran@mail.ru"));
        userList.add(new User(3, User.Status.REGISTERED_USER, "Golovin Mikhail", "8-701-8923753", "mike91@mail.ru"));
        userList.add(new User(4, User.Status.GUEST, "Almukhanov Aset", "8-701-2342420", "almukhanov@mail.ru"));
        userList.add(new User(5, User.Status.REGISTERED_USER, "Smagulova Dinara", "8-778-7774799", "dinara_16_92@mail.ru"));
        userList.forEach(System.out::println);
        System.out.println();

        Order order1 = new Order(234, userList.get(2), "MasterCard", new GregorianCalendar(2015, 3, 2, 15, 0));
        order1.addParameters(product1, product2, product7);
        order1.calculatePrice();
        Order order2 = new Order(235, userList.get(4), "VISA", new GregorianCalendar(2015, 4, 23, 12, 30));
        order2.addParameters(product1, product3, product5);
        order2.calculatePrice();

        System.out.println(order1);
        System.out.println(order2 +
                "\n");

        Accounting accounting = new Accounting(1024, new GregorianCalendar(2015, 12, 31));
        accounting.addSoldProduct(order1, order2);
        accounting.priceSum();
        System.out.println(accounting);
    }

    private Product search(List<Product> arrayList, Product product){
        Product result = new Product();
        for (Product o : arrayList) {
            if (o.equals(product)){
                result = o;
            }
        }
        return result;
    }

}
