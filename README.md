The Partner Center Java SDK, provides an SDK to interact with the Microsoft's Partner Center Service. This enables the Partners to perform the Partner Center operations programatically or through their own portals. The Java SDK is the latest addition to existing portfolio of REST APIs and the C# SDK. This is currently tested and supports Java versions upwards of Java 6, due to a dependancy on ADAL which does not support Java versions below 1.7. 
This repo includes the Java SDK code as well as a sample-application that demonstrates how to make calls and consume the Java SDK.

Here are the steps you can follow to run the SDK and Sample-App code locally:
1. Install Java, Maven and Eclipse (or another IDE) if you don't already have these installed
2. Setup the JAVA_HOME and JRE_HOME environment variables.
3. Setup the MAVEN_HOME environment variable.
4. Download the SDK and Samples projects from GitHub.
5. Import the downloaded projects into the IDE as maven projects.
6. Replace the place holders values for the App-Id, Username, Password etc in the SamplesConfiguration.json file, which is located in resources in the Samples project.
6. Run the Program.java file in the com.microsoft.store.partnercenter.samples package in the Samples project.
7. This will show a Menu which guides through running the different scenarios supported by the SDK.
