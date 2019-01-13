
var submit=document.getElementById("submit1");
my_login =function () {

    var account=document.getElementById("id").value;
    var password=document.getElementById("password").value;

    var xmlhttp=new XMLHttpRequest();
    var url="10.0.1.67/form_view/?id="+id+"&password="+password;
    // var url="/servlet/getInfoServlet";

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

