window.onload(a=function () {

});



var submit=document.getElementById("submit1");
submit.onclick=function () {
    var account=document.getElementById("id").innerText;
    var password=document.getElementById("password");

    var xmlhttp=new XMLHttpRequest();
    var url="/servlet/getInfoServlet";

    if(xmlhttp.readyState===4){
        var rtn=xmlhttp.responseText;
        if(rtn===400){

            var node=document.getElementById("regi");
            node.innerText+="登录失败";
        }
    }
    xmlhttp.open("GET",url,true);
    xmlhttp.send();
};

