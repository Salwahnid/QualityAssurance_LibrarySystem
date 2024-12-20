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
                bat '\"${Maven}\\bin\\mvn.cmd\" test'
            }
        }
        stage('Quality Analysis') {
            steps {
                withSonarQubeEnv('SonarQube') {
                    bat '\"${Maven}\\bin\\mvn.cmd\" sonar:sonar'
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
            script {
                 emailext(
                                subject: "Build SUCCESS: ${env.JOB_NAME} ${env.BUILD_NUMBER}",
                                body: "Good news! The build for ${env.JOB_NAME} completed successfully.",
                                to: 'hnid.salwa1@gmail.com',
                                replyTo: 'salwahnid1@gmail.com',
                                mimeType: 'text/html'
                            )
                        }
                    }
        failure {
            script {
                 emailext(
                                subject: "Build FAILED: ${env.JOB_NAME} ${env.BUILD_NUMBER}",
                                body: "Unfortunately, the build for ${env.JOB_NAME} has failed. Please check Jenkins logs for more details.",
                                to: 'hnid.salwa1@gmail.com',
                                replyTo: 'salwahnid1@gmail.com',
                                mimeType: 'text/html'
                            )
                        }
                 }

    }
}
