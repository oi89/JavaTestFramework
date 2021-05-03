pipeline {
    agent any

    tools {
            maven 'MAVEN'
    }

    parameters {
            string(name: 'GIT_URL', defaultValue: 'https://github.com/oi89/JavaTestFramework.git', description: 'The target git url')
            string(name: 'GIT_BRANCH', defaultValue: 'master', description: 'The target git branch')
    }

    stages {
        stage('Pull from GitHub') {
            steps {
                git ([
                    url: "${params.GIT_URL}",
                    branch: "${params.GIT_BRANCH}"
                    ])
            }
        }
        stage('Run maven clean test') {
            steps {
                bat 'mvn clean test -Dbrowser=firefox'
            }
        }
        stage('Backup and Reports') {
            steps {
                archiveArtifacts artifacts: 'target/**/*.*', fingerprint: true
            }
            post {
                always {
                    script {
                        allure([
                            includeProperties: false,
                            jdk: '',
                            properties: [],
                            reportBuildPolicy: 'ALWAYS',
                            results: [[path: 'target/allure-results']]
                        ])

                        sendNotification()
                    }
                }
            }
        }
    }
 }

 def sendNotification() {
    def summary = junit testResults: '**/target/surefire-reports/*.xml'

    def colorCode = '#FF0000'
    if (currentBuild.currentResult == 'SUCCESS') {
        colorCode = '#00FF00'
    }

    def slackMessage = "${currentBuild.currentResult}: Job '${env.JOB_NAME}', Build ${env.BUILD_NUMBER}. \nPassed time: ${currentBuild.durationString}. \n\nTESTS:\nTotal = ${summary.totalCount},\nFailures = ${summary.failCount},\nSkipped = ${summary.skipCount},\nPassed = ${summary.passCount} \n\nMore info at: ${env.BUILD_URL}"

    slackSend(color: colorCode, message: slackMessage)
 }