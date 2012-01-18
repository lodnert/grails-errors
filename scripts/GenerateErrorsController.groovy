includeTargets << new File("$errorsPluginDir/scripts/_GenerateErrorsArtifacts.groovy")

target ('default': "Creates the errors controller with associated GSPs and configures it to handle errors") {
    depends(checkVersion, parseArguments)
    generateErrorsArtifacts(argsMap)
}
