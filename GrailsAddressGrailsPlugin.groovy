import grails.util.Environment

class GrailsAddressGrailsPlugin {
    // the plugin version
    def version = "0.1"
    // the version or versions of Grails the plugin is designed for
    def grailsVersion = "1.3.7 > *"
    // the other plugins this plugin depends on
    def dependsOn = [hibernate:"1.3.7 > * "]
    // resources that are excluded from plugin packaging
    def pluginExcludes = [
        "grails-app/views/error.gsp"
    ]

    def title = "Grails Address Plugin"
    def author = "James Cook"
    def authorEmail = "grails@jamescookie.com"
    def description = '''\
An address domain object that can be embedded in other domain object to save redefining it all the time
'''

    def documentation = "http://grails.org/plugin/grails-address"

    def license = "APACHE"
    def scm = [ url: "http://github.com/jamescookie/grails-address" ]

    def doWithSpring = {
        mergeConfig(application)
    }

    protected mergeConfig(application) {
        def addressConfig = application.config.grails?.plugin?.address?.clone()
        application.config.merge(loadConfig(application)).grails.plugin.address.merge(addressConfig)
    }

    protected loadConfig(application) {
        new ConfigSlurper(Environment.current.name).parse(application.classLoader.loadClass("AddressDefaultConfig"))
    }
}
