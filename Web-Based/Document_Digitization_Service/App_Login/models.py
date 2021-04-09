from django.db import models
from django.contrib.auth.models import User

# Create your models here.

class User_info(models.Model):
    id=models.AutoField(primary_key=True)
    first_name=models.CharField(max_length=30)
    last_name=models.CharField(max_length=30)
    email=models.EmailField(max_length=30)
    password=models.CharField(max_length=30)
    registerdate=models.DateTimeField(auto_now_add=True,blank=True)
    uploaded_files=models.IntegerField(default=True,null=True, blank=True)
    avater=models.ImageField(upload_to='pp',null=True, blank=True)

class employee(models.Model):
    #emp=models.ForeignKey(User_info, on_delete=models.CASCADE)
    role=models.CharField(max_length=30)
