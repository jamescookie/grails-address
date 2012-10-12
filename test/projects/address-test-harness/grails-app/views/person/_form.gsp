<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'name', 'error')} ">
    <label for="name">
        <g:message code="person.name.label" default="Name"/>
    </label>
    <g:textField name="name" value="${personInstance?.name}"/>
</div>

<fieldset class="embedded"><legend><g:message code="person.address.label" default="Address"/></legend>
    <g:render template="/address/form" model="[addressInstance: personInstance?.address, prefix: 'address.']" plugin="address"/>
</fieldset>

