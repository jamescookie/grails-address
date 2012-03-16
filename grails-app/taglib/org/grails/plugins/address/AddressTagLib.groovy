package org.grails.plugins.address

class AddressTagLib {
    static namespace = "address"

    def display = {args, body ->
        def address = args.address
        if (!address || !(address instanceof Address)) throw new IllegalArgumentException("Need to supply an address")
        out << '<ul class="address">'
        if (body) out << body()
        renderField(address, "line1")
        renderField(address, "line2")
        renderField(address, "line3")
        renderField(address, "town")
        renderField(address, "county")
        renderField(address, "postCode")
        renderField(address, "country")
        out << '</ul>'
    }

    private void renderField(address, name) {
        def value = address."$name"
        if (value) {
            out << """<li class="$name">$value</li>"""
        }
    }
}
