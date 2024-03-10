package org.example;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Factory {

    public static final EntityManagerFactory object = Persistence.createEntityManagerFactory("myunit");

}
