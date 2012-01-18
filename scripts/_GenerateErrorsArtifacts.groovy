includeTargets << grailsScript("_GrailsInit")
includeTargets << grailsScript("_GrailsCreateArtifacts")

generateErrorsArtifacts = { Map argsMap = [:] ->
    ant.mkdir(dir:"${basedir}/grails-app/controllers")

    def type = "Controller"
    if (!argsMap["params"]) {
        argsMap["params"] = []
        argsMap["params"] << grailsConsole.userInput("Specify a fully qualified class name for your errors Controller (e.g. com.xyz.ErrorsController), press Enter to skip:")
    }

    for (name in argsMap["params"]) {
        if (!name) {
            return
        }
        name = purgeRedundantArtifactSuffix(name, type)
        createArtifact(name: name, suffix: type, type: "ErrorsController", path: "grails-app/controllers")
        createUnitTest(name: name, suffix: type)
    }
    
    ant.mkdir(dir:"${basedir}/grails-app/views/errors")
    
    def errorTypes = ["403","404","500"]
    for (error in errorTypes) {
        def artifactFile = "${basedir}/grails-app/views/errors/error${error}.gsp"
        def templateFile = resolveResources("file:${pluginsHome}/*/src/templates/errors/error${error}.gsp")[0]
        copyGrailsResource(artifactFile, templateFile)
    }
    
    // Very hacky way of doing this, only really works on a new project. Needs improvement
    def mappingsFile = new File("${basedir}/grails-app/conf/UrlMappings.groovy")
    def mappings = '''\n\t\t// Added by Errors plugin\n\t\t"403"(controller: "errors", action: "error403")\n\t\t"404"(controller: "errors", action: "error404")\n\t\t"500"(controller: "errors", action: "error500")\n'''
    def writer = new StringWriter()
	boolean added = false
	if (mappingsFile.exists()) {
	    mappingsFile.eachLine { line ->
	       if( line.contains('''"500"(view:'/error')''') ) {
	           writer.append(mappings)
	           added = true
	       }
	       else {
	           writer.append("${line}\n")
	       } 
	    }
	}
	
	if (added) {
	    mappingsFile.text = writer.toString()
	    grailsConsole.addStatus "Modified grails-app/conf/UrlMappings.groovy, please check mappings!"
	}
	else {
	    grailsConsole.warn "UrlMappings.groovy not modified, please add the following to it: ${mappings}"
	}
}
