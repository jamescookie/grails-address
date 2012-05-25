#Address Plugin for Grails

Simply a domain object that contains all the fields you need to create an address. This object can be embedded in many other domain objects.

The fields that are defined are:

*  line1
*  line2
*  line3
*  town
*  county
*  postCode
*  country

##Customisable

You can customise the address to suit your needs, but the same customisations will apply to all your address objects.

###Field Names

If you don't like the default names defined for the fields, you can simply override them in i18n messages.properties, e.g.

    address.postCode.label=Zip Code

###Validation

The plugin uses regex to validate the fields. Out of the box, the required fields are line1, town and post code. This can be overridden by defining your own regex for any of the fields, e.g.

    grails.plugin.address.validation.line1 = /\d+ .+/

###Error messages

If a fields fails to match your defined regex, you will get an error. You can override the error messages like this, e.g.

    default.invalid.address.line1=Address error - {0}: {2} does not match {3}

