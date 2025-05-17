pipeline {
    agent {
        docker {
            image 'maven:3.9.9-ibm-semeru-17-focal'
            args '--network=host'
        }
    }
    
    stages {
        stage("소스코드 가져오기") {
            steps {
                script {
                    git branch: 'main', url: 'https://github.com/PHJJJJ/jenkins_deploy_to_nexus.git';
                }
            }
        }

        stage("빌드 및 테스트") {
            steps {
                script {
                    sh 'mkdir -p ./.m2/repository'
                    sh 'mvn -Dmaven.repo.local=./.m2/repository clean test'
                }
            }
        }

        stage("Nexus 스냅샷 저장소에 배포") {
            steps {
                script {
                    // 빌드와 동일한 로컬 저장소 경로 사용
                    sh 'mvn -Dmaven.repo.local=./.m2/repository -s settings.xml deploy -DskipTests'
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