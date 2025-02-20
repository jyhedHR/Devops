pipeline {
    agent any 
    tools {
        maven 'M2_HOME'
    }

    stages {
        stage('Hello') {
            steps {
                echo 'Hi Jihed'
            }
        }
        
        stage('Git Checkout') {
            steps {
                git branch: 'main', 
                    url: 'https://github.com/jyhedHR/Devops.git',
                    credentialsId: 'Git_Key' // Remove this if repo is public
            }
        }
        
        stage('Build Project') {
            steps {
                sh 'mvn clean install -DskipTests' 
            }
        }

        stage('Run SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SonarQube') { // Replace 'SonarQube' with the actual name in Jenkins
                    sh 'mvn sonar:sonar'
                }
            }
        }
    }
}
