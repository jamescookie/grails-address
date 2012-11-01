package address.test.harness

import org.grails.plugins.address.Address

class Person {

    String name
    Address address

    static embedded = ['address']

    static constraints = {
    }
}
