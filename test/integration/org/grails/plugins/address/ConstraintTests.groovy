package org.grails.plugins.address

class ConstraintTests extends GroovyTestCase {
    def grailsApplication

    void testDefaultConstraints() {
        def address = new Address(line1: 'line1', town: 'town', postCode: 'AA11AA')
        address.save()

        assertFalse address.hasErrors()
    }
    
    void testFailingDefaultConstraints() {
        def address = new Address()
        address.save()

        assertTrue address.hasErrors()
    }

    void testOverridingDefaultConstraints() {
        grailsApplication.config.grails.plugin.address.line1 = /.*/
        grailsApplication.config.grails.plugin.address.town = /.*/
        grailsApplication.config.grails.plugin.address.postCode = /.*/
        def address = new Address()
        address.save()
        
        assertFalse address.hasErrors()
    }
    
    void testOneConstraintNotMet() {
        grailsApplication.config.grails.plugin.address.line1 = /\d+/
        grailsApplication.config.grails.plugin.address.town = /.*/
        grailsApplication.config.grails.plugin.address.postCode = /.*/
        def address = new Address()
        address.save()

        assertTrue address.hasErrors()
    }

    void testOneConstraintMet() {
        grailsApplication.config.grails.plugin.address.line1 = /\d+/
        grailsApplication.config.grails.plugin.address.town = /.*/
        grailsApplication.config.grails.plugin.address.postCode = /.*/
        def address = new Address(line1: '123')
        address.save()

        assertFalse address.hasErrors()
    }
}
