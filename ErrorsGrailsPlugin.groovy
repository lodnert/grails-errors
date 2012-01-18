class ErrorsGrailsPlugin {
    // the plugin version
    def version = "0.5"
    // the version or versions of Grails the plugin is designed for
    def grailsVersion = "2.0 > *"
    // the other plugins this plugin depends on
    def dependsOn = [:]
    // resources that are excluded from plugin packaging
    def pluginExcludes = [
        "grails-app/views/error.gsp"
    ]

    // TODO Fill in these fields
    def title = "Errors Plugin" // Headline display name of the plugin
    def author = "Craig Raw"
    def authorEmail = "craig@quirk.biz"
    def description = '''\
This plugin sets up some error handling for your application. 
It also looks for GSP pages matching the Grails convention of finding resources before rendering the 404 page, allowing pages to be added without further configuration.
'''

    // URL to the plugin's documentation
    def documentation = "http://grails.org/plugin/errors"

    // Extra (optional) plugin metadata

    // License: one of 'APACHE', 'GPL2', 'GPL3'
    def license = "APACHE"

    // Details of company behind the plugin (if there is one)
    def organization = [ name: "Quirk Labs", url: "http://www.quirklabs.co.za" ]
}
