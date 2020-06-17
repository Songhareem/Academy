from django.shortcuts import render
from django.core.paginator import Paginator
from .models import Notice
from .customPager import CustomPager

# Create your views here.
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
