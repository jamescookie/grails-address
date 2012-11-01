package org.grails.plugins.address

class AddressConstraint {
    def grailsApplication
    def pluginManager

    static expectsParams = ['property']

    def skipBlankValues = false
    def skipNullValues = false
    
    def property

    def validate = { val, obj ->
        property = params.property
        def regex = grailsApplication.config.grails?.plugin?.address?.validation?."$property"
        if (regex) {
            def test = val?.toString() ?: ""
            if ((test =~ regex).asBoolean()) {
                return true
            } else {
                if (constraintPluginVersionGreaterThan("0.6.0")) {
                    return [defaultMessageCode, regex]
                } else {
                    return false
                }
            }
        } else {
            return true
        }
    }

    boolean constraintPluginVersionGreaterThan(version) {
        GrailsVersionUtils.isVersionGreaterThan(version, pluginManager.getGrailsPlugin('constraints').version)
    }
    
    String getDefaultMessageCode() {
        "default.invalid.address.$property".toString()   
    }
}
