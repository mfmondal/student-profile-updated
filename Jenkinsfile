pipeline{
	
    agent any
    environment {
       // PATH = "$PATH:/opt/apache-maven-3.8.2/bin"
       PATH = "$PATH:/opt/share/maven"
    }
    
    stage('Pull Code'){
          steps{
               checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/mfmondal/student-profile.git']])
            }
        }
        
        stage('Compile Code'){
            steps{
                sh 'mvn clean install -DskipTests=true'
            }
        }
        
        //  stage('SonarQube Analysis'){
        //     steps{
        //      //   sh 'mvn clean org.jacoco:jacoco-maven-plugin:prepare-agent install sonar:sonar -Dsonar.host.url=http://34.195.210.156:9000/ -Dsonar.login=sqp_c69310efee23de078f7b3ff37925dbfe61f0c971'
        //     sh 'mvn clean org.sonarsource.scanner.maven:sonar-maven-plugin:3.8.7:sonar'
        //     }
        // }
        
          stage('Build Docker Image'){
            steps{
                sh 'docker build -t frmondal/student-profile .'
            }
        }
        
        stage('Push Image to DockerHub'){
            steps{
                 withCredentials([string(credentialsId: 'dockerhubpassword', variable: 'dockerhubpassword')]) {
                 sh 'docker login -u frmondal -p ${dockerhubpassword}'
                 sh 'docker push frmondal/student-profile:'

                }
            }
        
        }
        


	    stage ("Docker push to ECR") {
	         steps {
	             script {
	                sh "aws ecr get-login-password --region us-east-1 | docker login --username AWS --password-stdin 211223789150.dkr.ecr.us-east-1.amazonaws.com"
	                sh "docker push 211223789150.dkr.ecr.us-east-1.amazonaws.com/student-profile"
	                 
	             }
	           }   
	        }
	        
	        stage ("Deploy to K8S") {
	            steps {
	                withKubeConfig(caCertificate: '', clusterName: '', contextName: '', credentialsId: 'K8S', namespace: '', restrictKubeConfigAccess: false, serverUrl: '') {
	                sh "kubectl apply -f eks-deploy-k8s.yaml"
	                    
	                }
	            }
	        }
    }
}