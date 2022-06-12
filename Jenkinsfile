pipeline{
    agent any
    tools{
        maven 'Maven_Home'
    }
    stages{
        stage('Build Maven'){
            steps{
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/ramsahnp/demo']]])
                 bat 'mvn clean install'
            }
        }
        stage('Build Docker Image'){
            steps{
                script{
                    bat 'docker build -t 99144/devops-integration .'
                }
            }
        }
        stage('Push Image to Hub'){
            steps{
                script{
                     withCredentials([string(credentialsId: 'docker-hub-pwd', variable: 'hubpwd')])
                     {
                         bat 'docker login -u 99144 -p ${hubpwd}'
                     }
                     bat 'docker push 99144/devops-integration'
                }
            }
        }
    }
}