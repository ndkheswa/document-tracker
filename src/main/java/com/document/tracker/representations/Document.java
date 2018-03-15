package com.document.tracker.representations;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;

public class Document {

    private int catalogueID;
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy MMM dd");
    private String receivedDate, requestedDueDate;
    private Customer customer;

    private enum RequestType {
        LICENSE, SMART_ID, PASSPORT
    }

    protected Document(int aCatalogueID, int requiredInDays) {
        this.catalogueID = aCatalogueID;
        Calendar calendar = new GregorianCalendar();
        this.receivedDate = formatter.format(calendar.getTime());
        calendar.add(Calendar.DAY_OF_MONTH, requiredInDays);
        this.requestedDueDate = formatter.format(calendar.getTime());
    }

    protected Document() {
        this(0, 0);
    }

    public void attachCustomer(Customer customer) {
        this.customer = customer;
    }

    public void detachCustomer() {
        this.customer = null;
    }

    public String getReceivedDate() {
        return receivedDate;
    }

    public String getRequestedDueDate() {
        return requestedDueDate;
    }

    public int getCatalogueID() {
        return catalogueID;
    }


}
