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
        form."address.line1"().value() == ""
        form."address.line2"().value() == ""
        form."address.line3"().value() == ""
        form."address.town"().value() == ""
        form."address.county"().value() == ""
        form."address.postCode"().value() == ""
        form."address.country"().value() == ""
    }

    def "Can add simple address"() {
        given:
        to PersonCreate

        when:
        form."name" = "Fred Bloggs"
        form."address.line1" = "Flat 16"
        form."address.line2" = "23a High Street"
        form."address.line3" = ""
        form."address.town" = "Brentford"
        form."address.county" = "Middlesex"
        form."address.postCode" = "TW89EW"
        form."address.country" = "UK"

        and:
        save PersonShow

        then:
        at PersonShow
        address.field('name').text() == "Fred Bloggs"
        address.field('line1').text() == "Flat 16"
        address.field('line2').text() == "23a High Street"
        !address.field('line3')
        address.field('town').text() == "Brentford"
        address.field('county').text() == "Middlesex"
        address.field('postCode').text() == "TW89EW"
        address.field('country').text() == "UK"

    }

}
