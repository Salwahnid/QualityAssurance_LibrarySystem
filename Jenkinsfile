pipeline {
    agent any
    environment {
        Maven = tool 'Maven'
    }
    stages {
        stage('Detect OS') {
                    steps {
                        script {
                            if (isUnix()) {
                                echo 'Environnement Unix détecté'
                                sh 'ls -la'
                            } else {
                                echo 'Environnement Windows détecté'
                                bat 'dir'
                            }
                        }
                    }
        }
        stage('Checkout') {
            steps {
                git 'https://github.com/Salwahnid/QualityAssurance_LibrarySystem.git'
            }
        }
        stage('Build') {
            steps {
                sh '"${Maven}/mvn" clean compile'
            }
        }
        stage('Test') {
            steps {
                sh '"${Maven}/mvn" test'
            }
        }
        stage('Quality Analysis') {
            steps {
                withSonarQubeEnv('SonarQube') {
                    sh '"${Maven}/mvn" sonar:sonar'
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
