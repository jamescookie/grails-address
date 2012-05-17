<%@ page import="org.grails.plugins.address.Address" %>
<div class="address">
    <div class="line1 fieldcontain ${hasErrors(bean: addressInstance, field: 'line1', 'error')} ">
        <label for="${prefix}line1">
            <g:message code="address.line1.label" default="Address Line 1" />
        </label>
        <g:textField name="${prefix}line1" value="${addressInstance?.line1}" />
    </div>

    <div class="line2 fieldcontain ${hasErrors(bean: addressInstance, field: 'line2', 'error')} ">
        <label for="${prefix}line2">
            <g:message code="address.line2.label" default="Address Line 2" />
        </label>
        <g:textField name="${prefix}line2" value="${addressInstance?.line2}" />
    </div>

    <div class="line3 fieldcontain ${hasErrors(bean: addressInstance, field: 'line3', 'error')} ">
        <label for="${prefix}line3">
            <g:message code="address.line3.label" default="Address Line 3" />
        </label>
        <g:textField name="${prefix}line3" value="${addressInstance?.line3}" />
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
        <g:if test="${grailsApplication.config.grails?.plugin?.address?.countryCodes}">
            <g:countrySelect name="${prefix}country" value="${addressInstance?.country}" noSelection="['':'']" from="${grailsApplication.config.grails?.plugin?.address?.countryCodes}"/>
        </g:if>
        <g:else>
            <g:countrySelect name="${prefix}country" value="${addressInstance?.country}" noSelection="['':'']"/>
        </g:else>
    </div>
</div>
