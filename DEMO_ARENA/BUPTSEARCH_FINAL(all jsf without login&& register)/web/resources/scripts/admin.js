var addPageTurning = function(present_page=1){
  var records_num = document.getElementById("records-num").innerHTML.replace(/[^\d]/g,'');
  var pages = Math.ceil(records_num/20);
  var page_turning = document.getElementById('page-turning');
  page_turning.innerHTML = null;
  for(var i=Math.max(1,present_page-4),j=i;i<=Math.min(j+9,pages);i++){
    button = document.createElement('button');
    button.innerHTML = i;
    button.className = 'pc';
    button.onclick = function(){
      getNewTable(this);
      addPageTurning(parseInt(this.innerHTML));
    }
    page_turning.appendChild(button);
  }
  document.getElementById('records').appendChild(page_turning);
}

var getNewTable = function(button){
  page = button.innerHTML;
  var xmlhttp; 
  if (window.XMLHttpRequest)
  {// code for IE7+, Firefox, Chrome, Opera, Safari
  xmlhttp=new XMLHttpRequest();
  }
  else
  {// code for IE6, IE5
  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  }
  xmlhttp.onreadystatechange=function()
  {
  if (xmlhttp.readyState==4 && xmlhttp.status==200)
    {
    var i = 0;
    table = document.getElementById("records-table");
    table.innerHTML = null;
    data=JSON.parse(xmlhttp.responseText);
    table.appendChild(createHead());
    while(row = data[i++]){
      tr = document.createElement('tr')
      tr.appendChild(createTh(row['id']));
      tr.appendChild(createTh(row['visit_time']));
      tr.appendChild(createTh(row['ip']));
      tr.appendChild(createTh(row['keyword']));
      table.appendChild(tr);
    }
    setTableColor();
    }
  }
  xmlhttp.open("GET","new-response.php?page="+page,true);
  xmlhttp.send();
}

var createTh = function(text){
  th = document.createElement('th');
  th.innerHTML = text;
  return th;
}

var createHead = function(){
  head = document.createElement('tr');
  head.appendChild(createTh(""));
  head.appendChild(createTh("搜索时间"));
  head.appendChild(createTh("IP地址"));
  head.appendChild(createTh("关键词"));
  return(head);
}

var removeElement = function(_element){
  var _parentElement = _element.parentNode;
  if(_parentElement){
         _parentElement.removeChild(_element);  
  }
}

var setTableColor = function(){
  var trs = document.getElementsByTagName('tr');
  var length = trs.length;
  for(var i=0;i<length;i++){
    if(i%2 == 0)trs[i].bgColor = "#F0F5FB";
  }
}