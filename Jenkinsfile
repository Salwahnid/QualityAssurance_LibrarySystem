pipeline {
    agent any
    environment {
        Maven = tool 'Maven'
    }
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/Salwahnid/QualityAssurance_LibrarySystem.git'
            }
        }
        stage('Build') {
            steps {
                bat "\"${Maven}\\bin\\mvn.cmd\" clean compile"
            }
        }
        stage('Test') {
            steps {
                bat "\"${Maven}\\bin\\mvn.cmd\" test"
            }
        }
        stage('Quality Analysis') {
            steps {
                withSonarQubeEnv('sonarqube') {
                    bat "\"${Maven}\\bin\\mvn.cmd\" sonar:sonar"
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
