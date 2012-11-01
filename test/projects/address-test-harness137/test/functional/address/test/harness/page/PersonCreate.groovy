package address.test.harness.page

import geb.Page

class PersonCreate extends Page {
    static url = "person/create"
    static at = { title == "Create Person" }

    static content = {
        form(required: true) { $('form') }
        saveButton(to: PersonEdit) { $("input.save") }
    }
    
	void save(to = PersonEdit) {
		saveButton.click(to)
	}
}
