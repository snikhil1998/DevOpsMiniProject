pipeline {
	environment {
    registry = "snikhil1998/my-calculator"
    registryCredential = 'dockerhub'
    dockerImage = ''
  }
  agent any
  stages {
    stage('Clean') {
      steps {
        sh 'mvn clean'
      }
    }

    stage('Build') {
      steps {
        sh 'mvn compile'
      }
    }

    stage('Test') {
      steps {
        sh 'mvn test'
      }
    }

		stage('DockerHub') {
      stages{
        stage('Build Image') {
          steps{
            script {
              dockerImage = docker.build
			  dockerImage1 = dockerImage registry + ":$BUILD_NUMBER"
			  dockerImage2 = dockerImage registry + ":latest"
            }
          }
        }
        stage('Push Image') {
          steps{
            script {
              docker.withRegistry( '', registryCredential ) {
                dockerImage1.push()
				dockerImage2.push()
              }
            }
          }
        }
      }
    }
		stage('Deploy') {
      agent any
      steps {
        script {
          step([$class: "RundeckNotifier",
          rundeckInstance: "Rundeck",
          options: """
            BUILD_VERSION=$BUILD_NUMBER
          """,
          jobId: "d0ca82c4-3e67-4cfe-bbc7-24377f55938e"])
        }
      }
    }
  }
}
