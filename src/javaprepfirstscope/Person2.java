package javaprepfirstscope;

import java.util.Optional;

public class Person2 {
    Address address;

    Person2(Address address) {
        this.address = address;
    }

    Person2() {
        this(new Address(new City("Kathmandu")));
    }

    public Address getAddress() {
        return address;
    }

    public static Optional<Person2> newPerson(int id) {
        return id == 1 ? Optional.of(new Person2()) : Optional.empty();
    }

    public static void main(String[] args) {
//        new Person2().getAddress().getCity(); (Will throw null pointer exception here since Person2().getAddress() results in null and it will try to invoke getCity() using null Address object
        System.out.println(Optional
                .ofNullable(new Person2().getAddress())
                .map(Address::getCity)
                .map(City::getName)
                .orElse("Unknown"));

        String cityName = newPerson(1)
                .map(Person2::getAddress)
                .map(Address::getCity)
                .map(City::getName)
                .orElse("Unknown");

        System.out.println(cityName);

        String missingCityName = newPerson(999)
                .map(Person2::getAddress)
                .map(Address::getCity)
                .map(City::getName)
                .orElse("Unknown");
        System.out.println(missingCityName);
    }
}

class Address {
    public City city;

    Address(City city) {
        this.city = city;
    }

    public City getCity() {
        return city;
    }
}

class City {
    public String name;


    City(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
