package org.grails.plugins.address

class Address {
    String line1
    String line2
    String line3
    String town
    String county
    String postCode
    String country
    
    static constraints = {
        line1    nullable: false, blank: false
        line2    nullable: true,  blank: true
        line3    nullable: true,  blank: true
        town     nullable: false, blank: false
        county   nullable: true,  blank: true
        postCode nullable: false, blank: false
        country  nullable: true,  blank: true
    }

    @Override
    public String toString() {
        return "Address{" +
                "line1='" + line1 + '\'' +
                ", line2='" + line2 + '\'' +
                ", line3='" + line3 + '\'' +
                ", town='" + town + '\'' +
                ", county='" + county + '\'' +
                ", postCode='" + postCode + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

}
