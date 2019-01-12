function add_reward() {


    console.log("******in add_reward*******");
    var x;
    var name = prompt("获奖名称");
    var degree = prompt("级别");
    var clazz = prompt("等级");
    var time = prompt("时间");


    var xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState === 4) {
            alert("添加成功");
        }
    };

    xmlhttp.open("GET", "/servlet/AddServlet?type=reward"+
        "&name="+name+
        "&degree="+degree+
        "&clazz="+clazz+
        "&time="+time, true);
    xmlhttp.send();
}


function add_project() {

    console.log("******in add_project*******");
    var x;
    var name = prompt("项目名称");
    var character = prompt("担任角色");
    var location = prompt("地点");
    var discribe = prompt("描述");


    var xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState === 4) {
            alert("添加成功");
        }
    };

    xmlhttp.open("GET", "/servlet/AddServlet?type=project"+
        "&name="+name+
        "&character="+character+
        "&location="+location+
        "&discribe="+discribe, true);
    xmlhttp.send();
}


function add_job() {

    console.log("******in add_job*******");
    var x;
    var company = prompt("公司");
    var position = prompt("职位");
    var location = prompt("地点");
    var discribe = prompt("描述");


    var xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState === 4) {
            alert("添加成功");
        }
    };

    xmlhttp.open("GET", "/servlet/AddServlet?type=job"+
        "&company="+company+
        "&position="+position+
        "&location="+location+
        "&discribe="+discribe, true);
    xmlhttp.send();
}



