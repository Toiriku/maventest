pipeline {
    agent any

    environment {
        DOCKERHUB_CREDENTIALS_ID = 'b5a68f67-1755-46c0-90bb-15b72f0532ca'
        DOCKERHUB_REPO = 'toiriku/maventest'
        DOCKER_IMAGE_TAG = 'latest'
    }

    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/Toiriku/maventest.git', branch: 'master'
            }
        }

        stage('Build & Test') {
            steps {
                    bat 'mvn clean package'
            }
        }

        stage('JaCoCo Coverage') {
            steps {
                jacoco execPattern: '**/target/jacoco.exec'
            }
        }

        stage('Docker Build') {
            steps {
                bat 'docker build -t %DOCKERHUB_REPO%:%DOCKER_IMAGE_TAG% .'
            }
        }

        stage('Docker Push') {
            steps {
                withCredentials([usernamePassword(
                    credentialsId: "${DOCKERHUB_CREDENTIALS_ID}",
                    usernameVariable: 'DOCKER_USER',
                    passwordVariable: 'DOCKER_PASS'
                )]) {
                    powershell '''
                        echo $env:DOCKER_PASS | docker login -u $env:DOCKER_USER --password-stdin
                        docker push ${env:DOCKERHUB_REPO}:${env:DOCKER_IMAGE_TAG}
                        docker logout
                    '''
                }
            }
        }
    }

    post {
        always {
            echo 'Cleaning up workspace...'
            cleanWs()
        }
    }
}
