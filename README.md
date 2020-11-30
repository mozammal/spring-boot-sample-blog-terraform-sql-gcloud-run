# spring-boot-terraform-google-sql-gcloud-run-demo

This example shows how to run a hello world service on Google Run using Terraform

**Prerequisites:** [Java 11](https://adoptopenjdk.net/)

 [Terraform](https://www.terraform.io/)
 
 [Google SQL](https://cloud.google.com/sql)


## Getting Started

Terraform is used to create the Google Cloud Run infrastructure needed to deploy our hello world spring boot service. The following commands create the cloud infrastructure
and will eventually show the URL of the deployed service,

```bash
git clone https://github.com/mozammal/spring-boot-sample-blog-terraform-sql-gcloud-run.gitt
cd spring-boot-sample-blog-terraform-sql-gcloud-run
mvn clean compile jib:build 
cd terraform
terraform init
terraform plan
terraform apply
terraform output url
```

You’ve now come to the point where you can finally be a membe, log in to the application, 
post new posts, and comments on others posts if you open the URL of the aforementioned blog service that has been deployed on Google Cloud Run using terraform output url.


Destroy the infrastructure that we created in the previous step by running the following command:
```
terraform destroy
```
