pipeline {
    agent any

    environment {
        DOCKERHUB_CREDENTIALS_ID = 'dockerhub-credentials'
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
                dir('my-app') {
                    bat 'mvn clean package'
                }
            }
        }

        stage('JaCoCo Coverage') {
            steps {
                jacoco execPattern: '**/target/jacoco.exec'
            }
        }

        stage('Docker Build') {
            steps {
                bat 'cd my-app && docker build -t %DOCKERHUB_REPO%:%DOCKER_IMAGE_TAG% .'
            }
        }

        stage('Docker Push') {
            steps {
                withCredentials([usernamePassword(
                    credentialsId: "%DOCKERHUB_CREDENTIALS_ID%",
                    usernameVariable: 'DOCKER_USER',
                    passwordVariable: 'DOCKER_PASS'
                )]) {
                    bat 'echo %DOCKER_PASS% | docker login -u %DOCKER_USER% --password-stdin'
                    bat "docker push %DOCKERHUB_REPO%:%DOCKER_IMAGE_TAG%"
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
