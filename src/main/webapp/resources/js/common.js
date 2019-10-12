const mealAjaxUrl = "/users/";

function printOK(jsonData, userID) {
    $('#results').html('<div class="alert alert-success" role="alert">' +
        'Search result for id = ' + userID + '<br>' +
        'Name = ' + jsonData.fio + ', Nickname = ' + jsonData.email +
        '</div>');
}

function err(data) {
    var alertCls = 'alert-danger';
    var msg = '';
    switch (data.status) {
        case 500:
        case 400:
        case 405:
            msg = data.responseJSON.message;
            alertCls = 'alert-warning';
            break;
        case 404:
            msg = data.responseJSON.message;
            alertCls = 'alert-secondary';
            break;
            break;
        case 0:
            msg = 'Service temporary unavailable';
            break;
        default:
            msg = 'Unhandled error';
    }
    $('#results').html('<div class="alert ' + alertCls + '" role="alert">' +
        msg + '</div>');
}

function searchUserById() {
    var userID = $("#userID").val();
    $('#userID').val('');
    $('#results').html('');

    $.ajax(mealAjaxUrl + userID)
        .done(function (data) {
            if ($(data).find(".form-signin").length > 0) {
                $(location).attr("href", "");
                return;
            }
            printOK(data, userID);
        })
        .fail(function (data) {
            err(data);
        });
}

$(function () {
    $('#formID').validate({
        rules: {
            userID: {
                digits: true,
                required: true
            }
        }
    });
});