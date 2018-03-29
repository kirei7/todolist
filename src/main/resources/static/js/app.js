const NOTES_PATH = "/notes";

$(document).ready(function () {
    initTaskGet();
    initTaskAdd();
    initTaskDelete();
    initTaskChangeStatus();
});

function initTaskGet() {
    $.get(NOTES_PATH, function (data) {
        data = JSON.parse(data);
        data.forEach( function(e){
            createAndPrependListItem(e);
        });
    });
}

function initTaskAdd() {
    $("#addtask-submit").click(function () {
        let noteData = {
            text: $("#addtask-input").val().trim()
        };
        if (noteData.text.length === 0) {
            alert("Can't add empty task");
            return;
        }
        noteData = JSON.stringify(noteData);
        $.ajax({
            type: 'POST',
            url: NOTES_PATH,
            data: noteData,
            contentType: "application/json",
            dataType: "json",
            complete: function (res) {
                let data = JSON.parse(res.responseText);
                createAndPrependListItem(data);
            }
        });
    });
}

function initTaskDelete() {
    let deleteId;
    $('#exampleModal').on('show.bs.modal', function (e) {
        deleteId = $(e.relatedTarget).attr("data-id");
    });
    $("#delete-confirm").click(function () {
        $.ajax({
            url: NOTES_PATH,
            type: 'DELETE',
            data: '{"id": ' + deleteId + '}',
            success: function (res) {
                let deleted = JSON.parse(res);
                $(".todo-item[data-id=" + deleted.id + "]").remove();
            }
        });
    });
}

function initTaskChangeStatus() {
    $(".list-wrapper").on("change", ".checkbox-custom", function () {
        let id = $(this).attr("data-id");
        $.ajax({
            url: NOTES_PATH + "/" + id,
            type: 'POST',
            success: function (res) {
                console.log(res);
            }
        });
    });
}

function createAndPrependListItem(jsonElement) {
    let target = createItem(jsonElement)
    $(".list-wrapper").prepend(target);
}
function createItem(jsonElement) {
    let target = $(".d-none .todo-item").clone();
    target.attr("data-id", jsonElement.id);
    target.find(".todo-item-text").val(jsonElement.text);
    let checkboxId = "checkbox-" + jsonElement.id;
    target.find("label").attr("for", checkboxId);
    target.find(".checkbox-custom")
        .prop("checked", jsonElement.isDone)
        .attr("id", checkboxId)
        .attr("data-id", jsonElement.id);
    target.find(".delete-item").attr("data-id", jsonElement.id);
    return target;
}