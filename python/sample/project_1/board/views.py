from django.shortcuts import render
from django.htpp import HttpResponse

# Create your views here.

def admin(request):
    return HttpResponse('<h1>test admin</h1>')

def sample(request)
    return HttpResponse('<h1>test sample</h1>')
