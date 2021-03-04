# DevAssignment

## Task to perform

Take any application and create jenkins dsl pipeline
and provide readme file with details and prerequiresits required to run pipeline on any server.

===================================================================================

## Prerequiresits
- Linux or Windows machine with:
    - 512 MB of RAM
    - 10 GB of drive space for Jenkins and your Docker images and containers.

- Docker installed on server


## Steps to run Jenkins on docker container
- Pull jenkins docker image from docker hub: <br />```$ docker pull jenkins/jenkins:lts```

- Create a new directory inside your server to store the jenkins data: <br /> ```$ mkdir /home/jenkins/data```

- Run jenkins on docker container: <br /> ```$ docker run -d -v /home/jenkins/data:/var/jenkins_home -p 8080:8080 jenkins/jenkins:lts```
  - If we want to connect slave agent we need to map port 50000: <br /> ```$ docker run -d -v /home/jenkins/data:/var/jenkins_home -p 8080:8080 -p 50000:50000 jenkins/jenkins:lts```
  - If we want to access jeenkins docker container: <br /> ```$ docker exec -it container-id bash```


- Jenkins is up on port 8080 on your server, to verify go to you browser and open ```http://server.ip:8080```

- Browser will re-direct us to: <br /> ![Image of JenkinsFirstTime]()

- Move inside jenkins docker container and get the secret key to initate with jenkins: <br /> ```$ cat /var/jenkins_home/secrets/initialAdminPassword```

- Copy and paste to the browser and select installed suggested plugins: <br /> ![Image_of_plugin]()

- Create Admin user and start using jenkins


## Steps to run on server
- Chnage directory on Server: <br /> ```cd /home/jenkins/data```
- Clone GitHub repo: <br /> ```git clone https://github.com/shailthacker/DevAssignmennt.git```
- 

## Steps to run on Jenkins UI
- Login to Jenkins web UI
- Go to Manage Jenkins -> Manage Plugin
- Click on Availabe tab and search Job dsl
- Install Job dsl plugin
- Create new pipeline : <br /> ![Create_pipeline]()
- From the Definition field, choose the Pipeline script from SCM option. This option instructs Jenkins to obtain your Pipeline from Source Control Management (SCM), which will be your git repository
- From the SCM field, choose Git
- Set script path as ```groovy_scripts/JobDSL.groovy```
- 
