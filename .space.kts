/**
* JetBrains Space Automation
* This Kotlin-script file lets you automate build activities
* For more info, see https://www.jetbrains.com/help/space/automation.html
*/

job("Hello World!") {
    container(displayName = "Run publish script", image = "maven:3-openjdk-17-slim") {
        env["REFORMED_TOKEN"] = Secrets("repo_key")
        
        shellScript {
        	content = """
            echo Build and run tests...
            mvn clean install
            echo Publish artifacts...
            mvn versions:set -DnewVersion=1.0.${'$'}JB_SPACE_EXECUTION_NUMBER
            mvn deploy
            """
        }
    	
    }
}
