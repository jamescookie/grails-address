package org.grails.plugins.address

class Address {
    String address1
    String address2
    String address3
    String town
    String county
    String postCode
    String country
    
    static constraints = {
        address1 nullable: false, blank: false
        address2 nullable: true,  blank: true
        address3 nullable: true,  blank: true
        town     nullable: false, blank: false
        county   nullable: true,  blank: true
        postCode nullable: false, blank: false
        country  nullable: true,  blank: true
    }
}
