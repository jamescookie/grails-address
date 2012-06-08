package org.grails.plugins.address

import org.apache.commons.lang.StringUtils

class AddressTagLib {
    static namespace = "address"

    def display = {args, body ->
        def address = args.address
        if (!address || !(address instanceof Address)) throw new IllegalArgumentException("Need to supply an address")
        String type = args.as ?: 'list'
        def method = 'renderAs' + StringUtils.capitalize(type)
        if (!this.metaClass.methods*.name.contains(method)) {
            throw new IllegalArgumentException("Unable to render as $type");
        }
        out << this."$method"(address, body)
    }

    String renderAsString(Address address, Closure body) {
        def output = createAddress(address) {name, value->"$value, "}
        if (output.size() > 2) {
            output = output[0..-3]
        }
        output
    }

    String renderAsList(Address address, Closure body) {
        def writer = new StringWriter()
        writer << '<ul class="address">'
        if (body) writer << body()
        writer << createAddress(address) {name, value->"""<li class="$name">$value</li>"""}
        writer << '</ul>'
        return writer.toString()
    }

    private String createAddress(Address address, Closure how) {
        def writer = new StringWriter()
        def renderItem = renderField.curry(how)
        writer << ['line1', 'line2', 'line3', 'town', 'county', 'postCode'].collect {renderItem(address, it)}.join('')
        def country = address.country
        if (country) {
            writer << how("country", g.country(code: country))
        }
        return writer.toString()
    }

    private renderField = {Closure output, address, name->
        def value = address."$name"
        if (value) {
            return output(name, value)
        } else {
            return ""
        }
    }
}
