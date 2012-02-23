package address.test.harness.page

import geb.Page

class PersonEdit extends Page {
    static at = { title == "Edit Person" }

    static content = {
        flashMessage(required: false) { $(".message").text() }
    }
}
