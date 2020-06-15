from django.shortcuts import render
from django.http import HttpResponse

# Controller
# Create your views here.
def list(request):
    # Data 전달
    context = {"board":"notice", "age":30}
    return render(request, 'notice/list.html', context)

def write(request):
    return render(request, 'notice/write.html')
