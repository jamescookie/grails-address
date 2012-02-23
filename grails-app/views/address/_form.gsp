<%@ page import="org.grails.plugins.address.Address" %>
<div class="address">
    <div class="address1 fieldcontain ${hasErrors(bean: addressInstance, field: 'address1', 'error')} ">
        <label for="${prefix}address1">
            <g:message code="address.address1.label" default="Address Line 1" />
        </label>
        <g:textField name="${prefix}address1" value="${addressInstance?.address1}" />
    </div>

    <div class="address2 fieldcontain ${hasErrors(bean: addressInstance, field: 'address2', 'error')} ">
        <label for="${prefix}address2">
            <g:message code="address.address2.label" default="Address Line 2" />
        </label>
        <g:textField name="${prefix}address2" value="${addressInstance?.address2}" />
    </div>

    <div class="address3 fieldcontain ${hasErrors(bean: addressInstance, field: 'address3', 'error')} ">
        <label for="${prefix}address3">
            <g:message code="address.address3.label" default="Address Line 3" />
        </label>
        <g:textField name="${prefix}address3" value="${addressInstance?.address3}" />
    </div>

    <div class="town fieldcontain ${hasErrors(bean: addressInstance, field: 'town', 'error')} ">
        <label for="${prefix}town">
            <g:message code="address.town.label" default="Town" />
        </label>
        <g:textField name="${prefix}town" value="${addressInstance?.town}" />
    </div>

    <div class="county fieldcontain ${hasErrors(bean: addressInstance, field: 'county', 'error')} ">
        <label for="${prefix}county">
            <g:message code="address.county.label" default="County" />
        </label>
        <g:textField name="${prefix}county" value="${addressInstance?.county}" />
    </div>

    <div class="postcode fieldcontain ${hasErrors(bean: addressInstance, field: 'postCode', 'error')} ">
        <label for="${prefix}postCode">
            <g:message code="address.postCode.label" default="Post Code" />
        </label>
        <g:textField name="${prefix}postCode" value="${addressInstance?.postCode}" />
    </div>

    <div class="country fieldcontain ${hasErrors(bean: addressInstance, field: 'country', 'error')} ">
        <label for="${prefix}country">
            <g:message code="address.country.label" default="Country" />
        </label>
        <g:textField name="${prefix}country" value="${addressInstance?.country}" />
    </div>
</div>
