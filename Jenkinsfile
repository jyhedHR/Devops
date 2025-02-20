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

        stage('Run Application') {
            steps {
                //sh 'java -jar target/*.jar' // Adjust this if your JAR name is specific
            }
        }
            stage('Run sonor') {
            steps {
                sh 'mvn sonor:sonor' // Adjust this if your JAR name is specific
            }
        }  
        }
    
}
