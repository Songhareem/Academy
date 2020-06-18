from django.shortcuts import render, redirect
from django.core.paginator import Paginator
from .models import Notice
from .customPager import CustomPager

# Create your views here.
def delete(request, num):
    notice = Notice(num = num)
    notice.delete()
    return redirect('notice:listPage', 1)

def update(request, num):
    if request.method == 'POST':
        notice = Notice.objects.get(pk=num)
        notice.title = request.POST['title'],
        notice.contents = request.POST['contents']
        notice.save()
        return redirect('notice:listPage', 1)
    else :
        notice = Notice.objects.get(pk=num)
        return render(request, 'notice/write.html', {
            "board":"NoticeUpdate",
            "vo":notice,
        })

def select(request, num = 1):
    notice = Notice.objects.get(pk=num)
    context = {
        "board":"noticeSelect",
        "vo":notice,
    }
    return render(request, 'notice/select.html', context)

def write(request):
    if request.method == 'POST':
        print("Post")
        notice = Notice(
            title=request.POST['title'], 
            writer=request.POST['writer'], 
            contents=request.POST['contents'],
        )
        notice.save()
        return redirect('notice:listPage', 1)
    else :
        print("write Form")
        return render(request, 'notice/write.html', {
            "board":"NoticeWrite"
        })


def list(request, page=1, kind="title", search=""):
    #querySet
    #noticeList = Notice.objects.all() #select * from notice
    #noticeList = Notice.objects.order_by("-num").all()  #order_by("-num") = num DESC / order_by("num") = num ASC
    
    #page 처리
    #perpage = 2
    #start = (page-1)*perpage
    #last = page*perpage
    #noticeList = Notice.objects.order_by("-num").all()[start:last]     # [startIndex:endIndex]

    #Paginator로 처리
    # perpage = 2
    # noticeList = Notice.objects.order_by("-num")    
    # noticeList = Paginator(noticeList, perpage)  #Paginator(QuerySet, 갯수)
    # noticeList = noticeList.page(page)

    #CustomPage로 처리
    pager = CustomPager(page, kind, search)
    noticeList = Notice.objects.order_by("-num")
    noticeList = Paginator(noticeList, 2)

    pager.makePage(noticeList.num_pages)

    noticeList = noticeList.get_page(pager.page)

    context = {
        "board":"noticeList",
        "list":noticeList,
        "pager": pager
    }
    return render(request, 'notice/list.html', context)
