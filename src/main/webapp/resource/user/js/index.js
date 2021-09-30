$(document).ready(function () {
    $('.header__body-logobtn').click(function (e) { 
        e.preventDefault();
        $('.body_nav-media').addClass('body_nav-show');
        $('.body, header, footer').addClass('body-bg');
    });
    $('.return').click(function (e) { 
        e.preventDefault();
        $('.body_nav-media').removeClass('body_nav-show');
        $('.body, header, footer').removeClass('body-bg');
    });
    //$('section, .header__log-search, footer').click(function (e) { 
       // e.preventDefault();
       // $('.body_nav-media').removeClass('body_nav-show');
       // $('.body, header, footer').removeClass('body-bg');
    //});
    $(window).scroll(function () { 
        if(pageYOffset > 90){
            $('header').addClass('header-position');
        }
        else{
            $('header').removeClass('header-position');
        }
    });
    $(window).resize(function () { 
        if($(window).width() <= 1022){
            $('.txtarticle__text-addjs').html(
                '<div class="body__aside">'
                    +'<div class="body__aside-txtaside">'
                        +'<div class="txtaside__title">'
                            +'<h6>Bài viết liên quan</h6>'
                        +'</div>'
                        +'<ul class="txtaside__list">'
                            +'<li class="txtaside__list-itemaside"><a href="" class="itemaside__link">Nhu cầu nhân lực'
                                +' ngành CNTT tại những thành phố lớn tại Việt Nam</a></li>'
                            +'<li class="txtaside__list-itemaside"><a href="" class="itemaside__link">Định hướng bản thân'
                                    +'ngay khi vào năm nhất là cần thiết</a></li>'
                            +'<li class="txtaside__list-itemaside"><a href="" class="itemaside__link">Cơ hội mở rộng với'
                                    +'sinh viên Việt Nam khi những nước phát triển hợp tác tìm kiếm nguồn nhân lực ngành'
                                    +'lập trình</a></li>'
                            +'<li class="txtaside__list-itemaside"><a href="" class="itemaside__link">Các thầy cô và môn'
                                    +'học phụ trách</a></li>'
                            +'<li class="txtaside__list-itemaside"><a href="" class="itemaside__link">WinForm liệu có còn'
                                    +'hữu dụng khi công nghệ đã quá cũ và khó update</a></li>'
                            +'<li class="txtaside__list-itemaside"><a href="" class="itemaside__link">Một Junior, Fresher'
                                    +'ngay sau khi ra trường cần chuẩn bị những kiến thức gì khi ứng tuyển vào những doanh'
                                    +'nghiệp</a></li>'
                            +'<li class="txtaside__list-itemaside"><a href="" class="itemaside__link">Nhà tuyển dụng đòi'
                                +' hỏi quá nhiều ở một lập trình viên mới ra trường</a></li>'
                        +'</ul>'
                    +'</div>'
                +'</div>'
            );
            $('.body__nav-pagey').addClass('body__nav-pagey1');
            $(window).scroll(function () { 
                if(window.pageYOffset >= 500 && window.pageYOffset < 2800 && $(window).width() <= 1022){
                    $('.body__nav-pagey').css('position','fixed');
                    $('.body__nav-pagey').css('max-width','295px');
                    $('.body__nav-pagey').css('top','3.5rem');
                    $('.body__nav-pagey').css('bottom','0');
                    $('.body__nav-pagey').css('overflow-y','scroll');
                }
                else{
                    $('.body__nav-pagey').css('position','relative');
                    $('.body__nav-pagey').css('max-width','none');
                    $('.body__nav-pagey').css('top','0');
                    $('.body__nav-pagey').css('overflow-y','unset');
                }
                if(window.pageYOffset >= 2800 && $(window).width() <= 1022){
                    $('.body__nav-pagey, .body_nav').css('position','relative');
                    $('.body__nav-pagey, .body_nav').css('transition','0s');
                    $('.body__nav-pagey').css('top','78%');
                    $('.body__nav-pagey').css('bottom','0%');
                    $('.body__nav-pagey').css('overflow-y','unset');
                }
                else if(window.pageYOffset >= 500 && window.pageYOffset < 2800 && $(window).width() <= 1022){
                    $('.body__nav-pagey').css('top','3.5rem');
                    $('.body__nav-pagey').css('bottom','0%');
                    $('.body__nav-pagey, .body_nav').css('transition','0.8s');
                    $('.body__nav-pagey').css('overflow-y','scroll');
                }
            });
        }
        else{
            $('.txtarticle__text-addjs').html('');
            $('.body__nav-pagey').removeClass('body__nav-pagey1');
            $('.body__nav-pagey').css('position','relative');
            $('.body__nav-pagey').css('max-width','none');
            $('.body__nav-pagey').css('top','0');
            $('.body__nav-pagey').css('overflow-y','unset');
        }
    });
    let a = $('.section__listing li');
    for(let  i=0; i<a.length; i++){
        $(a[i]).click(function (e) { 
            e.preventDefault();
            if($('.section__listing li').hasClass('active')){
                $('.section__listing li').removeClass('active');
            }
            $(this).addClass('active');
        });
    }
    $('.uptop__btn').click(function (e) { 
        e.preventDefault();
        $('html, body').animate({scrollTop: 0}, 500);

    });
});