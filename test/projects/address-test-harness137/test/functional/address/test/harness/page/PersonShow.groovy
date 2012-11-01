package address.test.harness.page

import geb.Page
import address.test.harness.page.module.AddressModule

class PersonShow extends Page {
    static at = { title == "Show Person" }

    static content = {
        address { module AddressModule, $('.address') }
    }
}
