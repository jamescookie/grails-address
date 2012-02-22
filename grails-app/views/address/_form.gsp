<%@ page import="org.grails.plugins.address.Address" %>
<div class="address">
    <div class="address1 fieldcontain ${hasErrors(bean: addressInstance, field: 'address1', 'error')} ">
        <label for="address1">
            <g:message code="address.address1.label" default="Address Line 1" />
        </label>
        <g:textField name="address1" value="${addressInstance?.address1}" />
    </div>

    <div class="address2 fieldcontain ${hasErrors(bean: addressInstance, field: 'address2', 'error')} ">
        <label for="address2">
            <g:message code="address.address2.label" default="Address Line 2" />
        </label>
        <g:textField name="address2" value="${addressInstance?.address2}" />
    </div>

    <div class="address3 fieldcontain ${hasErrors(bean: addressInstance, field: 'address3', 'error')} ">
        <label for="address3">
            <g:message code="address.address3.label" default="Address Line 3" />
        </label>
        <g:textField name="address3" value="${addressInstance?.address3}" />
    </div>

    <div class="town fieldcontain ${hasErrors(bean: addressInstance, field: 'town', 'error')} ">
        <label for="town">
            <g:message code="address.town.label" default="Town" />
        </label>
        <g:textField name="town" value="${addressInstance?.town}" />
    </div>

    <div class="county fieldcontain ${hasErrors(bean: addressInstance, field: 'county', 'error')} ">
        <label for="county">
            <g:message code="address.county.label" default="County" />
        </label>
        <g:textField name="county" value="${addressInstance?.county}" />
    </div>

    <div class="postcode fieldcontain ${hasErrors(bean: addressInstance, field: 'postCode', 'error')} ">
        <label for="postCode">
            <g:message code="address.postCode.label" default="Post Code" />
        </label>
        <g:textField name="postCode" value="${addressInstance?.postCode}" />
    </div>

    <div class="country fieldcontain ${hasErrors(bean: addressInstance, field: 'country', 'error')} ">
        <label for="country">
            <g:message code="address.country.label" default="Country" />
        </label>
        <g:textField name="country" value="${addressInstance?.country}" />
    </div>
</div>
