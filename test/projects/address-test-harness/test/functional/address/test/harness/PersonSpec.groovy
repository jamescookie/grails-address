package address.test.harness

import address.test.harness.page.*

class PersonSpec extends address.test.harness.GebSpec {

    def cleanup() {
        deletePerson()
    }

    private void deletePerson() {
        to PersonList
        at PersonList
        if(editPersonLink(0).isPresent()) {
            editPersonLink(0).click()
            withConfirm(true) {$(".delete").click(PersonList) }
        }
    }

    def "Default values are present on edit page"() {
        when:
        to PersonCreate

        then:
        form."name"().value() == ""
        form."address.address1"().value() == ""
        form."address.address2"().value() == ""
        form."address.address3"().value() == ""
        form."address.town"().value() == ""
        form."address.county"().value() == ""
        form."address.postCode"().value() == ""
        form."address.country"().value() == ""
    }

}
