pipeline {
    agent any
   
    stages {
        stage("Create Required Jobs"){
            steps{
                jobDsl scriptText: '''
                job("example-1"){
                    steps{
                        shell ("echo hello world")
                    }
                }'''
                jobDsl scriptText: '''
                job("example-2"){
                    steps{
                        shell ("echo hello world2")
                    }
                }'''
                jobDsl scriptText: '''
                job("example-3"){
                    steps{
                        shell ("echo hello world3")
                    }
                }'''
            }
            
        }
        stage ("Build Jobs")
        {
            stages{
                stage("Build Job1")
                {
                    steps{
                        script{
                            build job: "example-1"
                        }
                    }
                }
                stage("Build Job2")
                {
                    steps{
                        script{
                            build job: "example-2"
                        }
                    }
                }
                stage("Build Job3")
                {
                    steps{
                        script{
                            build job: "example-3"
                        }
                    }
                }
            }
        }
    }
}
