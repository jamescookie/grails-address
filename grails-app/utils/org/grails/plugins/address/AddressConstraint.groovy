package org.grails.plugins.address

class AddressConstraint {
    def grailsApplication

    static expectsParams = ['property']

    def skipBlankValues = false
    def skipNullValues = false

    def validate = { val, obj ->
        def property = params.property
        def regex = grailsApplication.config.grails?.plugin?.address?."$property"
        if (regex) {
            def test = val?.toString() ?: ""
            return (test =~ regex).asBoolean()
        } else {
            return true
        }
    }
}
