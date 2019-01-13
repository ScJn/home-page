window.onload = function () {
    getProject();
};
baseUrl = 'http://localhost:8084';

getInfo=function(){
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState === 4) {

        }
    };
    xmlhttp.open("GET", "/servlet/getInfoServlet",true);
    xmlhttp.send();
};


getProject = function () {
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function () {
        let user;
        if (xmlhttp.readyState === 4) {
            var json = xmlhttp.responseText;

            var data = JSON.parse(json);

            var job = document.getElementsByClassName("jobs");

            // console.log("json[\"jobs\"][i]"+json["jobs"][0].company);

            // var job_company = document.getElementsByClassName("job-company");
            // var job_position = document.getElementsByClassName("job-position");
            // var job_location = document.getElementsByClassName("job-location");
            // var job_discribe = document.getElementsByClassName("job-discribe");

            console.log("user" + data["users"][0].name);

            document.getElementsByClassName("name")[0].innerHTML=data["users"][0].name;
            user = document.getElementsByClassName("left-font");
            user[0].innerHTML+=
                "<div class=\"item school\">在读学校："+data["users"][0].school+"</div>" +
                "<div class=\"item major\">专业："+data["users"][0].major+"</div>" +
                "<div class=\"item phone\">联系电话："+data["users"][0].phone+"</div>" +
                "<div class=\"item mail\">邮箱："+data["users"][0].mail+"</div>" +
                "<div class=\"item git\">github："+data["users"][0].github+"</div>";

            document.getElementById("pic").src=data["users"][0].pic;

            for (let i = 0; i < data["jobs"].length; i++) {
                job[0].innerHTML += "<ul>" +
                    "<li>" +
                    "<div class=\"in-item job-company\">公司名称：" + data["jobs"][i].company + "</div>" +
                    "</li>" +
                    "<li>" +
                    "<div class=\"in-item job-position\">职位：" + data["jobs"][i].position + "</div>" +
                    "</li>" +
                    "<li>" +
                    "<div class=\"in-item job-location\">地点：" + data["jobs"][i].location + "</div>" +
                    "</li>" +
                    "<li>" +
                    "<div class=\"in-item job-discribe\">描述：" + data["jobs"][i].discribe + "</div>" +
                    "</li>" +
                    "</ul>";
            }

            var projects = document.getElementsByClassName("projects");
            for (let i = 0; i < data["projects"].length; i++) {
                projects[0].innerHTML +=
                    "<ul>" +
                    "<li>" +
                    "<div class=\"in-item project-name\">项目名称：" + data["projects"][i].name + "</div>" +
                    "</li>" +
                    "<li>" +
                    "<div class=\"in-item project-character\">担任角色：" + data["projects"][i].character + "</div>" +
                    "</li>" +
                    "<li>" +
                    "<div class=\"in-item project-location\">地点：" + data["projects"][i].location + "</div>" +
                    "</li>" +
                    "<li>" +
                    "<div class=\"in-item project-discribe\">描述：" + data["projects"][i].discribe + "</div>" +
                    "</li>" +
                    "</ul>";
            }
            var rewards = document.getElementsByClassName("rewards");
            for (let i = 0; i < data["rewards"].length; i++) {
                rewards[0].innerHTML += "<ul>" +
                    "<li>" +
                    "<div class=\"in-item reward-name\">获奖名称：" + data["rewards"][i].name + "</div>" +
                    "</li>" +
                    "<li>" +
                    "<div class=\"in-item reward-clazz\">级别：" + data["rewards"][i].clazz + "</div>" +
                    "</li>" +
                    "<li>" +
                    "<div class=\"in-item reward-degree\">等级：" + data["rewards"][i].degree + "</div>" +
                    "</li>" +
                    "<li>" +
                    "<div class=\"in-item reward-time\">时间：" + data["rewards"][i].time + "</div>" +
                    "</li>" +
                    "</ul>";
            }
        }
    };

    xmlhttp.open("GET", "/servlet/getInfoServlet",true);
    xmlhttp.send();

};
