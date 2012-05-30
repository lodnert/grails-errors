class ErrorsGrailsPlugin {
    def version = "0.7"
    def grailsVersion = "2.0 > *"
    def dependsOn = [:]
    def pluginExcludes = [
        "grails-app/views/error.gsp"
    ]
    def title = "Errors Plugin"
    def author = "Craig Raw"
    def authorEmail = "craig@quirk.biz"
    def description = '''\
This plugin sets up some basic error handling for your application. Specifically, it creates a default ErrorController for handling 403, 404 and 500 status codes, along with accompanying GSPs.

It also looks for GSP pages (matching the Grails convention of finding resources) before rendering the 404 page, allowing pages to be added without creating controllers or further configuration of the URL mappings. 
This is useful in allowing GSP pages to be added to your project by people not familiar with Groovy/Grails.
'''
    def license = "APACHE"
    def organization = [ name: "Quirk Labs", url: "http://www.quirklabs.co.za" ]
    def documentation = "https://github.com/quirklabs/grails-errors"
    def scm = [ url: "https://github.com/quirklabs/grails-errors" ]
}
