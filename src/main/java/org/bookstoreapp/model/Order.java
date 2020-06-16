package org.bookstoreapp.model;

public class Order {
    private String FullName;
    private String DeliveryAdress;
    private String Email;
    private String PhoneNr;

    public Order(){

    }

    public Order(String fullName, String deliveryAdress, String email, String phoneNr) {
        FullName = fullName;
        DeliveryAdress = deliveryAdress;
        Email = email;
        PhoneNr = phoneNr;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getDeliveryAdress() {
        return DeliveryAdress;
    }

    public void setDeliveryAdress(String deliveryAdres) {
        DeliveryAdress = deliveryAdres;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhoneNr() {
        return PhoneNr;
    }

    public void setPhoneNr(String phoneNr) {
        PhoneNr = phoneNr;
    }

    @Override
    public String toString() {
        return "Order{" +
                "FullName='" + FullName + '\'' +
                ", DeliveryAdress='" + DeliveryAdress + '\'' +
                ", Email='" + Email + '\'' +
                ", PhoneNr='" + PhoneNr + '\'' +
                '}';
    }
}


