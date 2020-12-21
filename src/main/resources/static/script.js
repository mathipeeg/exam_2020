function load(){
    getAll();
    addStudentSubmit()
}

function getAll() {
    $.ajax({
        url:"/api/get",
        type:"POST",
        contentType:"application/JSON",
        success: function (data) {
            $.each(data.result, function (index, value){
                console.log(value.id);
                writeHTML(value, data.supervisor[index], data.supervisorsList);
            })
        },
        error: function () {
            console.log("error in showing");
        }
    });
}

function dropDown(array, superId, id){
    let elm = document.getElementById('supervisor-drp-' + id),
        df = document.createDocumentFragment();
    for (let i = 0; i <= array.length - 1; i++) {
        let option = document.createElement('option');
        option.value = array[i].id;
        let temp = array[i].name;
        option.appendChild(document.createTextNode(temp));
        if(array[i].id === superId){ option.selected = true; }
        df.appendChild(option);
    }
    elm.appendChild(df);
}

function addStudentSubmit(){
    let form = ($("#add-student-form"))
    form.submit(function (event){
        event.preventDefault();
        addStudent()
    });
}

function addStudent(){
    let id = document.getElementById("add-supervisor").value;

    let superObj = {};
    superObj["id"] = id;

    let studObj = {};
    studObj["name"] = $("#student-name").val();
    studObj["email"] = $("#student-email").val();
    studObj["supervisor"] = superObj;
    studObj["count"] = $("#students > div").length;

    $.ajax({
        url:"/api/add-student",
        type:"POST",
        contentType:"application/JSON",
        data: JSON.stringify(studObj),
        success:function (data){
            writeHTML(data.result[0], data.supervisor[0], data.supervisorsList);
        },
        error: function(){
            console.log("Error in addStudent()!")
        }
    });
}

function updateStudents(id){
    let drpdwn = document.getElementById("supervisor-drp-" + id);

    let superObj = {};
    superObj["id"] = drpdwn.value;

    let studObj = {};
    studObj["id"] = id;
    studObj["name"] = $("#name-" + id).val();
    studObj["email"] = $("#email-" + id).val();
    studObj["supervisor"] = superObj;
    studObj["count"] = $("#students > div").length;

    $.ajax({
        url:"/api/update-student",
        type:"POST",
        contentType:"application/JSON",
        data: JSON.stringify(studObj),
        success:function (data) {
            $("#students").html('');
            $.each(data.result, function (index, value){
                writeHTML(value, data.supervisor[index], data.supervisorsList);
            })
        },
        error: function(){
            console.log("Error in updateStudents()!");
        }
    });
}

function writeHTML(value, supervisorData, supervisorsList){
    $("#students").append("<p id='p-" + value.id + "'> Name: <input id='name-" + value.id + "' type='text' name='name' value='" + value.name + "'>" +
        " E-mail: <input id='email-" + value.id + "' type='text' name='email' value='" + value.email + "'>" +
        " Supervisor: <select id='supervisor-drp-" + value.id + "'>" +
        " </select> " +
        " <button type='submit' onclick='updateStudents(" + value.id + ")'>Update</button> " +
        "<button type='submit' onclick='deleteStudentButton(" + value.id + ")'>Delete</button>")
    dropDown(supervisorsList, supervisorData.id, value.id);
}

function deleteStudentButton(id) {
    let studObj = {};
    studObj["id"] = id;

    $.ajax({
        url: "/api/delete-student",
        type: "POST",
        contentType: "application/JSON",
        data: JSON.stringify(studObj),
        success: function () {
            $("#p-" + id).html('');
        }
    });
}
