pipeline {
    agent any

    environment {
        MAVEN_HOME = tool name: 'apache-maven-3.9.8', type: 'Maven'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/WillieBett/Springbootkafka.git'
            }
        }
        stage('Build') {
            steps {
                script {
                    withMaven(maven: 'apache-maven-3.9.8') {
                        sh 'mvn clean install'
                    }
                }
            }
        }
        stage('Test') {
            steps {
                script {
                    withMaven(maven: 'apache-maven-3.9.8') {
                        sh 'mvn test'
                    }
                }
            }
        }
        stage('Package') {
            steps {
                script {
                    withMaven(maven: 'apache-maven-3.9.8') {
                        sh 'mvn package'
                    }
                }
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying application...'
                // Add deployment steps here
            }
        }
    }

    post {
        success {
            echo 'Build successful!'
        }
        failure {
            echo 'Build failed!'
        }
    }
}
