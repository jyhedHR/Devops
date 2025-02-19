pipeline {

 agent any

tools{
    jdk 'JAVA_HOME'
    maven 'M2_HOME'
    
}

 stages {

 stage('GIT') {

           steps {

               git branch: 'master',

               url: 'https://github.com/jyhedHR/Devops.git/'

          }

     }

 stage ('Compile Stage') {

 steps {

 sh 'mvn clean compile'

 }

 }

 }

}
