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
        line1    nullable: true, blank: true, address: [property: 'line1']
        line2    nullable: true, blank: true, address: [property: 'line2']
        line3    nullable: true, blank: true, address: [property: 'line3']
        town     nullable: true, blank: true, address: [property: 'town']
        county   nullable: true, blank: true, address: [property: 'county']
        postCode nullable: true, blank: true, address: [property: 'postCode']
        country  nullable: true, blank: true, address: [property: 'country']
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
