Grails Errors Plugin
====================

This plugin sets up some basic error handling for your application, namely 403, 404 and 500 errors. Specifically, it creates a default controller for handling 403, 404 and 500 status codes, along with accompanying GSPs. Simply install, and it will prompt for a name for the controller to handle these errors.

You can skip adding the errors controller on install and add it later instead by executing 
```
> grails generate-errors-controller xyz.ErrorsController
```

In addition, before rendering a 404, it will look for .gsp pages in the grails-app/view folder matching the Grails convention. This allows .gsp pages to be added without creating controllers or further configuration of the URL mappings. This is useful in allowing GSP pages to be added to your project by people not familiar with Groovy/Grails.

For example, adding the file grails-app/view/company/aboutus.gsp will cause it be rendered for a request to /company/aboutus without further configuration.
