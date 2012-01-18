Grails Errors Plugin
====================

This plugin sets up some basic error handling for your application, namely 403, 404 and 500 errors. Simply install, and it will prompt for a name for the controller to handle these errors.

In addition, before rendering a 404, it will look for .gsp pages in the grails-app/view folder matching the Grails convention. This allows .gsp pages to be added without further configuration.

For example, adding the file grails-app/view/company/aboutus.gsp will cause it be rendered for a request to /company/aboutus without further configuration.
