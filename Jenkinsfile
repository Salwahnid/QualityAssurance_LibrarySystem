pipeline {
    agent any
    environment {
        MAVEN_HOME = tool 'Maven'
    }
    stages {
        stage('Checkout') {
            steps {

                git 'https://github.com/Salwahnid/QualityAssurance_LibrarySystem.git'
            }
        }
        stage('Build') {
            steps {
                sh '$maven/bin/mvn clean compile'
            }
        }
        stage('Test') {
            steps {
                sh '$maven/bin/mvn test'
            }
        }
        stage('Quality Analysis') {
            steps {
                withSonarQubeEnv('SonarQube') {
                    sh '$maven/bin/mvn sonar:sonar'
                }
            }
        }
        stage('Deploy') {
            steps {
                echo 'Déploiement simulé réussi'
            }
        }
    }
    post {
        success {
            emailext to: 'salwahnid1@gmail.com',
                subject: 'Build Success',
                body: 'Le build a été complété avec succès.'
        }
        failure {
            emailext to: 'salwahnid1@gmail.com',
                subject: 'Build Failed',
                body: 'Le build a échoué.'
        }
    }
}
