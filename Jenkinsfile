pipeline {

agent any

parameters {

    booleanParam(
        name: 'RUN_API',
        defaultValue: true,
        description: 'Execute API Automation after OrangeHRM'
    )
}

stages {

    stage('Checkout OrangeHRM') {

        steps {
            checkout scm
        }
    }

    stage('Build Project') {

        steps {
            bat 'mvn clean compile'
        }
    }

    stage('Execute OrangeHRM Cucumber Suite') {

        steps {

            bat 'mvn clean test -Pcucumber'
        }
    }

    stage('Publish OrangeHRM Reports') {

        steps {

            publishHTML([
                allowMissing: true,
                alwaysLinkToLastBuild: true,
                keepAll: true,
                reportDir: 'reports/extent',
                reportFiles: 'ExtentReport.html',
                reportName: 'OrangeHRM Extent Report'
            ])

            publishHTML([
                allowMissing: true,
                alwaysLinkToLastBuild: true,
                keepAll: true,
                reportDir: 'reports/extent',
                reportFiles: 'cucumber-report.html',
                reportName: 'OrangeHRM Cucumber Report'
            ])
        }
    }

    stage('Approval Gate') {

        when {
            expression { params.RUN_API }
        }

        steps {

            input(
                message: 'OrangeHRM execution completed successfully. Execute API Automation?',
                ok: 'Run API Tests'
            )
        }
    }

    stage('Checkout API Framework') {

        when {
            expression { params.RUN_API }
        }

        steps {

            dir('FakeStoreAPI') {

                git(
                    url: 'https://github.com/ParthGawli37/FakeStore-API-Automation.git',
                    branch: 'main'
                )
            }
        }
    }

    stage('Execute API Automation') {

        when {
            expression { params.RUN_API }
        }

        steps {

            dir('FakeStoreAPI') {

                bat 'mvn clean test'
            }
        }
    }
}

post {

    always {

        archiveArtifacts(
            artifacts: 'reports/**/*',
            allowEmptyArchive: true
        )
    }

    success {

        echo 'Pipeline completed successfully.'
    }

    failure {

        echo 'Pipeline execution failed.'
    }
}

}
