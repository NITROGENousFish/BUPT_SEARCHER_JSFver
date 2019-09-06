function adjustHeaderPosition(){
	width = document.documentElement.clientWidth;
	header = document.getElementById("header");
	if(width<=1100){
		header.style.left=791+'px';
	}
	else header.style.left = (width - 310)+'px';
	setTimeout(adjustHeaderPosition, 100);
}

function addLoadEvent(func){
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
}

function checkChinese(){
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
}

addLoadEvent(adjustHeaderPosition);
addLoadEvent(checkChinese);