package org.grails.plugins.address

class ConstraintTests extends GroovyTestCase {
    def grailsApplication

    void testDefaultConstraints() {
        def address = new Address(line1: 'line1', town: 'town', postCode: 'AA11AA')
        address.save()
        
        assertFalse address.hasErrors()
    }
    
    void testNoConstraints() {
        grailsApplication.config.grails.plugin.address.line1 = /.*/
        grailsApplication.config.grails.plugin.address.town = /.*/
        grailsApplication.config.grails.plugin.address.postCode = /.*/
        def address = new Address()
        address.save()
        
        assertFalse address.hasErrors()
    }
    
    void testOneConstraintNotMet() {
        def address = new Address()
        grailsApplication.config.grails.plugin.address.line1 = /\d+/
        address.save()

        assertTrue address.hasErrors()
    }

    void testOneConstraintMet() {
        def address = new Address(line1: '123')
        grailsApplication.config.grails.plugin.address.line1 = /\d+/
        address.save()

        assertFalse address.hasErrors()
    }
}
