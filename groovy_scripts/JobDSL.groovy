pipeline {
    agent any
   
    stages {
        stage("Create Job"){
            steps{
                jobDsl scriptText: '''
                pipelineJob('test-pipeline') {
                  definition {
                    cpsScm {
                      scm {
                        git {
                          remote {
                            url('/home/jenkins/data/DevAssignmennt')
                          }
                          branch('*/test')
                        }
                      }
                    }
                  }
                }
                '''
            }
            
        }
        stage ("Trigger Job")
        {
            steps{
                script{
                    build job: "test-pipeline"
                }
            }
        }
    }
}
