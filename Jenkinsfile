pipeline {
    agent any

    tools {
        jdk 'Java17'
    }

    environment {
        APP_NAME = 'CurrencyExchange'
    }

    stages {

        stage('Checkout') {
            steps {
                git 'https://your-git-repo-url.git'
            }
        }

        stage('Build') {
            steps {
                sh './gradlew clean build -x test'
            }
        }

        stage('Deploy') {
            steps {
                sh '''
                pkill -f ${APP_NAME} || true
                nohup java -jar build/libs/*.jar > app.log 2>&1 &
                '''
            }
        }

        stage('Health Check') {
            steps {
                sh '''
                sleep 10
                curl http://localhost:8080/actuator/health
                '''
            }
        }
    }

    post {
        success {
            echo 'Application deployed successfully.'
        }

        failure {
            echo 'Build or deployment failed.'
        }
    }
}