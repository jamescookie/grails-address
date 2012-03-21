package address.test.harness.page.module

import geb.Module

class AddressModule extends Module {

    static content = {
        field(required: false) { name-> $(".$name") }
    }
}
