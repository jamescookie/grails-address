package address.test.harness.page

import geb.Page

class PersonList extends Page {
    static url = "person/list"
    static at = { title == "Person List" }

    static content = {
        numberOfPeople { $('tbody tr').size() }
        editPersonLink(required: false) { index-> $('tbody tr')[index].find('a')}
        createPersonLink(to: PersonCreate) { $("a.create") }
    }
}
