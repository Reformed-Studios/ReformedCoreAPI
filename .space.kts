/**
* JetBrains Space Automation
* This Kotlin-script file lets you automate build activities
* For more info, see https://www.jetbrains.com/help/space/automation.html
*/

job("Build and publish to maven.") {
    container(displayName = "Run publish script", image = "maven:3-openjdk-17-slim") {
        env["REFORMED_TOKEN"] = Secrets("repo_key")
        
        shellScript {
        	content = """
            echo Build and run tests...
            mvn clean install
            echo Publish artifacts...
            mvn deploy -s settings.xml \
            	-DreformedToken=${'$'}REFORMED_TOKEN
            """
        }
    	
    }
}
