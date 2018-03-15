package com.document.tracker.representations;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.LinkedList;


public class Customer {

    private final int id;
    private final String firstName;
    private final String lastName;
    //private final String phone;

    private Collection<Document> submittedDocuments;

    public Customer(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        submittedDocuments = new LinkedList();
    }

    protected Customer() {
        this(0,"", "");
    }

    public void attachDocument(Document document) {
        document.attachCustomer(this);
        submittedDocuments.add(document);
    }

    public void detachDocument(Document document) {
        document.detachCustomer();
        submittedDocuments.remove(document);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

}
