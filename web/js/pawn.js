$(document).ready(function () {
    getData();
    console.log("ready");
});

baseUrl = 'http://localhost:8084/';
getData = function () {
    let objData;
    $.ajax(
        {
            type: 'GET',
            url: baseUrl + 'pawn/',
            data: {},
            datatype: 'json',
            beforeSend: function (xhr) {
                xhr.withCredentials = true;
            },
            crossDomain: true,
            success: function (data) {
                if (data.status === 0) {
                    console.log("22");
                    objData = data.data;
                    for (let i = 0; i < objData.length; i++) {
                        let html = '';

                        html += '<tr>';
                        html += '<th scope="row">' + objData[i].id + '</th>';
                        html += '<td>' + objData[i].rightId + '</td>';
                        html += '<td>' + objData[i].name + '</td>';
                        html += '<td>' + objData[i].property + '</td>';
                        html += '<td>' + objData[i].authorityPerson + '</td>';
                        html += '<td>' + objData[i].source + '</td>';
                        html += '<td>' + objData[i].initialValue + '</td>';
                        html += '<td>' + objData[i].maxRatio + '</td>';
                        html += '<td>' + objData[i].theScale + '</td>';
                        html += '<td>' + objData[i].returned + '</td>';
                        html += '<td>';
                        html += '<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">修改 </button>';
                        html += '<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#addModal">新增 </button>';
                        html += '</td>';
                        html += '</tr>';
                        console.log(html);

                        let $table = $("#dangTable");
                        $table.append(html);
                    }
                }
            }
        }
    );
    return objData;
};
$("#savePawn").click(function () {

    alert("yes");

    let rightId = $('#rightId').val();
    let name = $('#name').val();
    let property = $('#property').val();
    let authorityPerson = $('#authorityPerson').val();
    let source = $('#source').val();
    let initialValue = $('#initialValue').val();
    let maxRatio = $('#maxRatio').val();
    let theScale = $('#theScale').val();
    console.log(theScale);
    $.ajax(
        {
            type: "POST",
            url: baseUrl + "pawn/",
            datatype: 'json',
            data: {
                'rightId': rightId,
                'name': name,
                'property': property,
                'authorityPerson': authorityPerson,
                'source': source,
                'initialValue': initialValue,
                'maxRatio': maxRatio,
                'theScale': theScale
            },
            beforeSend: function (xhr) {
                xhr.withCredentials = true;
            },
            crossDomain: true,
            success: function (data) {
                if (data.status === 0) {
                    alert("添加成功");
                    getData();
                }
            }
        }
    )
});