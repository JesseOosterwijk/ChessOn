pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        echo 'Starting Build Step'
        sh 'mvn clean install -Dlicense.skip=true'
        echo 'Build Step Complete'
      }
    }

    stage('Testing') {
      steps {
        sh 'mvn sonar:sonar -Dsonar.host.url=http://localhost:9000 -Dlicense.skip=true'
      }
    }

  }
}