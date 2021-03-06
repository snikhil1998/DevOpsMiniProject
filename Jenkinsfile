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
              dockerImage = docker.build registry + ":$BUILD_NUMBER"
            }
          }
        }
        stage('Push Image') {
          steps{
            script {
              docker.withRegistry( '', registryCredential ) {
                dockerImage.push()
                tagLatest = "docker tag " + registry  + ":$BUILD_NUMBER" + " " + registry + ":latest"
				pushLatestBuild = "docker push " + registry
				sh tagLatest
				sh pushLatestBuild
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
          jobId: "85bb66cd-b410-494d-8184-c8d739f8e9d9"])
        }
      }
    }
  }
}
