#!/usr/bin/env groovy
pipeline {
    agent any
    options {
        skipStagesAfterUnstable()
    }
    stages {
        stage('Build Maven Jar') {
            steps {
                bat 'mvn clean install -DskipTests'
            }
        }
        stage('Build Docker Image') {
            steps {
                bat 'docker build -t=madcard31/sample-docker-image .'
            }
        }
        stage('Push Docker Image to Docker Hub') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'DOCKER_PWD', usernameVariable: 'DOCKER_USR')]) {
                    bat 'docker login -u %DOCKER_USR% -p %DOCKER_PWD%'
                }
                bat 'docker push madcard31/sample-docker-image:latest'
            }
        }
    } // stages
    post{
        always {
            bat 'docker logout'
        }
    }
} // pipeline



