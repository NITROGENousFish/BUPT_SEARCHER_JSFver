var countclick = 0;

//添加事件
var addLoadEvent = function(func){
	var oldonload = window.onload;
	if(typeof window.onload != 'function'){
		window.onload = func;
	}
	else{
		window.onload = function(){
			oldonload();
			func();
		}
	}
};

//调整index.html中header宽度
var adjustHeaderWidth = function(){
    if(!document.getElementById)return false;
    if(!document.getElementsByClassName)return false;
    if(!document.getElementById("menu"))return false;
    var header = document.getElementById("menu");
    var lists = header.getElementsByTagName("li")
    header.style.width=lists.length*94+30 + "px";
};

//添加彩蛋
var eggs = function(){
	if(!document.getElementById("contact"))return false;
	document.getElementById("contact").onclick = function(){
		countclick++;
		if(countclick == 10)alert("ruaaaaaaaaaaaaa!居然点了这么多次！真是愚昧的人类！");
	}
};

//检查输入是否为中文
var checkChinese = function(){
    if(!document.getElementById("searchboxForm"))return false;
    if(!document.getElementById("submit"))return false;
    if(!document.getElementById("content"))return false;
    form = document.getElementById("searchboxForm");
    content = document.getElementById("content");
    submit = document.getElementById("submit");
    submit.onclick = function(){
        if(content.value.search(/[^\u4E00-\u9FA5\s]/g)!=-1){
            alert("请勿输入中文以外的字符，现在搜索引擎尚不支持非中文搜索。")
            return false;
        }
    }
};

//调整searcher.php中header的位置
var adjustHeaderPosition = function(){
	width = document.documentElement.clientWidth;
	header = document.getElementById("header");
	if(width <= 1200){
		header.style.left=791+'px';
	}
	else header.style.left = (width - 410)+'px';
	setTimeout(adjustHeaderPosition, 100);
};

var switchCanvas = function(){
    var canvas = document.getElementsByTagName('canvas')[0];
    var button = document.getElementById('button');
    var switcher = document.getElementsByClassName('canvas-switch')[0];
    switcher.onclick = function(){
        if(canvas.style.display === 'block'){
            button.style.left = button.style.left || '3px';
            canvas.style.display = 'none';
            switcher.style.backgroundColor = "#838383";
            //button.style.left = '25px';
            slideDivX(button, 22, 150);
        }
        else {
            button.style.left = button.style.left || '25px';
            canvas.style.display = 'block';
            switcher.style.backgroundColor = "#10b45a";
            //button.style.left = '3px';
            slideDivX(button, -22, 150);
        }
    };
};
/*
var slideDivX = function(div, dis, time){
    var left = parseInt(div.style.left);
    var temp = dis/time, count = 0;
    var step = function(){
        left += temp;
        div.style.left = left + 'px';
        count += 1;
        if(count < time){
            setTimeout(step, 100);
        }
    };
};
*/
var slideDivX = function(div, dis, time){
    var times = time/10, temp = dis/times;
    var count = 0;
    var left = parseInt(div.style.left);
    var step = function(){
        left += temp;
        div.style.left = left + 'px';
        count += 1;
        if(count < times){
            setTimeout(step, 10);
        }
    };
    setTimeout(step, 10);
};

function adjustLoginPosition(){
	width = document.documentElement.clientWidth;
    header = document.getElementById("login");
    if(header != null){
        if(width<=1100){
            header.style.left=1000+'px';
        }
        else header.style.left = (width - 100)+'px';
        setTimeout(adjustLoginPosition, 100);
    }
}

function adjustSettingPosition(){
	width = document.documentElement.clientWidth;
    header = document.getElementById("setting");
    if(header != null){
        if(width<=700){
            header.style.left=600+'px';
        }
        else header.style.left = (width - 100)+'px';
        setTimeout(adjustLoginPosition, 100);
    }
}