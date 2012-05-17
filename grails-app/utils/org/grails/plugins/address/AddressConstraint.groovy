package org.grails.plugins.address

class AddressConstraint {
    def grailsApplication

    static expectsParams = ['property']

    def skipBlankValues = false
    def skipNullValues = false

    def validate = { val, obj ->
        def property = params.property
        def regex = grailsApplication.config.grails?.plugin?.address?.validation?."$property"
        if (regex) {
            def test = val?.toString() ?: ""
            if ((test =~ regex).asBoolean()) {
                return true
            } else {
                return ["default.invalid.address.$property".toString(), regex]
            }
        } else {
            return true
        }
    }
}
