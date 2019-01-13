window.onload = function () {
    getProject();
};
baseUrl = 'http://localhost:8084';

getInfo = function () {
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState === 4) {

        }
    };

    xmlhttp.open("GET", "/servlet/getInfoServlet", true);
    xmlhttp.send();
};

save_info = function () {

    console.log("******in save_info*************");

    var xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState === 4) {
            alert("保存成功");
        }
    };
    xmlhttp.open("GET", "/servlet/SaveServlet?" +
        "id=" + document.getElementsByClassName("info-id")[0].value +
        "&major=" + document.getElementsByClassName("item major")[0].value +
        "&phone=" + document.getElementsByClassName("item phone")[0].value +
        "&mail=" + document.getElementsByClassName("item mail")[0].value +
        "&git=" + document.getElementsByClassName("item git")[0].value +
        "&type=info", true);
    xmlhttp.send();
};
save = function (name) { //job
    console.log(name, name[name.length - 1]);
    var i = name[name.length - 1];
    console.log("保存按钮触发……………………………………………………");
    console.log(document.getElementsByClassName("in-item job-id" + i)[0].value);
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState === 4) {
            alert("保存成功");
        }
    };

    xmlhttp.open("GET", "/servlet/SaveServlet?" +
        "id=" + document.getElementsByClassName("in-item job-id" + i)[0].value +
        "&company=" + document.getElementsByClassName("in-item job-company" + i)[0].value +
        "&position=" + document.getElementsByClassName("in-item job-position" + i)[0].value +
        "&location=" + document.getElementsByClassName("in-item job-location" + i)[0].value +
        "&discribe=" + document.getElementsByClassName("in-item job-discribe" + i)[0].value +
        "&type=job", true);
    xmlhttp.send(
    );
};

save_project = function (name) {
    var i = name[name.length - 1];
    console.log("保存按钮触发……………………………………………………");
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState === 4) {
            alert("保存成功");
        }
    };

    xmlhttp.open("GET", "/servlet/SaveServlet?" +
        "id=" + document.getElementsByClassName("in-item project-id" + i)[0].value +
        "&name=" + document.getElementsByClassName("in-item project-name" + i)[0].value +
        "&character=" + document.getElementsByClassName("in-item project-character" + i)[0].value +
        "&location=" + document.getElementsByClassName("in-item project-location" + i)[0].value +
        "&discribe=" + document.getElementsByClassName("in-item project-discribe" + i)[0].value +
        "&type=project", true);
    xmlhttp.send(
    );

};

save_reward = function (name) {
    var i = name[name.length - 1];
    console.log("保存按钮触发……………………………………………………");
    console.log(document.getElementsByClassName("in-item reward-time" + i)[0].value);
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState === 4) {
            alert("保存成功");
        }
    };

    xmlhttp.open("GET", "/servlet/SaveServlet?" +
        "id=" + document.getElementsByClassName("in-item reward-id" + i)[0].value +
        "&name=" + document.getElementsByClassName("in-item reward-name" + i)[0].value +
        "&clazz=" + document.getElementsByClassName("in-item reward-clazz" + i)[0].value +
        "&degree=" + document.getElementsByClassName("in-item reward-degree" + i)[0].value +
        "&time=" + document.getElementsByClassName("in-item reward-time" + i)[0].value +
        "&type=reward", true);
    xmlhttp.send();
};

delete_job=function(index){
    var i=index[index.length-1];
    console.log("******in delete_job********");

    var xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState === 4) {
            alert("删除成功");
        }
    };

    xmlhttp.open("GET", "/servlet/DeleteServlet?" +
        "&type=job&id="+document.getElementsByClassName("in-item job-id"+i)[0].value, true);
    xmlhttp.send();
};

delete_reward=function(data){
    var i=data[data.length-1];
    console.log("******in delete_reward********");

    var xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState === 4) {
            alert("删除成功");
        }
    };

    xmlhttp.open("GET", "/servlet/DeleteServlet?" +
        "&type=reward&id="+document.getElementsByClassName("in-item reward-id"+i)[0].value, true);
    xmlhttp.send();
};

delete_project=function(index){
    var i=index[index.length-1];
    console.log("******in delete_project********");

    var xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState === 4) {
            alert("删除成功");
        }
    };

    xmlhttp.open("GET", "/servlet/DeleteServlet?" +
        "&type=project&id="+document.getElementsByClassName("in-item project-id"+i)[0].value, true);
    xmlhttp.send();
};

save_pic=function(){

    console.log("************in save pic************");
    var path=document.getElementById("pic-path");
    var picDom=document.getElementById("pic");
    picDom.src=path.value;


    var xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState === 4) {
            alert("修改成功");
        }
    };

    xmlhttp.open("POST", "/servlet/SavePicServlet?" +
        "&type=pic&id="+path.value, true);
    xmlhttp.send();


};

getProject = function () {
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function () {
        let user;
        if (xmlhttp.readyState === 4) {
            var json = xmlhttp.responseText;

            var data = JSON.parse(json);

            // console.log("data[job][0]" + data["jobs"][0].company);
            // console.log("data[rewards][0]" + data["rewards"][0].name);
            // console.log("data[projects][0]" + data["projects"][0].name);
            var job = document.getElementsByClassName("jobs");

            // console.log("json[\"jobs\"][i]"+json["jobs"][0].company);

            // var job_company = document.getElementsByClassName("job-company");
            // var job_position = document.getElementsByClassName("job-position");
            // var job_location = document.getElementsByClassName("job-location");
            // var job_discribe = document.getElementsByClassName("job-discribe");

            console.log("user" + data["users"][0].name);

            document.getElementsByClassName("name")[0].innerHTML = data["users"][0].name;

            document.getElementById("pic").src=data["users"][0].pic;
            user = document.getElementsByClassName("left-font");
            user[0].innerHTML +=
                '<input class= "info-id" type="hidden" value="' + data["users"][0].id + '">' +

                '<div>在读学校：<input class="item school" value="' + data["users"][0].school + '"</input></div>' +
                '<div>专业：<input class="item major" value="' + data["users"][0].major + '"</input></div>' +
                '<div>联系电话：<input class="item phone" value="' + data["users"][0].phone + '"</input></div>' +
                '<div>邮箱：<input class="item mail" value="' + data["users"][0].mail + '"</input></div>' +
                '<div>github：<input class="item git" value="' + data["users"][0].github + '"</input></div>' +
                '<div><button type="submit" onclick="save_info()" >保存</button>';
            for (let i = 0; i < data["jobs"].length; i++) {
                job[0].innerHTML += "<div class='jobchange'><ul>" +
                    "<input class='in-item job-id" + i + "' type='hidden' value='" + data["jobs"][i].id + "'>" +
                    "<li>" +
                    "公司名称：<input class=\"in-item job-company" + i + "\" type='text' name='back-company' value='" + data["jobs"][i].company + "'> </input>" +
                    "</li>" +
                    "<li>" +
                    "职位：<input class=\"in-item job-position" + i + "\" type='text' name='back-position'  value='" + data["jobs"][i].position + "'> </input>" +
                    "</li>" +
                    "<li>" +
                    "地点：<input class=\"in-item job-location" + i + "\" type='text' name='back-location'  value='" + data["jobs"][i].location + "'> </input>" +
                    "</li>" +
                    "<li>" +
                    "描述：<textarea class=\"in-item job-discribe" + i + "\"  name='back-discribe' cols='50' rows='5' '>" + data["jobs"][i].discribe + "</textarea>" +
                    "</li>" +
                    "</ul><button  type='submit' value='保存'  onclick='save(\"job-submit" + i + "\")' id='job-submit" + i + "'>保存</button>" +
                    "<button  type='submit' value='保存'  onclick='delete_job(\"job-submit" + i + "\")' id='job-delete" + i + "'>删除</button></div>";

                // var submitDom=document.getElementById("job-submit"+i);
                // submitDom.addEventListener('click',function () {  // 绑定函数
                //
                // });
            }

            var projects = document.getElementsByClassName("projects");
            for (let i = 0; i < data["projects"].length; i++) {
                projects[0].innerHTML +=
                    "<div class='projectchange'><ul>" +
                    "<input class='in-item project-id" + i + "' type='hidden' value='" + data["projects"][i].id + "'>" +
                    "<li>" +
                    "项目名称：<input class=\"in-item project-name" + i + "\" type='text' name='back-' value='" + data["projects"][i].name + "'> </input>" +
                    "</li>" +
                    "<li>" +
                    "担任角色：<input class=\"in-item project-character" + i + "\" type='text' name='back-position'  value='" + data["projects"][i].character + "'> </input>" +
                    "</li>" +
                    "<li>" +
                    "地点：<input class=\"in-item project-location" + i + "\" type='text' name='back-location'  value='" + data["projects"][i].location + "'> </input>" +
                    "</li>" +
                    "<li>" +
                    "描述：<textarea class=\"in-item project-discribe" + i + "\"  name='back-discribe' cols='50' rows='5' '>" + data["projects"][i].discribe + "</textarea>" +
                    "</li>" +
                    "</ul><button  type='submit' value='保存'  onclick='save_project(\"project-submit" + i + "\")' id='project-submit" + i + "'>保存</button>" +
                    "     <button  type='submit' value='保存'  onclick='delete_project(\"project-submit" + i + "\")' id='project-delete" + i + "'>删除</button></div>";

            }
            var rewards = document.getElementsByClassName("rewards");

            for (let i = 0; i < data["rewards"].length; i++) {
                console.log(data["rewards"][i].time + "*****");

                rewards[0].innerHTML +=
                    "<div class='rewardchange'><ul>" +
                    "<input class='in-item reward-id" + i + "' type='hidden' value='" + data["rewards"][i].id + "'>" +
                    "<li>" +
                    "获奖名称：<input class=\"in-item reward-name" + i + "\" type='text' name='back-' value='" + data["rewards"][i].name + "'> </input>" +
                    "</li>" +
                    "<li>" +
                    "级别：<input class=\"in-item reward-clazz" + i + "\" type='text' name='back-position'  value='" + data["rewards"][i].clazz + "'> </input>" +
                    "</li>" +
                    "<li>" +
                    "等级：<input class=\"in-item reward-degree" + i + "\" type='text' name='back-location'  value='" + data["rewards"][i].degree + "'> </input>" +
                    "</li>" +
                    "<li>" +
                    "时间：<input type='text' class=\"in-item reward-time" + i + "\"  name='back-discribe' value='" + data["rewards"][i].time + "'</input>" +
                    "</li>" +
                    "</ul><button  type='submit' value='保存'  onclick='save_reward(\"reward-submit" + i + "\")' id='reward-submit" + i + "'>保存</button>" +
                    "<button  type='submit' value='保存'  onclick='delete_reward(\"reward-submit" + i + "\")' id='reward-delete" + i + "'>删除</button></div>";
            }
        }
    };

    xmlhttp.open("GET", "/servlet/getInfoServlet", true);
    xmlhttp.send();

};
