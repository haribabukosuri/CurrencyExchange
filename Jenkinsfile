pipeline {
    agent any

    environment {
        APP_NAME = 'CurrencyExchange'
        // Prevents Jenkins from killing the app process after the job ends
        JENKINS_NODE_COOKIE = 'dontKillMe'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/haribabukosuri/CurrencyExchange.git'
            }
        }

        stage('Build') {
            steps {
                sh '''
                    chmod +x gradlew
                    ./gradlew clean build -x test
                '''
            }
        }

        stage('Deploy') {
            steps {
                sh '''
                    # Kill existing process if running
                    pkill -f ${APP_NAME} || true
                    
                    # Run the jar. Note: assumes only one executable jar exists in libs
                    nohup java -jar build/libs/${APP_NAME}-*.jar > app.log 2>&1 &
                '''
            }
        }

        stage('Health Check') {
            steps {
                script {
                    // Give the app time to start before checking
                    sleep 20
                    try {
                        sh 'curl -f http://localhost:8080/actuator/health'
                    } catch (Exception e) {
                        error "Health check failed. Check app.log for details."
                    }
                }
            }
        }
    }

    post {
        success {
            echo 'Application deployed successfully.'
        }
        failure {
            echo 'Build or deployment failed. Check console output.'
        }
    }
}
