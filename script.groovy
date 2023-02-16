def buildJar() {
    echo "building the application..."
    sh 'mvn package'
} 

def buildImage() {
    echo "building the docker image..."
    sh 'docker build -t awaiskhurshid/java-maven-app:jma-3.0 .'
    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        
        sh "docker login -u $USER -p $PASS"
        sh 'docker push awaiskhurshid/java-maven-app:jma-3.0'
    }
} 

def deployApp() {
    echo 'deploying the application...'
} 

return this
