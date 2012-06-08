package org.grails.plugins.address

import grails.test.mixin.*

@TestFor(AddressTagLib)
@Mock(Address)
class AddressTagLibTests {

    void testSupplyingNothing() {
        shouldFail {
            applyTemplate('<address:display />')
        }
    }

    void testSupplyingNull() {
        shouldFail {
            applyTemplate('<address:display address="${address}" />', [address: null])
        }
    }

    void testShouldRenderEmptyAddress() {
        def address = new Address()
        assert applyTemplate('<address:display address="${address}" />', [address: address]) == '<ul class="address"></ul>'
    }

    void testShouldRenderFullAddress() {
        def address = new Address(
                line1: "line 1",
                line2: "line 2",
                line3: "line 3",
                town: "a town",
                postCode: "WW1 1WW",
                county: "a county",
                country: "gbr")
        assert applyTemplate('<address:display address="${address}" />', [address: address]) == '<ul class="address"><li class="line1">line 1</li><li class="line2">line 2</li><li class="line3">line 3</li><li class="town">a town</li><li class="county">a county</li><li class="postCode">WW1 1WW</li><li class="country">United Kingdom</li></ul>'
    }

    void testShouldRenderPartialAddress() {
        def address = new Address(
                line1: "line 1",
                town: "a town",
                postCode: "WW1 1WW")
        assert applyTemplate('<address:display address="${address}" />', [address: address]) == '<ul class="address"><li class="line1">line 1</li><li class="town">a town</li><li class="postCode">WW1 1WW</li></ul>'
    }

    void testShouldRenderBodyAsPartOfList() {
        def address = new Address(
                line1: "line 1")
        assert applyTemplate('<address:display address="${address}"><li>A name</li></address:display>', [address: address]) == '<ul class="address"><li>A name</li><li class="line1">line 1</li></ul>'
    }

    void testShouldRenderAsString() {
        def address = new Address(
                line1: "line 1",
                line2: "line 2",
                line3: "line 3",
                town: "a town",
                postCode: "WW1 1WW",
                county: "a county",
                country: "gbr")
        assert applyTemplate('<address:display address="${address}" as="string" />', [address: address]) == 'line 1, line 2, line 3, a town, a county, WW1 1WW, United Kingdom'
    }

    void testCanRenderEmptyAddressAsString() {
        def address = new Address()
        assert applyTemplate('<address:display address="${address}" as="string" />', [address: address]) == ''
    }

    void testCannotRenderAsAnythingElse() {
        def address = new Address()
        shouldFail {
            applyTemplate('<address:display address="${address}" as="rubbish" />', [address: address])
        }
    }
}
