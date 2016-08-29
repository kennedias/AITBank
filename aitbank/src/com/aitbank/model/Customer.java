package com.aitbank.model;

/**
 * This class represents the Customer.
 * It contains also the related methods to manipulate the customer.
 *
 * @author 5399 - Kennedy Oliveira
 */
public class Customer {
    
    private int customerID;
    private String name;

    /**
     * Get the customerID attribute.
     * @return customerID  
     */
    public int getCustomerID() {
        return customerID;
    }

    /**
     * Set the customerID attribute.
     * @param customerID
     */
    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    /**
     * Get the name attribute.
     * @return name  
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name attribute.
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
    
    
}
