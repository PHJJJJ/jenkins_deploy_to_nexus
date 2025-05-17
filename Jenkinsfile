pipeline {
    // Docker 이미지를 사용하여 Java 17 + Maven 환경 구성
    agent {
        docker {
            image 'maven:3.8.6-openjdk-17'
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
                    sh "mvn clean test"
                }
            }
        }

        stage("Nexus 스냅샷 저장소에 배포") {
            steps {
                script {
                    // Maven의 deploy 목표를 사용하여 스냅샷 저장소에 배포
                    sh "mvn deploy -DskipTests"
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