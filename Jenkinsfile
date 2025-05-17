pipeline {
    // Docker 이미지를 사용하여 Java 17 + Maven 환경 구성
    agent {
        docker {
            image 'maven:3.9.9-ibm-semeru-17-focal'
            args '-v /var/jenkins_home/maven-repo:/var/jenkins_home/workspace/java_deploy_to_nexus/.m2/repository'
        }
    }

    stages {
        stage("소스코드 가져오기") {
            steps {
                // 여기에 git 저장소 정보 입력
                script {
                    git branch: 'main', url: 'https://github.com/PHJJJJ/jenkins_deploy_to_nexus.git';
                }
            }
        }

        stage("빌드 및 테스트") {
            steps {
                script {
                    sh 'mvn -s settings.xml clean test'
                }
            }
        }

        stage("Nexus 스냅샷 저장소에 배포") {
            steps {
                script {
                    // Maven의 deploy 목표를 사용하여 스냅샷 저장소에 배포
                    sh 'mvn -s settings.xml deploy'
                }
            }
        }
    }

    post {
        success {
            echo "빌드 및 배포가 성공적으로 완료되었습니다."
        }
        failure {
            echo "빌드 또는 배포 중 오류가 발생했습니다."
        }
    }
}