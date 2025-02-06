pipeline {
    agent any 
    tools{
        maven'M2_HOME'
    }

    stages {
        stage('Hello') {
            steps {
            echo 'hi jyhed'
            }
            
        }
          stage('GIT') {
            steps {
              
                   git branch: 'main', 
                    url: 'https://github.com/jyhedHR/Devops.git',
                    credentialsId: 'Git_Key'
            }
            
        }
            stage('Build Project') {
            steps {
                sh 'mvn clean package -DskipTests' // Builds the Spring Boot project and packages it as a JAR
            }
        }

       script {
                    // Start the Spring Boot application in the background
                    def appProcess = sh(script: 'java -jar target/*.jar &', returnStdout: true).trim()
                    echo "Application started with PID: ${appProcess}"

                    // Wait for the application to start (adjust the sleep duration as needed)
                    sleep(time: 10, unit: 'SECONDS')

                    // Shutdown the VM
                    echo 'Shutting down the VM...'
                    sh 'sudo shutdown -h now'
                }
            
        }
    
}